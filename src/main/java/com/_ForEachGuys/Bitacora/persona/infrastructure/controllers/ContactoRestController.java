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

import com._ForEachGuys.Bitacora.persona.application.service.IContactoService;
import com._ForEachGuys.Bitacora.shared.domain.entity.Contacto;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/contacto")
public class ContactoRestController {
    private final IContactoService contactoService;

    @Autowired
    public ContactoRestController(IContactoService contactoService) {
        this.contactoService = contactoService;
    }

    @GetMapping
    public List<Contacto> getAllContacto() {
        return contactoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contacto> getContactoById(@PathVariable Long id) {
        Optional<Contacto> contacto = contactoService.findById(id);
        if (contacto.isPresent()) {
            return ResponseEntity.ok(contacto.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Contacto> createContacto(@RequestBody Contacto contacto) {
        Contacto savedContacto = contactoService.save(contacto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedContacto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contacto> updateContacto(@PathVariable Long id, @RequestBody Contacto contacto) {
        contacto.setIdContacto(id);
        try {
            Contacto updateContacto = contactoService.update(contacto);
            return ResponseEntity.ok(updateContacto);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContacto(@PathVariable Long id) {
        try {
            contactoService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}