package es.pildoras.IoC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoDemoSingletonPrototype {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Carga de XML de configuración
		
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		// Petición de beans al contenedor Spring
		
		SecretarioEmpleado María = contexto.getBean("miSecretarioEmpleado", SecretarioEmpleado.class);
		
		SecretarioEmpleado Pedro = contexto.getBean("miSecretarioEmpleado", SecretarioEmpleado.class);
		
		SecretarioEmpleado Manolo = contexto.getBean("miSecretarioEmpleado", SecretarioEmpleado.class);
		
		SecretarioEmpleado Juan = contexto.getBean("miSecretarioEmpleado", SecretarioEmpleado.class);
		
		SecretarioEmpleado Ana = contexto.getBean("miSecretarioEmpleado", SecretarioEmpleado.class);
		
		System.out.println(María);
		
		System.out.println(Pedro);
		
		System.out.println(Manolo);
		
		System.out.println(Juan);
		
		System.out.println(Ana);
		
		/*if (María == Pedro) System.out.println("Apuntan al mismo objeto");
		else System.out.println("No son el mismo objeto");*/
	}

}
