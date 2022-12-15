package es.pildoras.conexionHibernate;

import javax.persistence.*;

@Entity
@Table(name="Detalles_Cliente")
public class DetallesCliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int Id;
	
	@Column(name="Web")
	private String Web;
	
	@Column(name="Telefono")
	private String Telefono;
	
	@Column(name="Comentarios")
	private String Comentarios;
	
	@OneToOne(mappedBy="detallesCliente", cascade=CascadeType.ALL)
	private Clientes elCliente;
	
	public DetallesCliente(){}

	public DetallesCliente(String web, String telefono, String comentarios) {		
		Web = web;
		Telefono = telefono;
		Comentarios = comentarios;
	}	

	@Override
	public String toString() {
		return "DetallesCliente [Id=" + Id + ", Web=" + Web + ", Telefono=" + Telefono + ", Comentarios=" + Comentarios
				+ "]";
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getWeb() {
		return Web;
	}

	public void setWeb(String web) {
		Web = web;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getComentarios() {
		return Comentarios;
	}

	public void setComentarios(String comentarios) {
		Comentarios = comentarios;
	}

	public Clientes getElCliente() {
		return elCliente;
	}

	public void setElCliente(Clientes elCliente) {
		this.elCliente = elCliente;
	}
	
}
