package com._ForEachGuys.Bitacora.services.personas.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com._ForEachGuys.Bitacora.repositories.entities.Persona;
import com._ForEachGuys.Bitacora.repositories.interfaces.PersonaRepository;
import com._ForEachGuys.Bitacora.services.personas.PersonasService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PersonasServiceImpl implements PersonasService {

    /* Repositorio de personas */
    private final PersonaRepository personaRepository;

    @Override
    public Persona buscarUsuario(final String username) {
        Optional<Persona> persona = personaRepository.findByUsername(username);

        if(persona.isPresent()) {
            System.out.println(persona.get());
            return persona.get();
        }
        else {
            return null;
        }
    }
    
}
