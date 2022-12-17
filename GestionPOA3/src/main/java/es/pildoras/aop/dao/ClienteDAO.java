package es.pildoras.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import es.pildoras.aop.Cliente;

@Component
public class ClienteDAO {
	
	public void insertaCliente(Cliente elCliente, String tipo) {
		
		System.out.println("\nCliente insertado con éxito\n");		
		
	}
	
	public List<Cliente> encuentraClientes(boolean miParam) {
		
		if (miParam) throw new RuntimeException("Error!! No se ha podido procesar la petición");
		
		List<Cliente> listaClientes = new ArrayList<>();
		
		// Simular clientes devueltos por BD
		
		Cliente cl1 = new Cliente("María", "Normal");
		Cliente cl2 = new Cliente("Ana", "VIP");
		Cliente cl3 = new Cliente("Sandra", "VIP");
		Cliente cl4 = new Cliente("Antonio", "Normal");
		
		// Agregar cliente a lista
		
		listaClientes.add(cl1);
		listaClientes.add(cl2);
		listaClientes.add(cl3);
		listaClientes.add(cl4);
		
		System.out.println("Ejecución finalizada del método encuentraClientes()");
		
		return listaClientes;	
	}
}
