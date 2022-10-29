package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.tipoDiscoDuroDTO;
import interfaces.tipoDiscoDuroDAO;
import util.conexionBD;

public class MySQLTipoDDDAO implements tipoDiscoDuroDAO {

	@Override
	public ArrayList<tipoDiscoDuroDTO> listartipoDD() {
		ArrayList<tipoDiscoDuroDTO> listarTipoDD = new ArrayList<tipoDiscoDuroDTO>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		try {	
			con = conexionBD.getConexion();
			String sql = "Select*from tb_tipoDiscoDuro";
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while (rst.next()) {
				tipoDiscoDuroDTO tdd = new tipoDiscoDuroDTO(rst.getInt(1),
															rst.getString(2));
				listarTipoDD.add(tdd);
			}
		}catch (Exception e) {
				System.out.println("Error al listar tipo de DiscoDuro:" + e.getMessage());
		}finally {
				conexionBD.closeConexion(con);
			}
		return listarTipoDD;
	}
}