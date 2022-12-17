package es.pildoras.aop.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoginConAspecto {
	
	@Pointcut("execution(* es.pildoras.aop.dao.*.*(..))")
	public void paraClientes() {}	

	@Before("paraClientes()")
	public void antesInsertarCliente() {
		
		System.out.println("El usuario está logeado");
		
		System.out.println("El perfil para insertar clientes es correcto");
	}	
}
