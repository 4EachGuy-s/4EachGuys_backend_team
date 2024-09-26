package com._ForEachGuys.Bitacora.shared.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "habilidades")
public class Habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHabilidad;

    @Size(min = 1, message = "El nombre de la habilidad debe contener mínimo 1 carácter")
    @Column(nullable = false, unique = true)
    private String nombreHabilidad;

    @ManyToOne
    @JoinColumn(name = "id_tipo_habilidad")
    private TipoHabilidad tipoHabilidad;

    public Long getIdHabilidad() {
        return idHabilidad;
    }

    public void setIdHabilidad(Long idHabilidad) {
        this.idHabilidad = idHabilidad;
    }

}
