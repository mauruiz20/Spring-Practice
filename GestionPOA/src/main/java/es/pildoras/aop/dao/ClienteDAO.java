package es.pildoras.aop.dao;

import org.springframework.stereotype.Component;

import es.pildoras.aop.Cliente;

@Component
public class ClienteDAO {
	
	public void insertaCliente(Cliente elCliente, String tipo) {
		
		System.out.println("\nCliente insertado con éxito\n");		
		
	}
	
	private String valoracionClienteNormal;
	
	private String codigoClienteNormal;

	public String getValoracionClienteNormal() {
		System.out.println("Obteniendo valoración del cliente");
		
		return valoracionClienteNormal;
	}

	public void setValoracionClienteNormal(String valoracionClienteNormal) {
		System.out.println("Estableciendo valoración del cliente");
		
		this.valoracionClienteNormal = valoracionClienteNormal;
	}

	public String getCodigoClienteNormal() {
		System.out.println("Obteniendo el código del cliente");
		
		return codigoClienteNormal;
	}

	public void setCodigoClienteNormal(String codigoClienteNormal) {
		System.out.println("Estableciendo código del cliente");
		
		this.codigoClienteNormal = codigoClienteNormal;
	}
}
