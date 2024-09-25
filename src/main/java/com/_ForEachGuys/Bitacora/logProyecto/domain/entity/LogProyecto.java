package com._ForEachGuys.Bitacora.logProyecto.domain.entity;

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
@Table(name = "logs_proyecto")
public class LogProyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLogProyecto;

    @Column(columnDefinition = "json")
    private String proyecto;

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
