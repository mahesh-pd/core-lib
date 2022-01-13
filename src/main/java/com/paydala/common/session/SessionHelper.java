package com.paydala.common.session;

import com.paydala.common.auth.pojos.Kyc;
import com.paydala.common.auth.pojos.PaymentData;
import com.paydala.common.cache.CacheService;
import com.paydala.common.data.auth.entity.SavedPymtSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Component
public class SessionHelper {

    public final static Logger LOG = LoggerFactory.getLogger(SessionHelper.class);

    private static CacheService cacheService;

    @Autowired
    public SessionHelper(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    public static void setPaymentData(SavedPymtSource savedPymtSource, Kyc kyc,
                                      Integer txnI1, Integer txnId2, int paymentType, String token) {
        PaymentData paymentData = null;
        Object obj = cacheService.getObject("payment_data:" + token);
        if (obj != null) {
            paymentData = (PaymentData) obj;
        } else {
            paymentData = new PaymentData();
        }

        LOG.info("Payment Data Before: {} | {}", paymentData, token);
        
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
        LOG.info("Payment Data After:  {} | {}", paymentData, token);
        cacheService.setObject("payment_data:" + token, paymentData);
    }

    public static PaymentData getPaymentData(String token) {
        Object obj = cacheService.getObject("payment_data:" + token);
        if(obj != null) {
            return (PaymentData) obj;
        }

        return null;
    }
}
