package br.furb.restapifurb.exceptions.runtime;

import java.io.Serial;
import java.io.Serializable;

public class NotAuthorizationException extends RuntimeException implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;

    public NotAuthorizationException(String message) {
        super(message);
    }
}
