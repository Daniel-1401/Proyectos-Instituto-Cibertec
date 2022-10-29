package modelos;

public class RegistroCliente {
	
	private String idCliente,nombreCliente,apellidoCliente, direccionCliente,numeroDocumento;
	private int  numeroTelefonico, idtipoDocumento;

	
	public RegistroCliente() {
		
	}

	public RegistroCliente(String idCliente, String nombreCliente, String apellidoCliente, String direccionCliente,
			String numeroDocumento, int numeroTelefonico, int idtipoDocumento) {
		super();
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.direccionCliente = direccionCliente;
		this.numeroDocumento = numeroDocumento;
		this.numeroTelefonico = numeroTelefonico;
		this.idtipoDocumento = idtipoDocumento;
	}
	
	
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	public String getDireccionCliente() {
		return direccionCliente;
	}
	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public int getNumeroTelefonico() {
		return numeroTelefonico;
	}
	public void setNumeroTelefonico(int numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}
	public int getIdtipoDocumento() {
		return idtipoDocumento;
	}
	public void setIdtipoDocumento(int idtipoDocumento) {
		this.idtipoDocumento = idtipoDocumento;
	}
	  
	 
	 
	  
	   

}
