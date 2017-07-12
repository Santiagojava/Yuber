package sessionbeans;

import javax.ejb.Local;

import clases.Historial;
import clases.Servicio;

@Local
public interface ManagerHistorialSessionBeanLocal {
	public boolean addHistorial(Historial historial);
	public Historial getHistorial(int cod);
	public boolean updateHistorial(Historial historial);
}
