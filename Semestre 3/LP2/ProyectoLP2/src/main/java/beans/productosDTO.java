package beans;

public class productosDTO {
	private String codigoProducto, modeloProducto, categoria, marca, descripcionPantalla, cpu, gpu, discoDuro, sistemaOperativo;
	private double precioVenta;
	public String getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public String getModeloProducto() {
		return modeloProducto;
	}
	public void setModeloProducto(String modeloProducto) {
		this.modeloProducto = modeloProducto;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getDescripcionPantalla() {
		return descripcionPantalla;
	}
	public void setDescripcionPantalla(String descripcionPantalla) {
		this.descripcionPantalla = descripcionPantalla;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getGpu() {
		return gpu;
	}
	public void setGpu(String gpu) {
		this.gpu = gpu;
	}
	public String getDiscoDuro() {
		return discoDuro;
	}
	public void setDiscoDuro(String discoDuro) {
		this.discoDuro = discoDuro;
	}
	public String getSistemaOperativo() {
		return sistemaOperativo;
	}
	public void setSistemaOperativo(String sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}
	public double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
	public productosDTO(String codigoProducto, String modeloProducto, String categoria, String marca,
			String descripcionPantalla, String cpu, String gpu, String discoDuro, String sistemaOperativo,
			double precioVenta) {
		super();
		this.codigoProducto = codigoProducto;
		this.modeloProducto = modeloProducto;
		this.categoria = categoria;
		this.marca = marca;
		this.descripcionPantalla = descripcionPantalla;
		this.cpu = cpu;
		this.gpu = gpu;
		this.discoDuro = discoDuro;
		this.sistemaOperativo = sistemaOperativo;
		this.precioVenta = precioVenta;
	}
	public productosDTO() {
		super();
	}
	
}
