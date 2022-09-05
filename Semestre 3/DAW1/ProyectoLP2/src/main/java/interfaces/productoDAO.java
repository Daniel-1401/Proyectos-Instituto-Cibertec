package interfaces;


import java.util.ArrayList;

import beans.productosDTO;

public interface productoDAO {
	
	public int registrar (productosDTO prod);
	
	public int actualizar (productosDTO prod);
	
	public int eliminar (String codigo);
	
	ArrayList<productosDTO> listarProd();
	
}
