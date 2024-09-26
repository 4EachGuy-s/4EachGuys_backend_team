package com._ForEachGuys.Bitacora.persona.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com._ForEachGuys.Bitacora.shared.domain.entity.Contacto;

public interface ContactoRepository extends JpaRepository<Contacto, Long> {
    
}
