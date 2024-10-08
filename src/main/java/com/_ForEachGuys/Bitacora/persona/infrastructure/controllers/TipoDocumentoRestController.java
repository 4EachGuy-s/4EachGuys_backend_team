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

import com._ForEachGuys.Bitacora.persona.application.service.ITipoDocumentoService;
import com._ForEachGuys.Bitacora.shared.domain.entity.TipoDocumento;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/tipoDocumento")
public class TipoDocumentoRestController {
    private final ITipoDocumentoService tipoDocumentoService;

    @Autowired
    public TipoDocumentoRestController(ITipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }

    @GetMapping
    public List<TipoDocumento> getAllTipoDocumento() {
        return tipoDocumentoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDocumento> getTipoDocumentoById(@PathVariable Long id) {
        Optional<TipoDocumento> tipoDocumento = tipoDocumentoService.findById(id);
        if (tipoDocumento.isPresent()) {
            return ResponseEntity.ok(tipoDocumento.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<TipoDocumento> createTipoDocumento(@RequestBody TipoDocumento tipoDocumento) {
        TipoDocumento savedTipoDocumento = tipoDocumentoService.save(tipoDocumento);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTipoDocumento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDocumento> updateTipoDocumento(@PathVariable Long id, @RequestBody TipoDocumento tipoDocumento) {
        tipoDocumento.setIdTipoDocumento(id);
        try {
            TipoDocumento updateTipoDocumento = tipoDocumentoService.update(tipoDocumento);
            return ResponseEntity.ok(updateTipoDocumento);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoDocumento(@PathVariable Long id) {
        try {
            tipoDocumentoService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}