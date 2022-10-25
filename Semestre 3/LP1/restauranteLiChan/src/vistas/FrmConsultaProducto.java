package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantemiento.GestionConsultas;
import modelos.RegistroCliente;
import modelos.RegistroProducto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmConsultaProducto extends JInternalFrame implements ActionListener {

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
					FrmConsultaProducto frame = new FrmConsultaProducto();
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
	public FrmConsultaProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListadoDePrdocutos = new JLabel("Listado de Productos");
		lblListadoDePrdocutos.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
		lblListadoDePrdocutos.setBounds(210, 26, 210, 30);
		contentPane.add(lblListadoDePrdocutos);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(this);
		btnNewButton.setSelectedIcon(new ImageIcon(FrmConsultaCliente.class.getResource("/img/BOTON_CERRAR_1.png")));
		btnNewButton.setRolloverIcon(new ImageIcon(FrmConsultaCliente.class.getResource("/img/BOTON_CERRAR_2.png")));
		btnNewButton.setIcon(new ImageIcon(FrmConsultaCliente.class.getResource("/img/BOTON_CERRAR_1.png")));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(583, 10, 28, 28);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 77, 581, 260);
		contentPane.add(scrollPane);
		
		tblSalida = new JTable();
		tblSalida.setModel(modelo);
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre Producto");
		modelo.addColumn("Precio");
		scrollPane.setViewportView(tblSalida);
		
		//setLocationRelativeTo(null);
		
		listadoProducto();
	}
	
	void listadoProducto() {
		ArrayList<RegistroProducto> lstConsultaPro = new GestionConsultas().listadoProducto();
		
		if(lstConsultaPro == null|| lstConsultaPro.size() == 0) {
			JOptionPane.showMessageDialog(this, "Listado Vacio");
		}else {
			for (RegistroProducto p : lstConsultaPro) {
				Object aDatos[] = {p.getIdProducto(), p.getNombreProducto(), p.getPrecioProducto()};
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
