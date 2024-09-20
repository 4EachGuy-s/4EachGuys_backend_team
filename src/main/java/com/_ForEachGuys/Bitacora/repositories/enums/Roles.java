package com._ForEachGuys.Bitacora.repositories.enums;

import java.util.Arrays;

public enum Roles {
    ADMINISTRADOR,
    COLABORADOR;

    public static boolean existe(String rol) {
        return Arrays.stream(
                Roles.values()).anyMatch(r -> r.name().equalsIgnoreCase(rol));
    }
}
