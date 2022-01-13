package com.paydala.common.enums;

public enum PaymentType {

    CREDIT_CARD(1),
    DEBIT(2),
    BANK(3);

    int value;

    PaymentType(int i) {
        this.value = i;
    }

    public int value() {
        return this.value;
    }
}
