package com.paydala.common.auth.pojos;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(proxyMode= ScopedProxyMode.TARGET_CLASS, value= WebApplicationContext.SCOPE_REQUEST)
public class UserTokenData {

    private TokenDetails tokenDetails;
    private String token;

    public TokenDetails getTokenDetails() {
        return tokenDetails;
    }

    public void setTokenDetails(TokenDetails tokenDetails) {
        this.tokenDetails = tokenDetails;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
