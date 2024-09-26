package com._ForEachGuys.Bitacora.log.application.service;

import java.util.List;
import java.util.Optional;

import com._ForEachGuys.Bitacora.shared.domain.entity.Proyecto;


public interface ILogServiceProyecto {
    List<Proyecto> findAll();
    Optional<Proyecto> findById(Long id);
    Proyecto save(Proyecto proyecto);
    Proyecto update(Proyecto proyecto);
    void deleteById(Long id);    
}
