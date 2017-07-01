package sessionbeans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import clases.Proveedor;
import clases.Servicio;
import clases.Usuario;

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
    	entityManager.getTransaction().begin();
        entityManager.persist(servicio);
        entityManager.flush();
        entityManager.getTransaction().commit();
    	return true;
    }
    public boolean addServicioProveedor(Servicio servicio, String proveedor){
    	Query q = entityManager.createQuery("SELECT s FROM Servicio s");
        List<Usuario> lista1=q.getResultList();
        Map<String,Usuario> users = new HashMap();
        for(int x=0;x<lista1.size();x++) {
            users.put(lista1.get(x).getNombre(),lista1.get(x));
        }
        Proveedor prov=(Proveedor) users.get(proveedor);
        servicio.setProveedor(prov);
        prov.setServicio(servicio);
        entityManager.getTransaction().begin();
        entityManager.persist(servicio);
        entityManager.persist(prov);
        entityManager.flush();
        entityManager.getTransaction().commit();
    	return true;
    }
    public Servicio getServicio(String servicio){
    	Query q = entityManager.createQuery("SELECT s FROM Servicio s");
        List<Servicio> lista1=q.getResultList();
        Map<String,Servicio> users = new HashMap();
        for(int x=0;x<lista1.size();x++) {
            users.put(lista1.get(x).getNombre(),lista1.get(x));
        }
        Servicio ser = (Servicio)users.get(servicio);
        return ser;
    }
}
