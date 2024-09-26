package com._ForEachGuys.Bitacora.shared.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "logs_actividad")
public class LogActividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLogActividad;

    @Column(columnDefinition = "json")
    private String actividad;
    
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaLog;

    private String comentarios;

    /* DNI */
    private String personaResponsable;

    /** 
     * @param accion Acción realizada (Eliminar, actualizar, crear)
     */
    private String accion;
}
