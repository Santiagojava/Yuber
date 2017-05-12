package clases;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Servicio")
public class Servicio implements Serializable{
	@Id
	@Column(name="nombre")
	private String nombre;
	@Column(name="desc_tarea")
	private String desc_tarea;
	@Column(name="tipo_ser")
	private TipoServicio vertical;
	@ManyToOne
    @JoinTable(name="Prov_Ser", 
            joinColumns=@JoinColumn(name="nom_serv"),
            inverseJoinColumns=@JoinColumn(name="nom_prov"))
    @MapKeyColumn(name="nom_prov",table="Prov_Ser")
	private Usuario proveedor;
	
	public Servicio(String nombre, String desc_tarea, TipoServicio vertical) {
		super();
		this.nombre = nombre;
		this.desc_tarea = desc_tarea;
		this.vertical = vertical;
	}
	public Servicio() {
		super();
	}
	
}
