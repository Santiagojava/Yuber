package sessionbeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import clases.Servicio;
import clases.Usuario;

/**
 * Session Bean implementation class ManagerUsuarioSessionBean
 */
@Stateless
@LocalBean
public class ManagerUsuarioSessionBean implements ManagerUsuarioSessionBeanLocal{

    /**
     * Default constructor.
     */
	@PersistenceContext(unitName="LAB_JAVAEE")
	private EntityManager entityManager;
	
    public ManagerUsuarioSessionBean() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public boolean addUsuario(Usuario usuario){
    	entityManager.persist(usuario);
    	return true;
    }

}
