package com._ForEachGuys.Bitacora.shared.infrastructure.utils.extracciones;

import java.util.Optional;

import com._ForEachGuys.Bitacora.shared.domain.entity.Contacto;

public class ExtraerContactoPersona {

    public static Contacto extraerContactos(final Optional<Contacto> contacto) {
        if(contacto.isPresent()) {
            return contacto.get();
        }
        else {
            return null;
        }
    }
    
}
