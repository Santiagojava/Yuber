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

import clases.EstadoProveedor;
import clases.Proveedor;
import clases.Solicitud;
import clases.Usuario;
import sessionbeans.ManagerServicioSessionBean;
import sessionbeans.ManagerServicioSessionBeanLocal;
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
    
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        	/*
        	InetAddress ip;
            ip = InetAddress.getLocalHost();
        	Usuario usu=new Proveedor("Tlanspoltes Lonqui","tr@tlanspolteslonqui.com","12345678",ip.getHostAddress(),EstadoProveedor.AUSENTE);
        	musb.addUsuario(usu);
        	*/
        	
        	
        	//CASO DE USO
            
        	InetAddress ip;
            ip = InetAddress.getLocalHost();
            
            HttpSession session=request.getSession();
            List<Solicitud> so= new ArrayList();
            session.setAttribute("solicitudes",so);
        	musb.cambiarEstado("Uber",EstadoProveedor.DISPONIBLE);
        	musb.cambiarIP("Uber",ip.getHostAddress());
        	Thread th=new WebThread("Uber",session);
        	th.start();
        	
        	/*
        	Usuario usu = musb.getUsuario("Uber");
        	System.out.println(usu.getEmail());
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	
	@Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
