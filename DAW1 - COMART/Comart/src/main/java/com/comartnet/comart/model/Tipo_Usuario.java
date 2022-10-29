package com.comartnet.comart.model;
import javax.persistence.*;

@Entity
@Table(name = "Tipo_Usuarios")
public class Tipo_Usuario {
	@Id
	@Column(name = "cod_TipoUsuario")
	private int cod_TipoUsuario;
	
	@Column(name = "nom_TipoUsuario")
	private String nom_TipoUsuario;

	public int getCod_TipoUsuario() {
		return cod_TipoUsuario;
	}

	public void setCod_TipoUsuario(int cod_TipoUsuario) {
		this.cod_TipoUsuario = cod_TipoUsuario;
	}

	public String getNom_TipoUsuario() {
		return nom_TipoUsuario;
	}

	public void setNom_TipoUsuario(String nom_TipoUsuario) {
		this.nom_TipoUsuario = nom_TipoUsuario;
	}
	
	public Tipo_Usuario() {
		super();
	}

	public Tipo_Usuario(int cod_TipoUsuario, String nom_TipoUsuario) {
		super();
		this.cod_TipoUsuario = cod_TipoUsuario;
		this.nom_TipoUsuario = nom_TipoUsuario;
	}

	@Override
	public String toString() {
		return "Tipo_Usuario [cod_TipoUsuario=" + cod_TipoUsuario + ", nom_TipoUsuario=" + nom_TipoUsuario + "]";
	}
}
