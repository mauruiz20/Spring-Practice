package es.pildoras.pruebaannotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoAnnotations2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Cargar el XML de configuración
		
			//ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Leer el Class de configuración
		
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(EmpleadosConfig.class);
		
		// Pedir un bean al contenedor
		
		/*Empleados Antonio = contexto.getBean("comercialExperimentado", Empleados.class);
		
		Empleados Lucia = contexto.getBean("comercialExperimentado", Empleados.class);
		
		// Apuntan al mismo objeto en memoria?
		
		if (Antonio == Lucia) {
			System.out.println("Apuntan al mismo lugar en memoria");					
		} else {
			System.out.println("No apuntan al mismo lugar en memoria");
		}
		System.out.println(Antonio + "\n" + Lucia);	*/
		
		Empleados empleado = contexto.getBean("directorFinanciero", Empleados.class);
		
		System.out.println(empleado.getTareas());
		
		System.out.println(empleado.getInforme());
		
		// Cerrar el contexto
		
		contexto.close();
	}

}
