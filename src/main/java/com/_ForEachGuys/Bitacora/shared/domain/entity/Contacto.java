package com._ForEachGuys.Bitacora.shared.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contactos")
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContacto;

    private String numeroTelefono1;
    private String numeroTelefono2;

    /**
     * @param correoElectronico Indispensable para autenticación
    */
    @Email(message = "El formato del email no es correcto")
    @Column(nullable = false, unique = true)
    private String correoElectronico;

}
