package com._ForEachGuys.Bitacora.auth.domain.entity;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JWTRequest implements Serializable {

	@NotNull
	@Email(message = "El formato del email no es correcto")
	private String username;

	@NotNull
    @Size(min = 8, message = "La contraseña debe tener mínimo 8 caracteres.")
    private String password;
    
}