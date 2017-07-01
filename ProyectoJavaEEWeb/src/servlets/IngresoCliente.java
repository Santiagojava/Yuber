package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Cliente;
import clases.Usuario;
import sessionbeans.ManagerUsuarioSessionBeanLocal;

/**
 * Servlet implementation class IngresoCliente
 */
@WebServlet("/IngresoCliente")
public class IngresoCliente extends HttpServlet {
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
        	InetAddress ip;
            ip = InetAddress.getLocalHost();
        	//Usuario cli= new Cliente("Ramon","ramon@donramon.com","12345678",ip.getHostAddress());
        	//musb.addUsuario(cli);
        	String destino = request.getParameter("destino");
        	Usuario usu=musb.getUsuario("Ramon");
        	String text= usu.getNombre() + "/" + destino;
        	usu=musb.getUsuario("Uber");
        	Socket s= new Socket(usu.getIp(),1025);
        	PrintStream salida= new PrintStream(s.getOutputStream());
        	salida.println(text);
        	salida.close();
        	s.close();
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

}
