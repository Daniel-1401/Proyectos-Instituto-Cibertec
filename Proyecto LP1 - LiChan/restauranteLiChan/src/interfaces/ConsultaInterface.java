package interfaces;

import java.util.ArrayList;

import modelos.RegistroCliente;
import modelos.RegistroProducto;

public interface ConsultaInterface {
	
	public ArrayList<RegistroCliente> listadoCliente();
	
	public ArrayList<RegistroProducto> listadoProducto();
	

}
