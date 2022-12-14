package es.pildoras.pruebasHibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class PruebasJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/pruebashibernate?useSSL=false";
		
		String usuario = "root";
		
		String contra = "";
		
		try {
			
			System.out.println("Intentando conectar con la BD: " + jdbcUrl);
			
			Connection miConexion = DriverManager.getConnection(jdbcUrl, usuario, contra);
			
			System.out.println("Conexión exitosa!!");
			
		} catch (Exception e) {	
			
			e.printStackTrace();
		}
	}

}
