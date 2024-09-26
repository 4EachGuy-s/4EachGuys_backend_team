package com._ForEachGuys.Bitacora.shared.domain.entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "proyectos")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProyecto;

    @Column(nullable = false, unique = true)
    private UUID codigo;

    /**
     * @param tiempo Hace referencia al tiempo total invertido en el proyecto
     */
    private double tiempo;

    @Temporal(TemporalType.DATE)
    private LocalDate fechaEntrega;

    @Size(min = 3, message = "EL título del proyecto no puede estar vacío, mínimo 3 caracteres")
    @Column(nullable = false)
    private String titulo;

    /**
     * @param estadoProyecto Hace referencia a los estados del proyecto
     *                       activa, pausa, finalizada, cancelada
     */

    @ManyToOne
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estadoProyecto;

    /**
     * @param personaResponsable Hace referencia a la persona a cargo de la
     *                           actividad
     */
    @ManyToOne
    @JoinColumn(name = "id_persona_responsable", nullable = false)
    private Persona personaResponsable;

    @ManyToOne
    @JoinColumn(name = "id_prioridad")
    private Prioridad prioridad;

    /**
     * @param esActivo Hace referencia a si el proyecto esta en progreso o finalizó
     *                 / se canceló
     *                 true en progreso y se puede gestionar
     */
    @Column(nullable = false)
    private boolean esActivo;

    public Long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Long idProyecto) {
        this.idProyecto = idProyecto;
    }
}