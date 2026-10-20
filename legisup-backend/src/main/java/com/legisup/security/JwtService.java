package com.legisup.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    private static final String SECRET_KEY = "legisup_secret_key_para_assinatura_jwt_muito_segura_2026";
    private static final long EXPIRATION_TIME = 86400000; // 24 Horas

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    public String gerarToken(String username, String perfil) {
        return Jwts.builder()
                .subject(username)
                .claim("perfil", perfil)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey())
                .compact();
    }

    public String obterUsernameDoToken(String token) {
        return obterClaims(token).getSubject();
    }

    public boolean validarToken(String token) {
        try {
            obterClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Claims obterClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}