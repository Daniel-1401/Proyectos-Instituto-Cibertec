package hilos;

import java.text.SimpleDateFormat;
import java.util.Date;
import vistas.frmLogin;

public class HiloReloj extends Thread {
	public void run() {
		while(true) {
			Date hora = new Date();
			frmLogin.lblReloj.setText(new SimpleDateFormat("HH:mm:ss").format(hora));
		}
		
	}
}
