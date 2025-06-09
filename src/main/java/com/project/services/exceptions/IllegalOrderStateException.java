package com.project.services.exceptions;

public class IllegalOrderStateException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public IllegalOrderStateException(String message) {
        super(message);
    }

    public IllegalOrderStateException(String message, Throwable cause) {
        super(message, cause);
    }
}
