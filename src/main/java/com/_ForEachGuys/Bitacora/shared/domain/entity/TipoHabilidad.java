package com._ForEachGuys.Bitacora.shared.domain.entity;

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
@Table(name = "tipos_habilidad")
public class TipoHabilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoHabilidad;

    @Size(min = 1, message = "El nombre del tipo debe contener mínimo 1 carácter")
    @Column(nullable = false, unique = true)
    private String nombreTipoHabilidad;

    private String descripcion;

    public Long getIdTipoHabilidad() {
        return idTipoHabilidad;
    }

    public void setIdTipoHabilidad(Long idTipoHabilidad) {
        this.idTipoHabilidad = idTipoHabilidad;
    }

}
