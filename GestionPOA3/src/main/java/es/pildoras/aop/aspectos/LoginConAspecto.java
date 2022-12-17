package es.pildoras.aop.aspectos;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import es.pildoras.aop.Cliente;

@Aspect
@Component
@Order(3)
public class LoginConAspecto {
	
	@Around("execution(* es.pildoras.aop.servicios.*.getServicio(..))")
	public Object ejecutarServicio(ProceedingJoinPoint elPoint) throws Throwable {
		
		System.out.println("---- Comienzo de acciones antes de llamada ----");
		
		long comienzo = System.currentTimeMillis();
		
		Object resultado = elPoint.proceed(); // elPoint apunta al método destino
		
		System.out.println("---- tareas después de llamada ----");
		
		long fin = System.currentTimeMillis();
		
		long duracion = fin - comienzo;
		
		System.out.println("El método tardó " + duracion/1000 + "s");
		
		return resultado;
	}
	
	@AfterReturning(pointcut="execution(* es.pildoras.aop.dao.ClienteDAO.encuentraClientes(..))", returning="listaDeClientes")
	public void tareaTrasEncontrarClientes(List<Cliente> listaDeClientes) {
		
		for (Cliente cl:listaDeClientes) {
			
			if (cl.getTipo() == "VIP") {
				
				procesadoDatosAfterReturning(cl);
				
				System.out.println("Existen clientes VIP en el listado. Nombre: " + cl.getNombre());
			}
		}
	}
	
	private void procesadoDatosAfterReturning(Cliente elCliente) {
		// TODO Auto-generated method stub
					
		String datosProcesados = "V.I.P." + elCliente.getNombre().toUpperCase();
		
		elCliente.setNombre(datosProcesados);
		
	}
	
	@AfterThrowing(pointcut="execution(* es.pildoras.aop.dao.ClienteDAO.encuentraClientes(..))", throwing="laExcepcion")
	public void procesandoDatosAfterExceptionEncuentraClientes(Throwable laExcepcion) {
		
		System.out.println("Aquí se estaría ejecutando de forma automática las tareas tras excepción");
		
	}
	
	@After("execution(* es.pildoras.aop.dao.ClienteDAO.encuentraClientes(..))")
	public void ejecutandoTareasConYSinExcepcion(JoinPoint elPoint) {
		
		System.out.println("Ejecutando tareas SIEMPRE!");
		
	}

	@Pointcut("execution(* es.pildoras.aop.dao.*.*(..))")
	public void paraClientes() {}	

	@Before("paraClientes()")
	public void antesInsertarCliente(JoinPoint miJoin) {
		
		System.out.println("El usuario está logeado");
		
		System.out.println("El perfil para insertar clientes es correcto");
		
		Object[] argumentos = miJoin.getArgs();
		
		for (Object temp:argumentos) {
			
			if (temp instanceof Cliente) {
				
				Cliente elCliente = (Cliente)temp;
				
				System.out.println("Nombre del cliente: " + elCliente.getNombre());
				System.out.println("Tipo del cliente: " + elCliente.getTipo());
			}
		}
	}	
}
