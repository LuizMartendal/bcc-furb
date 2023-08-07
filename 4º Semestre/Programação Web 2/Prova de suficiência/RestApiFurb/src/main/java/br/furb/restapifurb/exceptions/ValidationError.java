package br.furb.restapifurb.exceptions;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends FormatException implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;

    private List<FieldMessage> errors = new ArrayList<FieldMessage>();

    public ValidationError(Integer status, String msg, Integer code, Long timeStamp) {
        super(status, msg, code, timeStamp);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String messagem) {
        errors.add(new FieldMessage(fieldName, messagem));
    }
}
