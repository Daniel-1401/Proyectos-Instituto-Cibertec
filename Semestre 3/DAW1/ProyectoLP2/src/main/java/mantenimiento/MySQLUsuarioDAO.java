package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.usuarioDTO;
import interfaces.usuarioDAO;
import util.conexionBD;

public class MySQLUsuarioDAO implements usuarioDAO {

	
	
	// REGISTRAR USUARIO
	@Override
	public int registrar(usuarioDTO u) {
int rs = 0;
		
		//PLANTILLA
		Connection con= null;
		PreparedStatement pst= null;
		
		try {
			//CONEXION
			con=conexionBD.getConexion();
			String sql= "insert into tb_usuarios values(?,?,?,?,?,?)";
			
			pst=con.prepareStatement(sql);
			
			pst.setString(1, u.getCodUsu());
			pst.setInt(2, u.getCodTipoUsu());
			pst.setString(3, u.getEmail());
			pst.setString(4, u.getContrasenia());
			pst.setString(5, u.getNomUsu());
			pst.setString(6, u.getApeUsu());
			
			rs=pst.executeUpdate();	
			
		} catch (Exception e) {
			//mensaje  de error
			System.out.println("Error al Registrar Usuario"+e.getMessage());
		}finally {
			conexionBD.closeConexion(con);
		}
		return rs;
	}

	@Override
	public usuarioDTO validar(String usuario, String clave) {
		usuarioDTO u = null;
		
		Connection con= null;
		PreparedStatement pst= null;
		ResultSet rs= null;
		
		try {
			con= conexionBD.getConexion();
			String sql = "{call usp_validaAcceso(?,?)}";
			
			pst =con.prepareCall(sql);
			pst.setString(1, usuario);
			pst.setString(2, clave);
			
			rs=pst.executeQuery();
			
			if(rs.next()) {
				u= new usuarioDTO(
						rs.getString(1),
						rs.getInt(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6)
						);
				
			} 
			}catch(Exception e) {
				System.out.print("Ocurrio un error al ingresar."+ e.getMessage());
				
			} finally {
				conexionBD.closeConexion(con);
			}
		
		
		
		return u;
		}
	}


