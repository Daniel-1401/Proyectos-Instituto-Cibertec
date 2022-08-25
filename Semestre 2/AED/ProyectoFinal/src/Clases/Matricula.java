package Clases;

public class Matricula {
	private int numMatricula, codAlumno, codCurso;
	private String fecha, hora;
	public Matricula(int numMatricula, int codAlumno, int codCurso, String fecha, String hora) {
		super();
		this.numMatricula = numMatricula;
		this.codAlumno = codAlumno;
		this.codCurso = codCurso;
		this.fecha = fecha;
		this.hora = hora;
	}
	public int getnumMatricula() {
		return numMatricula;
	}
	public void setnumMatricula(int numMatricula) {
		this.numMatricula = numMatricula;
	}
	public int getcodAlumno() {
		return codAlumno;
	}
	public void setcodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}
	public int getcodCurso() {
		return codCurso;
	}
	public void setcodCurso(int codCurso) {
		this.codCurso = codCurso;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}

}
