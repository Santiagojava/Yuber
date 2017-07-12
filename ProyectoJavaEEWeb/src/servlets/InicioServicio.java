package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.EstadoProveedor;
import clases.Proveedor;
import clases.Solicitud;
import clases.Usuario;
import sessionbeans.ManagerSolicitudSessionBeanLocal;

/**
 * Servlet implementation class InicioServicio
 */
@WebServlet("/InicioServicio")
public class InicioServicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	ManagerSolicitudSessionBeanLocal mssb;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        	//
        } finally {
            out.close();
        }
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cliente=(String)request.getSession().getAttribute("nombre_cli");
		String text="Espera a que "+cliente+" finalice el servicio";
		int cod=(int)request.getSession().getAttribute("cod_sol");
		Solicitud soli = mssb.getSolicitud(cod);
		mssb.setIniciarServicio(cod,true);
		response.setContentType("text/plain"); 
	    response.setCharacterEncoding("UTF-8"); 
	    response.getWriter().write(text);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

}
