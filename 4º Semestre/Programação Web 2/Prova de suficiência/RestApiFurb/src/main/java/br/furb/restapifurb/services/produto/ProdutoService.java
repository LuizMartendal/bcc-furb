package br.furb.restapifurb.services.produto;

import br.furb.restapifurb.models.comanda.ProdutoComanda;
import br.furb.restapifurb.models.produto.Produto;
import br.furb.restapifurb.repositories.produto.ProdutoRepository;
import br.furb.restapifurb.services.ServiceImpl;
import br.furb.restapifurb.services.comanda.ProdutoComandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService extends ServiceImpl<Produto> {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ProdutoComandaService produtoComandaService;

    @Override
    public JpaRepository<Produto, Long> getRepository() {
        return repository;
    }

    @Override
    public void delete(Long id) {
        List<ProdutoComanda> produtoComandas = produtoComandaService.findAllProdutoComandaByProdutoId(id);
        if (produtoComandas.size() > 0) {
            produtoComandaService.deleteAll(produtoComandas);
        }
        super.delete(id);
    }
}
