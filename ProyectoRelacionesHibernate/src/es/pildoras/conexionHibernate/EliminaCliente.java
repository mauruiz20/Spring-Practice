package es.pildoras.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminaCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Clientes.class)
								.addAnnotatedClass(DetallesCliente.class)
								.buildSessionFactory();
		
		Session miSession = miFactory.openSession();
		
		try {						
			
			miSession.beginTransaction();
			
			Clientes elCliente = miSession.get(Clientes.class, 3);
			
			if (elCliente != null) {
				
				miSession.delete(elCliente);
				
				System.out.println("Registro eliminado correctamente en BD");
				
			} else {
				
				System.out.println("No se encontró al cliente");
			}
			
			miSession.getTransaction().commit();			
			
			miSession.close();
			
		} finally {
			
			miFactory.close();
		}
	}

}
