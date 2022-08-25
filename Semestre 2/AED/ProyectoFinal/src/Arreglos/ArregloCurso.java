package Arreglos;

import Clases.Curso;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArregloCurso {
	private ArrayList < Curso > curso;
	
	public ArregloCurso() {
		curso = new ArrayList < Curso > ();
		cargarCursos();
	}
	
	public void adicionar( Curso x ) {
		curso.add(x);
		grabarCurso();
	}
	
	public int tamaño() {
		return curso.size();
	}
	
	public Curso obtener( int pos ) {
		return curso.get(pos);
	}
	
	public Curso buscar( int codCurso ) {
		for (int i = 0; i < tamaño(); i++) {
			if (obtener(i).getCodCurso() == codCurso) {
				return obtener(i);
			}
		}
		return null;
	}
	
	public void eliminar( Curso C ) {
		curso.remove(C);
		grabarCurso();
	}
	
	public void actualizarArchivo() {
		grabarCurso();
	}
	private void cargarCursos() {
		try {
			BufferedReader br;
			String linea;
			String[] s;
			int codCurso, ciclo, creditos, horas;
			String asignatura;
			
			br = new BufferedReader(new FileReader("Cursos.txt"));
			
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codCurso	= Integer.parseInt(s[0].trim());
				asignatura	= s[1].trim();
				ciclo		= Integer.parseInt(s[2].trim());
				creditos	= Integer.parseInt(s[3].trim());
				horas		= Integer.parseInt(s[4].trim());
				adicionar(new Curso(codCurso, asignatura, ciclo, creditos, horas));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}

	private void OrdenarLista() {
		try {
			Collections.sort(curso, new Comparator<Curso>() {

				@Override
				public int compare(Curso arg0, Curso arg1) {
					return arg0.getCodCurso().compareTo(arg1.getCodCurso());
				}
			});
		}catch (Exception e) {
			
		}
	}
	private void grabarCurso() {
		OrdenarLista();
		try {
			PrintWriter pw;
			String linea;
			Curso C;
			
			pw = new PrintWriter(new FileWriter("Cursos.txt"));
			
			for (int i = 0; i < tamaño(); i++) {
				C = obtener(i);
				linea = C.getCodCurso()   + ";" +
						C.getAsignatura() + ";" +
						C.getCiclo() 	  + ";" +
						C.getCreditos()    + ";" +
						C.getHoras();
				pw.println(linea);
			}
			pw.close();
			
		} catch (Exception e) {
		}
	}
	
	public void Ordenar() {
		Curso temp;
		for (int i = 0; i < tamaño(); i++) {
			for (int j = 0; j < tamaño(); j++) {
				if (obtener(i).getCodCurso() < obtener(j).getCodCurso()) {
					temp = obtener(j);
					
				}
			}
		}
	}
}
