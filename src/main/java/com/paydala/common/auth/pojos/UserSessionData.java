package com.paydala.common.auth.pojos;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(proxyMode= ScopedProxyMode.TARGET_CLASS, value= WebApplicationContext.SCOPE_SESSION)
public class UserSessionData {
    private String userId;
    private String email;
    private Object sessionData;
    private String txnId1;
    private String txnId2;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getSessionData() {
        return sessionData;
    }

    public void setSessionData(Object sessionData) {
        this.sessionData = sessionData;
    }

    public String getTxnId1() {
        return txnId1;
    }

    public void setTxnId1(String txnId1) {
        this.txnId1 = txnId1;
    }

    public String getTxnId2() {
        return txnId2;
    }

    public void setTxnId2(String txnId2) {
        this.txnId2 = txnId2;
    }
}
