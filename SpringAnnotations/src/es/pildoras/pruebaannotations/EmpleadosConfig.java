package es.pildoras.pruebaannotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("es.pildoras.pruebaannotations")
public class EmpleadosConfig {

	// Definir el bean para InformeFinancieroDtoCompras
	
	@Bean
	public CreacionInformeFinanciero informeFinancieroDtoCompras() { // Id del Bean inyectado
		return new InformeFinancieroDtoCompras();
	}
	
	// Definir el bean para DirectorFinanciero e inyectar dependencias
	
	@Bean
	public Empleados directorFinanciero() {
		return new DirectorFinanciero(informeFinancieroDtoCompras());
	}
}
