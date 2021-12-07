package com.paydala.common.exception;

public class SessionDataException extends RuntimeException {

    private String message;

    public SessionDataException() {

    }

    public SessionDataException(String message) {
        this.message = message;
    }
}
