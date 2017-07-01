package sessionbeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import clases.Historial;
import clases.Solicitud;

/**
 * Session Bean implementation class ManagerSolicitudSessionBean
 */
@Stateless
public class ManagerSolicitudSessionBean implements ManagerSolicitudSessionBeanLocal{
	@PersistenceContext(unitName="LAB_JAVAEE")
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public ManagerSolicitudSessionBean() {
    	
    }
    @Override
    public boolean addSolicitud(Solicitud solicitud){
        entityManager.persist(solicitud);
    	return true;
    }
}
