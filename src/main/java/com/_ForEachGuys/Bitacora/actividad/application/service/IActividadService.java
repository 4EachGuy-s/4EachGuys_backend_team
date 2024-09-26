package com._ForEachGuys.Bitacora.actividad.application.service;

import java.util.List;
import java.util.Optional;

import com._ForEachGuys.Bitacora.shared.domain.entity.Actividad;

public interface IActividadService {
    List<Actividad> findAll();
    Optional<Actividad> findById(Long id);
    Actividad save(Actividad chapter);
    Actividad update(Actividad chapter);
    void deleteById(Long id);
}
