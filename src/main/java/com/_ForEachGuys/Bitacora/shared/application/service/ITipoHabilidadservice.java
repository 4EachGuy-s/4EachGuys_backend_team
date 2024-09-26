package com._ForEachGuys.Bitacora.shared.application.service;

import java.util.List;
import java.util.Optional;

import com._ForEachGuys.Bitacora.shared.domain.entity.TipoHabilidad;

public interface ITipoHabilidadservice {
    List<TipoHabilidad> findAll();
    Optional<TipoHabilidad> findById(Long id);
    TipoHabilidad save(TipoHabilidad tipoHabilidad);
    TipoHabilidad update(TipoHabilidad tipoHabilidad);
    void deleteById(Long id);
}