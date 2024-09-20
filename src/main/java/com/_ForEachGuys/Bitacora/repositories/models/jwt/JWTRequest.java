package com._ForEachGuys.Bitacora.repositories.models.jwt;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JWTRequest implements Serializable {

	private String username;
	private String password;
    
}