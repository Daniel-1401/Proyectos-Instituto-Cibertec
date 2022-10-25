package modelos;

public class TipoCargo {
	private int idCargo;
	private String Descripcion;
	public int getIdCargo() {
		return idCargo;
	}
	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public TipoCargo(int idCargo, String descripcion) {
		super();
		this.idCargo = idCargo;
		Descripcion = descripcion;
	}
	public TipoCargo() {
		super();
	}
	
}
