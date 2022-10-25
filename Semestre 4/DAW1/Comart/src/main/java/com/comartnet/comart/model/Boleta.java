package com.comartnet.comart.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name = "Boleta")
public class Boleta{
	@Id
	@Column(name = "IdBoleta")
	private String IdBoleta;
	
	@Column(name = "cod_Usuario")
	private String cod_Usuario;
	
	@Column(name = "fec_venta")
	private String fec_venta;
	
	@Column(name = "hora_venta")
	private String hora_venta;

	public String getIdBoleta() {
		return IdBoleta;
	}

	public void setIdBoleta(String idBoleta) {
		IdBoleta = idBoleta;
	}

	public String getCod_Usuario() {
		return cod_Usuario;
	}

	public void setCod_Usuario(String cod_Usuario) {
		this.cod_Usuario = cod_Usuario;
	}

	public String getFec_venta() {
		return fec_venta;
	}

	public void setFec_venta(String fec_venta) {
		this.fec_venta = fec_venta;
	}

	public String getHora_venta() {
		return hora_venta;
	}

	public void setHora_venta(String hora_venta) {
		this.hora_venta = hora_venta;
	}

	public Boleta() {
		super();
	}

	public Boleta(String idBoleta, String cod_Usuario, String fec_venta, String hora_venta) {
		super();
		IdBoleta = idBoleta;
		this.cod_Usuario = cod_Usuario;
		this.fec_venta = fec_venta;
		this.hora_venta = hora_venta;
	}

	@Override
	public String toString() {
		return "Boleta [IdBoleta=" + IdBoleta + ", cod_Usuario=" + cod_Usuario + ", fec_venta=" + fec_venta
				+ ", hora_venta=" + hora_venta + "]";
	}
}
