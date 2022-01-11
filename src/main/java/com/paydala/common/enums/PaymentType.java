package com.paydala.common.enums;

public enum PaymentType {

    CREDIT_CARD(1), BANK(3);

    int value;

    PaymentType(int i) {

    }

    public int value() {
        return this.value;
    }
}
