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
import com._ForEachGuys.Bitacora.shared.application.service.IPrioridadService;
import com._ForEachGuys.Bitacora.shared.domain.entity.Prioridad;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/prioridad")
public class PrioridadRestController {
    private final IPrioridadService prioridadService;

    @Autowired
    public PrioridadRestController(IPrioridadService prioridadService){
        this.prioridadService = prioridadService;
    }

    @GetMapping
    public List<Prioridad> getAllPrioridad() {
        return prioridadService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prioridad> getPrioridadById(@PathVariable Long id) {
        Optional<Prioridad> prioridad = prioridadService.findById(id);
        if (prioridad.isPresent()) {
            return ResponseEntity.ok(prioridad.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Prioridad> createPrioridad(@RequestBody Prioridad prioridad) {
    Prioridad savedPrioridad = prioridadService.save(prioridad);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPrioridad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prioridad> updatePrioridad(@PathVariable Long id, @RequestBody Prioridad prioridad) {
        prioridad.setIdPrioridad(id);
        try{
            Prioridad updatePrioridad = prioridadService.update(prioridad);
            return ResponseEntity.ok(updatePrioridad);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrioridad(@PathVariable Long id) {
        try{
            prioridadService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND). build();
        }
    }
}