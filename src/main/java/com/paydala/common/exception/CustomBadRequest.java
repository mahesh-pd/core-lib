package com.paydala.common.exception;

public class CustomBadRequest extends RuntimeException {

    private String message;

    public CustomBadRequest() {

    }

    public CustomBadRequest(String message) {
        this.message = message;
    }
}
