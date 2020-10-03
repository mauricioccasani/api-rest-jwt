package com.maurcio.ccasani.app_rest_jwt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class JwtResponse implements Serializable {
	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private final String usuario;
}
