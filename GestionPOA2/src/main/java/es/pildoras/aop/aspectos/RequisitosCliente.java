package es.pildoras.aop.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class RequisitosCliente {

	@Before("es.pildoras.aop.aspectos.LoginConAspecto.paraClientes()")
	public void requisitosCliente() {
		
		System.out.println("El cliente cumple los requisitos para ser insertado en la BD");
	}
}
