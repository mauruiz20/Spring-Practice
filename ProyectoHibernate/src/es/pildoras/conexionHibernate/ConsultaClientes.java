package es.pildoras.conexionHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConsultaClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
		
		Session miSession = miFactory.openSession();
		
		try {
			
			// Comenzar sesión
			
			miSession.beginTransaction();
			
			// Consulta de clientes
			
			List<Clientes> losClientes = miSession.createQuery("from Clientes").getResultList();
			
			// Mostrar los clientes
			
			recorreClientesConsultados(losClientes);
			
			// Consulta: dame los Gomez
			
			losClientes = miSession.createQuery("from Clientes cl where cl.Apellidos='Gomez'").getResultList();
			
			// Mostrar los Gomez
			
			recorreClientesConsultados(losClientes);
			
			// Muestra los que viven en Buenos Aires o se apellidan Delgado
			
			losClientes = miSession.createQuery("from Clientes cl where cl.Apellidos='Delgado' or cl.Direccion='Buenos Aires 512'").getResultList();
			
			// Mostrar
			
			recorreClientesConsultados(losClientes);
			
			// Commit
			
			miSession.getTransaction().commit();
			
			// Cerrar sesión
			
			miSession.close();
			
		} finally {
			
			miFactory.close();
			
		}
		
	}

	private static void recorreClientesConsultados(List<Clientes> losClientes) {
		for (Clientes unCliente:losClientes) {
			
			System.out.println(unCliente);
		}
		
		System.out.println("\n");
	}

}
