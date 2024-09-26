package com._ForEachGuys.Bitacora.shared.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com._ForEachGuys.Bitacora.shared.domain.entity.TipoHabilidad;

public interface TipoHabilidadRepository extends JpaRepository<TipoHabilidad, Long> {
    
}