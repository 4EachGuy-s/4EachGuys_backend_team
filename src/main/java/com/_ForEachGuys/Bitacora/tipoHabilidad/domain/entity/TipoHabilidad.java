package com._ForEachGuys.Bitacora.tipoHabilidad.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "tipo_habilidad")
public class TipoHabilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoHabilidad;

    private String nombreTipoHabilidad;
    private String descripcion;

    // Getters y Setters
}
