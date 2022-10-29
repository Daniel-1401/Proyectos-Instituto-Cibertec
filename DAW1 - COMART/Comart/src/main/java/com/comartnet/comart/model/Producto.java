package com.comartnet.comart.model;

import javax.persistence.*;

@Entity
@Table(name = "Productos")
public class Producto {
	@Id
	@Column(name = "Id_Producto")
	private int IdProducto;
	
	@Column(name = "Nom_Producto")
	private String NomProducto;
	
	@Column(name = "Des_Producto")
	private String DesProducto;
	
	@Column(name = "PrecioUnidad")
	private double precioUnidad;
	
	@Column(name = "Stock_Producto")
	private int StockProducto;
	
	@Column(name = "UnidadesEnPedido")
	private int unidadesEnPedido;
	
	@Column(name = "imagen")
	private String imag;
	
	@Column(name = "cod_Categoria")
	private int codCategoria;

	public int getIdProducto() {
		return IdProducto;
	}

	public void setIdProducto(int idProducto) {
		IdProducto = idProducto;
	}

	public String getNomProducto() {
		return NomProducto;
	}

	public void setNomProducto(String nomProducto) {
		NomProducto = nomProducto;
	}

	public String getDesProducto() {
		return DesProducto;
	}

	public void setDesProducto(String desProducto) {
		DesProducto = desProducto;
	}

	public double getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecioUnidad(double precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public int getStockProducto() {
		return StockProducto;
	}

	public void setStockProducto(int stockProducto) {
		StockProducto = stockProducto;
	}

	public int getUnidadesEnPedido() {
		return unidadesEnPedido;
	}

	public void setUnidadesEnPedido(int unidadesEnPedido) {
		this.unidadesEnPedido = unidadesEnPedido;
	}

	public String getImag() {
		return imag;
	}

	public void setImag(String imag) {
		this.imag = imag;
	}

	public int getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}

	@Override
	public String toString() {
		return "Producto [IdProducto=" + IdProducto + ", NomProducto=" + NomProducto + ", DesProducto=" + DesProducto
				+ ", precioUnidad=" + precioUnidad + ", StockProducto=" + StockProducto + ", unidadesEnPedido="
				+ unidadesEnPedido + ", imag=" + imag + ", codCategoria=" + codCategoria + "]";
	}

	
	
}
