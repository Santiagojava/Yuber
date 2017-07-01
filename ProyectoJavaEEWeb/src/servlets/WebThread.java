package servlets;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.servlet.http.HttpSession;

import clases.Solicitud;
import clases.Usuario;
import sessionbeans.ManagerSolicitudSessionBeanLocal;
import sessionbeans.ManagerUsuarioSessionBeanLocal;

public class WebThread extends Thread{
	Socket s;
	ServerSocket ss;
	InputStreamReader entradaSocket;
	BufferedReader entrada;
	DataOutputStream salida;
	String prov;
	int puerto;
	HttpSession session;
	List<Solicitud>so;
	public WebThread(String prov,HttpSession session){
		super();
		puerto=1025;
		this.prov=prov;
		this.session=session;
		so=new ArrayList();
	}
	@Override
    public void run(){
		try {
			ss= new ServerSocket(puerto);
			while(true){
				s= ss.accept();
				entradaSocket = new InputStreamReader(s.getInputStream());
				entrada = new BufferedReader(entradaSocket);
				salida = new DataOutputStream(s.getOutputStream());
				String cadena=entrada.readLine();
				String[] partes = cadena.split("/");
				Solicitud solicitud = new Solicitud();
				solicitud.setDestino(partes[1]);
				solicitud.setNom_prov(prov);
				solicitud.setNombre_cli(partes[0]);
				so.add(solicitud);
				session.setAttribute("solicitudes",so);
				entrada.close();
				entrada=null;
				salida.close();
				salida=null;
				s.close();
				s=null;
			}
		}catch(Exception e){};
    }
}
