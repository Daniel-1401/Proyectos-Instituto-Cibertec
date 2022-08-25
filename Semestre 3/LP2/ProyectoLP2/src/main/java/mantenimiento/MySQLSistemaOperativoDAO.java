package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.sistemaOperativoDTO;
import interfaces.SistemaOperativoDAO;
import util.conexionBD;

public class MySQLSistemaOperativoDAO implements SistemaOperativoDAO{

	@Override
	public ArrayList<sistemaOperativoDTO> listarSO() {
		ArrayList<sistemaOperativoDTO> listarSistOperativo = new ArrayList<sistemaOperativoDTO>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		try {
			con = conexionBD.getConexion();
			String sql = "	SELECT * FROM tb_sistemaOperativo;";
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while(rst.next()) {
				sistemaOperativoDTO so = new sistemaOperativoDTO(rst.getInt(1),
																rst.getString(2));	
				listarSistOperativo.add(so);
			}
		} catch (Exception e) {
			System.out.println("Error al listar Sistema Operativo:"+ e.getMessage());
		}finally {
			conexionBD.closeConexion(con);
		}
		return listarSistOperativo;
	}

}
