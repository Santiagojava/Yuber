package clases;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente extends Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	public Cliente(){
	}
	public Cliente(String nombre, String email, String password,String ip){
		super(nombre,email,password,ip);
	}
	
}
