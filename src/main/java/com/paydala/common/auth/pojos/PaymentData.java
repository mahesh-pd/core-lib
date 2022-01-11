package com.paydala.common.auth.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.paydala.common.data.auth.entity.SavedPymtSource;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentData implements Serializable {

    private List<SavedPymtSource> sources;
    private List<Integer> transactionIds;
    private Kyc kyc;
    private int paymentType;

    public List<SavedPymtSource> getSources() {
        return sources;
    }

    public void setSources(List<SavedPymtSource> sources) {
        this.sources = sources;
    }

    public List<Integer> getTransactionIds() {
        return transactionIds;
    }

    public void setTransactionIds(List<Integer> transactionIds) {
        this.transactionIds = transactionIds;
    }

    public Kyc getKyc() {
        return kyc;
    }

    public void setKyc(Kyc kyc) {
        this.kyc = kyc;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }
}
