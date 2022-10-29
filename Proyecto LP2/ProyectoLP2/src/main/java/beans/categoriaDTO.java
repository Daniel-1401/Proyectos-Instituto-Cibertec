package beans;

public class categoriaDTO {
	
	public int codCategoria;
	public String nomCategoria;

	public int getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}

	public String getNomCategoria() {
		return nomCategoria;
	}

	public void setNomCategoria(String nomCategoria) {
		this.nomCategoria = nomCategoria;
	}

	public categoriaDTO(int codCategoria, String nomCategoria) {
		super();
		this.codCategoria = codCategoria;
		this.nomCategoria = nomCategoria;
	}

	public categoriaDTO() {
		super();
	}
	
	
	
	
}
