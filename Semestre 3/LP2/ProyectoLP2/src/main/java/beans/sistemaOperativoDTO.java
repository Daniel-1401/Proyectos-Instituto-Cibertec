package beans;

public class sistemaOperativoDTO {

	public int codSO;
	public String nomSO;

	public int getCodSO() {
		return codSO;
	}

	public void setCodSO(int codSO) {
		this.codSO = codSO;
	}

	public String getNomSO() {
		return nomSO;
	}

	public void setNomSO(String nomSO) {
		this.nomSO = nomSO;
	}

	public sistemaOperativoDTO(int codSO, String nomSO) {
		super();
		this.codSO = codSO;
		this.nomSO = nomSO;
	}

	public sistemaOperativoDTO() {
		super();
	}
	
	
	
}
