package es.pildoras.conexionHibernate;

import javax.persistence.*;

@Entity
@Table(name="Clientes")
public class Clientes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int Id;
	
	@Column(name="Nombre")
	private String Nombre;
	
	@Column(name="Apellido")
	private String Apellido;
	
	@Column(name="Direccion")
	private String Direccion;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Id")
	private DetallesCliente detallesCliente;
	
	public Clientes(){}	
	
	public Clientes(String nombre, String apellido, String direccion) {		
		Nombre = nombre;
		Apellido = apellido;
		Direccion = direccion;
	}

	@Override
	public String toString() {
		return "Clientes [Id=" + Id + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Direccion=" + Direccion
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

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public DetallesCliente getDetallesCliente() {
		return detallesCliente;
	}

	public void setDetallesCliente(DetallesCliente detallesCliente) {
		this.detallesCliente = detallesCliente;
	}
	
}
