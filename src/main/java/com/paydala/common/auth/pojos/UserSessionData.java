package com.paydala.common.auth.pojos;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(proxyMode= ScopedProxyMode.TARGET_CLASS, value= WebApplicationContext.SCOPE_SESSION)
public class UserSessionData {
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
