package sessionbeans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import clases.Historial;
import clases.Solicitud;
import clases.Usuario;

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
    @Override
    public List<Solicitud> getSolicitudes(String prov){
    	Query q = entityManager.createQuery("SELECT s FROM Solicitud s");
        List<Solicitud> lista1=q.getResultList();
        for(int i=0;i<lista1.size();i++){
        	if(!lista1.get(i).getNom_prov().equals(prov)){
        		lista1.remove(lista1.get(i).getId());
        	}
        }
        return lista1;
    }
    @Override
    public List<Solicitud> getSolicitudesCli(String cli){
    	Query q = entityManager.createQuery("SELECT s FROM Solicitud s");
        List<Solicitud> lista1=q.getResultList();
        for(int i=0;i<lista1.size();i++){
        	if(!lista1.get(i).getNombre_cli().equals(cli)){
        		lista1.remove(lista1.get(i).getId());
        	}
        }
        return lista1;
    }
    @Override
    public boolean removeSolicitud(int solicitud){
    	Solicitud sol=(Solicitud)entityManager.find(Solicitud.class,solicitud);
    	entityManager.remove(sol);
    	return true;
    }
    @Override
    public boolean setAcepta_Prov(String nombre_prov,String nombre_cli,boolean aceptar){
    	Query q = entityManager.createQuery("SELECT s FROM Solicitud s");
        List<Solicitud> lista1=q.getResultList();
        for(int i=0;i<lista1.size();i++){
        	if(lista1.get(i).getNombre_cli().equals(nombre_cli) && lista1.get(i).getNom_prov().equals(nombre_prov)){
        		lista1.get(i).setAcepta_prov(aceptar);
        		entityManager.merge(lista1.get(i));
        		return true;
        	}
    	}
    	return false;
    }
    @Override
	public boolean setAcepta_Cli(String nombre_prov,String nombre_cli,boolean aceptar){
    	Query q = entityManager.createQuery("SELECT s FROM Solicitud s");
        List<Solicitud> lista1=q.getResultList();
        for(int i=0;i<lista1.size();i++){
        	if(lista1.get(i).getNombre_cli().equals(nombre_cli) && lista1.get(i).getNom_prov().equals(nombre_prov)){
        		lista1.get(i).setAcepta_cli(aceptar);
        		entityManager.merge(lista1.get(i));
        		return true;
        	}
    	}
    	return false;
	}
    @Override
    public boolean setIniciarServicio(int cod,boolean iniciar){
    	Solicitud sol=(Solicitud)entityManager.find(Solicitud.class,cod);
    	sol.setIniciar_ser(iniciar);
    	entityManager.merge(sol);
    	return true;
    }
    @Override
    public boolean setFinalizarServicio(int cod,boolean finalizar){
    	Solicitud sol=(Solicitud)entityManager.find(Solicitud.class,cod);
    	sol.setFinalizar_ser(finalizar);;
    	entityManager.merge(sol);
    	return true;
    }
    @Override
    public Solicitud getSolicitud(int cod){
    	Solicitud sol=(Solicitud)entityManager.find(Solicitud.class,cod);
    	return sol;
    }
    @Override
    public boolean setReview(int cod,int review){
    	Solicitud sol=(Solicitud)entityManager.find(Solicitud.class,cod);
    	sol.setReview(review);
    	entityManager.merge(sol);
    	return true;
    }
}
