package mantemiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import interfaces.AccesoInterface;
import modelos.Acceso;
import utils.ConectorBD;

public class GestionAcceso implements AccesoInterface{

	@Override
	public Acceso loginAccess(String user, String password) {
		Acceso usuario = null;
		Connection conexion = null;
		PreparedStatement pst = null;
		ResultSet resultado = null;
		try {
			conexion = ConectorBD.getConexion();
			String sentencia = "{CALL accessUser(?,?)}";
			pst = conexion.prepareStatement(sentencia);
			pst.setString(1, user);
			pst.setString(2, password);
			resultado = pst.executeQuery();
			if(resultado.next()) {
				usuario = new Acceso();
				usuario.setIdUsuario(resultado.getInt(1));
				usuario.setLogin(resultado.getString(2));
				usuario.setPassword(resultado.getString(3));
				usuario.setCargoUsuario(resultado.getInt(4));
				usuario.setGenero(resultado.getString(5));
				usuario.setNombre(resultado.getString(6));
				usuario.setApellido(resultado.getString(7));
			}
		}catch (Exception e) {
			System.out.println("Erro en la accessUser: " + e.getMessage());
		}finally {
			try {
				if(conexion != null) {
					conexion.close();
				}
			}catch (Exception e) {
				System.out.println("Error al cerrar la conexion: " + e.getMessage());
			}
		}
		return usuario;
	}

}
