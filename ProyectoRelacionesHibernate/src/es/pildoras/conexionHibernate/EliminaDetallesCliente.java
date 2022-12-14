package es.pildoras.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminaDetallesCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Clientes.class)
								.addAnnotatedClass(DetallesCliente.class)
								.buildSessionFactory();
		
		Session miSession = miFactory.openSession();
		
		try {						
			
			miSession.beginTransaction();
			
			DetallesCliente detalleDeCliente = miSession.get(DetallesCliente.class, 1);
			
			//detalleDeCliente.getElCliente().setDetallesCliente(null);
			
			if (detalleDeCliente != null) {
				
				miSession.delete(detalleDeCliente);
				
				System.out.println("Registro eliminado correctamente en BD");
				
			} else {
				
				System.out.println("No se encontrĂ³ al detalle");
			}
			
			miSession.getTransaction().commit();			
			
			miSession.close();
			
		} finally {
			
			miFactory.close();
		}
	}

}
