package com.paydala.common.util;

import com.paydala.common.auth.pojos.TokenDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

@Component
public class FilterUtils {

    @Value("${jwt.secret}")
    private String secret;

    public static TokenDetails verifyJwtToken(String token) {

        if (isTokenExpired(token)) {
            return null;
        }

        Claims claims = getAllClaimsFromToken(token);
        String sid = claims.get("sid") != null ? String.valueOf(claims.get("sid")) : null;

        if (claims.get("sid") == null
                || claims.get("name") == null
                || claims.get("email") == null
                || claims.get("preferred_username") == null) {
            return null;
        } else {
            return new TokenDetails(String.valueOf(claims.get("sid")), String.valueOf(claims.get("email")),
                    String.valueOf(claims.get("name")), String.valueOf(claims.get("preferred_username")));
        }
    }

    private static Claims getAllClaimsFromToken(String token) {
        //TODO: set the signing key
        return Jwts.parser().
                //setSigningKey(secret).
                        parseClaimsJws(token).getBody();
    }

    public static <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    public static Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    private static Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
}
