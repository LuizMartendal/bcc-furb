package br.furb.restapifurb.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormatException implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;

    private Integer status;
    private String message;
    private Integer code;
    private Long timestamp;

}
