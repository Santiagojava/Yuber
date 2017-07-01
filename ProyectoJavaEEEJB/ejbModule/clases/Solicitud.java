package clases;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Solicitud
 *
 */
@Entity
@Table(name="Solicitud")
public class Solicitud implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="destino")
	private String destino;
	@Column(name="nombre_cli")
	private String nombre_cli;
	@Column(name="nom_prov")
	private String nom_prov;
	
	public String getNom_prov() {
		return nom_prov;
	}

	public void setNom_prov(String nom_prov) {
		this.nom_prov = nom_prov;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getNombre_cli() {
		return nombre_cli;
	}

	public void setNombre_cli(String nombre_cli) {
		this.nombre_cli = nombre_cli;
	}

	private static final long serialVersionUID = 1L;

	public Solicitud() {
		super();
	}
   
}
