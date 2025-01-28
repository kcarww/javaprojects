package com.example.meusgastos.security;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.example.meusgastos.domain.model.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
    @Value("${auth.jwt.secret}")
    private String jwtSecret;

    @Value("${auth.jwt-expiration-milliseg}")
    private Long jwtExpirationMilliseg;

    public String gerarToken(Authentication authentication) {
        Date dataExpiracao = new Date(new Date().getTime() + jwtExpirationMilliseg);

        Usuario usuario = (Usuario) authentication.getPrincipal();

        try {
            Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes("UTF-8"));

            return Jwts.builder()
                .subject(usuario.getUsername())
                .issuedAt(new Date())
                .expiration(dataExpiracao)
                .signWith(key)
                .compact();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "";
        }
        
    }

    private Claims getClaims(String token) {
        try {
            Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes("UTF-8"));
            SecretKey secretKey = (SecretKey) key;
            
            Claims claims =  Jwts.parser()
            .verifyWith(secretKey)
            .build()
            .parseSignedClaims(token)
            .getPayload();

            return claims;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getUserName (String token) {
        Claims claims = getClaims(token);
        if (claims != null) {
            return claims.getSubject();
        }
        return null;
    }

    public boolean isValidToken(String token) {
        Claims claims = getClaims(token);
        if (claims == null) {
            return false;
        }
        
        String email = claims.getSubject();
        Date dataExpiracao = claims.getExpiration();
        Date dataAtual = new Date(System.currentTimeMillis());
        
        if (email != null && dataAtual.before(dataExpiracao)) {
            return true;
        }

        return false;
    }
}
