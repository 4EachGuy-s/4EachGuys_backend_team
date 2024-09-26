package com._ForEachGuys.Bitacora.shared.application.service;

import java.util.List;
import java.util.Optional;

import com._ForEachGuys.Bitacora.shared.domain.entity.Estado;

public interface IEstadoService {
    List<Estado> findAll();
    Optional<Estado> findById(Long id);
    Estado save(Estado estado);
    Estado update(Estado estado);
    void deleteById(Long id);
}