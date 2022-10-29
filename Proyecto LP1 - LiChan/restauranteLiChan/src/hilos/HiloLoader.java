package hilos;

import javax.swing.JFrame;

import vistas.frmLoader;

public class HiloLoader extends Thread{
	
//	private JFrame ventana;
	
	public HiloLoader(JFrame ventana) {
//		super();
//		this.ventana = ventana;
	}

	public void run() {
		for(int i = 0; i <= 100; i++) {
			frmLoader.progressBar.setValue(i);
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
