package clases;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Administrador")
public class Administrador extends Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	public Administrador(){
	}
	public Administrador(String nombre, String email, String password, String ip){
		super(nombre,email,password,ip);
	}
}
