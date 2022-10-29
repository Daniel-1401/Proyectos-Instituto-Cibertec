package mantemiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ConsultaInterface;
import modelos.RegistroCliente;
import modelos.RegistroProducto;
import utils.ConectorBD;

public class GestionConsultas implements ConsultaInterface{

	/************** CONSULTAS CLIENTES ****************/
	
	public ArrayList<RegistroCliente> listadoCliente() {
		
		ArrayList<RegistroCliente> lista = null;
		
		Connection con = null; 
		PreparedStatement pst = null; 
		ResultSet rs = null; 
		
		try {
			con = ConectorBD.getConexion();
			String sql = "{call usp_consultaCliente()}";
			
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();
			
			
			lista = new ArrayList<>();
			
			while (rs.next()) {
				
				RegistroCliente rc = new RegistroCliente();
				rc.setIdCliente(rs.getString(1));
				rc.setNombreCliente(rs.getString(2));
				rc.setApellidoCliente(rs.getString(3));
				rc.setDireccionCliente(rs.getString(4));
				rc.setNumeroTelefonico(rs.getInt(5));
				rc.setNumeroDocumento(rs.getString(6));
				
				
				lista.add(rc);				
			}
			
		} catch (Exception e) {
			System.out.println("Error en la CONSULTA: " + e.getMessage());
		} finally {
			try {
				if(con != null) 
					con.close();
				
			}catch (SQLException e) {
				System.out.println("Error Cerrar la conexión: " + e.getMessage());
			}
		}
		
		return lista;
	}

	/************** CONSULTAS PRODUCTO ****************/
	public ArrayList<RegistroProducto> listadoProducto() {
		
		ArrayList<RegistroProducto> lista = null;
		
		Connection con = null; 
		PreparedStatement pst = null; 
		ResultSet rs = null; 
		
		try {
			con = ConectorBD.getConexion();
			String sql = "select * from tb_producto";
			
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();
			
			
			lista = new ArrayList<>();
			
			while (rs.next()) {
				
				RegistroProducto p = new RegistroProducto();
				p.setIdProducto(rs.getString(1));
				p.setNombreProducto(rs.getString(2));
				p.setPrecioProducto(rs.getDouble(3));
				
				lista.add(p);				
			}
			
		} catch (Exception e) {
			System.out.println("Error en la consulta Producto: " + e.getMessage());
		} finally {
			try {
				if(con != null) 
					con.close();
				
			}catch (SQLException e) {
				System.out.println("Error Cerrar la conexión: " + e.getMessage());
			}
		}
		return lista;
	}

}
