package com.paydala.common.session;

import com.paydala.common.auth.pojos.Kyc;
import com.paydala.common.auth.pojos.PaymentData;
import com.paydala.common.data.auth.entity.SavedPymtSource;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class SessionHelper {

    public static void setPaymentData(SavedPymtSource savedPymtSource, Kyc kyc,
                                      Integer txnI1, Integer txnId2, int paymentType, HttpSession session) {
        PaymentData paymentData = null;
        Object obj = session.getAttribute("payment_data");
        if (obj != null) {
            paymentData = (PaymentData) obj;
        } else {
            paymentData = new PaymentData();
        }
        
        List<Integer> transactions = null;
        if (CollectionUtils.isEmpty(paymentData.getTransactionIds())) {
            transactions = new ArrayList<>();
        } else {
            transactions = paymentData.getTransactionIds();
        }

        if (txnI1 != null)
            transactions.add(txnI1);

        if (txnId2 != null)
            transactions.add(txnId2);

        List<SavedPymtSource> sources = null;
        if (CollectionUtils.isEmpty(paymentData.getSources())) {
            sources = new ArrayList<>();
        } else {
            sources = paymentData.getSources();
        }

        if (savedPymtSource != null)
            sources.add(savedPymtSource);

        paymentData.setSources(sources);
        paymentData.setTransactionIds(transactions);

        if (kyc != null)
            paymentData.setKyc(kyc);

        paymentData.setPaymentType(paymentType);
        session.setAttribute("payment_data", paymentData);
    }
}
