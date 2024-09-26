package com._ForEachGuys.Bitacora.shared.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com._ForEachGuys.Bitacora.shared.domain.entity.Persona;

public interface AdministradorRepository extends JpaRepository<Persona, Long> {
    
}