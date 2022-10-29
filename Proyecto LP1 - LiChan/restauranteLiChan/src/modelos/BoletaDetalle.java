package modelos;

public class BoletaDetalle {
	private String idBoleta;
	private String idProducto;
	private int cantidadProducto;
	private double precioTotalProducto;
	public String getIdBoleta() {
		return idBoleta;
	}
	public void setIdBoleta(String idBoleta) {
		this.idBoleta = idBoleta;
	}
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public int getCantidadProducto() {
		return cantidadProducto;
	}
	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}
	public double getPrecioTotalProducto() {
		return precioTotalProducto;
	}
	public void setPrecioTotalProducto(double precioTotalProducto) {
		this.precioTotalProducto = precioTotalProducto;
	}
	public BoletaDetalle(String idBoleta, String idProducto, int cantidadProducto, double precioTotalProducto) {
		super();
		this.idBoleta = idBoleta;
		this.idProducto = idProducto;
		this.cantidadProducto = cantidadProducto;
		this.precioTotalProducto = precioTotalProducto;
	}
	public BoletaDetalle() {
		super();
	}
	

}
