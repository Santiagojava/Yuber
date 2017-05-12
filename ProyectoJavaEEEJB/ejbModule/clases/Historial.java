package clases;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Historial")
public class Historial implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@OneToOne
	@JoinColumn(name="nombre_cli")
	private Usuario cliente;
	@OneToOne
	@JoinColumn(name="nombre_prov")
	private Usuario proveedor;
	public Usuario getCliente() {
		return cliente;
	}
	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	public Usuario getProveedor() {
		return proveedor;
	}
	public void setProveedor(Usuario proveedor) {
		this.proveedor = proveedor;
	}
	public Historial() {
		super();
	}
	
	
}
