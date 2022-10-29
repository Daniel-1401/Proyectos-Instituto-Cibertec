package com.comartnet.comart.model;

import javax.persistence.*;

@Entity
@Table(name = "Categoria")
public class Categoria {
	@Id
	@Column(name = "cod_Categoria")
	private int codCategoria;
	
	@Column(name = "nom_Categoria")
	private String nomCategoria;

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

	@Override
	public String toString() {
		return "Categoria [codCategoria=" + codCategoria + ", nomCategoria=" + nomCategoria + "]";
	}

	
	
}
