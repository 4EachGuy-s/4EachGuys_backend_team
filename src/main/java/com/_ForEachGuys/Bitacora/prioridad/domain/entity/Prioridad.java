package com._ForEachGuys.Bitacora.prioridad.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prioridades")
public class Prioridad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrioridad;

    private String descripcionPrioridad;

    @Size(min = 1, message = "El nombre de la prioridad debe contener mínimo 1 carácter")
    @Column(nullable = false, unique = true)
    private String nombrePrioridad;

}
