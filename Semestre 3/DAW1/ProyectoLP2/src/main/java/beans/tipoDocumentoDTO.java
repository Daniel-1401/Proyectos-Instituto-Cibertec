package beans;

public class tipoDocumentoDTO {
	
	public int codTipoDoc;
	public String nomTipoDoc;

	public int getCodTipoDoc() {
		return codTipoDoc;
	}

	public void setCodTipoDoc(int codTipoDoc) {
		this.codTipoDoc = codTipoDoc;
	}

	public String getNomTipoDoc() {
		return nomTipoDoc;
	}

	public void setNomTipoDoc(String nomTipoDoc) {
		this.nomTipoDoc = nomTipoDoc;
	}

	public tipoDocumentoDTO(int codTipoDoc, String nomTipoDoc) {
		super();
		this.codTipoDoc = codTipoDoc;
		this.nomTipoDoc = nomTipoDoc;
	}

	public tipoDocumentoDTO() {
		super();
	}


}
