package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clases.Historial;
import clases.Solicitud;
import clases.Usuario;
import sessionbeans.ManagerHistorialSessionBeanLocal;
import sessionbeans.ManagerSolicitudSessionBeanLocal;

/**
 * Servlet implementation class AceptaProveedor
 */
@WebServlet("/AceptaProveedor")
public class AceptaProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	ManagerSolicitudSessionBeanLocal mssb;
	@EJB
	ManagerHistorialSessionBeanLocal mhsb;
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        	String nombre_cli=request.getParameter("nombre_cli");
        	request.getSession().setAttribute("nombre_cli",nombre_cli);
        	Usuario usu=(Usuario)request.getSession().getAttribute("user_data");
        	List<Solicitud>solicitudes=mssb.getSolicitudesCli(nombre_cli);
        	for(int i=0;i<solicitudes.size();i++){
        		Solicitud sol=solicitudes.get(i);
        		if(!sol.getNom_prov().equals(usu.getNombre())){
        			mssb.removeSolicitud(sol.getId());
        		}
        		else{
        			request.getSession().setAttribute("cod_sol",sol.getId());
        		}
    		}
        	//Setea en la solicitud el booleano de que acepta
        	mssb.setAcepta_Prov(usu.getNombre(),nombre_cli,true);
        	//Crea el review en donde se setearan datos mas adelante
        	Historial his= new Historial();
        	mhsb.addHistorial(his);
        	int cod_sol = (int)request.getSession().getAttribute("cod_sol");
        	mssb.setReview(cod_sol,his.getId());
        	response.sendRedirect("buscarCliente.jsp");
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
