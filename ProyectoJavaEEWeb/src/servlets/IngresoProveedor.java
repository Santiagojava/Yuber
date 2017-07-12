package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import clases.EstadoProveedor;
import clases.Proveedor;
import clases.Solicitud;
import clases.Usuario;
import sessionbeans.ManagerServicioSessionBean;
import sessionbeans.ManagerServicioSessionBeanLocal;
import sessionbeans.ManagerSolicitudSessionBeanLocal;
import sessionbeans.ManagerUsuarioSessionBean;
import sessionbeans.ManagerUsuarioSessionBeanLocal;

/**
 * Servlet implementation class IngresoProveedor
 */
@WebServlet("/IngresoProveedor")
public class IngresoProveedor extends HttpServlet {
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
        	
        	InetAddress ip;
        	ip = InetAddress.getLocalHost();
        	
        	//Caso Prueba
        	//Usuario pro=new Proveedor("Uber","uber@uber.com","12345678",ip.getHostAddress(),"1000",EstadoProveedor.AUSENTE);
        	//musb.addUsuario(pro);
        	
        	
        	//CASO DE USO
            
            //Caso real
//            List<Integer> ids=new ArrayList();
//            HttpSession session=request.getSession();
//            List<Solicitud> so= new ArrayList();
//            session.setAttribute("solicitudes",so);
//            Usuario usu =(Usuario)session.getAttribute("user_data");
        	
            //Caso prueba
            Usuario usu = (Usuario)musb.getUsuario("Uber");
            musb.cambiarEstado(usu.getNombre(),EstadoProveedor.DISPONIBLE);
        	musb.cambiarIP(usu.getNombre(),ip.getHostAddress());
        	
        	WebThread th=new WebThread(usu.getNombre());
        	th.start();
        	/*while(true){
        		List<Solicitud> sol=th.getSolicitudes();
        		for(int i=0;i<sol.size();i++){
        			if(){
        				mssb.addSolicitud(sol.get(i));
            			ids.add(sol.get(i).getId());
        			}
        		}
        	}
        	*/
        } finally {
            out.close();
        }
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Usuario usu=(Usuario)request.getSession().getAttribute("user_data");
		List<Solicitud> solicitudes=mssb.getSolicitudes(usu.getNombre());
		String json = new Gson().toJson(solicitudes);
		out.write(json);
		//out.write("Tienes "+cant.toString()+" peticiones nuevas");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//processRequest(request, response);
		
	}
	
	@Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
