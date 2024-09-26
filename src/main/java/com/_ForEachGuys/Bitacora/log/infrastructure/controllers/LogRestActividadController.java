package com._ForEachGuys.Bitacora.log.infrastructure.controllers;

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

import com._ForEachGuys.Bitacora.log.application.service.ILogServiceActividad;
import com._ForEachGuys.Bitacora.shared.domain.entity.Actividad;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/log-actividad")
public class LogRestActividadController {
    
    private final ILogServiceActividad logServiceActividad;

    @Autowired
    public LogRestActividadController(ILogServiceActividad logServiceActividad){
        this.logServiceActividad = logServiceActividad;
    }

    @GetMapping
    public List<Actividad> getAllActividads() {
        return logServiceActividad.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actividad> getActividadById(@PathVariable Long id) {
        Optional<Actividad> actividad = logServiceActividad.findById(id);
        if (actividad.isPresent()) {
            return ResponseEntity.ok(actividad.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Actividad> createActividad(@RequestBody Actividad Actividad) {
    Actividad savedActividad = logServiceActividad.save(Actividad);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedActividad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actividad> updateActividad(@PathVariable Long id, @RequestBody Actividad Actividad) {
        Actividad.setIdActividad(id);
        try{
            Actividad updateActividad = logServiceActividad.update(Actividad);
            return ResponseEntity.ok(updateActividad);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActividad(@PathVariable Long id) {
        try{
            logServiceActividad.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND). build();
        }
    }    
}
