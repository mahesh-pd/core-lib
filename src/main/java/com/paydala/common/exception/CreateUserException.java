package com.paydala.common.exception;

public class CreateUserException extends RuntimeException {

    private String message;

    public CreateUserException() {}

    public CreateUserException(String message) {
        this.message = message;
    }
}
