package interfaces;

import java.util.ArrayList;

import modelos.EmpleadoAdmin;
import modelos.EmpleadoRecep;
import modelos.TipoCargo;
import modelos.TipoDocumento;

public interface EmpleadoInterface {
	
	public int registrarEmpleadoAdmin(EmpleadoAdmin e);
	public int actualizarEmpledoAdmin(EmpleadoAdmin e);
	
	public int registrarEmpleadoRecep(EmpleadoRecep e);
	public int actualizarEmpleadoRecep(EmpleadoRecep e);
	
	public EmpleadoRecep obtener(String id);

	public int eliminarEmpleado(String id);
	
	public ArrayList<TipoDocumento> listadoTipoDocumento();
	public ArrayList<TipoCargo> listadoTipoCargo();
	public String generarCodigo(int cargo);
	
	
}
