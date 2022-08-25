package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.marcaDTO;
import beans.paisDTO;
import interfaces.paisDAO;
import util.conexionBD;

public class MySQLPaisDAO implements paisDAO{

	@Override
	public ArrayList<paisDTO> listarPais() {
		ArrayList<paisDTO> lstpais = new ArrayList<paisDTO>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		try {
			con = conexionBD.getConexion();
			String sql = "Select * from tb_pais";
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			
			while (rst.next()) {
				paisDTO marca = new paisDTO(rst.getInt(1),
											rst.getString(2));
				lstpais.add(marca);
			}
			
		} catch (Exception e) {
			System.out.println("Error al listar pais:" + e.getMessage());
		}finally {
			conexionBD.closeConexion(con);
		}
		return lstpais;
	}
}
