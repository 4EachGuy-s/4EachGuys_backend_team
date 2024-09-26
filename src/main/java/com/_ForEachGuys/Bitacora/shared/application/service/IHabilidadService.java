package com._ForEachGuys.Bitacora.shared.application.service;

import java.util.List;
import java.util.Optional;

import com._ForEachGuys.Bitacora.shared.domain.entity.Habilidad;

public interface IHabilidadService {
    List<Habilidad> findAll();
    Optional<Habilidad> findById(Long id);
    Habilidad save(Habilidad habilidad);
    Habilidad update(Habilidad habilidad);
    void deleteById(Long id);
}