package com._ForEachGuys.Bitacora.shared.domain;

import java.security.SecureRandom;
import java.util.Base64;


public class FirmaSecreta {

    private static FirmaSecreta key;
    private final int longitud = 32;
    private final String firma;

    private FirmaSecreta() {

        byte[] bites = new byte[longitud];
        SecureRandom secureRandom = new SecureRandom();

        secureRandom.nextBytes(bites);

        this.firma = Base64.getEncoder().encodeToString(bites);

    }

    public static String getFirma() {

        if(key == null) {
            key = new FirmaSecreta();
            return key.firma;
        }
        else {
            return key.firma;
        }

    }
    
}
