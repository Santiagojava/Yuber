package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import clases.TipoServicio;
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
	    	//Lineas de register
	    	//Usuario cli= new Cliente("Ramon Ramon","ramon@ramon.com","12345678","192.168.1.5","-56.108850593115244#-34.33727214315811");
	    	//Usuario prove = new Proveedor("Jardinero Pepe","pepe@pepin.com","12345678","192.168.1.5","-56.110850593115244#-34.43727214315811",EstadoProveedor.DISPONIBLE,5,"Jardineria");
	    	//cli.setVertical(TipoServicio.ONSITE);
	    	//prove.setVertical(TipoServicio.ONSITE);
	    	//musb.addUsuario(cli);
	    	//musb.addUsuario(prove);
	    	//
	    	String usu=request.getParameter("usu");
	    	String psswd=(String) request.getParameter("psswd");
	    	Usuario usuario = musb.getUsuario(usu);
	    	if(usuario!=null){
	    		if(usuario.getPassword().equals(psswd)){
	    			request.getSession().setAttribute("user_data",usuario);
	    			if(usuario instanceof Proveedor){
	    				response.sendRedirect("indexProv.jsp");
	    			}
	    			else if(usuario instanceof Cliente){
	    				if(usuario.getVertical().equals(TipoServicio.ONSITE)){
	    					List<Usuario>users=musb.getUsuarios();
    						List<String>usuarios=new ArrayList();
    						for(int i=0;i<users.size();i++){
    							if(users.get(i) instanceof Proveedor){
    								if(users.get(i).getVertical().equals(TipoServicio.ONSITE)){
    									Proveedor prov=(Proveedor)users.get(i);
	    								usuarios.add(prov.getCategoria());
    								}
    							}
							}
    						Set<String> hs = new HashSet<>();
    						hs.addAll(usuarios);
    						usuarios.clear();
    						usuarios.addAll(hs);
    						request.getSession().setAttribute("usuarios",usuarios);
	    					response.sendRedirect("on-site.jsp");
	    				}
	    				else 
	    					if(usuario.getVertical().equals(TipoServicio.REMOTO)){
	    						List<Usuario>users=musb.getUsuarios();
	    						List<String>usuarios=new ArrayList();
	    						for(int i=0;i<users.size();i++){
	    							if(users.get(i) instanceof Proveedor){
	    								if(users.get(i).getVertical().equals(TipoServicio.REMOTO)){
	    									Proveedor prov=(Proveedor)users.get(i);
		    								usuarios.add(prov.getCategoria());
	    								}
	    							}
    							}
	    						Set<String> hs = new HashSet<>();
	    						hs.addAll(usuarios);
	    						usuarios.clear();
	    						usuarios.addAll(hs);
	    						request.getSession().setAttribute("usuarios",usuarios);
	    						response.sendRedirect("remoto.jsp");
	    					}
	    				else 
	    					if(usuario.getVertical().equals(TipoServicio.TRANSPORTE)){
	    						List<Usuario>users=musb.getUsuarios();
	    						List<String>usuarios=new ArrayList();
	    						for(int i=0;i<users.size();i++){
	    							if(users.get(i) instanceof Proveedor){
	    								if(users.get(i).getVertical().equals(TipoServicio.TRANSPORTE)){
	    									Proveedor prov=(Proveedor)users.get(i);
		    								usuarios.add(prov.getCategoria());
	    								}
	    							}
    							}
	    						Set<String> hs = new HashSet<>();
	    						hs.addAll(usuarios);
	    						usuarios.clear();
	    						usuarios.addAll(hs);
	    						request.getSession().setAttribute("usuarios",usuarios);
	    						//response.sendRedirect(request.getContextPath() + "/Transporte.jsp");
	    						response.sendRedirect("Transporte.jsp");
	    					}
	    				
	    				
	    			}else{
	    				response.sendRedirect("indexProv.jsp");
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
	    /*
		response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    try {
	    	String usu=request.getParameter("usu");
	    	String psswd=(String) request.getParameter("psswd");
	    	Usuario usuario = musb.getUsuario(usu);
	    	if(usuario!=null){
	    		if(usuario.getPassword().equals(psswd)){
	    			request.getSession().setAttribute("user_data",usuario);
	    			if(usuario instanceof Proveedor){
	    				response.sendRedirect("indexProv.jsp");
	    			}
	    			else if(usuario instanceof Cliente){
	    				if(usuario.getVertical().equals(TipoServicio.ONSITE))
	    					response.sendRedirect("on-site.jsp");
	    				else if(usuario.getVertical().equals(TipoServicio.REMOTO))
	    					response.sendRedirect("remoto.jsp");
	    				else if(usuario.getVertical().equals(TipoServicio.TRANSPORTE))
	    					response.sendRedirect("Transporte.jsp");
	    				
	    				
	    			}else{
	    				response.sendRedirect("indexProv.jsp");
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
	    */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

}
