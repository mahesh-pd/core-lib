package com.paydala.common.enums;

public enum TransactionType {

    USER_TO_PAYDALA(1), PAYDALA_TO_PARTNER(2), FUND_WALLET(3), WITHDRAW_FROM_WALLET(4);

    private int type;

    TransactionType(int i) {
        this.type = i;
    }

    public int value() {
        return this.type;
    }
}
