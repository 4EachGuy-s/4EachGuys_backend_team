package com._ForEachGuys.Bitacora.shared.infrastructure.controllers;

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
import com._ForEachGuys.Bitacora.shared.application.service.ITipoHabilidadservice;
import com._ForEachGuys.Bitacora.shared.domain.entity.TipoHabilidad;
import jakarta.persistence.EntityNotFoundException;


@RestController
@RequestMapping("/tipoHabilidad")
public class TipoHabilidadRestController {
    private final ITipoHabilidadservice tipoHabilidadservice;

    @Autowired
    public TipoHabilidadRestController(ITipoHabilidadservice tipoHabilidadservice) {
        this.tipoHabilidadservice = tipoHabilidadservice;
    }

    @GetMapping
    public List<TipoHabilidad> getAllTipoHabilidad() {
        return tipoHabilidadservice.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoHabilidad> getTipoHabilidadById(@PathVariable Long id) {
        Optional<TipoHabilidad> tipoHabilidad = tipoHabilidadservice.findById(id);
        if (tipoHabilidad.isPresent()) {
            return ResponseEntity.ok(tipoHabilidad.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<TipoHabilidad> createTipoHabilidad(@RequestBody TipoHabilidad tipoHabilidad) {
        TipoHabilidad savedTipoHabilidad = tipoHabilidadservice.save(tipoHabilidad);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTipoHabilidad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoHabilidad> updateTipoHabilidad(@PathVariable Long id, @RequestBody TipoHabilidad tipoHabilidad) {
        tipoHabilidad.setIdTipoHabilidad(id);
        try {
            TipoHabilidad updateTipoHabilidad = tipoHabilidadservice.update(tipoHabilidad);
            return ResponseEntity.ok(updateTipoHabilidad);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoHabilidad(@PathVariable Long id) {
        try {
            tipoHabilidadservice.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}