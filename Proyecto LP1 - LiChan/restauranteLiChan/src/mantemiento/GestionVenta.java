package mantemiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.VentasInterface;
import modelos.Boleta;
import modelos.BoletaDetalle;
import modelos.ProductosSeleccionados_Temporal;
import utils.ConectorBD;

public class GestionVenta implements VentasInterface {

/******* BOLETA ****/
	
	public String generaNumeroBoleta() {
		String numBol = null; 

		Connection con = null;  
		PreparedStatement pst = null;  
		ResultSet rs = null;  

		try {

			con = ConectorBD.getConexion();

			String sql = "select substring(max(idBoleta),2) from tb_boleta";

			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();  

			if (rs.next()) {
				numBol = String.format("B%04d", rs.getInt(1)+1); 
			}
			
		} catch (Exception e) {
			System.out.println("Error en generaNumBoleta : " + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {

				System.out.println("Error al cerrar conexión : " + e.getMessage());
			}
		}

		return numBol;
	}

	@Override
	public ArrayList<ProductosSeleccionados_Temporal> lstProductosSeleccionados() {
		ArrayList<ProductosSeleccionados_Temporal> lista = new ArrayList<ProductosSeleccionados_Temporal>();
		Connection conexion = null;
		PreparedStatement ejecutor = null;
		ResultSet rs = null;
		try {
			conexion = ConectorBD.getConexion();
			String sentencia = " SELECT * FROM `tb_ClienteProducto_Temporal`";
			ejecutor = conexion.prepareStatement(sentencia);
			rs = ejecutor.executeQuery();
			while(rs.next()) {
				ProductosSeleccionados_Temporal nuevo = new ProductosSeleccionados_Temporal();
				nuevo.setNumItem(rs.getInt(2));
				nuevo.setIdBoleta(rs.getString(3));
				nuevo.setIdCliente(rs.getString(4));
				nuevo.setIdProducto(rs.getString(5));
				nuevo.setCantidadProducto(rs.getInt(6));
				nuevo.setTotalProductoSeleccionado(rs.getDouble(7));
				nuevo.setNombreProducto(rs.getString(8));
				nuevo.setPrecioUnitProducto(rs.getDouble(9));
				lista.add(nuevo);
			}
		}catch (Exception e) {
			System.out.println("ERROR AL LISTAR PRODUCTOS TEMPORALES");
		}finally {
			try {
				if(conexion != null) {
					conexion.close();
				}
			}catch (SQLException se) {
				System.out.println("ERROR AL CERRAR CONEXION: " + se.getMessage());
			}
		}
		return lista;
	}
	
	@Override
	public int insertarProductosSeleccionadosTemporal(ProductosSeleccionados_Temporal p, int numItem) {
		int ok = 0;
		Connection conexion = null;
		PreparedStatement ejecutor = null;
		try {
			conexion = ConectorBD.getConexion();
			String sentencia = "CALL ins_productoClienteTemporal(?,?,?,?,?,?,?,?)";
			ejecutor = conexion.prepareStatement(sentencia);
			ejecutor.setInt(1, numItem);
			ejecutor.setString(2, p.getIdBoleta());
			ejecutor.setString(3, p.getIdCliente());
			ejecutor.setString(4, p.getIdProducto());
			ejecutor.setInt(5, p.getCantidadProducto());
			ejecutor.setDouble(6, p.getTotalProductoSeleccionado());
			ejecutor.setString(7, p.getNombreProducto());
			ejecutor.setDouble(8, p.getPrecioUnitProducto());
			
			ok = ejecutor.executeUpdate();
		}catch (Exception e) {
			System.out.println("ERROR AL REGISTRAR ADMINISTRADOR: " + e.getMessage());
		}finally {
			try {
				if(conexion != null) {
					conexion.close();
				}
			}catch (SQLException se) {
				System.out.println("ERROR AL CERRAR LA CONEXION : " + se.getMessage());
			}
		}
		return ok;
	}

	@Override
	public int eliminarProductoSeleccionado(String idCliente, int numeroItem) {
		int ok = 0;
		Connection conexion = null;
		PreparedStatement ejecutor = null;
		try {
			conexion = ConectorBD.getConexion();
			String sentencia = "CALL del_productoClienteTemporal(?,?);";
			ejecutor = conexion.prepareStatement(sentencia);
			ejecutor.setString(1, idCliente);
			ejecutor.setInt(2, numeroItem);
			ok = ejecutor.executeUpdate();
		}catch (Exception e) {
			System.out.println("ERROR AL ELIMINAR PRODUCTO SELECCIONADO DEL CLIENTE: " + e.getMessage());
		}finally {
			try {
				if(conexion != null) {
					conexion.close();
				}
			}catch (SQLException se) {
				System.out.println("ERROR AL CERRAR LA CONEXION: " + se.getMessage());
			}
		}
		return ok;
	}

	@Override
	public double sumaTotalProductosSeleccionados(String idCliente) {

		double suma = 0.0;
		Connection conexion = null;
		PreparedStatement ejecutor = null;
		ResultSet rs = null;
		try {
			conexion = ConectorBD.getConexion();
			String sentencia = "CALL sum_TotalproductoClienteTemporal(?);";
			ejecutor = conexion.prepareStatement(sentencia);
			ejecutor.setString(1, idCliente);
			rs = ejecutor.executeQuery();
			if(rs.next()) {
				suma = rs.getDouble(1);
			}
		}catch (Exception e) {
			System.out.println("ERROR AL ELIMINAR PRODUCTO SELECCIONADO DEL CLIENTE: " + e.getMessage());
		}finally {
			try {
				if(conexion != null) {
					conexion.close();
				}
			}catch (SQLException se) {
				System.out.println("ERROR AL CERRAR LA CONEXION: " + se.getMessage());
			}
		}
			return suma;
		
	}

	@Override
	public String obtenerRecepcionista(int idUsuario) {
		String idEmpleado = "";
		Connection conexion = null;
		PreparedStatement ejecutor = null;
		ResultSet rs = null;
		try {
			conexion = ConectorBD.getConexion();
			String sentencia = "CALL get_IdRecepcionista (?);";
			ejecutor = conexion.prepareStatement(sentencia);
			ejecutor.setInt(1, idUsuario);
			rs = ejecutor.executeQuery();
			if(rs.next()) {
				idEmpleado = rs.getString(1);
			}
		}catch (Exception e) {
			System.out.println("ERROR AL BUSCAR ID_EMPLEADO: " + e.getMessage());
		}finally {
			try {
				if(conexion != null) {
					conexion.close();
				}
			}catch (SQLException se) {
				System.out.println("ERROR AL CERRAR LA CONEXION: " + se.getMessage());
			}
		}
	return idEmpleado;
	}

	@Override
	public int registrarBoleta(Boleta b) {
		int ok = 0;
		Connection conexion = null;
		PreparedStatement ejecutor = null;
		try {
			conexion = ConectorBD.getConexion();
			String sentencia = "CALL ins_Boleta(?,?,?,?)";
			ejecutor = conexion.prepareStatement(sentencia);
			ejecutor.setString(1, b.getIdBoleta());
			ejecutor.setString(2, b.getFecha());
			ejecutor.setString(3, b.getIdCliente());
			ejecutor.setString(4, b.getIdRecepcionista());
			ok = ejecutor.executeUpdate();
		}catch (Exception e) {
			System.out.println("ERROR AL REGISTRAR BOLETA: " + e.getMessage());
		}finally {
			try {
				if(conexion != null) {
					conexion.close();
				}
			}catch (SQLException se) {
				System.out.println("ERROR AL CERRAR LA CONEXION : " + se.getMessage());
			}
		}
		return ok;
	}

	@Override
	public int registrarBoletaDetalle(BoletaDetalle bd) {
		int ok = 0;
		Connection conexion = null;
		PreparedStatement ejecutor = null;
		try {
			conexion = ConectorBD.getConexion();
			String sentencia = "CALL ins_DetalleBoleta(?,?,?,?);";
			ejecutor = conexion.prepareStatement(sentencia);
			ejecutor.setString(1, bd.getIdBoleta());
			ejecutor.setString(2, bd.getIdProducto());
			ejecutor.setInt(3, bd.getCantidadProducto());
			ejecutor.setDouble(4, bd.getPrecioTotalProducto());			
			ok = ejecutor.executeUpdate();
		}catch (Exception e) {
			System.out.println("ERROR AL REGISTRAR BOLETA DETALLE: " + e.getMessage());
		}finally {
			try {
				if(conexion != null) {
					conexion.close();
				}
			}catch (SQLException se) {
				System.out.println("ERROR AL CERRAR LA CONEXION : " + se.getMessage());
			}
		}
		return ok;
	}
}
