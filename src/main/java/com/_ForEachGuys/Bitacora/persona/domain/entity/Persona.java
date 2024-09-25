package com._ForEachGuys.Bitacora.persona.domain.entity;



import java.time.LocalDate;

import com._ForEachGuys.Bitacora.contacto.domain.entity.Contacto;
import com._ForEachGuys.Bitacora.habilidad.domain.entity.Habilidad;
import com._ForEachGuys.Bitacora.proyecto.domain.entity.Proyecto;
import com._ForEachGuys.Bitacora.rol.domain.entity.Rol;
import com._ForEachGuys.Bitacora.tipoDocumento.domain.entity.TipoDocumento;

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
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;

    private String pNombre;
    private String sNombre;
    private String pApellido;
    private String sApellido;
    private String dni;
    private LocalDate fechaNacimiento;
    private String password;

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "id_tipo_documento")
    private TipoDocumento tipoDocumento;

    @ManyToOne
    @JoinColumn(name = "id_proyecto")
    private Proyecto proyecto;

    @ManyToOne
    @JoinColumn(name = "id_contacto")
    private Contacto contacto;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "id_habilidad")
    private Habilidad habilidad;

    // Getters y Setters
}
