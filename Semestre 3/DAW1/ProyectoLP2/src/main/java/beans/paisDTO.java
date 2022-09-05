package beans;

public class paisDTO {
	
	public int codPais;
	public String nomPais;

	public int getCodPais() {
		return codPais;
	}

	public void setCodPais(int codPais) {
		this.codPais = codPais;
	}

	public String getNomPais() {
		return nomPais;
	}

	public void setNomPais(String nomPais) {
		this.nomPais = nomPais;
	}

	public paisDTO(int codPais, String nomPais) {
		super();
		this.codPais = codPais;
		this.nomPais = nomPais;
	}

	public paisDTO() {
		super();
	}
	

}
