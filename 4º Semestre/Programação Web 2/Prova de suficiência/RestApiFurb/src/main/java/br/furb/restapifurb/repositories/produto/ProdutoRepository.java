package br.furb.restapifurb.repositories.produto;

import br.furb.restapifurb.models.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
