package beans;

public class usuarioDTO {

	public String codUsu;
	public int codTipoUsu;
	public String email, contrasenia, nomUsu, apeUsu;
	

	public void setCodUsu(String codUsu) {
		this.codUsu = codUsu;
	}
	
	public String getCodUsu() {
		return codUsu;
	}

	public int getCodTipoUsu() {
		return codTipoUsu;
	}

	public void setCodTipoUsu(int codTipoUsu) {
		this.codTipoUsu = codTipoUsu;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNomUsu() {
		return nomUsu;
	}

	public void setNomUsu(String nomUsu) {
		this.nomUsu = nomUsu;
	}

	public String getApeUsu() {
		return apeUsu;
	}

	public void setApeUsu(String apeUsu) {
		this.apeUsu = apeUsu;
	}

	public usuarioDTO(String codUsu, int codTipoUsu, String email, String contrasenia, String nomUsu, String apeUsu) {
		super();
		this.codUsu = codUsu;
		this.codTipoUsu = codTipoUsu;
		this.email = email;
		this.contrasenia = contrasenia;
		this.nomUsu = nomUsu;
		this.apeUsu = apeUsu;
	}
	
	@Override
	public String toString() {
		return "usuarioDTO [codUsu=" + codUsu + ", codTipoUsu=" + codTipoUsu + ", email=" + email + ", contrasenia="
				+ contrasenia + ", nomUsu=" + nomUsu + ", apeUsu=" + apeUsu + "]";
	}

	public usuarioDTO() {
		super();
	}

}
