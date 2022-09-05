package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.marcaDTO;
import interfaces.marcaDAO;
import util.conexionBD;

public class MySQLMarcaDAO implements marcaDAO {

	@Override
	public ArrayList<marcaDTO> listarMarca() {
		ArrayList<marcaDTO> lstmarca = new ArrayList<marcaDTO>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		try {
			con = conexionBD.getConexion();
			String sql = "Select * from tb_marca";
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			
			while (rst.next()) {
				marcaDTO marca = new marcaDTO(rst.getInt(1),
												rst.getString(2));
				lstmarca.add(marca);
			}
			
		} catch (Exception e) {
			System.out.println("Error al listar marcas:" + e.getMessage());
		}finally {
			conexionBD.closeConexion(con);
		}
		return lstmarca;
	}
}
