package com.paydala.common.util;

import com.paydala.common.auth.pojos.TokenDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;
import java.util.function.Function;

@Component
public class FilterUtils {

    private static String[] requestUrls = new String[]{"/auth-service/registeruser", "/auth-service/getusertoken",
            "/auth-service/checkuser", "/auth-service/guestlogin", "/auth-service/testsave", "/linktoken"};

    public static boolean isAuthRequired(String url) {
        for(String s : requestUrls) {
            if(url.contains(s)) {
                return false;
            }
        }

        return true;
    }

    public static void addCORSHeaders(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, " +
                "Content-Type, Accept, Authorization, Content-Disposition");

        //https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-Content-Type-Options
        response.addHeader("x-content-type-options", "nosniff");
        //https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Strict-Transport-Security
        response.addHeader("strict-transport-security", "max-age=31536000");
        //https://content-security-policy.com/
        response.addHeader("content-security-policy",
                "default-src *.liveperson.net *.botcentralai.com;"
                        + " script-src *.liveperson.net *.botcentralai.com;"
                        + " connect-src *.liveperson.net *.botcentralai.com *.botcentralapi.com;"
//                          + " img-src *.liveperson.net *.botcentralai.com;"
                        + " style-src *.liveperson.net *.botcentralai.com;");
        //https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-XSS-Protection
        response.addHeader("X-XSS-Protection", "1");
    }
}
