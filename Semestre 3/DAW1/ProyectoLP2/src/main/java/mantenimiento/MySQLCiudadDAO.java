package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.ciudadDTO;
import interfaces.ciudadDAO;
import util.conexionBD;

public class MySQLCiudadDAO implements ciudadDAO{

	@Override
	public ArrayList<ciudadDTO> listarCiudad() {
		ArrayList<ciudadDTO> listarCiudad = new ArrayList<ciudadDTO>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		try {
			con = conexionBD.getConexion();
			String sql = "Select * from tb_ciudad";
			pst = con.prepareStatement(sql);
			rst=pst.executeQuery();
			while(rst.next()) {
				ciudadDTO cd = new ciudadDTO(rst.getString(1),
												rst.getString(2));
				listarCiudad.add(cd);
			}
		} catch (Exception e) {
			System.out.println("Error al listar ciudad:" + e.getMessage());
		}finally {
			conexionBD.closeConexion(con);
		}
		return listarCiudad;
	}
}
