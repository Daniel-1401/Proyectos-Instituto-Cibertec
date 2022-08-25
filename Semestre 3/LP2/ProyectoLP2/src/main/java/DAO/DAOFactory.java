package DAO;

import interfaces.DiscoDuroDAO;
import interfaces.SistemaOperativoDAO;
import interfaces.administradorDAO;
import interfaces.carritoDAO;
import interfaces.categoriaDAO;
import interfaces.ciudadDAO;
import interfaces.cpuDAO;
import interfaces.facturaDAO;
import interfaces.gpuDAO;
import interfaces.marcaDAO;
import interfaces.paisDAO;
import interfaces.productoDAO;
import interfaces.tipoDiscoDuroDAO;
import interfaces.tipoDocumentoDAO;
import interfaces.usuarioDAO;

public abstract class DAOFactory {
	public static final int MYSQL = 1;
	
	public abstract administradorDAO	getAdministradorDAO();
	public abstract carritoDAO			getCarritoDAO();
	public abstract categoriaDAO		getCategoriaDAO();
	public abstract facturaDAO			getFacturaDAO();
	public abstract marcaDAO			getMarcaDAO();
	public abstract productoDAO			getProductoDAO();
	public abstract usuarioDAO			getUsuarioDAO();
	public abstract ciudadDAO			getCiudadDAO();
	public abstract cpuDAO				getCpuDAO();
	public abstract DiscoDuroDAO		getDiscoDuroDAO();
	public abstract SistemaOperativoDAO getSODAO();
	public abstract gpuDAO				getGPU();
	public abstract paisDAO				getpaisDAO();
	public abstract tipoDiscoDuroDAO	getTipoDiscoDuroDAO();
	public abstract tipoDocumentoDAO	getTipoDocu();
	
	public static DAOFactory getDaoFactory(int bd) {
		switch (bd) {
		case MYSQL: 
			return new MySQLDAOFactory();
		default:
			return null;
		}
	}
}
