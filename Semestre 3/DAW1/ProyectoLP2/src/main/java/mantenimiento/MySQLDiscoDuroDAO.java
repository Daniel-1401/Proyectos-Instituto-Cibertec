package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.DiscoDuroDTO;
import beans.categoriaDTO;
import interfaces.DiscoDuroDAO;
import util.conexionBD;

public class MySQLDiscoDuroDAO implements DiscoDuroDAO{

	@Override
	public ArrayList<DiscoDuroDTO> listarDiscoDuro() {
		ArrayList<DiscoDuroDTO> listarDD = new ArrayList<DiscoDuroDTO>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rslt = null;
		try {
			con = conexionBD.getConexion();
			String sql = "Select * from tb_discoDuro";
			pst = con.prepareStatement(sql);
			rslt = pst.executeQuery();			
			while (rslt.next()) {
				DiscoDuroDTO dd = new DiscoDuroDTO(	rslt.getInt(1),
													rslt.getInt(2),
													rslt.getString(3),
													rslt.getInt(4));
				listarDD.add(dd);
			}
		} catch (Exception e) {
			System.out.println("Error al listar disco duro:" + e.getMessage());
		}finally {
			conexionBD.closeConexion(con);
		}
	return listarDD;
	}
}

