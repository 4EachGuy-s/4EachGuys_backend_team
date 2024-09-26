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

import com._ForEachGuys.Bitacora.log.application.service.ILogServicePersona;
import com._ForEachGuys.Bitacora.shared.domain.entity.Persona;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/log-persona")
public class LogRestPersonaController {
    private final ILogServicePersona logServicePersona;
    
       @Autowired
    public LogRestPersonaController(ILogServicePersona logServicePersona){
        this.logServicePersona = logServicePersona;
    }

    @GetMapping
    public List<Persona> getAllPersonas() {
        return logServicePersona.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable Long id) {
        Optional<Persona> persona = logServicePersona.findById(id);
        if (persona.isPresent()) {
            return ResponseEntity.ok(persona.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Persona> createPersona(@RequestBody Persona Persona) {
    Persona savedPersona = logServicePersona.save(Persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPersona);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable Long id, @RequestBody Persona Persona) {
        Persona.setIdPersona(id);
        try{
            Persona updatePersona = logServicePersona.update(Persona);
            return ResponseEntity.ok(updatePersona);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable Long id) {
        try{
            logServicePersona.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND). build();
        }
    }
}
