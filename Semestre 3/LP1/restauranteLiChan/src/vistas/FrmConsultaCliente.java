package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantemiento.GestionConsultas;
import modelos.RegistroCliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class FrmConsultaCliente extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	
	DefaultTableModel modelo = new DefaultTableModel();
	private JTable tblSalida;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaCliente frame = new FrmConsultaCliente();
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
	public FrmConsultaCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listado de Clientes");
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
		lblNewLabel.setBounds(214, 22, 210, 30);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 85, 585, 241);
		contentPane.add(scrollPane);
		
		tblSalida = new JTable();
		tblSalida.setModel(modelo);
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre Compl.");
		modelo.addColumn("Direccion");
		modelo.addColumn("Telefono");
		modelo.addColumn("Documento");
		scrollPane.setViewportView(tblSalida);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(this);
		btnNewButton.setSelectedIcon(new ImageIcon(FrmConsultaCliente.class.getResource("/img/BOTON_CERRAR_1.png")));
		btnNewButton.setRolloverIcon(new ImageIcon(FrmConsultaCliente.class.getResource("/img/BOTON_CERRAR_2.png")));
		btnNewButton.setIcon(new ImageIcon(FrmConsultaCliente.class.getResource("/img/BOTON_CERRAR_1.png")));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(583, 10, 28, 28);
		contentPane.add(btnNewButton);
		
		listadoConsultaCliente();
	}
	
	void listadoConsultaCliente() {
		
		ArrayList<RegistroCliente> lstConsultaCli = new GestionConsultas().listadoCliente();
		
		if(lstConsultaCli == null || lstConsultaCli.size() == 0) {
			JOptionPane.showMessageDialog(this, "Listado Vacio");
		}else {
			for (RegistroCliente r : lstConsultaCli) {
				Object aDatos[] = {r.getIdCliente(),r.getNombreCliente() + " " + r.getApellidoCliente(),r.getDireccionCliente(),
								r.getNumeroTelefonico(),r.getNumeroDocumento()};
				modelo.addRow(aDatos);
			}
		}
		
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(arg0);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
		dispose();
	}
}
