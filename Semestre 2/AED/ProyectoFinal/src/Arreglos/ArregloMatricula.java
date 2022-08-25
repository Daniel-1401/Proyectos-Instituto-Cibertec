package Arreglos;

import Clases.Matricula;
import java.io.*;
import java.util.ArrayList;

public class ArregloMatricula {
	private ArrayList <Matricula> matricula;
	
	public ArregloMatricula () {
		matricula = new ArrayList<Matricula>();
		cargarMatriculas();
	}
	public int tamaño() {
		return matricula.size();
	}
	public void adicionar(Matricula M) {
		matricula.add(M);
		grabarMatriculas();
	}
	
	public void eliminar(Matricula M) {
		matricula.remove(M);
		grabarMatriculas();
	}
	
	public Matricula obtener(int pos) {
		return matricula.get(pos);
	}
	
	public Matricula buscar(int numMatricula) {
		for (int i = 0; i < tamaño(); i++) {
			if (obtener(i).getnumMatricula() == numMatricula) {
				return obtener(i);
			}
		}
		return null;
	}
	
	public void actualizarArchivo() {
		grabarMatriculas();
	}
	
	public void cargarMatriculas() {
		try {
			BufferedReader br;
			String linea, fecha, hora;
			String[] s;
			int numMatricula, codAlumno, codCurso;
			
			br = new BufferedReader(new FileReader("Matriculas.txt"));
			
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				numMatricula	= Integer.parseInt(s[0].trim());
				codAlumno		= Integer.parseInt(s[1].trim());
				codCurso		= Integer.parseInt(s[2].trim());
				fecha			= s[3].trim();
				hora			= s[4].trim();
				adicionar(new Matricula(numMatricula, codAlumno, codCurso, fecha, hora));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}

	public void grabarMatriculas() {
		try {
			PrintWriter pw;
			String linea;
			Matricula m;
			
			pw = new PrintWriter(new FileWriter("Matriculas.txt"));
			for (int i = 0; i < tamaño(); i++) {
				m = obtener(i);
				linea = m.getnumMatricula() + ";" +
						m.getcodAlumno()    + ";" +
						m.getcodCurso()		+ ";" +
						m.getFecha()		+ ";" +
						m.getHora();
				pw.println(linea);
			}
			pw.close();
			
		}
		catch (Exception e) {
		}
	}
	
	
	public int codigoCorrelativo() {
		if (tamaño() == 0) {
			return 100001;
		}
		else {
			return obtener(tamaño()-1).getnumMatricula()+1;
		}
	}

}























