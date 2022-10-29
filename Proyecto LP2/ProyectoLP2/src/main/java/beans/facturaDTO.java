package beans;

public class facturaDTO {

	public String codFac;
	public int codCli;
	public String fechaPedido;
	public double total, precioEnvio;
	
	
	public String getCodFac() {
		return codFac;
	}
	public void setCodFac(String codFac) {
		this.codFac = codFac;
	}
	public int getCodCli() {
		return codCli;
	}
	public void setCodCli(int codCli) {
		this.codCli = codCli;
	}
	public String getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getPrecioEnvio() {
		return precioEnvio;
	}
	public void setPrecioEnvio(double precioEnvio) {
		this.precioEnvio = precioEnvio;
	}
	public facturaDTO(String codFac, int codCli, String fechaPedido, double total, double precioEnvio) {
		super();
		this.codFac = codFac;
		this.codCli = codCli;
		this.fechaPedido = fechaPedido;
		this.total = total;
		this.precioEnvio = precioEnvio;
	}
	public facturaDTO() {
		super();
	}
	
	
	
	
}
