package br.furb.restapifurb.models.usuario;

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
@Entity(name = "usuarios")
public class Usuario extends ModelImpl implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;

    @Length(min = 3, max = 150, message = "O nome do usuário deve conter entre 3 a 150 caracteres")
    @NotNull(message = "O nome do usuário não pode ser núlo")
    @NotEmpty(message = "O nome do usuário não pode ser vázio")
    @NotBlank(message = "O nome do usuário não pode estár em branco")
    @Column(name = "nome", columnDefinition = "varchar(150)")
    private String nome;

    @Length(min = 11, max = 20, message = "O telefone do usuário deve conter entre 11 a 20 digitos")
    @NotNull(message = "O telefone do usuário não pode ser núlo")
    @NotEmpty(message = "O telefone do usuário não pode ser vázio")
    @NotBlank(message = "O telefone do usuário não pode estár em branco")
    @Column(name = "telefone", columnDefinition = "varchar(20)")
    private String telefone;
}
