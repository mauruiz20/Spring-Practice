package es.pildoras.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.pildoras.aop.dao.ClienteDAO;

public class ClasePrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Leer la configuración de Spring
		
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);
		
		// Obtener el bean del contenedor de Spring
		
		ClienteDAO elCliente = contexto.getBean("clienteDAO", ClienteDAO.class);
		
		// Llamar al método
		
		elCliente.insertaCliente();
		
		// Cerrar el contexto
		
		contexto.close();
	}

}
