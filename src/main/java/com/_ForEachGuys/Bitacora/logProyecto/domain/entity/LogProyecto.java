package com._ForEachGuys.Bitacora.logProyecto.domain.entity;

import java.time.LocalDate;

import com._ForEachGuys.Bitacora.persona.domain.entity.Persona;
import com._ForEachGuys.Bitacora.proyecto.domain.entity.Proyecto;

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
@Table(name = "log_proyecto")
public class LogProyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLogProyecto;

    private String titulo;
    private String tiempo;
    private LocalDate fechaEntrega;
    private String actividades;
    private String prioridad;
    private String estadoProyecto;
    private LocalDate fechaLog;
    private Boolean activo;
    private String comentarios;
    private String accion;

    @ManyToOne
    @JoinColumn(name = "id_persona_responsable")
    private Persona personaResponsable;

    @ManyToOne
    @JoinColumn(name = "id_proyecto")
    private Proyecto proyecto;

    // Getters y Setters
}
