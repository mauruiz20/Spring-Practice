package es.pildoras.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.pildoras.aop.dao.ClienteDAO;
import es.pildoras.aop.dao.ClienteVIPDAO;

public class ClasePrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Leer la configuración de Spring
		
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);
		
		// Obtener el bean del contenedor de Spring
		
		ClienteDAO elCliente = contexto.getBean("clienteDAO", ClienteDAO.class);
		
		ClienteVIPDAO elClienteVIP = contexto.getBean("clienteVIPDAO", ClienteVIPDAO.class);
		
		// Llamar al método
		
		Cliente cl1 = new Cliente();
		
		cl1.setNombre("Juan Díaz");
		
		cl1.setTipo("Normal");
		
		elCliente.insertaCliente(cl1, cl1.getTipo());
		
		elClienteVIP.insertaClienteVIP();		
		
		// Cerrar el contexto
		
		contexto.close();
	}

}
