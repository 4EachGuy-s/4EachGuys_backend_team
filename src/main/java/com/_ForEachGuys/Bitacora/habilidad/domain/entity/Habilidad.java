package com._ForEachGuys.Bitacora.habilidad.domain.entity;

import com._ForEachGuys.Bitacora.tipoHabilidad.domain.entity.TipoHabilidad;

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
@Table(name = "habilidad")
public class Habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHabilidad;

    private String nombreHabilidad;

    @ManyToOne
    @JoinColumn(name = "id_tipo_habilidad")
    private TipoHabilidad tipoHabilidad;

    // Getters y Setters
}
