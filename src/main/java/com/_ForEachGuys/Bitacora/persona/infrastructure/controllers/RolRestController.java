package com._ForEachGuys.Bitacora.persona.infrastructure.controllers;

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
import com._ForEachGuys.Bitacora.persona.application.service.IRolService;
import com._ForEachGuys.Bitacora.shared.domain.entity.Rol;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/rol")
public class RolRestController {
    private final IRolService rolService;

    @Autowired
    public RolRestController(IRolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public List<Rol> getAllRol() {
        return rolService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> getRolById(@PathVariable Long id) {
        Optional<Rol> rol = rolService.findById(id);
        if (rol.isPresent()) {
            return ResponseEntity.ok(rol.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Rol> createRol(@RequestBody Rol rol) {
        Rol savedRol = rolService.save(rol);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRol);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> updateRol(@PathVariable Long id, @RequestBody Rol rol) {
        rol.setIdRol(id);
        try {
            Rol updateRol = rolService.update(rol);
            return ResponseEntity.ok(updateRol);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable Long id) {
        try {
            rolService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}