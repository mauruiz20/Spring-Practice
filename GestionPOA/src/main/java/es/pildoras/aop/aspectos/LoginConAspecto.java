package es.pildoras.aop.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginConAspecto {
	
	//@Pointcut("execution(public * insertaCliente*(..))")
	@Pointcut("execution(* es.pildoras.aop.dao.*.*(..))")
	private void paraClientes() {}
	
	@Pointcut("execution(* es.pildoras.aop.dao.*.get*(..))")
	private void paraGetters() {}
	
	@Pointcut("execution(* es.pildoras.aop.dao.*.set*(..))")
	private void paraSetters() {}
	
	@Pointcut("paraClientes() && !(paraGetters() || paraSetters())")
	private void paqueteExceptoGetterSetter() {}

	//@Before("execution(public void insertaCliente())")
	//@Before("execution(public void es.pildoras.aop.dao.ClienteVIPDAO.insertaCliente())")
	//@Before("execution(public * insertaCliente*(es.pildoras.aop.Cliente, ..))")
	//@Before("execution(public * insertaCliente*(..))")
	//@Before("paraClientes()")
	//@Before("paraGetters()")
	//@Before("paraSetters()")
	@Before("paqueteExceptoGetterSetter()")
	public void antesInsertarCliente() {
		
		System.out.println("El usuario está logeado");
		
		System.out.println("El perfil para insertar clientes es correcto");
	}
	
	//@Before("paraClientes()")
	public void requisitosCliente() {
		
		System.out.println("El cliente cumple los requisitos para ser insertado en la BD");
	}
	
	//@Before("paraClientes()")	
	public void requisitosTabla() {
		
		System.out.println("Hay menos de 3000 registros en la tabla. Puedes insertar el nuevo cliente");
	}
}
