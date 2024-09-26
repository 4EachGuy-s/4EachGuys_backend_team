package com._ForEachGuys.Bitacora.actividad.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com._ForEachGuys.Bitacora.shared.domain.entity.Actividad;

public interface ActividadRepository extends JpaRepository<Actividad, Long>{
    
}