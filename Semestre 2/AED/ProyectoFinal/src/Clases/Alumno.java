package Clases;

public class Alumno {
	private int codAlumno, edad, celular, estado;
	private String nombre, apellidos, dni;
	public Alumno(int codAlumno, String nombre, String apellidos, int edad, String dni, int celular, int estado) {
		super();
		this.codAlumno = codAlumno;
		this.edad = edad;
		this.celular = celular;
		this.estado = estado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
	}
	public Integer getCodAlumno() {
		return codAlumno;
	}
	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getCelular() {
		return celular;
	}
	public void setCelular(int celular) {
		this.celular = celular;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
}
