package br.furb.restapifurb.services.comanda;

import br.furb.restapifurb.dtos.ComandaDTO;
import br.furb.restapifurb.exceptions.runtime.BadRequestException;
import br.furb.restapifurb.exceptions.runtime.NotFoundException;
import br.furb.restapifurb.models.comanda.Comanda;
import br.furb.restapifurb.models.comanda.ProdutoComanda;
import br.furb.restapifurb.models.produto.Produto;
import br.furb.restapifurb.repositories.comanda.ComandaRepository;
import br.furb.restapifurb.services.produto.ProdutoService;
import br.furb.restapifurb.services.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComandaService implements br.furb.restapifurb.services.Service<ComandaDTO> {

    @Autowired
    private ComandaRepository repository;

    @Autowired
    private ProdutoComandaService produtoComandaService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public ComandaDTO create(ComandaDTO entity) {
        if (usuarioService.findById(entity.getUsuario().getId()) == null) {
            throw new NotFoundException("Usuário " + entity.getUsuario().getNome() + " não encontrado");
        }
        Comanda comanda = repository.save(dtoParaComanda(entity));
        for (Produto p: entity.getProdutos()) {
            if (produtoService.findById(p.getId()) == null) {
                throw new NotFoundException("Produto " + p.getNome() + " não encontrado");
            }
            produtoComandaService.create(new ProdutoComanda(p, comanda));
        }
        return entity;
    }

    @Override
    public ComandaDTO update(ComandaDTO entity, Long id) {
        Optional<Comanda> comandaRetornada = repository.findById(id);
        if (comandaRetornada.isPresent()) {
            Comanda comanda = repository.save(converterComanda(dtoParaComanda(entity), comandaRetornada.get()));
            for (Produto p: entity.getProdutos()) {
                if (produtoService.findById(p.getId()) == null) {
                    throw new NotFoundException("Produto " + p.getNome() + " não encontrado");
                }
                if (produtoComandaService.findProdutoComandaByProdutoIdAndComandaId(p.getId(), comanda.getId()) == null) {
                    produtoComandaService.create(new ProdutoComanda(p, comanda));
                }
            }
            return entity;
        }
        throw new NotFoundException("Comanda não encontrada");
    }

    private Comanda converterComanda(Comanda c, Comanda comanda) {
        if (usuarioService.findById(c.getUsuario().getId()) == null) {
            throw new NotFoundException("Usuário " + c.getUsuario().getNome() + " não encontrado");
        }
        comanda.setUsuario(c.getUsuario());
        comanda.setData(c.getData());
        return comanda;
    }

    private Comanda dtoParaComanda(ComandaDTO dto) {
        return new Comanda(dto.getUsuario(), new Date());
    }

    private ComandaDTO comandaParaDTO(Comanda comanda) {
        return new ComandaDTO(
                comanda.getUsuario(),
                comanda.getData(),
                converterParaProdutos(produtoComandaService.findAllProdutoComandaByComandaId(comanda.getId()))
        );
    }

    @Override
    public List<ComandaDTO> findAll() {
        return repository.findAll().stream()
                .map(comanda -> {
                   List<Produto> produtos = converterParaProdutos(produtoComandaService.findAllProdutoComandaByComandaId(comanda.getId()));
                   return new ComandaDTO(comanda.getUsuario(), comanda.getData(), produtos);
                }).collect(Collectors.toList());
    }

    private List<Produto> converterParaProdutos(List<ProdutoComanda> produtoComandaByComandaId) {
        return produtoComandaByComandaId.stream()
                .map(produtoComanda -> produtoService.findById(produtoComanda.getProduto().getId()))
                .collect(Collectors.toList());
    }

    @Override
    public ComandaDTO findById(Long id) {
        return comandaParaDTO(repository.findById(id).orElseThrow(() -> new NotFoundException("Comanda não encontrada")));
    }

    @Override
    public void delete(Long id) {
        List<ProdutoComanda> produtoComandas = produtoComandaService.findAllProdutoComandaByComandaId(id);
        if (produtoComandas.size() > 0) {
            produtoComandaService.deleteAll(produtoComandas);
        }
        repository.deleteById(id);
    }

    public List<Comanda> findAllComandasByUsuario(Long id) {
        return repository.findAllByUsuario(usuarioService.findById(id));
    }

    public void deleteAll(List<Comanda> comandas) {
        for (int i = 0; i < comandas.size(); i++) {
            delete(comandas.get(i).getId());
        }
    }
}
