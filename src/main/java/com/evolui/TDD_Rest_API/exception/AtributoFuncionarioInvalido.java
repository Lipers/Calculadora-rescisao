package com.evolui.TDD_Rest_API.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class AtributoFuncionarioInvalido extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AtributoFuncionarioInvalido(String message) {
        super(message);
    }

}
