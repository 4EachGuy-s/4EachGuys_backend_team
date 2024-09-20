package com._ForEachGuys.Bitacora.config.security;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

public class ManagerCookies {

    public static void crearCookieJWT(HttpServletResponse response, String nombre, String token, int duracion) {
        Cookie cookie = new Cookie(nombre, token);

        cookie.setHttpOnly(true);
        cookie.setMaxAge(duracion);
        cookie.setPath("/");
        cookie.setSecure(false); // Configurar como true si solo se permite envíos por HTTPS

        // Añadir el cookie a la respuesta HTTP
        response.addCookie(cookie);
    }

    public static void eliminarCookie(HttpServletResponse response, String nombre) {
        Cookie cookie = new Cookie(nombre, "");

        cookie.setMaxAge(0);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        
        // Añadir el cookie a la respuesta HTTP
        response.addCookie(cookie);
    }
    
}
