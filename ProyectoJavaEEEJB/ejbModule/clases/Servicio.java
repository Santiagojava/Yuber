package clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Servicio")
public class Servicio implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="nombre")
	private String nombre;
	@Column(name="desc_tarea")
	private String desc_tarea;
	@Column(name="tipo_ser")
	private TipoServicio vertical;
	@ManyToMany(mappedBy="servicios")
	private List<Proveedor>proveedores=new ArrayList();
	@OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name="Ser_Sub",
            joinColumns=@JoinColumn(name="nom_serv"),
            inverseJoinColumns=@JoinColumn(name="tipo_sub"))
    @MapKeyColumn(name="tipo_sub",table="Ser_Sub")
	private List<SubVertical>subverticales=new ArrayList();
	//@ManyToOne
    //@JoinTable(name="Prov_Ser", 
    //        joinColumns=@JoinColumn(name="nom_serv"),
    //        inverseJoinColumns=@JoinColumn(name="nom_prov"))
    //@MapKeyColumn(name="nom_prov",table="Prov_Ser")
	//private Usuario proveedor;
	
	public Servicio(String nombre, String desc_tarea, TipoServicio vertical) {
		super();
		this.nombre = nombre;
		this.desc_tarea = desc_tarea;
		this.vertical = vertical;
	}
	public Servicio() {
		super();
	}
	public List<Proveedor> getProveedores() {
		return proveedores;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedores.add(proveedor);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDesc_tarea() {
		return desc_tarea;
	}
	public void setDesc_tarea(String desc_tarea) {
		this.desc_tarea = desc_tarea;
	}
	public TipoServicio getVertical() {
		return vertical;
	}
	public void setVertical(TipoServicio vertical) {
		this.vertical = vertical;
	}
	
}
