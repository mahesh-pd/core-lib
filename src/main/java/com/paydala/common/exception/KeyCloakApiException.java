package com.paydala.common.exception;

public class KeyCloakApiException extends RuntimeException {

    private String message;

    public KeyCloakApiException() {

    }

    public KeyCloakApiException(String message) {
        this.message = message;
    }
}
