package com._ForEachGuys.Bitacora.tipoDocumento.domain.entity;

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
@Table(name = "tipos_documento")
public class TipoDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoDocumento;

    /**
     * @param descripcion Se usa para agregar un breve texto que indique a que hace
     *                    referencia el nombre, ejemplo: Tarjeta de identidad,
     *                    cédula de ciudadanía.
     */
    private String descripcion;

    /**
     * 
     * @param nombreTipoDoc Hace referencia al acrónimo del tipo de documento,
     *                      ejemplo TI, CC, etc.
     */
    @Size(min = 3, message = "El tipo de documento debe ser de mínimo 2 caracteres.")
    @Column(nullable = false, unique = true)
    private String nombreTipoDoc;

}
