package com._ForEachGuys.Bitacora.shared.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "actividades")
public class Actividad {

    public Long getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Long idActividad) {
        this.idActividad = idActividad;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActividad;

    @Column(nullable = false, unique = true)
    private UUID codigo;

    private Boolean esActiva;

    @Size(min = 3, message = "EL título de la actividad no puede estar vacío, mínimo 3 caracteres")
    @Column(nullable = false)
    private String titulo;

    /** 
     * @param inicioLabor Hace referencia al instante en donde la actividad está en estado
     * activo (la actividad está en progreso)
     */
    @Temporal(TemporalType.DATE)
    private LocalDate inicioLabor;

    /** 
     * @param inicioActividad Hace referencia al instante en donde la actividad fue creada 
    */

    @NotNull(message = "Para crearse una actividad, debe tener una fecha de inicio")
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)    
    private LocalDateTime inicioActividad;

    /** 
     * @param finActividad Hace referencia al instante en donde la actividad está en estado
     * finalizado o cancelado
    */

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime finActividad;

    private String descripcion;

    /** 
     * @param tiempo Hace referencia al tiempo total invertido en la actividad
     */
    private double tiempo;

    /** 
     * @param esActivo Hace referencia a si la tarea esta en progreso o finalizó / se canceló
     * true en progreso y se puede gestionar
     */
    @Column(nullable = false)
    private Boolean esActivo;

    /**
     * @param personaResponsable Hace referencia a la persona a cargo de la actividad
     */
    @ManyToOne
    @JoinColumn(
        name = "id_persona_responsable",
        nullable = false
        )
    private Persona personaResponsable;

    @ManyToOne
    @JoinColumn(
        name = "id_tipo_actividad",
        nullable = false
        )
    private TipoActividad tipoActividad;

    @ManyToOne
    @JoinColumn(
        name = "id_prioridad",
        nullable = false
        )
    private Prioridad prioridad;

    /**
     * @param estadoActividad Hace referencia a los estados de la actividad 
     * activa, pausa, finalizada, cancelada
     */

    @ManyToOne
    @JoinColumn(
        name = "id_estado",
        nullable = false
        )
    private Estado estadoActividad;

}
