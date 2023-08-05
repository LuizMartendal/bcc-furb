package br.furb.restapifurb.services.produto;

import br.furb.restapifurb.models.produto.Produto;
import br.furb.restapifurb.repositories.produto.ProdutoRepository;
import br.furb.restapifurb.services.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService extends ServiceImpl<Produto> {

    @Autowired
    private ProdutoRepository repository;

    @Override
    public JpaRepository<Produto, Long> getRepository() {
        return repository;
    }
}
