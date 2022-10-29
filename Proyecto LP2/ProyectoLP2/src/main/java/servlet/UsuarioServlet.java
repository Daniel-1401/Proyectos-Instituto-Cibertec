package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.usuarioDTO;
import DAO.DAOFactory;
import mantenimiento.MySQLUsuarioDAO;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet(name = "us", urlPatterns = { "/us" })
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opc= request.getParameter("opcion");
		System.out.println("Opcion seleccionada:"+ opc);
		
		opc = (opc== null) ? "cerrar" : opc;
		
	////segun la opcion...
	switch(opc) {
	//MENU
	case "r": registro(request, response); break;
	case "l": login (request, response); break;
	default:
		System.out.println("Cerranso la sesion ID");
		System.out.println("Id Sesion...............:"+ request.getSession().getId());
		System.out.println("--------------------------------");
		request.getSession().invalidate();
		response.sendRedirect("login.jsp");
		
	}
	}

	private void registro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ingreso al Servlet registrar usuario");
		//variables
		String mensaje="";
		String url;
		
		String codusuario = request.getParameter("txtCodUsuario");
		int tipocod= Integer.parseInt(request.getParameter("txtTipo"));
		String email= request.getParameter("txtCorreo");
		String contraseña= request.getParameter("txtContraseña");
		String nombreusu= request.getParameter("txtNombreUsu");
		String apellidos= request.getParameter("txtApellidos");
		
		
		usuarioDTO u = new usuarioDTO();
		u.setCodUsu(codusuario);
		u.setCodTipoUsu(tipocod);
		u.setEmail(email);
		u.setContrasenia(contraseña);
		u.setNomUsu(nombreusu);
		u.setApeUsu(apellidos);
		
		MySQLUsuarioDAO gu= new MySQLUsuarioDAO();
		int ok= gu.registrar(u);
		
		if(ok==0) {
			mensaje +="Error al Registrar los datos , revisar";
			url = "/registro.jsp";
		}else {
			mensaje ="<script>alert('"+"Registro del usuario<strong>"+ codusuario +
					"</strong>OK, ingrese al sistema"+"')</script>";
			url="/login.jsp";
		}
		
		//Salidas
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
		
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hola Mundo, soy un servlet");
		// TRABAJAMOS CON LAS SESSIONES
		HttpSession miSesion= request.getSession();
		//mostramos en consola
		System.out.println("Id Sesion...............:"+ miSesion.getId());
		System.out.println("Fech/Hora creacion......:"+ new SimpleDateFormat().format(miSesion.getCreationTime()));
		System.out.println("Tiempo Max Inactividad..:"+ miSesion.getMaxInactiveInterval());
		System.out.println("Id Sesion...............:"+ miSesion.getId());
		String url ;
		
		//leer los datos de entrada request.getParameter("Nombre de campo"));
		String usuario = request.getParameter("txtusuario");
		String clave   = request.getParameter("txtclave");
		
		//proceso validar datos
		DAOFactory fabrica = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		usuarioDTO u=	fabrica.getUsuarioDAO().validar(usuario, clave);
			
	
	//validacion con mensaje
		if(u!=null) {
			url="productos.jsp";
			//request.setAttribute("u",u);
			request.getSession().setAttribute("u", u);			
		}
		else {
			request.setAttribute("mensaje",
					"<script>alert('Usuario o clave incorrecto alumnos de IDAT') ;</script>");
			url= "login.jsp";
			
		}
		
		//SALIDA: REDIRECCIONAMIENTO
		//response.sendRedirect(url);
		//para la salida de atributos es con este request
		request.getRequestDispatcher(url).forward(request, response);
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
		doGet(request, response);
	}

}
