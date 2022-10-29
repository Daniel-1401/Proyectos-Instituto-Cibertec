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
import mantenimiento.MySQLAdministradorDAO;
import mantenimiento.MySQLCarritoDAO;
import mantenimiento.MySQLCategoriaDAO;
import mantenimiento.MySQLFacturaDAO;
import mantenimiento.MySQLGPUDAO;
import mantenimiento.MySQLMarcaDAO;
import mantenimiento.MySQLPaisDAO;
import mantenimiento.MySQLProductoDAO;
import mantenimiento.MySQLSistemaOperativoDAO;
import mantenimiento.MySQLTipoDDDAO;
import mantenimiento.MySQLTipoDocu;
import mantenimiento.MySQLUsuarioDAO;
import mantenimiento.MySQLCiudadDAO;
import mantenimiento.MySQLCpuDAO;
import mantenimiento.MySQLDiscoDuroDAO;

public class MySQLDAOFactory extends DAOFactory{

	@Override
	public administradorDAO getAdministradorDAO() {
		// TODO Auto-generated method stub
		return new MySQLAdministradorDAO();
	}

	@Override
	public carritoDAO getCarritoDAO() {
		// TODO Auto-generated method stub
		return new MySQLCarritoDAO();
	}

	@Override
	public categoriaDAO getCategoriaDAO() {
		// TODO Auto-generated method stub
		return new MySQLCategoriaDAO();
	}

	@Override
	public facturaDAO getFacturaDAO() {
		// TODO Auto-generated method stub
		return new MySQLFacturaDAO();
	}

	@Override
	public marcaDAO getMarcaDAO() {
		// TODO Auto-generated method stub
		return new MySQLMarcaDAO();
	}

	@Override
	public productoDAO getProductoDAO() {
		// TODO Auto-generated method stub
		return new MySQLProductoDAO();
	}

	@Override
	public usuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new MySQLUsuarioDAO();
	}

	@Override
	public ciudadDAO getCiudadDAO() {
		// TODO Auto-generated method stub
		return new MySQLCiudadDAO();
	}

	@Override
	public cpuDAO getCpuDAO() {
		// TODO Auto-generated method stub
		return new MySQLCpuDAO();
	}

	@Override
	public DiscoDuroDAO getDiscoDuroDAO() {
		// TODO Auto-generated method stub
		return new MySQLDiscoDuroDAO();
	}

	@Override
	public SistemaOperativoDAO getSODAO() {
		// TODO Auto-generated method stub
		return new MySQLSistemaOperativoDAO();
	}

	@Override
	public gpuDAO getGPU() {
		// TODO Auto-generated method stub
		return new MySQLGPUDAO();
	}

	@Override
	public paisDAO getpaisDAO() {
		// TODO Auto-generated method stub
		return new MySQLPaisDAO();
	}

	@Override
	public tipoDiscoDuroDAO getTipoDiscoDuroDAO() {
		// TODO Auto-generated method stub
		return new MySQLTipoDDDAO();
	}

	@Override
	public tipoDocumentoDAO getTipoDocu() {
		// TODO Auto-generated method stub
		return new MySQLTipoDocu();
	}
}