package es.pildoras.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ActualizaClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
		
		Session miSession = miFactory.openSession();
		
		try {			
			
			//int ClienteId = 1;
			
			miSession.beginTransaction();
			
			//Clientes miCliente = miSession.get(Clientes.class, ClienteId);
			
			//miCliente.setNombre("José");
			
			//miSession.createQuery("update Clientes set Apellidos='Peron' where Apellidos LIKE 'P%'").executeUpdate();
			
			miSession.createQuery("delete Clientes where Direccion='Balcarce 123'").executeUpdate();
			
			System.out.println("Registro modificado correctamente en BD");			
			
			miSession.getTransaction().commit();
			
			miSession.close();
			
		} finally {
			
			miFactory.close();
		}
	}

}
