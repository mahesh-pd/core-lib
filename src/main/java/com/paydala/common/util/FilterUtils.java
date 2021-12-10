package com.paydala.common.util;

import com.paydala.common.auth.pojos.TokenDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.function.Function;

@Component
public class FilterUtils {

    private static String[] requestUrls = new String[]{"/auth-service/registeruser", "/auth-service/getusertoken"};

    public static boolean isAuthRequired(String url) {
        for(String s : requestUrls) {
            if(url.contains(s)) {
                return false;
            }
        }

        return true;
    }
}
