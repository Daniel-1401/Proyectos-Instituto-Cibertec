package beans;

public class ciudadDTO {

	public String codCiudad;
	public String nombreCiudad;
	
	public String getCodCiudad() {
		return codCiudad;
	}
	public void setCodCiudad(String codCiudad) {
		this.codCiudad = codCiudad;
	}
	public String getNombreCiudad() {
		return nombreCiudad;
	}
	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}
	
	public ciudadDTO(String codCiudad, String nombreCiudad) {
		super();
		this.codCiudad = codCiudad;
		this.nombreCiudad = nombreCiudad;
	}
	public ciudadDTO() {
		super();
	}
		
}
