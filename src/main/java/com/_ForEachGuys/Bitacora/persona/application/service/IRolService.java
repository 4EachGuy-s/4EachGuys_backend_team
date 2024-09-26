package com._ForEachGuys.Bitacora.persona.application.service;

import java.util.List;
import java.util.Optional;
import com._ForEachGuys.Bitacora.shared.domain.entity.Rol;

public interface IRolService {
    List<Rol> findAll();
    Optional<Rol> findById(Long id);
    Rol save(Rol rol);
    Rol update(Rol rol);
    void deleteById(Long id);
}