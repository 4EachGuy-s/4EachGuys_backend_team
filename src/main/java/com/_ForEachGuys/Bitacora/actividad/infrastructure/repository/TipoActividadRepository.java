package com._ForEachGuys.Bitacora.actividad.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com._ForEachGuys.Bitacora.shared.domain.entity.TipoActividad;

public interface TipoActividadRepository extends JpaRepository<TipoActividad, Long> {
    
}