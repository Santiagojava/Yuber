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
	@Column(name="acepta_prov")
	private boolean acepta_prov;
	@Column(name="acepta_cli")
	private boolean acepta_cli;
	@Column(name="iniciar_ser")
	private boolean iniciar_ser;
	@Column(name="finalizar_ser")
	private boolean finalizar_ser;
	@Column(name="review")
	private int review;
	
	public int getReview() {
		return review;
	}

	public void setReview(int review) {
		this.review = review;
	}

	public boolean isIniciar_ser() {
		return iniciar_ser;
	}

	public void setIniciar_ser(boolean iniciar_ser) {
		this.iniciar_ser = iniciar_ser;
	}

	public boolean isFinalizar_ser() {
		return finalizar_ser;
	}

	public void setFinalizar_ser(boolean finalizar_ser) {
		this.finalizar_ser = finalizar_ser;
	}

	public boolean isAcepta_prov() {
		return acepta_prov;
	}

	public void setAcepta_prov(boolean acepta_prov) {
		this.acepta_prov = acepta_prov;
	}

	public boolean isAcepta_cli() {
		return acepta_cli;
	}

	public void setAcepta_cli(boolean acepta_cli) {
		this.acepta_cli = acepta_cli;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
		this.acepta_prov=false;
		this.acepta_cli=false;
		this.iniciar_ser=false;
		this.finalizar_ser=false;
	}
   
}
