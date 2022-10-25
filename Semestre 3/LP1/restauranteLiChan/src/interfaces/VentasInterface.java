package interfaces;

import java.util.ArrayList;

import modelos.Boleta;
import modelos.BoletaDetalle;
import modelos.ProductosSeleccionados_Temporal;

public interface VentasInterface {
	
	public String generaNumeroBoleta();
	
	public ArrayList<ProductosSeleccionados_Temporal> lstProductosSeleccionados();
	public int insertarProductosSeleccionadosTemporal(ProductosSeleccionados_Temporal p, int numItem);
	public int eliminarProductoSeleccionado(String idCliente, int numeroItem);
	public double sumaTotalProductosSeleccionados(String idCliente);
	public String obtenerRecepcionista(int idUsuario);
	public int registrarBoleta(Boleta b);
	public int registrarBoletaDetalle(BoletaDetalle b);
}
