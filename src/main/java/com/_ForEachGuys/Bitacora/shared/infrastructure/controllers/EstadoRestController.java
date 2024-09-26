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

import com._ForEachGuys.Bitacora.shared.application.service.IEstadoService;
import com._ForEachGuys.Bitacora.shared.domain.entity.Estado;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/estado")
public class EstadoRestController {
    private final IEstadoService estadoService;

    @Autowired
    public EstadoRestController(IEstadoService estadoService){
        this.estadoService = estadoService;
    }

    @GetMapping
    public List<Estado> getAllEstado() {
        return estadoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> getEstadoById(@PathVariable Long id) {
        Optional<Estado> estado = estadoService.findById(id);
        if (estado.isPresent()) {
            return ResponseEntity.ok(estado.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Estado> createEstado(@RequestBody Estado estado) {
    Estado savedEstado = estadoService.save(estado);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEstado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> updateEstado(@PathVariable Long id, @RequestBody Estado estado) {
        estado.setIdEstado(id);
        try{
            Estado updateEstado = estadoService.update(estado);
            return ResponseEntity.ok(updateEstado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstado(@PathVariable Long id) {
        try{
            estadoService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND). build();
        }
    }
}