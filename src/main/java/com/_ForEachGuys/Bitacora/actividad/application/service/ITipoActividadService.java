package com._ForEachGuys.Bitacora.actividad.application.service;

import java.util.List;
import java.util.Optional;

import com._ForEachGuys.Bitacora.shared.domain.entity.TipoActividad;

public interface ITipoActividadService {
    List<TipoActividad> findAll();
    Optional<TipoActividad> findById(Long id);
    TipoActividad save(TipoActividad tipoActividad);
    TipoActividad update(TipoActividad tipoActividad);
    void deleteById(Long id);
}