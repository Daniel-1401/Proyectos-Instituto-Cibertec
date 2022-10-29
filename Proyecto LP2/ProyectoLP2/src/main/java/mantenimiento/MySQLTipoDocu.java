package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.gpuDTO;
import beans.tipoDocumentoDTO;
import interfaces.tipoDocumentoDAO;
import util.conexionBD;

public class MySQLTipoDocu implements tipoDocumentoDAO {

	@Override
	public ArrayList<tipoDocumentoDTO> listarTipoDoc() {
		ArrayList<tipoDocumentoDTO> listarTipoDoc = new ArrayList<tipoDocumentoDTO>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		try {	
			con = conexionBD.getConexion();
			String sql = "Select*from tb_TipoDocumento";
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while (rst.next()) {
				tipoDocumentoDTO tdd = new tipoDocumentoDTO(rst.getInt(1),
															rst.getString(2));
				listarTipoDoc.add(tdd);
			}
		}catch (Exception e) {
				System.out.println("Error al listar tipo de documento:" + e.getMessage());
		}finally {
				conexionBD.closeConexion(con);
			}
		return listarTipoDoc;
	}
}
