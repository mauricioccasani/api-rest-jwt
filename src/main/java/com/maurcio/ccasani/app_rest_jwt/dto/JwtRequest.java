package com.maurcio.ccasani.app_rest_jwt.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequest implements Serializable{
	
	private String username;
	private String password;
	
}
