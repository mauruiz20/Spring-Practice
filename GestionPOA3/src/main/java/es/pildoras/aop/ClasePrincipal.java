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
		
		try {
			
			boolean miParam = true;		
			elCliente.encuentraClientes(miParam);
		
		} catch (Exception miEx) {
			
			System.out.println("Excepción lanzada desde la clase principal");
			System.out.println(miEx.getMessage());
		}
		
		System.out.println("Aquí continuaría la ejecución del programa");
		
		// Cerrar el contexto
		
		contexto.close();
	}

}
