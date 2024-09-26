package com._ForEachGuys.Bitacora.shared.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "registros_sesion")
public class RegistroSesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegistroSesion;

    /** 
     * @param tiempo Hace referencia al tiempo total en cada sesión
     */
    private double tiempo;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime horaInicio;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime horaFin;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

}
