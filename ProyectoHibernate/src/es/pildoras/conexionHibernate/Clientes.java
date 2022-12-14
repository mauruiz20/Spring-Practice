package es.pildoras.conexionHibernate;

import javax.persistence.*;

@Entity
@Table(name="Clientes")
public class Clientes {
	
	@Id
	@Column(name="Id")
	private int Id;
	
	@Column(name="Nombre")
	private String Nombre;
	
	@Column(name="Apellidos")
	private String Apellidos;
	
	@Column(name="Direccion")
	private String Direccion;
	
	public void Clientes () {		
	}	
	
	public Clientes(String nombre, String apellidos, String direccion) {		
		Nombre = nombre;
		Apellidos = apellidos;
		Direccion = direccion;
	}

	@Override
	public String toString() {
		return "Clientes [Id=" + Id + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", Direccion=" + Direccion
				+ "]";
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	
}
