package com._ForEachGuys.Bitacora.log.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com._ForEachGuys.Bitacora.shared.domain.entity.Persona;


@Repository
public interface LogRepositoryPersona extends JpaRepository<Persona,Long>{
    
}
