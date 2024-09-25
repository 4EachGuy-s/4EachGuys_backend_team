package com._ForEachGuys.Bitacora.actividad.domain.entity;

import com._ForEachGuys.Bitacora.estado.domain.entity.Estado;
import com._ForEachGuys.Bitacora.persona.domain.entity.Persona;
import com._ForEachGuys.Bitacora.prioridad.domain.entity.Prioridad;
import com._ForEachGuys.Bitacora.tipoActividad.domain.entity.TipoActividad;

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
@Table(name = "actividad")
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActividad;

    private String codigo;
    private Boolean esActiva;
    private String titulo;
    private String inicioLabor;
    private String inicioActividad;
    private String descripcion;
    private String tiempo;
    private Boolean esActivo;

    @ManyToOne
    @JoinColumn(name = "id_persona_responsable")
    private Persona personaResponsable;

    @ManyToOne
    @JoinColumn(name = "id_tipo_actividad")
    private TipoActividad tipoActividad;

    @ManyToOne
    @JoinColumn(name = "id_prioridad")
    private Prioridad prioridad;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estadoActividad;

    // Getters y Setters
}
