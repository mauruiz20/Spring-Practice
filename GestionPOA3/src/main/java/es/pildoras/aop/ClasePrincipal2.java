package es.pildoras.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.pildoras.aop.servicios.MedicionServicio;

public class ClasePrincipal2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Leer la configuración de Spring
		
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);
		
		// Obtener el bean del contenedor de Spring
		
		MedicionServicio elServicio = contexto.getBean("medicionServicio", MedicionServicio.class);
				
		System.out.println("Llamando al método getServicio()");
		
		String datos = elServicio.getServicio();
		
		System.out.println("Devolución del método: " + datos);
		
		// Cerrar el contexto
		
		contexto.close();
	}

}
