package mantemiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import interfaces.EmpleadoInterface;
import modelos.EmpleadoAdmin;
import modelos.EmpleadoRecep;
import modelos.TipoCargo;
import modelos.TipoDocumento;
import utils.ConectorBD;

public class GestionEmpleado implements EmpleadoInterface{

	@Override
	public int registrarEmpleadoAdmin(EmpleadoAdmin ea) {
		int ok = 0;
		Connection conexion = null;
		PreparedStatement ejecutor = null;
		try {
			conexion = ConectorBD.getConexion();
			String sentencia = "CALL ins_empleadoUsuario (?,?,?,?,?,?,?,?,?,?,?,?,?);";
			ejecutor = conexion.prepareStatement(sentencia);
			ejecutor.setString(1, ea.getIdEmpleado());
			ejecutor.setString(2, ea.getNombreEmpleado());
			ejecutor.setString(3, ea.getApellidoEmpleado());
			ejecutor.setInt(4, ea.getIdTipoDocumento());
			ejecutor.setString(5, ea.getNumeroDocumento());
			ejecutor.setString(6, ea.getFechaNacimiento());
			ejecutor.setInt(7, ea.getIdCargo());
			ejecutor.setString(8, ea.getGenero());
			ejecutor.setString(9, ea.getEstado());
			ejecutor.setInt(10, ea.getIdUsuario());
			ejecutor.setString(11, ea.getUser());
			ejecutor.setString(12, ea.getPass());
			ejecutor.setDouble(13, ea.getSueldo());
			
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
	public int actualizarEmpledoAdmin(EmpleadoAdmin e) {
		int ok = 0;
		Connection conexion = null;
		PreparedStatement ejecutor = null;
		try {
			conexion = ConectorBD.getConexion();
			String sentencia = "CALL upd_Empleado(?,?,?,?,?,?)";
			ejecutor = conexion.prepareStatement(sentencia);
			ejecutor.setString(1, e.getIdEmpleado());
			ejecutor.setString(2, e.getNombreEmpleado());
			ejecutor.setString(3, e.getApellidoEmpleado());
			ejecutor.setString(4, e.getEstado());
			ejecutor.setString(5, e.getPass());
			ejecutor.setDouble(6, e.getSueldo());
			ok = ejecutor.executeUpdate();
		}catch (Exception ex) {
			System.out.println("ERROR AL ACTUALIZAR ADMINISTRADOR: " + ex.getMessage());
		}finally {
			try {
				if(conexion != null) {
					conexion.close();
				}
			}catch (SQLException se) {
				System.out.println("ERROR AL CERRAR CONEXION: " + se.getMessage());
			}
		}
		return ok;
	}
	
	@Override
	public int registrarEmpleadoRecep(EmpleadoRecep er) {
		int ok = 0;
		Connection conexion = null;
		PreparedStatement ejecutor = null;
		try {
			conexion = ConectorBD.getConexion();
			String sentencia = "CALL ins_empleadoRecep (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ejecutor = conexion.prepareStatement(sentencia);
			ejecutor.setString(1, er.getIdEmpleado());
			ejecutor.setString(2, er.getNombreEmpleado());
			ejecutor.setString(3, er.getApellidoEmpleado());
			ejecutor.setInt(4, er.getIdTipoDocumento());
			ejecutor.setString(5, er.getNumeroDocumento());
			ejecutor.setString(6, er.getFechaNacimiento());
			ejecutor.setInt(7, er.getIdCargo());
			ejecutor.setString(8, er.getGenero());
			ejecutor.setString(9, er.getEstado());
			ejecutor.setInt(10, er.getIdUsuario());
			ejecutor.setString(11, er.getUser());
			ejecutor.setString(13, er.getPass());
			ejecutor.setInt(14, er.getNumHorasPorDia());
			ejecutor.setInt(15, er.getDiasLaborales());
			ejecutor.setDouble(16, er.getPagoPorHora());
			ok = ejecutor.executeUpdate();
		}catch (Exception e) {
			System.out.println("ERROR AL REGISTRAR RECEPCIONISTA: " + e.getMessage());
		}finally {
			try {
				if(conexion != null) {
					conexion.close();
				}
			}catch (SQLException sq) {
				System.out.println("ERROR AL CERRAR CONEXION: " + sq.getMessage());
			}
		}
		return ok;
	}
	@Override
	public int actualizarEmpleadoRecep(EmpleadoRecep er) {
		int ok = 0;
		Connection conexion = null;
		PreparedStatement ejecutor = null;
		try {
			conexion = ConectorBD.getConexion();
			String sentencia = "CALL upd_EmpleadoRECEP(?,?,?,?,?,?,?,?)";
			ejecutor = conexion.prepareStatement(sentencia);
			ejecutor.setString(1, er.getIdEmpleado());
			ejecutor.setString(2, er.getNombreEmpleado());
			ejecutor.setString(3, er.getApellidoEmpleado());
			ejecutor.setString(4, er.getEstado());
			ejecutor.setString(6, er.getPass());
			ejecutor.setInt(6, er.getNumHorasPorDia());
			ejecutor.setInt(6, er.getDiasLaborales());
			ejecutor.setDouble(6, er.getPagoPorHora());
			ok = ejecutor.executeUpdate();
		}catch (Exception e) {
			System.out.println("ERROR AL ACTUALIZAR RECEPCIONISTA: " + e.getMessage());
		}finally {
			try {
				if(conexion != null) {
					conexion.close();
				}
			}catch (SQLException se) {
				System.out.println("ERROR AL CERRAR CONEXION: " + se.getMessage());
			}
		}
		return ok;
	}

	@Override
	public EmpleadoRecep obtener(String id) {
		EmpleadoRecep empleado = new EmpleadoRecep();
		Connection conexion = null;
		PreparedStatement ejecutor = null;
		ResultSet rs = null;
		try {
			conexion = ConectorBD.getConexion();
			String sentencia = "SELECT * FROM `tb_empleado` WHERE `tb_empleado`.`idEmplEado` = ?";
			ejecutor = conexion.prepareStatement(sentencia);
			ejecutor.setString(1, id);
			rs = ejecutor.executeQuery();
			if(rs.next()) {
				empleado.setIdEmpleado(rs.getString(1));
				empleado.setNombreEmpleado(rs.getString(2));
				empleado.setApellidoEmpleado(rs.getString(3));
				empleado.setIdTipoDocumento(rs.getInt(4));
				empleado.setNumeroDocumento(rs.getString(5));
				empleado.setFechaNacimiento(rs.getString(6));
				empleado.setIdCargo(rs.getInt(7));
				empleado.setGenero(rs.getString(8));
				empleado.setEstado(rs.getString(9));
				empleado.setIdUsuario(rs.getInt(10));
			}
		}catch (Exception e) {
			System.out.println("ERROR AL BUSCAR EMPLEADO: " + e.getMessage());
		}finally {
			try {
				if(conexion != null) {
					conexion.close();
				}
			}catch (SQLException ex) {
				System.out.println("ERRO AL CERRAR CONEXION: " + ex.getMessage());
			}
		}
		return empleado;
	}

	//---------------------------------------------V TERMINADO V-------------------------------------------------------\\
	
	@Override
	public int eliminarEmpleado(String id) {
		int ok = 0;
		Connection conexion = null;
		PreparedStatement ejecutor = null;
		try {
			conexion = ConectorBD.getConexion();
			String sentencia = "CALL del_Empleado (?)";
			ejecutor = conexion.prepareStatement(sentencia);
			ejecutor.setString(1, id);
			ok = ejecutor.executeUpdate();
		}catch (Exception e) {
			System.out.println("ERROR AL ELIMINAR: " + e.getMessage());
		}finally {
			try {
				if(conexion != null) {
					conexion.close();
				}
			}catch (SQLException se) {
				System.out.println("ERROR AL CERRA LA CONEXION: " + se.getMessage());
			}
		}
		return ok;
	}

	@Override
	public ArrayList<TipoDocumento> listadoTipoDocumento() {
		ArrayList<TipoDocumento> lista = null;
		Connection conexion = null; 
		PreparedStatement ejecutor = null; 
		ResultSet rs = null;
		try {
			conexion = ConectorBD.getConexion();
			String sql = "select * from tb_tipo_documento";
			ejecutor = conexion.prepareStatement(sql);
			rs = ejecutor.executeQuery();
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
				if(conexion != null) {
					conexion.close();
				}
			}catch (SQLException e) {
				System.out.println("Error Cerrar la conexión: " + e.getMessage());
			}
		}		
		return lista;
	}

	@Override
	public ArrayList<TipoCargo> listadoTipoCargo() {
		ArrayList<TipoCargo> lstCargo = new ArrayList<TipoCargo>();
		Connection conexion = null;
		PreparedStatement ejecutor = null;
		ResultSet rs = null;
		try {
			conexion = ConectorBD.getConexion();
			String sentencia = "SELECT * FROM `tb_cargo`";
			ejecutor = conexion.prepareStatement(sentencia);
			rs = ejecutor.executeQuery();
			while(rs.next()) {
				TipoCargo tipoCargo = new TipoCargo();
				tipoCargo.setIdCargo(rs.getInt(1));
				tipoCargo.setDescripcion(rs.getString(2));
				lstCargo.add(tipoCargo);
			}
		}catch (Exception e) {
			System.out.println("ERROR AL LISTAR TIPOS DE CARGO: " +e.getMessage());
		}finally {
			try {
				if(conexion != null) {
					conexion.close();
				}
			}catch (SQLException se) {
				System.out.println("ERROR AL CERRAR LA CONEXION: " + se.getMessage());
			}
		}
		return lstCargo;
	}

	@Override
	public String generarCodigo(int cargo) {
		String codigo = null;
		Connection conexion = null;
		PreparedStatement ejecutor = null;
		ResultSet rs = null;
		try {
			conexion = ConectorBD.getConexion();
			String sentencia = "SELECT SUBSTRING(MAX(`tb_empleado`.`idEmpleado`),2) FROM `tb_empleado` WHERE `tb_empleado`.`idCargo` = ? ";
			ejecutor = conexion.prepareStatement(sentencia);
			ejecutor.setInt(1, cargo);
			rs = ejecutor.executeQuery();
			if(rs.next()) {
				switch(cargo) {
				case 1:
					codigo = String.format("A%04d", rs.getInt(1)+1); break;
				case 2:
					codigo = String.format("R%04d", rs.getInt(1)+1); break;
				default:
					codigo = ("ERROR");break;
				}
			}
		}catch (Exception e) {
			System.out.print("ERROR AL GENERAR CODIGO: " + e.getMessage());
		}finally {
			try {
				if(conexion != null) {
					conexion.close();
				}
			}catch (SQLException ex) {
				System.out.println("ERROR AL CERRAR CONEXION: " + ex.getMessage());
			}
		}
		return codigo;
	}

	
}
