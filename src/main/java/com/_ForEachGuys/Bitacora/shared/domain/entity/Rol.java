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
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    private String descripcion;

    @Size(min = 1, message = "El nombre del rol debe contener mínimo 1 carácter")
    @Column(nullable = false, unique = true)
    private String nombreRol;

    public Long getIdRol() {
        return idRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    

}
