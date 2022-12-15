package es.pildoras.conexionHibernate;

import java.util.Date;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CrearPedidosCliente {

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
			
			// Crear pedidos del cliente
			
			Pedidos pedido1 = new Pedidos(new GregorianCalendar(2020,7,5));
			Pedidos pedido2 = new Pedidos(new GregorianCalendar(2022,5,25));
			Pedidos pedido3 = new Pedidos(new GregorianCalendar(2020,3,30));
			
			// Agregar pedidos creados al cliente
			
			elCliente.agregarPedidos(pedido1);
			elCliente.agregarPedidos(pedido2);
			elCliente.agregarPedidos(pedido3);
			
			// Guardar los pedidos en la BD
			
			miSession.save(pedido1);
			miSession.save(pedido2);
			miSession.save(pedido3);
			
			miSession.getTransaction().commit();
			
			System.out.println("Registros insertados correctamente en BD");
			
		} catch (Exception ex1) {
			
			ex1.printStackTrace();
			
		} finally {
			
			miSession.close();
			
			miFactory.close();
		}
	}

}
