package br.furb.restapifurb.repositories.comanda;

import br.furb.restapifurb.models.comanda.Comanda;
import br.furb.restapifurb.models.comanda.ProdutoComanda;
import br.furb.restapifurb.models.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoComandaRepository extends JpaRepository<ProdutoComanda, Long> {

    List<ProdutoComanda> findAllProdutoComandaByComanda(Comanda comanda);

    List<ProdutoComanda> findAllProdutoComandaByProduto(@NotNull(message = "Produto não pode ser núlo") Produto produto);

    ProdutoComanda findProdutoComandaByProdutoAndComanda(Produto produto, Comanda comanda);
}
