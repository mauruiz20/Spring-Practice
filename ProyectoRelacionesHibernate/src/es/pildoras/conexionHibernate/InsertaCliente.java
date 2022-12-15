package es.pildoras.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertaCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Clientes.class)
								.addAnnotatedClass(DetallesCliente.class)
								.buildSessionFactory();
		
		Session miSession = miFactory.openSession();
		
		try {
			
			Clientes cliente1 = new Clientes("Paco", "Gomez", "9 de julio");
			
			DetallesCliente detallesCliente1 = new DetallesCliente("www.pildorasinformaticas.es", "123456", "Segundo cliente");
			
			// Asociar los objetos
			
			cliente1.setDetallesCliente(detallesCliente1);			
			
			miSession.beginTransaction();
			
			miSession.save(cliente1);
			
			miSession.getTransaction().commit();
			
			System.out.println("Registro insertado correctamente en BD");
			
			miSession.close();
			
		} finally {
			
			miFactory.close();
		}
	}

}
