package com.paydala.common.exception;

public class UserExistsException extends RuntimeException {
    private String message;

    public UserExistsException(String message) {
        super(message);
        this.message = message;
    }

    public UserExistsException() {
    }
}
