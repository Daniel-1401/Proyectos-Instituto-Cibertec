package FuncionGenerales;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class FuncionesGenerales {
	
	public static void error(String Mnsj){
        JOptionPane.showMessageDialog(null, Mnsj, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
	public static int  confirmar(String Mnsj){
		int input = JOptionPane.showConfirmDialog(null,Mnsj, "ALERTA",JOptionPane.YES_NO_OPTION);
		
		return input;
    }
	public static String MayCorrespondiente(String S) {
		char[] caracteres = S.toCharArray();
		caracteres[0] = Character.toUpperCase(caracteres[0]);
		for (int i = 0; i < S.length() - 2; i++) {
			if (caracteres[i] == ' ') {
				caracteres[i + 1] = Character.toUpperCase(caracteres[i+1]);
			}
		}
		return new String(caracteres); 
	}
	public static void HabilitarBotones(boolean X,
			JButton A, JButton B, JButton C 
			, JButton D, JButton E) {
		A.setEnabled(X);
		B.setEnabled(X);
		C.setEnabled(X);
		D.setEnabled(X);
		E.setEnabled(X);

	}
	public static void MostrarDatos(String Mnsj) {
		int input = JOptionPane.showConfirmDialog(null,Mnsj, "DATOS:", JOptionPane.DEFAULT_OPTION);
	}
	public static void mensaje(String Mnsj) {
		JOptionPane.showMessageDialog(null, Mnsj);
	}
}
