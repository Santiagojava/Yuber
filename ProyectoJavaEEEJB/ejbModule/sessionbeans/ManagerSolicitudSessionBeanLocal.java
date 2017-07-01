package sessionbeans;

import javax.ejb.Local;

import clases.Servicio;
import clases.Solicitud;

@Local
public interface ManagerSolicitudSessionBeanLocal {
	
	public boolean addSolicitud(Solicitud solicitud);
}
