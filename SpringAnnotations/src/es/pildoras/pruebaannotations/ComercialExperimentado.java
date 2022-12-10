package es.pildoras.pruebaannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComercialExperimentado implements Empleados {
	
	// Autowired con campo
	
	@Autowired
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
