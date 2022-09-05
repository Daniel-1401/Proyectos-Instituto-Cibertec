package beans;

public class DiscoDuroDTO {
	
	public int codDD,codTipoDD,codMarca;
	public String capacidad;
	
	public int getCodDD() {
		return codDD;
	}

	public void setCodDD(int codDD) {
		this.codDD = codDD;
	}

	public int getCodMarca() {
		return codMarca;
	}

	public void setCodMarca(int codMarca) {
		this.codMarca = codMarca;
	}

	public String getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public int getCodTipoDD() {
		return codTipoDD;
	}

	public void setCodTipoDD(int codTipoDD) {
		this.codTipoDD = codTipoDD;
	}

	public DiscoDuroDTO(int codDD, int codMarca, String capacidad, int codTipoDD) {
		super();
		this.codDD = codDD;
		this.codMarca = codMarca;
		this.capacidad = capacidad;
		this.codTipoDD = codTipoDD;
	}

	public DiscoDuroDTO() {
		super();
	}

	
	
}
