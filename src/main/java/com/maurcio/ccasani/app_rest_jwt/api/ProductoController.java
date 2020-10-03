package com.maurcio.ccasani.app_rest_jwt.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {

	@GetMapping("/hola")
	public String name() {
		return "hola mundo";
	}
}
