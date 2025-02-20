package com.leoholmer.AllMusic.Backend.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class JwtTokenUtil {

    private static final String SECRET_KEY = "your-secret-key"; // Cambia esto por una clave segura
    private static final long EXPIRATION_TIME = 10 * 24 * 60 * 60 * 1000; // 10 días en milisegundos

    public String generateToken(String subject) {
        return "Bearer " + JWT.create()
                .withSubject(subject)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET_KEY));
    }

    public boolean verify(String token) {
        try {
            JWT.require(Algorithm.HMAC512(SECRET_KEY)).build().verify(token.replace("Bearer ", ""));
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }

    public String getSubject(String token) {
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512(SECRET_KEY)).build().verify(token.replace("Bearer ", ""));
        return decodedJWT.getSubject();
    }
}