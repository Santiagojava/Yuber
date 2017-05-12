package sessionbeans;

import javax.ejb.Local;

import clases.Usuario;

@Local
public interface ManagerUsuarioSessionBeanLocal {
	public boolean addUsuario(Usuario usuario);
}
