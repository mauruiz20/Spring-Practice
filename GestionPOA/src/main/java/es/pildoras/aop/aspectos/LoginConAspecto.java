package es.pildoras.aop.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginConAspecto {

	//@Before("execution(public void es.pildoras.aop.dao.ClienteVIPDAO.insertaCliente())")
	//@Before("execution(public void insertaCliente())")
	@Before("execution(public void insertaCliente*())")
	public void antesInsertarCliente() {
		
		System.out.println("\nEl usuario está logeado");
		
		System.out.println("El perfil para insertar clientes es correcto\n");
	}
}
