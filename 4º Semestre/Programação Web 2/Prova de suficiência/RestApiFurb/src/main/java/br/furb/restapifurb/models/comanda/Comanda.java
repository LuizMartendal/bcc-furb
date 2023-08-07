package br.furb.restapifurb.models.comanda;

import br.furb.restapifurb.models.ModelImpl;
import br.furb.restapifurb.models.produto.Produto;
import br.furb.restapifurb.models.usuario.Usuario;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Comanda", description = "Entidade comanda")
@Entity(name = "comandas")
public class Comanda extends ModelImpl implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    @NotNull(message = "Data não pode ser núla")
    @Column
    private Date data;

}
