package beans;

public class carritoDTO {
	
	public int codCarrito;
	public String codusuario, codFactura, codProd;
	public int cantidad;
	public double subtotal;
	
	public int getCodCarrito() {
		return codCarrito;
	}
	public void setCodCarrito(int codCarrito) {
		this.codCarrito = codCarrito;
	}
	public String getCodusuario() {
		return codusuario;
	}
	public void setCodusuario(String codusuario) {
		this.codusuario = codusuario;
	}
	public String getCodFactura() {
		return codFactura;
	}
	public void setCodFactura(String codFactura) {
		this.codFactura = codFactura;
	}
	public String getCodProd() {
		return codProd;
	}
	public void setCodProd(String codProd) {
		this.codProd = codProd;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	
	public carritoDTO(int codCarrito, String codusuario, String codFactura, String codProd, int cantidad,
			double subtotal) {
		super();
		this.codCarrito = codCarrito;
		this.codusuario = codusuario;
		this.codFactura = codFactura;
		this.codProd = codProd;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
	}
	
	public carritoDTO() {
		super();
	}
	
	

}
