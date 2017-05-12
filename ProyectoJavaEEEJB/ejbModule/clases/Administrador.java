package clases;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Administrador")
public class Administrador extends Usuario implements Serializable{
	
	public Administrador(){
	}
	
	public Administrador(String nombre, String email, String password){
		super(nombre,email,password);
	}
}
