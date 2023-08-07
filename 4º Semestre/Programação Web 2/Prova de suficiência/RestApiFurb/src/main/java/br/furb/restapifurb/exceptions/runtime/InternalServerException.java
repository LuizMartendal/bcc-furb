package br.furb.restapifurb.exceptions.runtime;

import java.io.Serial;
import java.io.Serializable;

public class InternalServerException extends RuntimeException implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;

    public InternalServerException(String message) {
        super(message);
    }
}
