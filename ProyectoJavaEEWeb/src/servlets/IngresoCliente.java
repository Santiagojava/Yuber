package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clases.Cliente;
import clases.EstadoProveedor;
import clases.Proveedor;
import clases.Solicitud;
import clases.Usuario;
import sessionbeans.ManagerSolicitudSessionBeanLocal;
import sessionbeans.ManagerUsuarioSessionBeanLocal;

/**
 * Servlet implementation class IngresoCliente
 */
@WebServlet("/IngresoCliente")
public class IngresoCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	ManagerUsuarioSessionBeanLocal musb;
	@EJB
	ManagerSolicitudSessionBeanLocal mssb;
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        	//Caso de Prueba
        	
        	InetAddress ip;
            ip = InetAddress.getLocalHost();
            /*
            String ubicacion="-56.108850593115244#-34.33727214315811";
        	Usuario cli= new Cliente("Ramon","ramon@donramon.com","12345678",ip.getHostAddress(),ubicacion);
        	musb.addUsuario(cli);
        	Usuario pro = new Proveedor("Uber","uber@uber.com","12345678",ip.getHostAddress(),ubicacion,EstadoProveedor.DISPONIBLE);
        	musb.addUsuario(pro);
        	*/
        	/*Usuario usu=musb.getUsuario("Ramon");
            String text= usu.getNombre() + "/" + usu.getUbicacion();
            Usuario prov=musb.getUsuario("Uber");
            Socket s= new Socket(prov.getIp(),1025);
        	PrintStream salida= new PrintStream(s.getOutputStream());
        	salida.println(text);
        	salida.close();
        	s.close();
            */
            //Caso real
        	
        	List<Usuario> users=musb.getUsuarios();
        	for(int i=0;i<users.size();i++){
        		if(users.get(i) instanceof Proveedor){
        			Proveedor prov=(Proveedor)users.get(i);
        			String categoria = request.getParameter("categoria");
        			if(prov.getCategoria().equals(categoria)){
        				if(prov.getEstado().equals(EstadoProveedor.DISPONIBLE)){
            				String latitud = request.getParameter("latitud");
            	        	String longitud = request.getParameter("longitud");
            	        	String[] coordenadas=users.get(i).getUbicacion().split("#");  
            	        	float lon_prov = Float.valueOf(coordenadas[0]);
            	        	float lat_prov = Float.parseFloat(coordenadas[1]);
            				float lon = Float.parseFloat(longitud);
            				float lat = Float.parseFloat(latitud);
            				float param = 1.0f;
            				
            				if((lon_prov >= (lon - param) && lon_prov <= (lon + param)) && (lat_prov >= (lat - param) && lat_prov <= (lat + param))){
            					
                				Usuario usu=(Usuario)request.getSession().getAttribute("user_data");
            					Solicitud sol=new Solicitud();
                				sol.setNombre_cli(usu.getNombre());
                				sol.setNom_prov(users.get(i).getNombre());
                				sol.setDestino(longitud + "#" + latitud);
                				mssb.addSolicitud(sol);
                				response.sendRedirect("esperaRespuesta.jsp");
            				}
            			}
        			}
        		}
        	}
        } finally {
            out.close();
        }
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text = "";
		Usuario usu=(Usuario)request.getSession().getAttribute("user_data");
		List<Solicitud> solicitudes=mssb.getSolicitudesCli(usu.getNombre());
		text="Espera a que tu solicitud sea aceptada por un Proveedor...";
		for(int i=0;i<solicitudes.size();i++){
			if(solicitudes.get(i).isAcepta_prov()){
				request.getSession().setAttribute("cod_sol",solicitudes.get(i).getId());
				request.getSession().setAttribute("nom_prov",solicitudes.get(i).getNom_prov());
				if(solicitudes.get(i).isIniciar_ser()){
					text="Cronometro.jsp";
				}
				else{
					text=solicitudes.get(i).getNom_prov()+" ha aceptado tu peticion, llegará a tu ubicación a la brevedad";
				}
			}
		}
	    response.setContentType("text/plain"); 
	    response.setCharacterEncoding("UTF-8"); 
	    response.getWriter().write(text);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
