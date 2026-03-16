package com.authentication.book_order.auth_service.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

import javax.crypto.SecretKey;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {

    private static final SecretKey key =
            Keys.hmacShaKeyFor("mysecretkeymysecretkeymysecretkey".getBytes());

    public static String generateToken(String username) {

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}
