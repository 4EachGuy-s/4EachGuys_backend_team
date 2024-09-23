package com._ForEachGuys.Bitacora.repositories.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com._ForEachGuys.Bitacora.repositories.entities.Persona;



public interface PersonaRepository extends JpaRepository<Persona, Long> {

    Optional<Persona> findById(long id);

    Optional<Persona> findByEmail(String email);

    Optional<Persona> findByDni(long dni);
    
}
