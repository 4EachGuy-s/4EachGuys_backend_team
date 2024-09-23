package com._ForEachGuys.Bitacora.repositories.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * @param codigo código unico para identificar el proyecto
      */
    private final String codigo = UUID.randomUUID().toString();

    /**
    * @param asignado persona que fue asignada como encargado del proyecto
    */
    @ManyToOne
    @JoinColumn(
        name = ""
    )
    private Persona asignado;

    private String titulo;

    private List<Actividad> actividades;

    /**
     *  @param tiempo tiempo transcurrido en proceso del proyecto     * 
     * */
    private double tiempo;

    private Prioridad prioridad;

    /** 
     * @param colaboradores personal seleccionado para trabajar en el proyecto
     */
    private List<Persona> colaboradores;

    private LocalDate fecha_entrega;

    /**
     * @param estado determina si un proyecto está activo o finalizado
     */
    private boolean estado;

}
