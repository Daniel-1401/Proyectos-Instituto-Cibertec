package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionBD {
	public static Connection getConexion() {
		Connection conexion = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/ciberimpacto?useSSL=false&useTimezone=true&serverTimezone=UTC";
			String usr = "root";
			String psw = "toor";
			conexion = DriverManager.getConnection(url, usr, psw);
		} catch (ClassNotFoundException e) {
				System.out.println("Driver no instalado -> " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error de conexion con la BD -> " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error general -> " + e.getMessage());
		}
		return conexion;
	}
	public static void closeConexion(Connection conexion) {
		
	}
}
