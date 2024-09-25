package com._ForEachGuys.Bitacora.logPersona.domain.entity;

import com._ForEachGuys.Bitacora.persona.domain.entity.Persona;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "log_persona")
public class LogPersona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLogPersona;

    private String password;
    private String estado;
    private String accion;
    private String comentarios;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    // Getters y Setters
}
