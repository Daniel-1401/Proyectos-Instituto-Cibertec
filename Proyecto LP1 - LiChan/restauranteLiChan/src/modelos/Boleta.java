package modelos;

public class Boleta {
	  private String idBoleta;
	  private String fecha;
	  private String idCliente;
	  private String idRecepcionista;
	public String getIdBoleta() {
		return idBoleta;
	}
	public void setIdBoleta(String idBoleta) {
		this.idBoleta = idBoleta;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getIdRecepcionista() {
		return idRecepcionista;
	}
	public void setIdRecepcionista(String idRecepcionista) {
		this.idRecepcionista = idRecepcionista;
	}
	public Boleta(String idBoleta, String fecha, String idCliente, String idRecepcionista) {
		super();
		this.idBoleta = idBoleta;
		this.fecha = fecha;
		this.idCliente = idCliente;
		this.idRecepcionista = idRecepcionista;
	}
	public Boleta() {
		super();
	}

}
