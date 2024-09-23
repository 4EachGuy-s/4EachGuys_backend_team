package com._ForEachGuys.Bitacora.repositories.entities;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "Personas")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    @JoinColumn(
        name = "tipo_documento_id"
    )
    private TiposDocumento tiposDocumento;

    @Column(nullable=false, unique = true)
    @Size(max = 10, min = 8, message = "El DNI ingresado no tiene una longitud válida")
    private String dni;

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
        name = "rol_id",
        nullable = false
    )
    private Rol rol;

    @Email(message = "El email no cuenta con un formato válido")
    private String email;

    @Size(min = 10, message = "Ingrese un número de teléfono válido")
    private String telefonono;

    @Column(name = "contrasena", nullable = false)
    @Size(min = 8, message = "La contraseña debe ser de al menos 8 caracteres, dígitos o caracteres especiales")
    private String password;

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    @JoinColumn(
        name = "colaborador_id"
    )
    private List<Persona> colaboradores;

    private List<Actividad> actividades;

    private List<Proyecto> proyectos;

    private List<Habilidad> habilidades;
    
}
