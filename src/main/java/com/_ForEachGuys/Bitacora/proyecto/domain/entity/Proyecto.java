package com._ForEachGuys.Bitacora.proyecto.domain.entity;

import java.time.LocalDate;

import com._ForEachGuys.Bitacora.estado.domain.entity.Estado;
import com._ForEachGuys.Bitacora.prioridad.domain.entity.Prioridad;

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
@Table(name = "proyecto")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProyecto;

    private String codigo;
    private String tiempo;
    private LocalDate fechaEntrega;
    private String titulo;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_prioridad")
    private Prioridad prioridad;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estadoProyecto;

    // Getters y Setters
}
