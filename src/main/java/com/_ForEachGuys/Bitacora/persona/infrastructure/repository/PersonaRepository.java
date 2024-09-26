package com._ForEachGuys.Bitacora.persona.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com._ForEachGuys.Bitacora.shared.domain.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    
}