package com._ForEachGuys.Bitacora.shared.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com._ForEachGuys.Bitacora.shared.domain.entity.Contacto;

public interface ContactoRepository extends JpaRepository<Contacto, Long> {

    Optional<Contacto> findByCorreoElectronico(String email);
    
}
