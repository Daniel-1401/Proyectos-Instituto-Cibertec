package modelos;

public class TipoDocumento {
	
	private int idTipoDocumento;
	private String descripcion;
	
	
	
	public TipoDocumento() {
		super();
	}
	
	public TipoDocumento(int idTipoDocumento, String descripcion) {
		super();
		this.idTipoDocumento = idTipoDocumento;
		this.descripcion = descripcion;
	}
	
	/**********************************************/
	
	public int getIdTipoDocumento() {
		return idTipoDocumento;
	}
	public void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
