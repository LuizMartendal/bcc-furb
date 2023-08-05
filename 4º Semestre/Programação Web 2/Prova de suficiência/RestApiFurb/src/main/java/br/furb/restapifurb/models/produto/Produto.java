package br.furb.restapifurb.models.produto;

import br.furb.restapifurb.models.ModelImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "produtos")
public class Produto extends ModelImpl implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;

    @Length(min = 4, max = 150, message = "O nome do produto deve conter entre 4 a 150 caracteres")
    @NotNull(message = "O nome do produto não pode ser núlo")
    @NotEmpty(message = "O nome do produto não pode ser vázio")
    @NotBlank(message = "O nome do produto não pode estár em branco")
    @Column(name = "nome", columnDefinition = "varchar(150)")
    private String nome;

    @NotNull(message = "O preço do produto não pode ser núlo")
    @Column(name = "preco", columnDefinition = "float(10)")
    private Double preco;
}
