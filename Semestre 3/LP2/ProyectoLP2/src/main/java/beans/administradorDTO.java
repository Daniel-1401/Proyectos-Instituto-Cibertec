package beans;

public class administradorDTO {
	public String 	codadmin,codusuario, nomadmin, apeadmin, codTipoDoc, numDoc, 
					telefono, codPais, codCiudad;

	
	public String getCodadmin() {
		return codadmin;
	}

	public void setCodadmin(String codadmin) {
		this.codadmin = codadmin;
	}

	public String getCodusuario() {
		return codusuario;
	}

	public void setCodusuario(String codusuario) {
		this.codusuario = codusuario;
	}

	public String getNomadmin() {
		return nomadmin;
	}

	public void setNomadmin(String nomadmin) {
		this.nomadmin = nomadmin;
	}

	public String getApeadmin() {
		return apeadmin;
	}

	public void setApeadmin(String apeadmin) {
		this.apeadmin = apeadmin;
	}

	public String getCodTipoDoc() {
		return codTipoDoc;
	}

	public void setCodTipoDoc(String codTipoDoc) {
		this.codTipoDoc = codTipoDoc;
	}

	public String getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCodPais() {
		return codPais;
	}

	public void setCodPais(String codPais) {
		this.codPais = codPais;
	}

	public String getCodCiudad() {
		return codCiudad;
	}

	public void setCodCiudad(String codCiudad) {
		this.codCiudad = codCiudad;
	}

	public administradorDTO(String codadmin, String codusuario, String nomadmin, String apeadmin, String codTipoDoc,
			String numDoc, String telefono, String codPais, String codCiudad) {
		super();
		this.codadmin = codadmin;
		this.codusuario = codusuario;
		this.nomadmin = nomadmin;
		this.apeadmin = apeadmin;
		this.codTipoDoc = codTipoDoc;
		this.numDoc = numDoc;
		this.telefono = telefono;
		this.codPais = codPais;
		this.codCiudad = codCiudad;
	}

	public administradorDTO() {
		super();
	}

}
