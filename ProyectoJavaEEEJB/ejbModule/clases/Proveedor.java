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
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Proveedor")
public class Proveedor extends Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column(name="estado")
	private EstadoProveedor estado;
	@Column(name="servicio")
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="Prov_Ser",
            joinColumns=@JoinColumn(name="nom_prov"),
            inverseJoinColumns=@JoinColumn(name="nom_ser"))
    @MapKeyColumn(name="nom_ser",table="Prov_Ser")
	List<Servicio>servicios=new ArrayList();
	//@OneToMany(fetch=FetchType.LAZY)
    //@JoinTable(name="Prov_Ser", 
    //        joinColumns=@JoinColumn(name="nom_prov"),
    //        inverseJoinColumns=@JoinColumn(name="nom_serv"))
    //@MapKeyColumn(name="nom_serv",table="Prov_Ser")
	//List<Servicio>servicios=new ArrayList();
	
	public Proveedor(){
	}
	public Proveedor(String nombre, String email, String password,String ip, EstadoProveedor estado){
		super(nombre,email,password,ip);
		this.estado=estado;
	}
	public List<Servicio> getServicios() {
		return servicios;
	}
	public void setServicio(Servicio servicio) {
		this.servicios.add(servicio);
	}
	public void setEstado(EstadoProveedor estado){
		this.estado=estado;
	}
	public EstadoProveedor getEstado(){
		return this.estado;
	}
}
