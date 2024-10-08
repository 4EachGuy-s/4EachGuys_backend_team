package com._ForEachGuys.Bitacora.shared.domain.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "personas")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;

    @Size(min = 3, message = "El nombre debe ser de mínimo 3 caracteres.")
    @Column(nullable = false)
    private String pNombre;
    private String sNombre;

    @Size(min = 3, message = "El nombre debe ser de mínimo 3 caracteres.")
    @Column(nullable = false)
    private String pApellido;
    private String sApellido;

    @Size(min = 8, message = "El número de documento debe contener mínimo 8 dígitos")
    @Column(nullable = false, unique = true)
    private String dni;

    @Past
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    @Size(min = 8, message = "La contraseña debe de contener mínimo 8 caracteres entre Mayúsculas, minúsculas, números y especiales")
    @Column(nullable = false)
    private String password;

    // Relaciones
    @NotNull
    @ManyToOne
    @JoinColumn(
        name = "id_tipo_documento",
        nullable = false
        )
    private TipoDocumento tipoDocumento;

    @OneToMany(mappedBy = "personaResponsable", fetch = FetchType.LAZY)
    private List<Proyecto> proyectos;

    @OneToMany(mappedBy = "personaResponsable", fetch = FetchType.LAZY)
    private List<Actividad> actividades;

    @OneToOne
    @JoinColumn(
        name = "id_contacto",
        nullable = false
        )
    private Contacto contacto;

    @ManyToOne
    @JoinColumn(
        name = "id_rol",
        nullable = false
        )
    private Rol rol;

    @ManyToMany
    @JoinTable(
        name = "persona_habilidad",
        joinColumns = @JoinColumn(
            name = "persona_id"
        ),
        inverseJoinColumns = @JoinColumn(
            name = "habilidad_id"
        )
    )
    private List<Habilidad> habilidades;

    
}
