package es.pildoras.SeguridadSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ElControlador {

	@GetMapping("/")
	public String muestraInicio() {
		
		return "inicio";
	}
	
	// Agregar mapping a administradores
	
	@GetMapping("/administradores")
	public String muestraAdministradores() {
		
		return "administradores";
	}
	
	// Agregar mapping a ayudantes
	
	@GetMapping("/ayudantes")
	public String muestraAyudantes() {
		
		return "ayudantes";
	}
	
	@GetMapping("/acceso-denegado")
	public String muestraAccesoDenegado() {
		
		return "acceso-denegado";
	}
}
