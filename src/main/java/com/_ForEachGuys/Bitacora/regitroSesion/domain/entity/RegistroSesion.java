package com._ForEachGuys.Bitacora.regitroSesion.domain.entity;

import java.time.LocalDate;

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
@Table(name = "registro_sesion")
public class RegistroSesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegistroSesion;

    private LocalDate tiempo;
    private String horaInicio;
    private String horaFin;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    // Getters y Setters
}
