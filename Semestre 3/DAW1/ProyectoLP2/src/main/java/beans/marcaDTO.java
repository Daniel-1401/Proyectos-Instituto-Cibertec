package beans;

public class marcaDTO {
	
	public int codMarca;
	
	public String nomMarca;

	public int getCodMarca() {
		return codMarca;
	}

	public void setCodMarca(int codMarca) {
		this.codMarca = codMarca;
	}

	public String getNomMarca() {
		return nomMarca;
	}

	public void setNomMarca(String nomMarca) {
		this.nomMarca = nomMarca;
	}

	public marcaDTO(int codMarca, String nomMarca) {
		super();
		this.codMarca = codMarca;
		this.nomMarca = nomMarca;
	}

	public marcaDTO() {
		super();
	}
	
	

}
