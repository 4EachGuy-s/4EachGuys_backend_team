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

import com._ForEachGuys.Bitacora.shared.application.service.IAdministradorService;
import com._ForEachGuys.Bitacora.shared.domain.entity.Persona;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/v1/")
public class AdministradorRestController {
    private final IAdministradorService administradorService;

    @Autowired
    public AdministradorRestController(IAdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @GetMapping
    public List<Persona> getAllAdministradores() {
        return administradorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getAdministradoresById(@PathVariable Long id) {
        Optional<Persona> administrador = administradorService.findById(id);
        if (administrador.isPresent()) {
            return ResponseEntity.ok(administrador.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Persona> createAdministrador(@RequestBody Persona persona) {
        Persona savedAdministrador = administradorService.save(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAdministrador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> updateAdministrador(@PathVariable Long id, @RequestBody Persona persona) {
        //persona.setIdPersona(id);
        try {
            Persona updateAdministrador = administradorService.update(persona);
            return ResponseEntity.ok(updateAdministrador);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministrador(@PathVariable Long id) {
        try {
            administradorService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}