package com._ForEachGuys.Bitacora.auth.infrastructure.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // Anotaciones para controlar solicitudes HTTP

import com._ForEachGuys.Bitacora.auth.application.service.IAuthServic;
import com._ForEachGuys.Bitacora.shared.domain.entity.Persona;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/v1/auth") // Mapea las solicitudes a la ruta base "/auth"
public class AuthenticationController {
    private final IAuthServic authService;
    
 @Autowired
    public AuthenticationController(IAuthServic authService){
        this.authService = authService;
    }

    @GetMapping
    public List<Persona> getAllPersonas() {
        return authService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable Long id) {
        Optional<Persona> Persona = authService.findById(id);
        if (Persona.isPresent()) {
            return ResponseEntity.ok(Persona.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Persona> createPersona(@RequestBody Persona Persona) {
    Persona savedPersona = authService.save(Persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPersona);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable Long id, @RequestBody Persona Persona) {
        Persona.setIdPersona(id);
        try{
            Persona updatePersona = authService.update(Persona);
            return ResponseEntity.ok(updatePersona);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable Long id) {
        try{
            authService.deletedById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND). build();
        }
    }   
    
}