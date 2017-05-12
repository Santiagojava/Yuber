package sessionbeans;

import javax.ejb.Local;

import clases.Servicio;

@Local
public interface ManagerServicioSessionBeanLocal {
	public boolean addServicio(Servicio servicio);
}
