package com.paydala.common.util;

import com.paydala.common.auth.pojos.TokenDetails;
import com.paydala.common.exception.JwtException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

public class JwtHelper {

    public final static Logger LOG = LoggerFactory.getLogger(JwtHelper.class);

    private static final long ttlMillis = System.getenv("JWT_TTL") != null ?
            Long.valueOf(System.getenv("JWT_TTL")) : 3600000;

    //private static final String RSA_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlWl/R2rv0ZsaQdQGMkhnx" +
    //        "ArFXMlxZcXlVLqLTexDHG5wDjf2sMbR4kz7ICaAxnnBbrPBrERzIR2daOF0sNwOryQvd7QlbHNKNrHeC+GFiSb2sJsKxlKsq0N52YG" +
    //        "9YsrDWqox1yap8rxf0g82/QMx8cqkTQ2/Ev7tUug+xDqBMl1N9gESMfo2527I0W8Wu1l3U67DO+QX8OzByKGzEVl1zzJejZZZaABSC" +
    //        "o2Ydq8RBXZaEjREzKz1sWD4wc2smuROkDAaFt6zhHKFTIn2WHfdxX5RyqUYqGfRgYPW7hq02Qo632tTyALNpGRStu7CBiDB5hro1Xs" +
    //        "lXcNDpeUtafs36QIDAQAB";

    private static final String RSA_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjmAeNZDKhJJP+EXt0FtEfS" +
            "Lqqbkrj3wUINs/+/c2CaUU9IsY48Ai29KheEwl94n4YM3vxCzLEhKBfdFQPbGfFYPRQrmVqTtz8VTNCmpor7B8lm+amU6Z3aXjY7rNkx" +
            "UXpPr9byqiNJ9m/SD+jhlMcDpvzhZPfyU8yyoZqYJlr/ZVND9t7QQwnDush4BI6pMq/5ESkJ+VKLqpo3jZO512+XJD9vUdEYdOyOQUWs" +
            "kSzYjO1LCSpWtjwoSwzq9QZhnUtmjeRErshipcogEs+Y8lTZ+PPtULAKWfRAbGIEJUoantE0llaZVPwu8g8509N8dz3tzRFXovlXQumW" +
            "cd2Vt8wQIDAQAB";

    public static String createJWT(Map<String, Object> claims) {

        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        try {
            RSAPrivateKey privateKey = (RSAPrivateKey) getPrivateKey("/Users/mahesh/workspace/paydala/jwtcert/id_rsa");

            String id = UUID.randomUUID().toString();
            //Let's set the JWT Claims
            JwtBuilder builder = Jwts.builder().setId(id)
                    .setIssuedAt(now)
                    .setSubject("GUEST_LOGIN")
                    .setIssuer("Paydala").setClaims(claims)
                    .signWith(signatureAlgorithm, privateKey);

            //if it has been specified, let's add the expiration
            if (ttlMillis > 0) {
                long expMillis = nowMillis + ttlMillis;
                Date exp = new Date(expMillis);
                builder.setExpiration(exp);
            }

            //Builds the JWT and serializes it to a compact, URL-safe string
            return builder.compact();
        } catch (Exception ex) {
            LOG.error("Jwt Error :", ex);
            throw new JwtException("Error creating JWT token: " + ex.getMessage());
        }
    }

    private static RSAPrivateKey getPrivateKey(String filename) throws NoSuchAlgorithmException, IOException, InvalidKeySpecException {

        File file = new File(filename);
        FileInputStream fis = new FileInputStream(file);
        DataInputStream dis = new DataInputStream(fis);

        byte[] keyBytes = new byte[(int) file.length()];
        dis.readFully(keyBytes);
        dis.close();

        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        RSAPrivateKey privateKey = (RSAPrivateKey) keyFactory.generatePrivate(spec);

        return privateKey;
    }

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
        try {
            //LOG.info("Verifying token : {}", token);
            byte[] decodedKey = Base64.getDecoder().decode(RSA_PUBLIC_KEY);
            //byte[] publicKeyBytes = decodedKey.getBytes();

            // create a key object from the bytes
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decodedKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPublicKey publicKey = (RSAPublicKey) keyFactory.generatePublic(keySpec);
            //Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) jwk.getPublicKey(), null);
            return Jwts.parser().
                    setSigningKey(publicKey).
                    parseClaimsJws(token).getBody();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            LOG.error("Error decoding JWT token:", ex);
            throw new JwtException("Error decoding JWT token: " + ex.getMessage());
        }
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
