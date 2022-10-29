package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmRegistroEmpleadosMenu extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblTitulo;
	private JButton btnAdministrador;
	private JButton btnRecepcionista;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroEmpleadosMenu frame = new FrmRegistroEmpleadosMenu();
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
	public FrmRegistroEmpleadosMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCerrar = new JButton("");
		btnCerrar.addActionListener(this);
		btnCerrar.setRolloverIcon(new ImageIcon(FrmRegistroEmpleado.class.getResource("/img/BOTON_CERRAR_2.png")));
		btnCerrar.setPressedIcon(new ImageIcon(FrmRegistroEmpleado.class.getResource("/img/BOTON_CERRAR_1.png")));
		btnCerrar.setIcon(new ImageIcon(FrmRegistroEmpleado.class.getResource("/img/BOTON_CERRAR_1.png")));
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setBorderPainted(false);
		btnCerrar.setBounds(430, 10, 28, 28);
		getContentPane().add(btnCerrar);
		
		lblTitulo = new JLabel("REGISTRAR:");
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 22));
		lblTitulo.setBounds(10, 37, 156, 28);
		contentPane.add(lblTitulo);
		
		btnAdministrador = new JButton("ADMINISTRADOR");
		btnAdministrador.addActionListener(this);
		btnAdministrador.setFont(new Font("Verdana", Font.BOLD, 16));
		btnAdministrador.setBounds(10, 75, 215, 178);
		contentPane.add(btnAdministrador);
		
		btnRecepcionista = new JButton("RECEPCIONISTA");
		btnRecepcionista.addActionListener(this);
		btnRecepcionista.setFont(new Font("Verdana", Font.BOLD, 16));
		btnRecepcionista.setBounds(251, 75, 205, 178);
		contentPane.add(btnRecepcionista);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnRecepcionista) {
			actionPerformedBtnRecepcionista(arg0);
		}
		if (arg0.getSource() == btnAdministrador) {
			actionPerformedBtnNewButton(arg0);
		}
		if(arg0.getSource() == btnCerrar) {
			accionCerrar(arg0);
		}
	}
	private void accionCerrar(ActionEvent arg0) {
		dispose();
	}
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
		FrmRegistroEmpleado.OpcionEmpleado = 1;
		frmPrincipal.panelContenedor.removeAll();
		FrmRegistroEmpleado frmRegistro = new FrmRegistroEmpleado();
		frmRegistro.setBounds(100, 100, 568, 430);
		frmPrincipal.panelContenedor.add(frmRegistro);
		frmRegistro.setVisible(true);
		dispose();
	}
	protected void actionPerformedBtnRecepcionista(ActionEvent arg0) {
		FrmRegistroEmpleado.OpcionEmpleado = 2;
		frmPrincipal.panelContenedor.removeAll();
		FrmRegistroEmpleado frmRegistro = new FrmRegistroEmpleado();
		frmRegistro.setBounds(100, 100, 568, 485);
		frmPrincipal.panelContenedor.add(frmRegistro);
		frmRegistro.setVisible(true);
		dispose();
	}
}
