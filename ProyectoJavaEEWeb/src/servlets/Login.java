package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
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
import sessionbeans.ManagerUsuarioSessionBeanLocal;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
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
    	String usu=(String) request.getAttribute("usu");
    	String psswd=(String) request.getAttribute("psswd");
    	Usuario usuario = musb.getUsuario(usu);
    	if(usuario!=null){
    		if(usuario.getPassword().equals(psswd)){
    			request.getSession().setAttribute("user_data",usuario);
    			if(usuario instanceof Proveedor){
    				response.sendRedirect("indexProv.jsp");
    			}
    			else{
    				response.sendRedirect("");
    			}
    		}
    		else{    			
    			request.getSession().setAttribute("error","Error,nombre de Usuario y/o constraseña incorrectos");
    			response.sendRedirect("index.jsp");
    		}
    	}
    	else{
    		request.getSession().setAttribute("error","Error,nombre de Usuario y/o constraseña incorrectos");
    		response.sendRedirect("index.jsp");
    	}
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
		processRequest(request,response);
	}

}
