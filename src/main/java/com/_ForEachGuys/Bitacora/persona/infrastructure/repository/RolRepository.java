package com._ForEachGuys.Bitacora.persona.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com._ForEachGuys.Bitacora.shared.domain.entity.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {
    
}