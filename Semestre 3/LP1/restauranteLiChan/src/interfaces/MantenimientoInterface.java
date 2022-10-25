package interfaces;

import java.util.ArrayList;

import modelos.RegistroCliente;
import modelos.RegistroProducto;
import modelos.TipoDocumento;

public interface MantenimientoInterface {
	
	/********* Cliente ***********/
	public ArrayList<TipoDocumento> listadoDeDocumento();
	
	public String generarCodigoCliRegistro();
	
	public int registro(RegistroCliente r);
	
	public int eliminar(String idCliente);
	
	public RegistroCliente buscar (String idCliente);
	
	public int actulizar(RegistroCliente r); 
	
	
	/********* Producto ***********/
	
	public String generarCodigoProducto();
	
	public int registro(RegistroProducto r);
	
	public int eliminarProducto (String idProducto);
	
	public RegistroProducto buscarProducto (String idProducto);
	
	public int actulizarProducto(RegistroCliente r); 
	
	
	
}
