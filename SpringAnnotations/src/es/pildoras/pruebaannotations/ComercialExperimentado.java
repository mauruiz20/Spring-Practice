package es.pildoras.pruebaannotations;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class ComercialExperimentado implements Empleados, InitializingBean, DisposableBean {
	
	// Ejecución de código después de creación del Bean
	
	public void afterPropertiesSet() throws Exception {
		System.out.println("Ejecutado tras creación de Bean");
	}
	
	// Ejecución de código después de apagado contenedor Spring
	
	public void destroy() throws Exception {
		System.out.println("Ejecutando antes de la destrucción");
	}	
	
	// Autowired con campo de clase y qualifier
	
	@Autowired
	@Qualifier("informeFinancieroTrim4")
	private CreacionInformeFinanciero nuevoInforme;
	
	public ComercialExperimentado() {
		
	}
	
	// Autowired con constructor
	
	/*@Autowired
	public ComercialExperimentado(CreacionInformeFinanciero nuevoInforme) {		
		this.nuevoInforme = nuevoInforme;
	}*/
	
	// Autowired con setter o cualquier método
	
	/*@Autowired
	public void setNuevoInforme(CreacionInformeFinanciero nuevoInforme) {
		this.nuevoInforme = nuevoInforme;
	}*/

	@Override
	public String getTareas() {
		// TODO Auto-generated method stub
		return "Vender, vender y vender más!";
	}	

	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		//return "Informe generado por el comercial";
		
		return nuevoInforme.getInformeFinanciero();
	}

}
