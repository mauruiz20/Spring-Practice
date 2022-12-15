package es.pildoras.conexionHibernate;

import java.util.Date;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ObtenerPedidosCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Clientes.class)
								.addAnnotatedClass(DetallesCliente.class)
								.addAnnotatedClass(Pedidos.class)
								.buildSessionFactory();
		
		Session miSession = miFactory.openSession();
		
		try {					
			
			miSession.beginTransaction();	
			
			// Obtener el cliente de la tabla Clientes de la BD
			
			Clientes elCliente = miSession.get(Clientes.class, 4);			
			
			System.out.println("Cliente: " + elCliente);
			
			System.out.println("Pedidos: " + elCliente.getPedidos());
			
			miSession.getTransaction().commit();			
			
		} catch (Exception ex1) {
			
			ex1.printStackTrace();
			
		} finally {
			
			miSession.close();
			
			miFactory.close();
		}
	}

}
