package br.furb.restapifurb.models.comanda;

import br.furb.restapifurb.models.ModelImpl;
import br.furb.restapifurb.models.produto.Produto;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "ProdutoComanda", description = "Relação de produtos e comandas")
@Entity(name = "produtos_comandas")
public class ProdutoComanda extends ModelImpl implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;

    @NotNull(message = "Produto não pode ser núlo")
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @NotNull(message = "Comanda não pode ser núla")
    @ManyToOne
    @JoinColumn(name = "comanda_id")
    private Comanda comanda;
}
