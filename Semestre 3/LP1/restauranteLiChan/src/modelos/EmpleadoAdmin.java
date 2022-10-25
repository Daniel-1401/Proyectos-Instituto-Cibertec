package modelos;

public class EmpleadoAdmin {
	private String idEmpleado;
	private String nombreEmpleado;
	private String apellidoEmpleado;
	private int idTipoDocumento;
	private String numeroDocumento;
	private String fechaNacimiento;
	private int idCargo;
	private String genero;
	private String estado;
	private int idUsuario;
	private double sueldo;
	private String user;
	private String pass;
	public String getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}
	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}
	public String getApellidoEmpleado() {
		return apellidoEmpleado;
	}
	public void setApellidoEmpleado(String apellidoEmpleado) {
		this.apellidoEmpleado = apellidoEmpleado;
	}
	public int getIdTipoDocumento() {
		return idTipoDocumento;
	}
	public void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getIdCargo() {
		return idCargo;
	}
	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public EmpleadoAdmin(String idEmpleado, String nombreEmpleado, String apellidoEmpleado, int idTipoDocumento,
			String numeroDocumento, String fechaNacimiento, int idCargo, String genero, String estado, int idUsuario,
			double sueldo, String user, String pass) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.apellidoEmpleado = apellidoEmpleado;
		this.idTipoDocumento = idTipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.fechaNacimiento = fechaNacimiento;
		this.idCargo = idCargo;
		this.genero = genero;
		this.estado = estado;
		this.idUsuario = idUsuario;
		this.sueldo = sueldo;
		this.user = user;
		this.pass = pass;
	}
	public EmpleadoAdmin() {
		super();
	}
	
}	
