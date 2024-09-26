package com._ForEachGuys.Bitacora.auth.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JWTResponse {

	private String message;
	private int status;

}