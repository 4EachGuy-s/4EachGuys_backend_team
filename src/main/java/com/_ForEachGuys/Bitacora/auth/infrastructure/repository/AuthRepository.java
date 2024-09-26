package com._ForEachGuys.Bitacora.auth.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com._ForEachGuys.Bitacora.shared.domain.entity.Persona;

@Repository
public interface AuthRepository  extends JpaRepository<Persona, Long> {

}