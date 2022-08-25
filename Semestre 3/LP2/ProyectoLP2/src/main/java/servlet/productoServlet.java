package servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import DAO.DAOFactory;
import beans.productosDTO;
import interfaces.productoDAO;
import mantenimiento.MySQLProductoDAO;

/**
 * Servlet implementation class productoServlet
 */
@WebServlet(name = "prodServ", urlPatterns = { "/prodServ" })
public class productoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productoServlet() {
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
		// TODO Auto-generated method stub
		System.out.println("-- Entro al Servlet de producto --");
		String opc = request.getParameter("opcion");
		opc = (opc == null ? "error" : opc);
		System.out.println("-- Opcion selesccionada: " + opc + " --");
		
		switch(opc) {
		case "añadirProducto": añadirProducto(request,response); break;
		case "a": actualizar(request,response); break;
		case "e": eliminar(request,response); break;
		case "l": listar(request,response); break;
		case "c": cargar(request,response); break;
		case "q": buscar(request,response); break;
		case "s": seleccionar(request,response); break;
		case "f": filtrar(request,response); break;
		
		default:
			System.out.println("No selecciono ninguna opcion");
			}
		}

		

		private void añadirProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String mensaje = "";
			String url = "";
			String 	codigoProducto   = request.getParameter("txtCodigoProducto");
			String 	modeloProducto   = request.getParameter("txtModeloProducto");
			String	Categoria        = request.getParameter("cboCategoria");
			String  Marca		     = request.getParameter("cboMarca");
			String	DescrpPantalla   = request.getParameter("txtDescripcionPantalla");
			String	cpu			     = request.getParameter("cboProcesador");
			String	gpu			     = request.getParameter("cboGPU");
			String	discoDuro        = request.getParameter("cboAlmacenamiento");
			String	SistemaOperativo = request.getParameter("cboSistemaOperativo");
			Double	precio 			 = Double.parseDouble(request.getParameter("txtPrecioProducto"));
			
			productosDTO prodNew = new productosDTO();
			prodNew.setCodigoProducto(codigoProducto);
			prodNew.setModeloProducto(modeloProducto);
			prodNew.setCategoria(Categoria);
			prodNew.setMarca(Marca);
			prodNew.setDescripcionPantalla(DescrpPantalla);
			prodNew.setCpu(cpu);
			prodNew.setGpu(gpu);
			prodNew.setDiscoDuro(discoDuro);
			prodNew.setSistemaOperativo(SistemaOperativo);
			prodNew.setPrecioVenta(precio);
			
//			DAOFactory fabrica = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
			int registro = new MySQLProductoDAO().registrar(prodNew);
			
			if(registro == 0) {
				mensaje +="<script>alert('ERROR AL REGISTRAR')</script>";
				url += "/AdminAñadirProd.jsp";
			}else {
				mensaje = "<script>alert('Registro del producto <strong>" + modeloProducto + "</strong>')</script>";
				url = "/AdminAñadirProd.jsp";
			}
			
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher(url).forward(request, response);
			
//			ArrayList<String> lista = new ArrayList<>();
//			insertProductoDTO p = new insertProductoDTO();
//			try {
//				FileItemFactory file = new  DiskFileItemFactory();
//				ServletFileUpload fileUpload = new ServletFileUpload(file);
//				List item = fileUpload.parseRequest(request);
//				for (int i = 0; i < item.size(); i++) {
//					FileItem fileItem = (FileItem)item.get(i);
//					if(!fileItem.isFormField()) {
//						File f = new File("\\ProyectoLP2\\src\\main\\webapp\\img\\imagenes" + fileItem.getName());
//						fileItem.write(f);
//						p.setImagen(f.getAbsolutePath());
//					}
//					else {
//						lista.add(fileItem.getString());
//					}
//				}
//				p.setCodCategoria(0);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
	}

		private void seleccionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// Obetener la informacion de un producto y lo envia a la pagina compra
					System.out.println("Ingresï¿½ al proceso seleccionar");
			// entradas
					String codigo = request.getParameter("codPro");
					System.out.println(codigo);
			// procesos
					
				//error productoDTO p = new MySQLProductoDAO().buscar(codigo);
			// salidas
					//error		request.getSession().setAttribute("p", p);
					
					//request.getRequestDispatcher("compra.jsp").forward(request, response);
					response.sendRedirect("compra.jsp");
			
		}

		private void cargar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
					System.out.println("Ingresï¿½ al proceso listado");
					//obtener el listado del producto, sin usar patron DAO
					//ArrayList<ProductoDTO> lista =  new MySQLProductoDAO().listado();
					
					// Usando ahora si patron DAO
					DAOFactory fabrica = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
					productoDAO pro = fabrica.getProductoDAO();
					
					
					//error		ArrayList<productoDTO> lista = pro.listado();
					//error	System.out.println(lista);
					
					//enviar el listado al JSP 
					//error	request.setAttribute("lstProductos", lista);
					request.getRequestDispatcher("catalogos.jsp").forward(request, response);
					
			
		}

		private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
					System.out.println("Seleccionï¿½ el proceso buscar");
			// entradas
					String codigo = request.getParameter("codPro");
					System.out.println(codigo);
			// procesos
					//error		productoDTO p = new MySQLProductoDAO().buscar(codigo);
			// salidas
					//error		request.setAttribute("p", p);
					request.getRequestDispatcher("mantenimientoproductos.jsp").forward(request, response);
			
		}
		
		private void filtrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			System.out.println("Seleccionï¿½ el proceso de filtrado");
			
			
			// entradas
			int codigo = Integer.parseInt(request.getParameter("txtid"));
			System.out.println(codigo);
			
			
			// procesos
			// Usando ahora si patron DAO
			DAOFactory fabrica = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
			productoDAO pro = fabrica.getProductoDAO();
			
			//error ArrayList<productoDTO> listxca = pro.listxcat(codigo);
			//error System.out.println(listxca);
		
			//enviar el listado al JSP 
			//error		request.setAttribute("lstProductos", listxca);
					request.getRequestDispatcher("catalogo.jsp").forward(request, response);
			
			
		}

		private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			//System.out.println("Ingresï¿½ al proceso listado");
			//DAOFactory fabrica = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
			//productoDAO pro = fabrica.getProductoDAO();
			//request.getRequestDispatcher("listado.jsp").forward(request, response);
			System.out.println("Ingresï¿½ al proceso listado");
			DAOFactory fabrica = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
			ArrayList<productosDTO> p =  new MySQLProductoDAO().listarProd();
			productoDAO pro = fabrica.getProductoDAO();
			request.setAttribute("p", p);
			request.getRequestDispatcher("AdminListarProd.jsp").forward(request, response);
			
		}
		
		private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
					System.out.println("Entro al proceso eliminar");
			// entradas
					String codigo = request.getParameter("txtid");
					System.out.println(codigo);
			//precesos
					//error	int rs = new MySQLProductoDAO().eliminar(codigo);
			//salidas
					//error	request.setAttribute("eli", rs);
					request.getRequestDispatcher("listado.jsp").forward(request, response);
			
		}

		private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
				System.out.println("entro al proceso actualizar");
			// variables
				String mensaje = "";
				String url;
			//entradas
				String descripcion = request.getParameter("txtdescrip");
				int stock = Integer.parseInt(request.getParameter("stock"));
				int idCategoria = Integer.parseInt(request.getParameter("idcat"));
				double precio = Double.parseDouble(request.getParameter("precio"));
				int estado = Integer.parseInt(request.getParameter("estado"));
				String id = request.getParameter("txtid");
				
				//error		ProductoDTO p = new ProductoDTO(descripcion, stock, idCategoria, precio, estado, id);
				//error	System.out.println(p);
			    
			//procesos
				MySQLProductoDAO gu = new MySQLProductoDAO();
				//error	int ok = gu.actualizar(p);
				
				//error	if (ok == 0) {
					mensaje = "Error al registrar los datos,revisar";
					url = "/mantenimientoproductos.jsp";
					//error	}else {
					mensaje = "<script>alert('Registro OK, listo para registrar');</script>";
					url = "/listado.jsp";
				}
				
				// salidas
		//error	request.setAttribute("mensaje", mensaje);
		//error		request.getRequestDispatcher(url).forward(request, response);
			
		//error}			
		}

//error	}