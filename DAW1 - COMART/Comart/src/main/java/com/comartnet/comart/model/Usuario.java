package com.comartnet.comart.model;
import javax.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario {
	@Id
	@Column(name = "cod_Usuario")
	private String cod_Usuario;
	
	@Column(name = "nom_Usuario")
	private String nom_Usuario;
	
	@Column(name = "ape_Usuario")
	private String ape_Usuario;
	
	@Column(name = "cod_TipoUsuario")
	private int cod_TipoUsuario;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "clave")
	private String clave;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "fecha_reg")
	private String fecha_reg;
	
	@Column(name = "fecha_nac")
	private String fecha_nac;

	public String getCod_Usuario() {
		return cod_Usuario;
	}

	public void setCod_Usuario(String cod_Usuario) {
		this.cod_Usuario = cod_Usuario;
	}

	public String getNom_Usuario() {
		return nom_Usuario;
	}

	public void setNom_Usuario(String nom_Usuario) {
		this.nom_Usuario = nom_Usuario;
	}

	public String getApe_Usuario() {
		return ape_Usuario;
	}

	public void setApe_Usuario(String ape_Usuario) {
		this.ape_Usuario = ape_Usuario;
	}

	public int getCod_TipoUsuario() {
		return cod_TipoUsuario;
	}

	public void setCod_TipoUsuario(int cod_TipoUsuario) {
		this.cod_TipoUsuario = cod_TipoUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFecha_reg() {
		return fecha_reg;
	}

	public void setFecha_reg(String fecha_reg) {
		this.fecha_reg = fecha_reg;
	}

	public String getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	
	public Usuario() {
		super();
	}

	public Usuario(String cod_Usuario, String nom_Usuario, String ape_Usuario, int cod_TipoUsuario, String email,
			String clave, String telefono, String fecha_reg, String fecha_nac) {
		super();
		this.cod_Usuario = cod_Usuario;
		this.nom_Usuario = nom_Usuario;
		this.ape_Usuario = ape_Usuario;
		this.cod_TipoUsuario = cod_TipoUsuario;
		this.email = email;
		this.clave = clave;
		this.telefono = telefono;
		this.fecha_reg = fecha_reg;
		this.fecha_nac = fecha_nac;
	}

	@Override
	public String toString() {
		return "Usuario [cod_Usuario=" + cod_Usuario + ", nom_Usuario=" + nom_Usuario + ", ape_Usuario=" + ape_Usuario
				+ ", cod_TipoUsuario=" + cod_TipoUsuario + ", email=" + email + ", clave=" + clave + ", telefono="
				+ telefono + ", fecha_reg=" + fecha_reg + ", fecha_nac=" + fecha_nac + "]";
	}
	
	
}
