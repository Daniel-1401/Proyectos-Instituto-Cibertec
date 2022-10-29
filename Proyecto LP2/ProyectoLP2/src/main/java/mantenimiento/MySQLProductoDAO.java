package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.categoriaDTO;
import beans.productosDTO;
import interfaces.productoDAO;
import util.conexionBD;

public class MySQLProductoDAO implements productoDAO {

	@Override
	public int registrar(productosDTO prod) {
		int resultado = 0;
		Connection conexion = null;
		PreparedStatement ps = null;
		try {
			conexion = conexionBD.getConexion();
			String sentencia = "call sp_insertarProducto(?,?,?,?,?,?,?,?,?,?);";
			ps = conexion.prepareStatement(sentencia);
			ps.setString(1, prod.getCodigoProducto());
			ps.setString(2, prod.getModeloProducto());
			ps.setString(3, prod.getCategoria());
			ps.setString(4, prod.getMarca());
			ps.setString(5, prod.getDescripcionPantalla());
			ps.setString(6, prod.getCpu());
			ps.setString(7, prod.getGpu());
			ps.setString(8, prod.getDiscoDuro());
			ps.setString(9, prod.getSistemaOperativo());
			ps.setDouble(10, prod.getPrecioVenta());
			resultado = ps.executeUpdate();
		}catch (Exception e) {
			System.out.println("Error al registrar producto -> " + e.getMessage());
		}finally {
			conexionBD.closeConexion(conexion);
		}
		return resultado;
	}

	@Override
	public int actualizar(productosDTO prod) {
		int resultado = 0;
		Connection conexion = null;
		PreparedStatement ps = null;
		try {
			conexion = conexionBD.getConexion();
			String sentencia = "call sp_ActualizarProducto(?,?,?,?);";
			ps = conexion.prepareStatement(sentencia);
			ps.setString(1, prod.getCodigoProducto());
			ps.setString(2, prod.getDiscoDuro());
			ps.setString(3, prod.getSistemaOperativo());
			ps.setDouble(4, prod.getPrecioVenta());
			resultado = ps.executeUpdate();
		}catch (Exception e) {
			System.out.println("Error al actualizar producto -> " + e.getMessage());
		}finally {
			conexionBD.closeConexion(conexion);
		}
		return resultado;
	}

	@Override
	public int eliminar(String codigo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<productosDTO> listarProd() {
		ArrayList<productosDTO> listarProduc = new ArrayList<productosDTO>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rslt = null;
		try {
			con = conexionBD.getConexion();
			String sql = "Select * from tb_producto";
			pst = con.prepareStatement(sql);
			rslt = pst.executeQuery();			
			while (rslt.next()) {
				productosDTO prod = new productosDTO(rslt.getString(1),
													rslt.getString(2),
													rslt.getString(3),
													rslt.getString(4),
													rslt.getString(5),
													rslt.getString(6),
													rslt.getString(7),
													rslt.getString(8),
													rslt.getString(9),
													rslt.getDouble(10));
				listarProduc.add(prod);
			}
		} catch (Exception e) {
			System.out.println("Error al listar productos:" + e.getMessage());
		}finally {
			conexionBD.closeConexion(con);
		}
	return listarProduc;
}
}
