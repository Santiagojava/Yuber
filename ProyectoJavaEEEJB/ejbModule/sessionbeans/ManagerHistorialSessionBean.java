package sessionbeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import clases.Historial;
import clases.Servicio;

/**
 * Session Bean implementation class ManagerHistorialSessionBean
 */
@Stateless
@LocalBean
public class ManagerHistorialSessionBean implements ManagerHistorialSessionBeanLocal{
	@PersistenceContext(unitName="LAB_JAVAEE")
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public ManagerHistorialSessionBean() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public boolean addHistorial(Historial historial){
    	entityManager.persist(historial);
    	return true;
    }
}
