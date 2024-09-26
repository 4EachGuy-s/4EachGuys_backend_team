package com._ForEachGuys.Bitacora.proyecto.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com._ForEachGuys.Bitacora.shared.domain.entity.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
    
}