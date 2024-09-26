package com._ForEachGuys.Bitacora.auth.application.service;

import java.util.List;
import java.util.Optional;

import com._ForEachGuys.Bitacora.shared.domain.entity.Persona;

public interface IAuthServic {
    List<Persona> findAll();
    Optional<Persona> findById(Long id);
    Persona save(Persona persona);
    Persona update(Persona persona);
    void deletedById(Long id);
}
