package com.paydala.common.data.txn.service;

import com.paydala.common.data.txn.access.LedgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LedgerService {

    @Autowired
    private LedgerRepository ledgerRepository;

    public float getWalletBalance(Integer userId) {
        float depositAmt = ledgerRepository.getFundingAmount(userId);
        float withdrawalAmt = ledgerRepository.getWithdrawalAmount(userId);

        return depositAmt - withdrawalAmt;
    }
}
