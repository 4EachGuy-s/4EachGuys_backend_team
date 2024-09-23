package com._ForEachGuys.Bitacora.services.personas;

import com._ForEachGuys.Bitacora.repositories.entities.Persona;

public interface PersonasService {

    Persona buscarUsuario(String email);
    
}
