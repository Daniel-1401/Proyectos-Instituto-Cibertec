package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import mantemiento.GestionMantenimiento;
import modelos.RegistroCliente;
import modelos.TipoDocumento;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmRegistroCliente extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtCodCliente;
	private JTextField txtApellidoCli;
	private JTextField txtDirecCli;
	private JTextField txtTelef;
	private JTextField txtNumDoc;
	private JComboBox cboDocumento;
	private JTextField txtNombreCli;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroCliente frame = new FrmRegistroCliente();
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
	public FrmRegistroCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Clientes");
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
		lblNewLabel.setBounds(132, 30, 238, 19);
		contentPane.add(lblNewLabel);
		
		txtCodCliente = new JTextField();
		txtCodCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCodCliente.setEditable(true);
			}
		});
		txtCodCliente.setEditable(false);
		txtCodCliente.setColumns(10);
		txtCodCliente.setBounds(136, 67, 155, 20);
		contentPane.add(txtCodCliente);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo de Cliente:");
		lblNewLabel_1.setBounds(10, 70, 127, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellido:");
		lblNewLabel_1_1.setBounds(10, 133, 86, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtApellidoCli = new JTextField();
		txtApellidoCli.setColumns(10);
		txtApellidoCli.setBounds(134, 133, 157, 20);
		contentPane.add(txtApellidoCli);
		
		JLabel lblNewLabel_1_2 = new JLabel("Direcci\u00F3n:");
		lblNewLabel_1_2.setBounds(10, 172, 101, 14);
		contentPane.add(lblNewLabel_1_2);
		
		txtDirecCli = new JTextField();
		txtDirecCli.setColumns(10);
		txtDirecCli.setBounds(133, 175, 158, 20);
		contentPane.add(txtDirecCli);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarCliente();
	
			}
		});
		btnEliminar.setBounds(360, 81, 107, 23);
		contentPane.add(btnEliminar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCliente();
			}
		});
		btnBuscar.setBounds(360, 114, 108, 23);
		contentPane.add(btnBuscar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actulizarCliente();
			}
		});
		btnActualizar.setBounds(360, 147, 108, 23);
		contentPane.add(btnActualizar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevoCliente();
				txtCodCliente.setEditable(false);
			}
		});
		btnLimpiar.setBounds(267, 338, 89, 23);
		contentPane.add(btnLimpiar);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registro();

			}
		});
		btnRegistrar.setBounds(93, 338, 89, 23);
		contentPane.add(btnRegistrar);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Tel\u00E9fono:");
		lblNewLabel_1_2_1.setBounds(10, 211, 101, 14);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Tipo de Documento:");
		lblNewLabel_1_2_2.setBounds(10, 243, 114, 14);
		contentPane.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Num Documento:");
		lblNewLabel_1_2_3.setBounds(10, 275, 101, 14);
		contentPane.add(lblNewLabel_1_2_3);
		
		txtTelef = new JTextField();
		txtTelef.setColumns(10);
		txtTelef.setBounds(133, 211, 158, 20);
		contentPane.add(txtTelef);
		
		txtNumDoc = new JTextField();
		txtNumDoc.setColumns(10);
		txtNumDoc.setBounds(133, 278, 158, 20);
		contentPane.add(txtNumDoc);
		
		cboDocumento = new JComboBox();
		cboDocumento.setBounds(133, 245, 158, 22);
		contentPane.add(cboDocumento);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Nombre:");
		lblNewLabel_1_1_1.setBounds(10, 98, 85, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtNombreCli = new JTextField();
		txtNombreCli.setColumns(10);
		txtNombreCli.setBounds(134, 98, 157, 20);
		contentPane.add(txtNombreCli);
//		setLocationRelativeTo(null);
		
		listadoCombo();
		txtCodCliente.setText(ObtenerCodigoCliente());
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(this);
		btnNewButton.setPressedIcon(new ImageIcon(FrmRegistroCliente.class.getResource("/img/BOTON_CERRAR_1.png")));
		btnNewButton.setRolloverIcon(new ImageIcon(FrmRegistroCliente.class.getResource("/img/BOTON_CERRAR_2.png")));
		btnNewButton.setIcon(new ImageIcon(FrmRegistroCliente.class.getResource("/img/BOTON_CERRAR_1.png")));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(439, 10, 28, 28);
		contentPane.add(btnNewButton);
	}
	
	void actulizarCliente() {
		String idCliente, nombreCli, apellidoCli, direcCli, numDocumento;
		int numeroTel, idtipoDocumento;

		idCliente = leerNombreCli();

		
		/*int rs = new GestionMantenimiento().actulizar(idCliente);
		
		 if(rs == 0) {
			 JOptionPane.showMessageDialog(this, "Error al Actualizar");
		 }else {
			 JOptionPane.showMessageDialog(this, "Cliente " + idCliente + " a sido Actulizado");
		 }
		*/
	}
	
	void registro() {
		
		String idCliente, nombreCli, apellidoCli, direcCli, numDocumento;
		int numeroTel, idtipoDocumento;
		
		idCliente = leerCodCliente();
		nombreCli = leerNombreCli();
		apellidoCli = leerApellidoCli();
		direcCli = leerDirecCli();
		numDocumento = leerNumDocumento();
		numeroTel = leerNumeroTel();
		idtipoDocumento = leerIdTipoDocumento();
		
		RegistroCliente rc = new RegistroCliente();
		rc.setIdCliente(idCliente);
		rc.setNombreCliente(nombreCli);
		rc.setApellidoCliente(apellidoCli);
		rc.setDireccionCliente(direcCli);
		rc.setNumeroTelefonico(numeroTel);
		rc.setIdtipoDocumento(idtipoDocumento);
		rc.setNumeroDocumento(numDocumento);
		
		
		if (idCliente == null || nombreCli == null || apellidoCli == null || direcCli == null || numeroTel == 0
				|| idtipoDocumento == 0 || numDocumento == null) {
			JOptionPane.showMessageDialog(this, "Ingrese TODOS los datos requeridos");
		}else {
			GestionMantenimiento gm = new GestionMantenimiento();
			int rs = gm.registro(rc);
			JOptionPane.showMessageDialog(this, "Cliente " + "'" + rc.getNombreCliente() + " " 
										+ rc.getApellidoCliente() + "'" + " Registrado");
			nuevoCliente();
		}
		
	}
	
	/********** Buscar *******/
	void buscarCliente() {
		String idCliente = leerCodCliente();
		
		RegistroCliente r = new GestionMantenimiento().buscar(idCliente);
		
		if(r == null) {
			JOptionPane.showMessageDialog(this, "Cliente "+ idCliente + " No existe");
		}else {
			txtNombreCli.setText(r.getNombreCliente());
			txtApellidoCli.setText(r.getApellidoCliente());
			txtDirecCli.setText(r.getDireccionCliente());
			txtTelef.setText(r.getNumeroTelefonico() + "");
			cboDocumento.setSelectedIndex(r.getIdtipoDocumento());
			txtNumDoc.setText(r.getNumeroDocumento());;
			
		}
	}
	
	
	/******************** Eliminar **********************/
	
	void eliminarCliente() {
		
		String idCliente;
		idCliente = leerCodCliente();
		
		int rs = new GestionMantenimiento().eliminar(idCliente);
		
		 if(rs == 0) {
			 JOptionPane.showMessageDialog(this, "Error al Eliminar");
		 }else {
			 JOptionPane.showMessageDialog(this, "Cliente " + idCliente + " a sido Eliminado");
		 }
		
	}
	
	/******* NUEVO CLIENTE *******/
	void nuevoCliente() {
		txtNombreCli.setText("");
		txtApellidoCli.setText("");
		txtNumDoc.setText("");
		txtDirecCli.setText("");
		txtTelef.setText("");
		
		cboDocumento.setSelectedItem("--> Seleccione");
		txtCodCliente.setText(ObtenerCodigoCliente());
	}
	
	
	/******* COMBO *******/
	void listadoCombo() {
		ArrayList<TipoDocumento> lstTdocumento = new GestionMantenimiento().listadoDeDocumento();
		
		cboDocumento.addItem("--> Seleccione");
		for (TipoDocumento td : lstTdocumento) {
			cboDocumento.addItem(td.getIdTipoDocumento() + ".- " + td.getDescripcion());
		}
	}
	
	
	/***** Numero de Registro   *********/
	private String ObtenerCodigoCliente() {
		return new GestionMantenimiento().generarCodigoCliRegistro();
	}
	
	/****** Validaion **********/
	private String leerCodCliente() {
		
		return txtCodCliente.getText();
	}

	private String leerNombreCli() {
		
		if (txtNombreCli.getText().length()==0) {
			JOptionPane.showMessageDialog(this, "Nombre es un campo OBLIGATORIO");
			return null;
		}
		
		if(!txtNombreCli.getText().matches("^[a-zA-Záéíóú ]{3,50}$")) {
			JOptionPane.showMessageDialog(this, "Ingrese Caracteres correctos en Nombre", "Aviso", 2);
			return null;
		}
		return txtNombreCli.getText();
	}

	private String leerApellidoCli() {
		
		if (txtApellidoCli.getText().length()==0) {
			JOptionPane.showMessageDialog(this, "Apellido es un campo OBLIGATORIO");
			return null;
		}
		
		if(!txtApellidoCli.getText().matches("^[a-zA-Záéíóú ]{3,50}$")) {
			JOptionPane.showMessageDialog(this, "Ingrese Caracteres correctos en el APELLIDO", "Aviso", 2);
			return null;
		}
		
		return txtApellidoCli.getText();
	}

	private String leerDirecCli() {
		
		if (txtDirecCli.getText().length()==0) {
			JOptionPane.showMessageDialog(this, "La dirección es un campo OBLIGATORIO");
			return null;
		}
		
		if(!txtDirecCli.getText().matches("^[a-zA-Záéíóú0-9. ]{3,50}$")) {
			JOptionPane.showMessageDialog(this, "Ingrese Caracteres correctos en la DIRECCIÓN", "Aviso", 2);
			return null;
		}
		
		return txtDirecCli.getText();
		
	}
	
	private int leerIdTipoDocumento() {
		if (cboDocumento.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Seleccione un Tipo de Documento", "Aviso",2);
			return 0;
		}
		return cboDocumento.getSelectedIndex();
	}

	private String leerNumDocumento() {
		
		if (txtNumDoc.getText().length()==0) {
			JOptionPane.showMessageDialog(this, "El número de Documento es un campo OBLIGATORIO");
			return null;
			
		}else {
			switch (cboDocumento.getSelectedItem() + "" ) {
			
			case "DNI": {
				if(!txtNumDoc.getText().matches("^[0-9]{​​​​​8}​​​​​​$")) {
					JOptionPane.showMessageDialog(this, "DNI incorrecto", "Aviso", 2);
					return null;
				}
			}
			case "PASAPORTE":
				if(!txtNumDoc.getText().matches("^[A-Z]{​​​​​1}​​​​​​[0-9]$")) {
					JOptionPane.showMessageDialog(this, "Pasaporte Incorrecto", "Aviso", 2);
					return null;
				}
			}
		}


		return txtNumDoc.getText();
	}

	private int leerNumeroTel() {
		
		if (txtTelef.getText().length()==0) {
			JOptionPane.showMessageDialog(this, "El número de Teléfono es un campo OBLIGATORIO");
			return 0;
		}
		
		if(!txtTelef.getText().matches("^[0-9]{9}$")) {
			JOptionPane.showMessageDialog(this, "Ingrese Caracteres correctos en el Telefono", "Aviso", 2);
			return 0;
		}

		return Integer.parseInt(txtTelef.getText());
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
