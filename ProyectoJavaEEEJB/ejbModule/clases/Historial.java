package clases;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "Historial")
public class Historial implements Serializable{
	private static final long serialVersionUID = 1L;
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
	@OneToOne
	@JoinColumn(name = "servicio")
	private Servicio servicio;
	@JoinColumn(name = "calif_cli")
	private int calif_cli;
	@JoinColumn(name = "calif_pro")
	private int calif_pro;
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@JoinColumn(name = "fecha")
	private Date fecha;
	
	public Servicio getServicio() {
		return servicio;
	}
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	public int getId() {
		return id;
	}
	public int getCalif_cli() {
		return calif_cli;
	}
	public void setCalif_cli(int calif_cli) {
		this.calif_cli = calif_cli;
	}
	public int getCalif_pro() {
		return calif_pro;
	}
	public void setCalif_pro(int calif_pro) {
		this.calif_pro = calif_pro;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
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
