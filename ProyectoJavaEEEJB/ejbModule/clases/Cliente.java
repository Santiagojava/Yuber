package clases;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente extends Usuario implements Serializable{

	public Cliente(){
	}
	public Cliente(String nombre, String email, String password){
		super(nombre,email,password);
	}
	
}
