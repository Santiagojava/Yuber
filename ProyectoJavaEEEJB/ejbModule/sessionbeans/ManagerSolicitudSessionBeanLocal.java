package sessionbeans;

import java.util.List;

import javax.ejb.Local;

import clases.Servicio;
import clases.Solicitud;

@Local
public interface ManagerSolicitudSessionBeanLocal {
	
	public boolean addSolicitud(Solicitud solicitud);
	public List<Solicitud> getSolicitudes(String prov);
	public boolean removeSolicitud(int solicitud);
	public List<Solicitud> getSolicitudesCli(String cli);
	public boolean setAcepta_Prov(String nombre_prov,String nombre_cli,boolean aceptar);
	public boolean setAcepta_Cli(String nombre_prov,String nombre_cli,boolean aceptar);
	public boolean setIniciarServicio(int cod,boolean iniciar);
	public boolean setFinalizarServicio(int cod,boolean finalizar);
	public Solicitud getSolicitud(int cod);
	public boolean setReview(int cod,int review);
}
