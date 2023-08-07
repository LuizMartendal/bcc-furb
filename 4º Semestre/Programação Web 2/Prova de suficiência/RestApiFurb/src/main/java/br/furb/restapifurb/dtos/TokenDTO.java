package br.furb.restapifurb.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TokenDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String usuario;
    private Date criado;
    private Date expiraEm;
    private String token;

}
