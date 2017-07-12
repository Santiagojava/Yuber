package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Proveedor;
import clases.Solicitud;
import sessionbeans.ManagerSolicitudSessionBeanLocal;
import sessionbeans.ManagerUsuarioSessionBeanLocal;

/**
 * Servlet implementation class FinalizarServicio
 */
@WebServlet("/FinalizarServicio")
public class FinalizarServicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	ManagerSolicitudSessionBeanLocal mssb;
	@EJB
	ManagerUsuarioSessionBeanLocal musb;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        	String tiempo = request.getParameter("tiempo");
        	String[] params= tiempo.split(":");
        	int cod_sol=(int)request.getSession().getAttribute("cod_sol");
        	int horas = Integer.parseInt(params[0]);
        	int minutos = Integer.parseInt(params[1]);
        	if(horas == -1){
        		horas=59;
        	}
        	if(minutos == -1){
        		minutos=59;
        	}
        	int min_total=0;
        	for(int i=0;i<horas;i++){
        		min_total+=60;
        	}
        	for(int i=0;i<minutos;i++){
        		min_total++;
        	}
			//Sacar de la tarifa del proveedor
        	Solicitud soli=mssb.getSolicitud(cod_sol);
        	String prov=soli.getNom_prov();
        	Proveedor pro=(Proveedor)musb.getUsuario(prov);
        	int precio=pro.getTarifa()*min_total;
        	mssb.setFinalizarServicio(cod_sol,true);
        	
        } finally {
            out.close();
        }
    }
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String text="De click al boton Iniciar Servicio cuando se encuentre con el cliente";
		int cod=(int)request.getSession().getAttribute("cod_sol");
		Solicitud soli=mssb.getSolicitud(cod);
		if(soli.isFinalizar_ser()){
			text="indexProv.jsp";
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
		processRequest(request,response);
	}

}
