package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hilos.HiloReloj;
import mantemiento.GestionAcceso;
import modelos.Acceso;
import utils.ConectorBD;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class frmLogin extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtUser;
	private JButton btnIniciarSesion;
	private JPasswordField txtPass;
	public static JLabel lblReloj;
	public static Acceso user = new Acceso();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
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
	public frmLogin() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblNewLabel.setBounds(45, 264, 84, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblPassword.setBounds(45, 339, 82, 18);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel_1 = new JLabel("BIENVENIDO");
		lblNewLabel_1.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		lblNewLabel_1.setBounds(70, 209, 190, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel imgLogin = new JLabel("");
		imgLogin.setIcon(new ImageIcon(frmLogin.class.getResource("/img/loginGit.png")));
		imgLogin.setBounds(100, 59, 130, 130);
		contentPane.add(imgLogin);
		
		JLabel imgUser = new JLabel("");
		imgUser.setIcon(new ImageIcon(frmLogin.class.getResource("/img/imgUser.png")));
		imgUser.setBounds(45, 292, 20, 20);
		contentPane.add(imgUser);
		
		JLabel imgPass = new JLabel("");
		imgPass.setIcon(new ImageIcon(frmLogin.class.getResource("/img/imgPass.png")));
		imgPass.setBounds(45, 367, 20, 20);
		contentPane.add(imgPass);
		
		btnIniciarSesion = new JButton("INICIAR SESION");
		btnIniciarSesion.addActionListener(this);
		btnIniciarSesion.setFont(new Font("Ebrima", Font.BOLD, 15));
		btnIniciarSesion.setBounds(25, 426, 280, 50);
		contentPane.add(btnIniciarSesion);
		
		txtUser = new JTextField();
		txtUser.setBounds(75, 290, 200, 27);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setSelectedIcon(null);
		btnNewButton_1.setPressedIcon(new ImageIcon(frmLogin.class.getResource("/img/BOTON_CERRAR_1.png")));
		btnNewButton_1.setRolloverIcon(new ImageIcon(frmLogin.class.getResource("/img/BOTON_CERRAR_2.png")));
		btnNewButton_1.setIcon(new ImageIcon(frmLogin.class.getResource("/img/BOTON_CERRAR_1.png")));
		btnNewButton_1.setBounds(292, 10, 28, 28);
		contentPane.add(btnNewButton_1);
		
		lblReloj = new JLabel("00:00:00");
		lblReloj.setHorizontalAlignment(SwingConstants.CENTER);
		lblReloj.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblReloj.setBounds(10, 10, 119, 19);
		contentPane.add(lblReloj);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(75, 364, 200, 27);
		contentPane.add(txtPass);
		iniciarReloj();
		conectarbd();
	}
	private void iniciarReloj() {
		HiloReloj reloj = new HiloReloj();
		reloj.start();
	}
	public void conectarbd() {
		ConectorBD conexion = new ConectorBD();
		conexion.getConexion();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnIniciarSesion) {
			IniciarSesion(arg0);
		}
	}
	protected void IniciarSesion(ActionEvent arg0) {
		String usuarios = txtUser.getText();
		String contraseña = String.valueOf(txtPass.getPassword());
		user = new GestionAcceso().loginAccess(usuarios, contraseña);
		if(user == null) {
			System.out.println(usuarios);
			System.out.println(contraseña);
			alerta("USUARIO O CLAVE INCORRECTA");
		}else {
			frmLoader loader = new frmLoader();
			loader.setVisible(true);
			dispose();
			loader.setLocationRelativeTo(null);
		}
		
	}
	private void alerta(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
}
