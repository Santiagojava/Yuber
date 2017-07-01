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
	private String tipo;
	public SubVertical() {
		super();
	}
	public SubVertical(String tipo){
		this.tipo=tipo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}