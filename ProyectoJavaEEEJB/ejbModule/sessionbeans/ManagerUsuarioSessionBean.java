package sessionbeans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import clases.EstadoProveedor;
import clases.Proveedor;
import clases.Servicio;
import clases.Usuario;

/**
 * Session Bean implementation class ManagerUsuarioSessionBean
 */
@Stateless
public class ManagerUsuarioSessionBean implements ManagerUsuarioSessionBeanLocal{

    /**
     * Default constructor.
     */
	@PersistenceContext(unitName="LAB_JAVAEE")
	private EntityManager entityManager;
	   
    public ManagerUsuarioSessionBean() {
    }
    @Override
    public boolean addUsuario(Usuario usuario){
        entityManager.persist(usuario);
    	return true;
    }
    @Override
    public Usuario getUsuario(String nombre){
    	Query q = entityManager.createQuery("SELECT u FROM Usuario u");
        List<Usuario> lista1=q.getResultList();
        Map<String,Usuario> users = new HashMap();
        for(int x=0;x<lista1.size();x++) {
            users.put(lista1.get(x).getNombre(),lista1.get(x));
        }
        Usuario usu = (Usuario)users.get(nombre);
        return usu;
    }
    @Override
    public List<Usuario> getUsuarios(){
    	Query q = entityManager.createQuery("SELECT u FROM Usuario u");
        List<Usuario> lista1=q.getResultList();
        return lista1;
    }
    @Override
    public void cambiarEstado(String nombre,EstadoProveedor estado){
    	Proveedor prov=(Proveedor)entityManager.find(Usuario.class,nombre);
        prov.setEstado(estado);
        entityManager.merge(prov);
    }
    @Override
    public void cambiarIP(String nombre,String ip){
    	Usuario usu=(Usuario)entityManager.find(Usuario.class,nombre);
        usu.setIp(ip);
        entityManager.merge(usu);
    }
}
