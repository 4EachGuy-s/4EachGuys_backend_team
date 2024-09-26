package com._ForEachGuys.Bitacora.shared.application.service;

import java.util.List;
import java.util.Optional;

import com._ForEachGuys.Bitacora.shared.domain.entity.Prioridad;

public interface IPrioridadService {
    List<Prioridad> findAll();
    Optional<Prioridad> findById(Long id);
    Prioridad save(Prioridad prioridad);
    Prioridad update(Prioridad prioridad);
    void deleteById(Long id);
}