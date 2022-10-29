package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.gpuDTO;
import interfaces.gpuDAO;
import util.conexionBD;

public class MySQLGPUDAO implements gpuDAO{

	@Override
	public ArrayList<gpuDTO> listarGPU() {
		ArrayList<gpuDTO> listarGPU = new ArrayList<gpuDTO>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		try {	
			con = conexionBD.getConexion();
			String sql = "Select*from tb_GPU";
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while (rst.next()) {
				gpuDTO gpu = new gpuDTO(	rst.getInt(1),
											rst.getInt(2),
											rst.getString(3),
											rst.getString(4));
				listarGPU.add(gpu);
			}
		}catch (Exception e) {
				System.out.println("Error al listar gpu's:" + e.getMessage());
		}finally {
				conexionBD.closeConexion(con);
			}
		return listarGPU;
	}
}
