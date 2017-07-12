package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.List;

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

/**
 * Servlet implementation class VerSolicitud
 */
@WebServlet("/VerSolicitud")
public class VerSolicitud extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        	String nombre_cli = request.getParameter("nombre_cli");
        	String  ubicacion = request.getParameter("ubicacion");
        	String pos[] = ubicacion.split("#");
        	HttpSession session= request.getSession();
        	session.setAttribute("nombre_cli",nombre_cli);
        	session.setAttribute("longitud",pos[0]);
        	session.setAttribute("latitud",pos[1]);
        	response.sendRedirect("pedido.jsp");
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
		processRequest(request,response);
	}

}
