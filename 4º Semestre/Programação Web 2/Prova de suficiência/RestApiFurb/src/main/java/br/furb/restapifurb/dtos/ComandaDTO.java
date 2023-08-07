package br.furb.restapifurb.dtos;

import br.furb.restapifurb.models.produto.Produto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.furb.restapifurb.models.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComandaDTO implements Serializable {

    @NotNull(message = "Usuário não pode ser núlo")
    private Usuario usuario;

    private Date data;

    @NotNull(message = "Uma comanda deve conter ao menos um produto")
    private List<Produto> produtos;

}
