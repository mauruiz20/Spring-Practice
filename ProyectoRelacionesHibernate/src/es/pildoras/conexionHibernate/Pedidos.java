package es.pildoras.conexionHibernate;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.*;

@Entity
@Table(name="Pedidos")
public class Pedidos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int Id;
	
	@Column(name="Fecha")
	private GregorianCalendar Fecha; // Clase Date obsoleta
	
	@Column(name="FormaPago")
	private String FormaPago;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="IdCliente")
	private Clientes Cliente;

	public Pedidos() {
	}	

	public Pedidos(GregorianCalendar fecha) {
		Fecha = fecha;		
	}

	@Override
	public String toString() {
		return "Pedidos [Id=" + Id + ", Fecha=" + Fecha + ", FormaPago=" + FormaPago + "]";
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public GregorianCalendar getFecha() {
		return Fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		Fecha = fecha;
	}

	public String getFormaPago() {
		return FormaPago;
	}

	public void setFormaPago(String formaPago) {
		FormaPago = formaPago;
	}

	public Clientes getCliente() {
		return Cliente;
	}

	public void setCliente(Clientes cliente) {
		Cliente = cliente;
	}
	
	
}
