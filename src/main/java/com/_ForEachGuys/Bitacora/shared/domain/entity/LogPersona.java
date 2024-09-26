package com._ForEachGuys.Bitacora.shared.domain.entity;

import java.time.LocalDateTime;

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

    @Column(columnDefinition = "json")
    private String persona;

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
