package com._ForEachGuys.Bitacora.shared.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com._ForEachGuys.Bitacora.shared.domain.entity.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    
}