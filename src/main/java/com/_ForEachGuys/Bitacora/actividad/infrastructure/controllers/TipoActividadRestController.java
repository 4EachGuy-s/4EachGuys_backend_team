package com._ForEachGuys.Bitacora.actividad.infrastructure.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com._ForEachGuys.Bitacora.actividad.application.service.ITipoActividadService;
import com._ForEachGuys.Bitacora.shared.domain.entity.TipoActividad;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/tipoActividad")
public class TipoActividadRestController {
    private final ITipoActividadService tipoActividadService;

    @Autowired
    public TipoActividadRestController(ITipoActividadService tipoActividadService){
        this.tipoActividadService = tipoActividadService;
    }

    @GetMapping
    public List<TipoActividad> getAllTipoActividad() {
        return tipoActividadService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoActividad> getTipoActividadById(@PathVariable Long id) {
        Optional<TipoActividad> tipoActividad = tipoActividadService.findById(id);
        if (tipoActividad.isPresent()) {
            return ResponseEntity.ok(tipoActividad.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<TipoActividad> createTipoActividad(@RequestBody TipoActividad tipoActividad) {
        TipoActividad savedTipoActividad = tipoActividadService.save(tipoActividad);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTipoActividad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoActividad> updateTipoActividad(@PathVariable Long id, @RequestBody TipoActividad tipoActividad) {
        tipoActividad.setIdTipoActividad(id);
        try{
            TipoActividad updateTipoActividad = tipoActividadService.update(tipoActividad);
            return ResponseEntity.ok(updateTipoActividad);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoActividad(@PathVariable Long id) {
        try{
            tipoActividadService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND). build();
        }
    }
}