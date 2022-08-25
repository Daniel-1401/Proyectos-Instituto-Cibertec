package Arreglos;

import Clases.Retiro;
import java.io.*;
import java.util.ArrayList;


public class ArregloRetiro {
	
	private ArrayList <Retiro> retiro;

	public ArregloRetiro() {
		retiro = new ArrayList<Retiro>();
		cargarRetiros();
	}
	
	public int tamaño() {
		return retiro.size();
	}
	
	public void adicionar(Retiro R) {
		retiro.add(R);
		grabarRetiros();
	}
	
	public void eliminar(Retiro R) {
		retiro.remove(R);
		grabarRetiros();
	}

	public Retiro obtener(int pos) {
		return retiro.get(pos);
	}
	
	public Retiro buscar(int NumRetiro) {
		for (int i=0; i<tamaño(); i++) {
			if (obtener(i).getNumRetiro() == NumRetiro) {
				return obtener(i);
			}
		}
		return null;
	}
	
	public void actualizarArchivo() {
		grabarRetiros();
	}
	
	private void grabarRetiros() {
		try {
			PrintWriter pw;
			String linea;
			Retiro x;
			pw = new PrintWriter(new FileWriter("Retiros.txt"));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				linea =	x.getNumRetiro() + ";" +
						x.getNumMatricula() + ";" +
						x.getFecha() + ";" +
						x.getHora();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	
	public void cargarRetiros() {
		try {
			BufferedReader br;
			String linea, fecha, hora;
			String[] s;
			int numRetiro, numMatricula;
			br = new BufferedReader(new FileReader("Retiros.txt"));
			while ((linea=br.readLine()) != null) {
				s = linea.split(";");
				numRetiro = Integer.parseInt(s[0].trim());
				numMatricula = Integer.parseInt(s[1].trim());
				fecha = s[2].trim();
				hora = s[3].trim();
				adicionar(new Retiro(numRetiro, numMatricula, fecha, hora));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
	
	public int codigoCorrelativo() {
		if (tamaño() == 0)
			return 200001;
		else
			return obtener(tamaño()-1).getNumRetiro() + 1;
	}
}