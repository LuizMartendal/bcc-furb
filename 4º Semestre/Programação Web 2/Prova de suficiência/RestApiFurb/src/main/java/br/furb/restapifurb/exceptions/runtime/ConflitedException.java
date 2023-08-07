package br.furb.restapifurb.exceptions.runtime;

import java.io.Serial;
import java.io.Serializable;

public class ConflitedException extends RuntimeException  implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;

    public ConflitedException(String message) {
        super(message);
    }
}
