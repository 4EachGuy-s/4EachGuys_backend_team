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

import com._ForEachGuys.Bitacora.log.application.service.ILogServiceProyecto;
import com._ForEachGuys.Bitacora.shared.domain.entity.Proyecto;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/log-proyectos")
public class LogRestProyectoController {

    private final ILogServiceProyecto logServiceProyecto;

    @Autowired
    public LogRestProyectoController(ILogServiceProyecto logServiceProyecto){
        this.logServiceProyecto = logServiceProyecto;
    }

    @GetMapping
    public List<Proyecto> getAllProyecto() {
        return logServiceProyecto.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> getProyectoById(@PathVariable Long id) {
        Optional<Proyecto> proyecto = logServiceProyecto.findById(id);
        if (proyecto.isPresent()) {
            return ResponseEntity.ok(proyecto.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Proyecto> createProyecto(@RequestBody Proyecto Proyecto) {
    Proyecto savedProyecto = logServiceProyecto.save(Proyecto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProyecto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyecto> updateProyecto(@PathVariable Long id, @RequestBody Proyecto Proyecto) {
        Proyecto.setIdProyecto(id);
        try{
            Proyecto updateProyecto = logServiceProyecto.update(Proyecto);
            return ResponseEntity.ok(updateProyecto);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProyecto(@PathVariable Long id) {
        try{
            logServiceProyecto.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND). build();
        }
    }
}
