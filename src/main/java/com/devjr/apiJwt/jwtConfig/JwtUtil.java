package com.devjr.apiJwt.jwtConfig;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${secret.key}")
    private String SECRET_KEY;

    @Value("${time.expiration}")
    private Long TIME_EXPIRATION;

    private Key getKey(){
        return new SecretKeySpec(SECRET_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());
    }

    public String generationToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+TIME_EXPIRATION))
                .signWith(getKey())
                .compact();
    }

    public String extractUsername(String token){
        JwtParser parser = Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build();

        Claims claims = parser.parseClaimsJws(token).getBody();

        return claims.getSubject();
    }

    public boolean tokenExpiration(String token){
        JwtParser parser = Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build();

        Claims claims = parser.parseClaimsJws(token).getBody();

        return claims.getExpiration()
                .before(new Date());
    }

    public boolean validateToken(String token,String username){
        return username.equals(extractUsername(token)) && !tokenExpiration(token);
    }









}
