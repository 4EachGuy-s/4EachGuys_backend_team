package com._ForEachGuys.Bitacora.shared.infrastructure.utils.validaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncodeUtil {

    @Autowired
    private static PasswordEncoder passwordEncode;

    public static String encriptar(final String password) {
        return passwordEncode.encode(password);
    }

    public static boolean validar(final String password, String passEncode) {
        return passwordEncode.matches(password, passEncode);
    }
    
}
