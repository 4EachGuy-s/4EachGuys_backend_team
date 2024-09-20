package com._ForEachGuys.Bitacora.utils.validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Esta clase extrae el nombre de la tabla en excepción DataIntegrityViolationException

public class ExtraerDataExceptionSQL {
    
    public static String nombreTabla(String mensaje) {
        Pattern tabla = Pattern.compile("into (\\w+)");
        Matcher matcher = tabla.matcher(mensaje);
        if(matcher.find()) {
            return matcher.group(1);
        }
        else {
            return "desconocido/a";
        }
    }

    public static String valorDuplicado(String mensaje) {
        Pattern valor = Pattern.compile("Duplicate entry '([^']+)'");
        Matcher matcher = valor.matcher(mensaje);

        if(matcher.find()) {
            return matcher.group(1);
        }
        else {
            return "desconocido/a";
        }
    }

}
