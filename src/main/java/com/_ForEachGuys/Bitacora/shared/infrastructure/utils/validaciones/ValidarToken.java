package com._ForEachGuys.Bitacora.shared.infrastructure.utils.validaciones;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import com._ForEachGuys.Bitacora.shared.domain.FirmaSecreta;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;

public class ValidarToken {

    public static boolean validar(Cookie[] cookies) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                // Verificar el nombre de la cookie
                if ("auth_token".equals(cookie.getName())) {
                    // Obtener valores de la cookie
                    String token = cookie.getValue();
                    // Firma secreta
                    final String SECRET_KEY = FirmaSecreta.getFirma();
                    // Obtener la clave secreta
                    final SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
                    try {
                        // Decodificar el token
                        Claims claims = Jwts.parser()
                                .verifyWith(key)
                                .build()
                                .parseSignedClaims(token)
                                .getPayload();

                        // Verificar si expiró el token
                        if (claims.getExpiration().after(new Date())) {
                            return true; // El token no ha expirado y es valido
                        }

                    } catch (JwtException e) {
                        return false;
                    }
                }
            }
        }

        // No se encontró la cookie
        return false;
    }

}
