package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hilos.HiloLoader;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.SwingConstants;

public class frmLoader extends JFrame implements ChangeListener {

	private JPanel contentPane;
	public static JProgressBar progressBar;
	private JLabel lblNewLabel;
	private JLabel lblNombreEmpleado;
	private JLabel lblApellidoEmpleado;
	private JLabel lblSaludo;
	private String saludo = "ERROR";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLoader frame = new frmLoader();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmLoader() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.addChangeListener(this);
		progressBar.setStringPainted(true);
		progressBar.setBounds(10, 186, 430, 45);
		contentPane.add(progressBar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 40, 128, 128);
		contentPane.add(lblNewLabel);
		
		lblNombreEmpleado = new JLabel(frmLogin.user.getNombre());
		lblNombreEmpleado.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreEmpleado.setFont(new Font("Eras Demi ITC", Font.PLAIN, 22));
		lblNombreEmpleado.setBounds(148, 84, 250, 26);
		contentPane.add(lblNombreEmpleado);
		
		lblApellidoEmpleado = new JLabel(frmLogin.user.getApellido());
		lblApellidoEmpleado.setHorizontalAlignment(SwingConstants.LEFT);
		lblApellidoEmpleado.setFont(new Font("Eras Demi ITC", Font.PLAIN, 22));
		lblApellidoEmpleado.setBounds(148, 115, 250, 26);
		contentPane.add(lblApellidoEmpleado);
		
		int hora = Integer.parseInt(new SimpleDateFormat("HH").format(new Date()));
		System.out.println(hora);
		if(hora > 4 && hora < 12) {
			saludo = "BUENOS DIAS.";
		}else if(hora > 11 && hora < 19){
			saludo = "BUENAS TARDES.";
		}else if(hora > 18 || hora < 5){
			saludo = "BUENAS NOCHES.";
		}
		
		lblSaludo = new JLabel(saludo);
		lblSaludo.setHorizontalAlignment(SwingConstants.LEFT);
		lblSaludo.setFont(new Font("Eras Demi ITC", Font.PLAIN, 22));
		lblSaludo.setBounds(148, 40, 292, 26);
		contentPane.add(lblSaludo);
		switch (frmLogin.user.getGenero()) {
		case "men": {
			lblNewLabel.setIcon(new ImageIcon(frmLoader.class.getResource("/img/userMen.png")));break;
		}
		case "woman":{
			lblNewLabel.setIcon(new ImageIcon(frmLoader.class.getResource("/img/userWoman.png")));break;
		}
		default:
			break;
		}
		iniciarCarga();
	}
	public void iniciarCarga() {
		HiloLoader carga = new HiloLoader(this);
		carga.start();
	}
	public void stateChanged(ChangeEvent arg0) {
		if (arg0.getSource() == progressBar) {
			stateChangedProgressBar(arg0);
		}
	}
	protected void stateChangedProgressBar(ChangeEvent arg0) {
		if(progressBar.getValue() == 100) {
			frmPrincipal principal = new frmPrincipal();
			principal.setVisible(true);
			principal.setLocationRelativeTo(null);
			dispose();
		}
	}
}
