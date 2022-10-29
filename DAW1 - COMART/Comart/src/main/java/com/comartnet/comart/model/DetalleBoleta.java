package com.comartnet.comart.model;

import java.io.Serializable;

import javax.persistence.*;

@Table
@Entity(name = "DetalleBoleta")
public class DetalleBoleta{
	@Id
	@Column(name = "IdBoleta")
	private String IdBoleta;

	@Column(name = "IdDetalleBoleta")
	private int IdDetalleBoleta;
	
	@Column(name = "Id_Producto")
	private int Id_Producto;
	
	@Column(name = "Cantidad")
	private int Cantidad;
	
	@Column(name = "Precio")
	private double Precio;
	
	@Column(name = "Total")
	private double Total;

	public String getIdBoleta() {
		return IdBoleta;
	}

	public void setIdBoleta(String idBoleta) {
		IdBoleta = idBoleta;
	}

	public int getIdDetalleBoleta() {
		return IdDetalleBoleta;
	}

	public void setIdDetalleBoleta(int idDetalleBoleta) {
		IdDetalleBoleta = idDetalleBoleta;
	}

	public int getId_Producto() {
		return Id_Producto;
	}

	public void setId_Producto(int id_Producto) {
		Id_Producto = id_Producto;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	public double getPrecio() {
		return Precio;
	}

	public void setPrecio(double precio) {
		Precio = precio;
	}

	public double getTotal() {
		return Total;
	}

	public void setTotal(double total) {
		Total = total;
	}
	
	public DetalleBoleta() {
		super();
	}

	public DetalleBoleta(String idBoleta, int idDetalleBoleta, int id_Producto, int cantidad, double precio,
			double total) {
		super();
		IdBoleta = idBoleta;
		IdDetalleBoleta = idDetalleBoleta;
		Id_Producto = id_Producto;
		Cantidad = cantidad;
		Precio = precio;
		Total = total;
	}

	@Override
	public String toString() {
		return "DetalleBoleta [IdBoleta=" + IdBoleta + ", IdDetalleBoleta=" + IdDetalleBoleta + ", Id_Producto="
				+ Id_Producto + ", Cantidad=" + Cantidad + ", Precio=" + Precio + ", Total=" + Total + "]";
	}
}
