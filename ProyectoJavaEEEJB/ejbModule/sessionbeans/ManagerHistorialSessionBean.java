package sessionbeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import clases.Historial;
import clases.Servicio;
import clases.Usuario;

/**
 * Session Bean implementation class ManagerHistorialSessionBean
 */
@Stateless
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
    @Override
    public Historial getHistorial(int cod){
    	Historial his=(Historial)entityManager.find(Historial.class,cod);
    	return his;
    }
    @Override
    public boolean updateHistorial(Historial historial){
    	entityManager.merge(historial);
    	return true;
    }
}
