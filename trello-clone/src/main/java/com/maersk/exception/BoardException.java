package com.maersk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BoardException extends RuntimeException {
    private static final long serialVersionUID = -470180507998010368L;

    public BoardException(final String message) {
        super(message);
    }
}
