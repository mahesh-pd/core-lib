package com.paydala.common.exception;

public class PaymentException extends RuntimeException {

    private String message;

    public PaymentException() {}

    public PaymentException(String message) {
        this.message = message;
    }
}
