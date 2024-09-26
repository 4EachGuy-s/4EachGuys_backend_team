package com._ForEachGuys.Bitacora.persona.application.service;

import java.util.List;
import java.util.Optional;

import com._ForEachGuys.Bitacora.shared.domain.entity.Contacto;

public interface IContactoService {
    List<Contacto> findAll();
    Optional<Contacto> findById(Long id);
    Contacto save(Contacto contacto);
    Contacto update(Contacto contacto);
    void deleteById(Long id);
}