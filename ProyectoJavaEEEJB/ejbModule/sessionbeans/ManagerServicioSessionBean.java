package sessionbeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import clases.Servicio;

/**
 * Session Bean implementation class ManagerServicioSessionBean
 */
@Stateless
@LocalBean
public class ManagerServicioSessionBean implements ManagerServicioSessionBeanLocal{
	@PersistenceContext(unitName="LAB_JAVAEE")
	private EntityManager entityManager;
	
    public ManagerServicioSessionBean() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public boolean addServicio(Servicio servicio){
    	entityManager.persist(servicio);
    	return true;
    }
}
