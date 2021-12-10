package com.paydala.common.exception;

public class JwtException extends RuntimeException {

    private String message;

    public JwtException() {

    }

    public JwtException(String message) {
        this.message = message;
    }
}
