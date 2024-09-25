package com._ForEachGuys.Bitacora.logActividad.domain.entity;

import java.time.LocalDate;

import com._ForEachGuys.Bitacora.actividad.domain.entity.Actividad;
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
@Table(name = "log_actividad")
public class LogActividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLogActividad;

    private String esActivo;
    private String tiempo;
    private String comentarios;
    private LocalDate inicioLabor;
    private String descripcion;
    private LocalDate inicioActividad;
    private LocalDate fechaLog;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "id_actividad")
    private Actividad actividad;

    // Getters y Setters
}
