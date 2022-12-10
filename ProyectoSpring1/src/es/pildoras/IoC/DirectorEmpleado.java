package es.pildoras.IoC;

public class DirectorEmpleado implements Empleados {
	
	// Creación de campo tipo CreaciónInforme (Interfaz)
	
	private CreacionInformes informeNuevo;
	
	// Creación de constructor que inyecta la dependencia
	public DirectorEmpleado(CreacionInformes informeNuevo) {
		this.informeNuevo = informeNuevo;
	}

	@Override
	public String getTareas() {
		// TODO Auto-generated method stub
		return "Gestiono la plantilla de la empresa";
	}

	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		return "Informe creado por el Director: " + informeNuevo.getInforme();
	}

}
