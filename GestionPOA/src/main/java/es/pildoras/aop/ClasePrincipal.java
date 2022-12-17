package es.pildoras.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.pildoras.aop.dao.ClienteDAO;
import es.pildoras.aop.dao.ClienteVIPDAO;

public class ClasePrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Leer la configuración de Spring
		
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);
		
		// Obtener el bean del contenedor de Spring
		
		ClienteDAO elCliente = contexto.getBean("clienteDAO", ClienteDAO.class);
		
		ClienteVIPDAO elClienteVIP = contexto.getBean("clienteVIPDAO", ClienteVIPDAO.class);
		
		// Llamar al método
		
		Cliente cl1 = new Cliente();
		
		elCliente.insertaCliente(cl1, "Normal");
		
		elClienteVIP.insertaClienteVIP();
		
		elCliente.setCodigoClienteNormal("123465");
		elCliente.setValoracionClienteNormal("positiva");
		
		String codigoCl = elCliente.getCodigoClienteNormal();
		String valoraCL = elCliente.getValoracionClienteNormal();
		
		// Cerrar el contexto
		
		contexto.close();
	}

}
