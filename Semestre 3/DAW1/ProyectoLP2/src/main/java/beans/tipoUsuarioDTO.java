package beans;

public class tipoUsuarioDTO {

	public int codTipoUsu;
	public String nomTipoUsu;
	public int getCodTipoUsu() {
		return codTipoUsu;
	}
	public void setCodTipoUsu(int codTipoUsu) {
		this.codTipoUsu = codTipoUsu;
	}
	public String getNomTipoUsu() {
		return nomTipoUsu;
	}
	public void setNomTipoUsu(String nomTipoUsu) {
		this.nomTipoUsu = nomTipoUsu;
	}
	
	public tipoUsuarioDTO(int codTipoUsu, String nomTipoUsu) {
		super();
		this.codTipoUsu = codTipoUsu;
		this.nomTipoUsu = nomTipoUsu;
	}
	
	public tipoUsuarioDTO() {
		super();
	}
	
	
	
	
}
