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
import com._ForEachGuys.Bitacora.shared.application.service.IHabilidadService;
import com._ForEachGuys.Bitacora.shared.domain.entity.Habilidad;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/habilidad")
public class HabilidadRestController {
    private final IHabilidadService habilidadService;

    @Autowired
    public HabilidadRestController(IHabilidadService habilidadService) {
        this.habilidadService = habilidadService;
    }

    @GetMapping
    public List<Habilidad> getAllHabilidades() {
        return habilidadService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habilidad> getHabilidadById(@PathVariable Long id) {
        Optional<Habilidad> habilidad = habilidadService.findById(id);
        if (habilidad.isPresent()) {
            return ResponseEntity.ok(habilidad.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Habilidad> createHabilidad(@RequestBody Habilidad habilidad) {
        Habilidad savedHabilidad = habilidadService.save(habilidad);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHabilidad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habilidad> updateHabilidad(@PathVariable Long id, @RequestBody Habilidad habilidad) {
        habilidad.setIdHabilidad(id);
        try {
            Habilidad updateHabilidad = habilidadService.update(habilidad);
            return ResponseEntity.ok(updateHabilidad);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        try {
            habilidadService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}