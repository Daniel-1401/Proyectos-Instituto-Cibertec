package modelos;

public class DetalleBoleta {
	private String idBoleta;
	private String idProducto;
	private int cantidadProducto;
	private double precioTotalProducto;
	private String nombreProducto;
	private double precioUnitProducto;
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
	
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public double getPrecioUnitProducto() {
		return precioUnitProducto;
	}
	public void setPrecioUnitProducto(double precioUnitProducto) {
		this.precioUnitProducto = precioUnitProducto;
	}
	public DetalleBoleta(String idBoleta, String idProducto, int cantidadProducto, double precioTotalProducto) {
		super();
		this.idBoleta = idBoleta;
		this.idProducto = idProducto;
		this.cantidadProducto = cantidadProducto;
		this.precioTotalProducto = precioTotalProducto;
	}
	
	public DetalleBoleta(String idBoleta, String idProducto, int cantidadProducto, double precioTotalProducto,
			String nombreProducto, double precioUnitProducto) {
		super();
		this.idBoleta = idBoleta;
		this.idProducto = idProducto;
		this.cantidadProducto = cantidadProducto;
		this.precioTotalProducto = precioTotalProducto;
		this.nombreProducto = nombreProducto;
		this.precioUnitProducto = precioUnitProducto;
	}
	public DetalleBoleta() {
		super();
	}
	
	
}
