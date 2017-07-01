package clases;
import java.io.Serializable;

import javax.persistence.*;

import sessionbeans.ManagerUsuarioSessionBean;
import sessionbeans.ManagerUsuarioSessionBeanLocal;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "Usuario")
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="nombre")
	private String nombre;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="ip")
	private String ip;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Usuario() {
		super();
	}
	public Usuario(String nombre, String email, String password, String ip) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.ip=ip;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
}
