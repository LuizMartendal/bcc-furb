package br.furb.restapifurb.models.usuario;

import br.furb.restapifurb.enuns.Roles;
import br.furb.restapifurb.models.ModelImpl;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Usuário", description = "Entidade usuário")
@Entity(name = "usuarios")
public class Usuario extends ModelImpl implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;

    @Length(min = 4, max = 100, message = "O campo usuário deve conter entre 4 a 100 caracteres")
    @NotNull(message = "O campo usuário não pode ser núlo")
    @NotEmpty(message = "O campo usuário não pode ser vázio")
    @NotBlank(message = "O campo usuário não pode estár em branco")
    @Column(name = "usuario", columnDefinition = "varchar(100)")
    private String usuario;

    @Length(min = 4, max = 100, message = "A senha do usuário deve conter entre 4 a 100 caracteres")
    @NotNull(message = "A senha do usuário não pode ser núlo")
    @NotEmpty(message = "A senha do usuário não pode ser vázio")
    @NotBlank(message = "A senha do usuário não pode estár em branco")
    @Column(name = "senha", columnDefinition = "varchar(100)")
    private String senha;

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

    @NotNull(message = "A role (função) do usuário não pode ser núla ")
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Roles role;

    @PrePersist
    private void formatarTelefone() {
        telefone = telefone.replaceAll("[^\\d.]", "");
        System.out.println(telefone);
    }

}
