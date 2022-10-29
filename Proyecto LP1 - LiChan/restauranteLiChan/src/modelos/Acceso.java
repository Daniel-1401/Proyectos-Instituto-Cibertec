package modelos;

public class Acceso {
	private int idUsuario;
	private String login;
	private String password;
	private int cargoUsuario;
	private String genero;
	private String nombre;
	private String apellido;
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCargoUsuario() {
		return cargoUsuario;
	}
	public void setCargoUsuario(int cargoUsuario) {
		this.cargoUsuario = cargoUsuario;
	}
	
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Acceso() {
		super();
	}
}
