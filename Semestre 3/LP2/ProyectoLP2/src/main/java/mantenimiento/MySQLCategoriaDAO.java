package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.categoriaDTO;
import interfaces.categoriaDAO;
import util.conexionBD;

public class MySQLCategoriaDAO implements categoriaDAO {

	@Override
	public ArrayList<categoriaDTO> listarCate() {
			ArrayList<categoriaDTO> listarCategoria = new ArrayList<categoriaDTO>();
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rslt = null;
			try {
				con = conexionBD.getConexion();
				String sql = "Select * from tb_categoria";
				pst = con.prepareStatement(sql);
				rslt = pst.executeQuery();			
				while (rslt.next()) {
					categoriaDTO cate = new categoriaDTO(rslt.getInt(1),
														rslt.getString(2));
					listarCategoria.add(cate);
				}
			} catch (Exception e) {
				System.out.println("Error al listar categorias:" + e.getMessage());
			}finally {
				conexionBD.closeConexion(con);
			}
		return listarCategoria;
	}
}
