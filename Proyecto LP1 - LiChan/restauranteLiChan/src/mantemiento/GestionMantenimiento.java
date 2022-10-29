package mantemiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.MantenimientoInterface;
import modelos.RegistroCliente;
import modelos.RegistroProducto;
import modelos.TipoDocumento;
import utils.ConectorBD;

public class GestionMantenimiento implements MantenimientoInterface{

	/**** Mantenimiento Cliente  *****/
	
	public ArrayList<TipoDocumento> listadoDeDocumento() {
		
		ArrayList<TipoDocumento> lista = null;
		
		Connection con = null; 
		PreparedStatement pst = null; 
		ResultSet rs = null;
		
		try {
			con = ConectorBD.getConexion();
			String sql = "select * from tb_tipo_documento";
			
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			
			lista = new ArrayList<>();
			
			while (rs.next()) {
				TipoDocumento td = new TipoDocumento();
				td.setIdTipoDocumento(rs.getInt(1));
				td.setDescripcion(rs.getString(2));

				lista.add(td);				
			}
			
		} catch (Exception e) {
			System.out.println("Error en COMBO por Tipo de Documento: " + e.getMessage());
		} finally {
			try {
				if(con != null) {
					con.close();
				}
			}catch (SQLException e) {
				System.out.println("Error Cerrar la conexión: " + e.getMessage());
			}
		}		
	
		return lista;
	}

	
	public String generarCodigoCliRegistro(){
		String codigo = null;
		
		Connection con = null;  
		PreparedStatement pst = null;  
		ResultSet rs = null;
		
		try {

			con = ConectorBD.getConexion();
			String sql = "select substring(max(idCliente),2) from tb_clientes";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();  

			if (rs.next()) {
				
				codigo = String.format("C%04d", rs.getInt(1)+1);
			}
			
		} catch (Exception e) {
			System.out.println("Error en generarNumeroRegistro : " + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {

				System.out.println("Error al cerrar conexión : " + e.getMessage());
			}
		}
				
		return codigo;
	}

	
	public int registro(RegistroCliente r) {
		int rs = 0;
		
		Connection con = null;  
		PreparedStatement pst1 = null;
		
		try {
			con = ConectorBD.getConexion();
			con.setAutoCommit(false);
			
			String sql1 = "INSERT INTO tb_clientes VALUES (?,?,?,?,?,?,?)";
			pst1 = con.prepareStatement(sql1);
			
			pst1.setString(1, r.getIdCliente());
			pst1.setString(2, r.getNombreCliente());
			pst1.setString(3, r.getApellidoCliente());
			pst1.setString(4, r.getDireccionCliente());
			pst1.setInt(5, r.getNumeroTelefonico());
			pst1.setInt(6, r.getIdtipoDocumento());
			pst1.setString(7, r.getNumeroDocumento());


			rs = pst1.executeUpdate(); 
			
			con.commit();
			
		} catch (Exception e) {
			System.out.println("Error en registro de  CLIENTE: " + e.getMessage());
			rs = 0;
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("Error en registro de  CLIENTE" +e1.getMessage());
			}
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {

				System.out.println("Error al cerrar conexión : " + e.getMessage());
			}
		}			
		
		return rs;
	}

	
	public int eliminar(String idCliente) {
		int rs = 0;
		
		Connection con = null; 
		PreparedStatement pst = null; 
		
		try {
			con = ConectorBD.getConexion();
			String sql = "delete from tb_clientes where idCliente = ?";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, idCliente);
			
			rs = pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error al Eliminar: " + e.getMessage());
		} finally {
			try {
				if(con != null) 
					con.close();
			}catch (SQLException e) {
				System.out.println("Error Cerrar la conexión: " + e.getMessage());
			}
		}
		
		return rs;
	}


	
	public RegistroCliente buscar(String idCliente) {
		RegistroCliente r = null;
		
		Connection con = null; 
		PreparedStatement pst = null; 
		ResultSet rs = null; 
		
		try {
			con = ConectorBD.getConexion();
			String sql = "select * from tb_clientes where idCliente = ?";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, idCliente);
			
			rs = pst.executeQuery();
			
			
			if (rs.next()) {
				
				
				r = new RegistroCliente();
	
				r.setIdCliente(rs.getString(1));
				r.setNombreCliente(rs.getString(2));
				r.setApellidoCliente(rs.getString(3));
				r.setDireccionCliente(rs.getString(4));
				r.setNumeroTelefonico(rs.getInt(5));	
				r.setIdtipoDocumento(rs.getInt(6));
				r.setNumeroDocumento(rs.getString(7));	
				
			}
			
		} catch (Exception e) {
			System.out.println("Error al Buscar Cliente: " + e.getMessage());
		} finally {
			try {
				if(con != null) {
					con.close();
				}
			}catch (SQLException e) {
				System.out.println("Error Cerrar la conexión: " + e.getMessage());
			}
		}
		return r;
	}


	//-- FALTA
	public int actulizar(RegistroCliente r) {
		int rs = 0;
		
		Connection con = null; 
		PreparedStatement pst = null;
		
		try {
			con = ConectorBD.getConexion();
			String sql = "{call usp_actulizaUsu(?,?,?,?,?,?,?)}";
			
			pst = con.prepareStatement(sql);
			
			pst.setString(1, r.getNombreCliente());
			pst.setString(2, r.getApellidoCliente());
			pst.setString(3, r.getDireccionCliente());
			pst.setInt(4, r.getNumeroTelefonico());
			pst.setInt(5, r.getIdtipoDocumento());
			pst.setString(6, r.getNumeroDocumento());
			
			rs = pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error al Actualizar: " + e.getMessage());
		} finally {
			try {
				if(con != null) 
					con.close();
			}catch (SQLException e) {
				System.out.println("Error Cerrar la conexión: " + e.getMessage());
			}
		}
		
		return rs;
	}

	
	/**** Mantenimiento Producto  *****/
	
	@Override
	public String generarCodigoProducto() {
		String codigo = null;
		
		Connection con = null;  
		PreparedStatement pst = null;  
		ResultSet rs = null;
		
		try {

			con = ConectorBD.getConexion();
			String sql = "select substring(max(idProducto),2) from tb_producto";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();  

			if (rs.next()) {
				
				codigo = String.format("P%04d", rs.getInt(1)+1);
			}
			
		} catch (Exception e) {
			System.out.println("Error en generarCodigoProducto : " + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {

				System.out.println("Error al cerrar conexión : " + e.getMessage());
			}
		}
		
		
		
		return codigo;
	}


	
	public int registro(RegistroProducto r) {
		int rs = 0;
		
		Connection con = null;  
		PreparedStatement pst1 = null;
		
		try {
			con = ConectorBD.getConexion();
			con.setAutoCommit(false);
			
			String sql1 = "INSERT INTO tb_producto VALUES (?,?,?)";
			pst1 = con.prepareStatement(sql1);
			
			pst1.setString(1, r.getIdProducto());
			pst1.setString(2, r.getNombreProducto());
			pst1.setDouble(3, r.getPrecioProducto());

			rs = pst1.executeUpdate(); 
			
			con.commit();
			
		} catch (Exception e) {
			System.out.println("Error en registro de Producto: " + e.getMessage());
			rs = 0;
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("ERROR EN EL REGISTRO DE Producto" +e1.getMessage());
			}
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {

				System.out.println("Error al cerrar conexión : " + e.getMessage());
			}
		}	

		return rs;
	}


	@Override
	public int eliminarProducto(String idProducto) {
		int rs = 0;
		
		Connection con = null; 
		PreparedStatement pst = null; 
		
		try {
			con = ConectorBD.getConexion();
			String sql = "delete from tb_producto where idProducto = ?";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, idProducto);
			
			rs = pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error al eliminarProducto: " + e.getMessage());
		} finally {
			try {
				if(con != null) 
					con.close();
			}catch (SQLException e) {
				System.out.println("Error Cerrar la conexión: " + e.getMessage());
			}
		}
		
		return rs;
	}



	
	public RegistroProducto buscarProducto(String idProducto) {
		
		RegistroProducto rp = null;
		
		Connection con = null; 
		PreparedStatement pst = null; 
		ResultSet rs = null; 
		
		try {
			con = ConectorBD.getConexion();
			String sql = "select * from tb_Producto where idProducto = ?";
			
			pst = con.prepareStatement(sql);
			pst.setString(1,idProducto);
			
			rs = pst.executeQuery();
			
			
			if (rs.next()) {
				
				
				rp = new RegistroProducto();
	
				rp.setIdProducto(rs.getString(1));
				rp.setNombreProducto(rs.getString(2));
				rp.setPrecioProducto(rs.getDouble(3));

			}
			
		} catch (Exception e) {
			System.out.println("Error al Buscar Producto: " + e.getMessage());
		} finally {
			try {
				if(con != null) {
					con.close();
				}
			}catch (SQLException e) {
				System.out.println("Error Cerrar la conexión: " + e.getMessage());
			}
		}
		
		return rp;	
	}


	@Override
	public int actulizarProducto(RegistroCliente r) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	
	
	
	
	
	

}
