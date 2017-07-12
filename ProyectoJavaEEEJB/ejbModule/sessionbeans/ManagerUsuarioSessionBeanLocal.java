package sessionbeans;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import clases.EstadoProveedor;
import clases.Usuario;

@Local
public interface ManagerUsuarioSessionBeanLocal {
	public boolean addUsuario(Usuario usuario);
	public void cambiarEstado(String nombre,EstadoProveedor estado);
	public Usuario getUsuario(String nombre);
	public void cambiarIP(String nombre,String ip);
	public List<Usuario> getUsuarios();
}
