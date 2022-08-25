package Arreglos;

import Clases.Alumno;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArregloAlumno {
	
	private ArrayList <Alumno> alumno;
	
	public ArregloAlumno() {
		alumno = new ArrayList <Alumno> ();
		cargarAlumnos();
	}
	public void adicionar (Alumno x) {
		alumno.add(x);
		grabarAlumnos();
	}
	public int tamaño() {
		return alumno.size();
	}
	public Alumno obtener(int pos) {
		return alumno.get(pos);
	}
	public Alumno buscar(int codAlumno) {
		for (int i = 0; i < tamaño(); i++) {
			if (obtener(i).getCodAlumno() == codAlumno) {
				return obtener(i);
			}
		}
		return null;
	}
	public void eliminar(Alumno A) {
		alumno.remove(A);
		grabarAlumnos();
	}
	public void actualizarArchivo() {
		grabarAlumnos();
	}
	
	private void OrdenarLista() {
		try {
			Collections.sort(alumno, new Comparator<Alumno>() {

				public int compare(Alumno arg0, Alumno arg1) {
					return arg0.getCodAlumno().compareTo(arg1.getCodAlumno());
				}
			});
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void grabarAlumnos() {
		OrdenarLista();
		try {
			PrintWriter pw;
			String linea;
			Alumno A;
			
			pw = new PrintWriter(new FileWriter("Alumnos.txt"));
			
			for (int i = 0; i < tamaño(); i++) {
				A = obtener(i);
				linea = A.getCodAlumno() + ";" +
						A.getNombre()	 + ";" +
						A.getApellidos() + ";" +
						A.getEdad()		 + ";" +
						A.getDni()		 + ";" +
						A.getCelular()	 + ";" +
						A.getEstado();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	private void cargarAlumnos() {
		try {
			BufferedReader br;
			String linea;
			String[] s;
			int codAlumno, edad, celular, estado;
			String nombre, apellido, dni;
			
			br = new BufferedReader(new FileReader("Alumnos.txt"));
			
			while((linea = br.readLine()) != null) {
				s = linea.split(";");
				codAlumno 	= Integer.parseInt(s[0].trim());
				nombre 		= s[1].trim();
				apellido 	= s[2].trim();
				edad		= Integer.parseInt(s[3].trim());
				dni			= s[4].trim();
				celular		= Integer.parseInt(s[5].trim());
				estado		= Integer.parseInt(s[6].trim());
				adicionar(new Alumno(codAlumno, nombre, apellido, edad, dni, celular, estado));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
	public int codigoCorrelativo() {
		if (tamaño() == 0) {
			return 202010001;
		}
		else {
			return obtener(tamaño()-1).getCodAlumno() + 1;
		}
	}
	
}
