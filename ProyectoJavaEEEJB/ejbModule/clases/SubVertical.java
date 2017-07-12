package clases;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: SubVertical
 *
 */
@Entity
@Table(name = "SubVertical")
public class SubVertical implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id 
    //@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="categoria")
	private String categoria;
	@Column(name="tarifa")
	private float tarifa;
	@Column(name="vertical")
	private TipoServicio vertical;
	
	public SubVertical() {
		super();
	}
	public SubVertical(String categoria,float tarifa,TipoServicio vertical){
		this.categoria=categoria;
		this.tarifa=tarifa;
		this.vertical=vertical;
	}
	public String getTipo() {
		return categoria;
	}
	public void setTipo(String categoria) {
		this.categoria = categoria;
	}
	public float getTarifa() {
		return tarifa;
	}
	public void setTarifa(float tarifa) {
		this.tarifa = tarifa;
	}
	
}