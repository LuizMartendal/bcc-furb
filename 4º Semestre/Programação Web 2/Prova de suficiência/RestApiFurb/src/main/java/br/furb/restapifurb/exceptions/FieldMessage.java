package br.furb.restapifurb.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class FieldMessage implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;

    private String fieldName;
    private String message;
}
