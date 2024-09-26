package com._ForEachGuys.Bitacora.log.application.service;

import java.util.List;
import java.util.Optional;

import com._ForEachGuys.Bitacora.shared.domain.entity.Actividad;

public interface ILogServiceActividad {
    List<Actividad> findAll();
    Optional<Actividad> findById(Long id);
    Actividad save(Actividad actividad);
    Actividad update(Actividad actividad);
    void deleteById(Long id);    
}
