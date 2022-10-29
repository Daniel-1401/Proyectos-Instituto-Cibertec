package modelos;

public class ProductosSeleccionados_Temporal {
	  private int numItem;
	  private String idBoleta;
	  private String idCliente;
	  private String idProducto;
	  private int CantidadProducto;
	  private double totalProductoSeleccionado;
	  private String NombreProducto;
	  private double PrecioUnitProducto;
	
	
	public int getNumItem() {
		return numItem;
	}
	public void setNumItem(int numItem) {
		this.numItem = numItem;
	}
	public String getIdBoleta() {
		return idBoleta;
	}
	public void setIdBoleta(String idBoleta) {
		this.idBoleta = idBoleta;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public int getCantidadProducto() {
		return CantidadProducto;
	}
	public void setCantidadProducto(int cantidadProducto) {
		CantidadProducto = cantidadProducto;
	}
	public double getTotalProductoSeleccionado() {
		return totalProductoSeleccionado;
	}
	public void setTotalProductoSeleccionado(double totalProductoSeleccionado) {
		this.totalProductoSeleccionado = totalProductoSeleccionado;
	}
	public String getNombreProducto() {
		return NombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		NombreProducto = nombreProducto;
	}
	public double getPrecioUnitProducto() {
		return PrecioUnitProducto;
	}
	public void setPrecioUnitProducto(double precioUnitProducto) {
		PrecioUnitProducto = precioUnitProducto;
	}
	
	
	public ProductosSeleccionados_Temporal(int numItem, String idBoleta, String idCliente, String idProducto,
			int cantidadProducto, double totalProductoSeleccionado, String nombreProducto, double precioUnitProducto) {
		super();
		this.numItem = numItem;
		this.idBoleta = idBoleta;
		this.idCliente = idCliente;
		this.idProducto = idProducto;
		CantidadProducto = cantidadProducto;
		this.totalProductoSeleccionado = totalProductoSeleccionado;
		NombreProducto = nombreProducto;
		PrecioUnitProducto = precioUnitProducto;
	}
	public ProductosSeleccionados_Temporal() {
		super();
	}
	  

}
