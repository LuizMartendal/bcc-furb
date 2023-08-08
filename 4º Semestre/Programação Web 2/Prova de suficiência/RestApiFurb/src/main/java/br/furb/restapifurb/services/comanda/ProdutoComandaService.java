package br.furb.restapifurb.services.comanda;

import br.furb.restapifurb.exceptions.runtime.NotFoundException;
import br.furb.restapifurb.models.comanda.ProdutoComanda;
import br.furb.restapifurb.repositories.comanda.ComandaRepository;
import br.furb.restapifurb.repositories.comanda.ProdutoComandaRepository;
import br.furb.restapifurb.repositories.produto.ProdutoRepository;
import br.furb.restapifurb.services.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoComandaService extends ServiceImpl<ProdutoComanda> {

    @Autowired
    private ProdutoComandaRepository repository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ComandaRepository comandaRepository;

    @Override
    public JpaRepository<ProdutoComanda, Long> getRepository() {
        return repository;
    }

    @Override
    public ProdutoComanda create(ProdutoComanda entity) {
        verificarProdutoEComanda(entity);
        return super.create(entity);
    }

    @Override
    public ProdutoComanda update(ProdutoComanda entity, Long id) {
        verificarProdutoEComanda(entity);
        return super.update(entity, id);
    }

    public List<ProdutoComanda> findAllProdutoComandaByComandaId(Long id) {
        return repository.findAllProdutoComandaByComanda(comandaRepository.findById(id).get());
    }

    public List<ProdutoComanda> findAllProdutoComandaByProdutoId(Long id) {
        return repository.findAllProdutoComandaByProduto(produtoRepository.findById(id).get());
    }

    public ProdutoComanda findProdutoComandaByProdutoIdAndComandaId(Long produto, Long comanda) {
        return repository.findProdutoComandaByProdutoAndComanda(produtoRepository.findById(produto).get(), comandaRepository.findById(comanda).get());
    }

    public void deleteAll(List<ProdutoComanda> produtoComandas) {
        repository.deleteAll(produtoComandas);
    }

    private void verificarProdutoEComanda(ProdutoComanda entity) {
        if (produtoRepository.findById(entity.getProduto().getId()).isEmpty()) {
            throw new NotFoundException("Produto não encontrado");
        }
        if (comandaRepository.findById(entity.getComanda().getId()).isEmpty()) {
            throw new NotFoundException("Comanda não encontrada");
        }
    }

}
