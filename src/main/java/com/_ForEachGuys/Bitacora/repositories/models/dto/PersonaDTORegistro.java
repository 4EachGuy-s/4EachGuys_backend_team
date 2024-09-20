package com._ForEachGuys.Bitacora.repositories.models.dto;

import com._ForEachGuys.Bitacora.repositories.entities.Rol;

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
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Personas")
public class PersonaDTORegistro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Size(min = 2, message = "Se debe ingresar un nombre")
    private String p_nombre;
    private String s_nombre;

    @Column(nullable = false)
    @Size(min = 2, message = "Se debe ingresar un apellido")
    private String p_apellido;
    private String s_apellido;

    @ManyToOne
    @JoinColumn(
        name = "rol_id"
    )
    private Rol rol;

    @Column(unique = true, nullable = false)
    @Size(min = 5, message = "Se debe ingresar un nombre de usuario")
    private String username;

    @Column(name = "contrasena", nullable = false)
    @Size(min = 8, message = "La contraseña debe ser de al menos 8 caracteres, dígitos o caracteres especiales")
    private String password;
    
}
