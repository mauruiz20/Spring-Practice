package es.pildoras.conexionHibernate;

import java.util.Date;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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
			
			//Clientes elCliente = miSession.get(Clientes.class, 4);			
			
			Query<Clientes> consulta = miSession.createQuery("SELECT CL FROM Clientes CL JOIN FETCH CL.pedidos WHERE CL.Id=:elClienteId", Clientes.class);
			
			consulta.setParameter("elClienteId", 4);
			
			Clientes elCliente = consulta.getSingleResult();
					
			System.out.println("Cliente: " + elCliente);			
			
			miSession.getTransaction().commit();
			
			miSession.close();
			
			System.out.println("Pedidos: " + elCliente.getPedidos());
			
		} catch (Exception ex1) {
			
			ex1.printStackTrace();
			
		} finally {
			
			
			
			miFactory.close();
		}
	}

}
