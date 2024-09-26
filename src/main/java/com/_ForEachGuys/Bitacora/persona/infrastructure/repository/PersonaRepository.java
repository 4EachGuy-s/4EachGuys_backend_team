package com._ForEachGuys.Bitacora.persona.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com._ForEachGuys.Bitacora.shared.domain.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

    @Query(value = "SELECT p.id_persona, p.p_nombre, p.s_nombre, p.p_apellido, p.s_apellido, " +
            "p.dni, p.fecha_nacimiento, p.password, p.id_tipo_documento, p.id_contacto, p.id_rol " +
            "FROM personas p " +
            "INNER JOIN contactos c ON p.id_contacto = c.id_contacto " +
            "WHERE c.correo_electronico = :email", nativeQuery = true)
    Optional<Persona> findByEmail(String email);

    Optional<Persona> findByDni(String dni);

}
