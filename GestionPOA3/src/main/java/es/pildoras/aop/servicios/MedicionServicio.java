package es.pildoras.aop.servicios;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class MedicionServicio {

	public String getServicio() {
		
		System.out.println("**** EL MÉTODO REALIZANDO SUS TAREAS ****");
		
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Servicios terminados";
	}
}
