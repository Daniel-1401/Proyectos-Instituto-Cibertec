package vistas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.net.IDN;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

import com.itextpdf.text.xml.XmlToTxt;
import com.toedter.calendar.JDateChooser;

import mantemiento.GestionEmpleado;
import mantemiento.GestionMantenimiento;
import mantemiento.GestionVenta;
import modelos.EmpleadoAdmin;
import modelos.EmpleadoRecep;
import modelos.TipoDocumento;

public class FrmRegistroEmpleado extends /**/JInternalFrame implements ActionListener {
	private JButton btnCerrar;
	private JLabel lblCodigo;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblTipodocumentp;
	private JLabel lblFechaDeNacimiento;
	private JLabel lblGenero;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JLabel lblNumeroDeDoc;
	private JTextField txtCodigo;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtNroDocumento;
	private JTextField txtGenero;
	private JTextField txtUsuario;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JComboBox cboTipoDocumento;
	private JDateChooser dtFecha;
	private JLabel lblSueldo;
	private JTextField txtSueldo;
	private JLabel lblNumeroDeHoras;
	private JTextField txtNumHorasPorDia;
	private JLabel lblDiasLaborales;
	private JTextField txtDiasLaborales;
	private JLabel lblPagoPorHora;
	private JTextField txtPagoPorHora;
	private JButton btnRegistrar;
	private JButton btnEliminar;
	private JButton btnActualizar;
	private JButton btnBuscar;
	private JButton btnNuevoRegistro;
	public static int OpcionEmpleado = 1;
	private String Titulo = "";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroEmpleado frame = new FrmRegistroEmpleado();
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
	public FrmRegistroEmpleado() {
		setBounds(100, 100, 568, 485);
		switch(OpcionEmpleado) {
		case 1:
			Titulo = "REGISTRAR ADMINISTRADOR";
				break;
		default:	
			Titulo = "REGISTRAR RECEPCIONISTA";
				break;
		}
		getContentPane().setLayout(null);
		
		btnCerrar = new JButton("");
		btnCerrar.addActionListener(this);
		btnCerrar.setRolloverIcon(new ImageIcon(FrmRegistroEmpleado.class.getResource("/img/BOTON_CERRAR_2.png")));
		btnCerrar.setPressedIcon(new ImageIcon(FrmRegistroEmpleado.class.getResource("/img/BOTON_CERRAR_1.png")));
		btnCerrar.setIcon(new ImageIcon(FrmRegistroEmpleado.class.getResource("/img/BOTON_CERRAR_1.png")));
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setBorderPainted(false);
		btnCerrar.setBounds(473, 10, 28, 28);
		getContentPane().add(btnCerrar);
		
		lblNewLabel = new JLabel(Titulo);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		lblNewLabel.setBounds(75, 10, 334, 63);
		getContentPane().add(lblNewLabel);
		
		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCodigo.setBounds(10, 83, 200, 20);
		getContentPane().add(lblCodigo);
		
		lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombres.setBounds(10, 113, 200, 20);
		getContentPane().add(lblNombres);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblApellidos.setBounds(10, 143, 200, 20);
		getContentPane().add(lblApellidos);
		
		lblTipodocumentp = new JLabel("TipoDocumento");
		lblTipodocumentp.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTipodocumentp.setBounds(10, 173, 200, 20);
		getContentPane().add(lblTipodocumentp);
		
		lblNumeroDeDoc = new JLabel("Numero de Documento:");
		lblNumeroDeDoc.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNumeroDeDoc.setBounds(10, 203, 200, 20);
		getContentPane().add(lblNumeroDeDoc);

		lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFechaDeNacimiento.setBounds(10, 233, 200, 20);
		getContentPane().add(lblFechaDeNacimiento);
		
		lblGenero = new JLabel("Genero:");
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGenero.setBounds(10, 263, 200, 20);
		getContentPane().add(lblGenero);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsuario.setBounds(10, 293, 200, 20);
		getContentPane().add(lblUsuario);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblContrasea.setBounds(10, 323, 200, 20);
		getContentPane().add(lblContrasea);
		
		txtCodigo = new JTextField();
		txtCodigo.setText("A/R0001");
		txtCodigo.setBounds(220, 83, 150, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBounds(220, 113, 150, 20);
		getContentPane().add(txtNombres);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(220, 143, 150, 20);
		getContentPane().add(txtApellidos);
		
		cboTipoDocumento = new JComboBox();
		cboTipoDocumento.setBounds(220, 173, 150, 20);
		getContentPane().add(cboTipoDocumento);

		txtNroDocumento = new JTextField();
		txtNroDocumento.setColumns(10);
		txtNroDocumento.setBounds(220, 203, 150, 20);
		getContentPane().add(txtNroDocumento);

		dtFecha = new JDateChooser();
		dtFecha.setBounds(220, 233, 150, 20);
		getContentPane().add(dtFecha);
		
		txtGenero = new JTextField();
		txtGenero.setColumns(10);
		txtGenero.setBounds(220, 263, 150, 20);
		getContentPane().add(txtGenero);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(220, 293, 150, 20);
		getContentPane().add(txtUsuario);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(220, 323, 150, 20);
		getContentPane().add(passwordField);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Verdana", Font.BOLD, 13));
		btnEliminar.setBounds(381, 80, 165, 50);
		getContentPane().add(btnEliminar);
		
		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(this);
		btnActualizar.setFont(new Font("Verdana", Font.BOLD, 13));
		btnActualizar.setBounds(381, 140, 165, 50);
		getContentPane().add(btnActualizar);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(this);
		btnBuscar.setFont(new Font("Verdana", Font.BOLD, 13));
		btnBuscar.setBounds(381, 200, 165, 50);
		getContentPane().add(btnBuscar);

		
		switch(OpcionEmpleado) {
			case 1:
				
				lblSueldo = new JLabel("Sueldo:");
				lblSueldo.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblSueldo.setBounds(10, 353, 200, 20);
				getContentPane().add(lblSueldo);
				
				txtSueldo = new JTextField();
				txtSueldo.setColumns(10);
				txtSueldo.setBounds(220, 353, 150, 20);
				getContentPane().add(txtSueldo);
				
				btnNuevoRegistro = new JButton("NUEVO REGISTRO");
				btnNuevoRegistro.addActionListener(this);
				btnNuevoRegistro.setFont(new Font("Verdana", Font.BOLD, 13));
				btnNuevoRegistro.setBounds(380, 260, 165, 50);
				getContentPane().add(btnNuevoRegistro);
				
				btnRegistrar = new JButton("REGISTRAR");
				btnRegistrar.addActionListener(this);
				btnRegistrar.setFont(new Font("Verdana", Font.BOLD, 13));
				btnRegistrar.setBounds(380, 320, 165, 50);
				getContentPane().add(btnRegistrar);

				break;
			case 2:
				lblNumeroDeHoras = new JLabel("Numero de horas por dia");
				lblNumeroDeHoras.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblNumeroDeHoras.setBounds(10, 353, 200, 20);
				getContentPane().add(lblNumeroDeHoras);
				
				txtNumHorasPorDia = new JTextField();
				txtNumHorasPorDia.setColumns(10);
				txtNumHorasPorDia.setBounds(220, 353, 150, 20);
				getContentPane().add(txtNumHorasPorDia);
				
				lblDiasLaborales = new JLabel("Dias laborales:");
				lblDiasLaborales.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblDiasLaborales.setBounds(10, 383, 200, 20);
				getContentPane().add(lblDiasLaborales);
				
				txtDiasLaborales = new JTextField();
				txtDiasLaborales.setColumns(10);
				txtDiasLaborales.setBounds(220, 383, 150, 20);
				getContentPane().add(txtDiasLaborales);
				
				lblPagoPorHora = new JLabel("Pago por hora:");
				lblPagoPorHora.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblPagoPorHora.setBounds(10, 413, 200, 20);
				getContentPane().add(lblPagoPorHora);
				
				txtPagoPorHora = new JTextField();
				txtPagoPorHora.setColumns(10);
				txtPagoPorHora.setBounds(220, 413, 150, 20);
				getContentPane().add(txtPagoPorHora);
				
				btnNuevoRegistro = new JButton("NUEVO REGISTRO");
				btnNuevoRegistro.setFont(new Font("Verdana", Font.BOLD, 13));
				btnNuevoRegistro.addActionListener(this);
				btnNuevoRegistro.setBounds(380, 308, 165, 50);
				getContentPane().add(btnNuevoRegistro);
				
				btnRegistrar = new JButton("REGISTRAR");
				btnRegistrar.setFont(new Font("Verdana", Font.BOLD, 13));
				btnRegistrar.addActionListener(this);
				btnRegistrar.setBounds(381, 383, 165, 50);
				getContentPane().add(btnRegistrar);
				break;
		}
		
		txtCodigo.setText(ObtenerCodEmpleado());
		listadoCombo();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
		if (arg0.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			btnCerrar(arg0);
		}
		if (arg0.getSource() == btnRegistrar) {
			actionPerformedbtnRegistrar(arg0);
		}
		if (arg0.getSource() == btnNuevoRegistro) {
			actionPerformedbtnNuevoRegistro(arg0);
		}
	}
	protected void btnCerrar(ActionEvent arg0) {
		dispose();
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
	}
	protected void actionPerformedBtnActualizar(ActionEvent arg0) {
	}
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
	}
	protected void actionPerformedbtnRegistrar(ActionEvent arg0) {
		
		String idEmpleado, nomEmpleado, apelliEmpleado, genero,
				fechaNacimiento, usuario, pass, numeroDocumento;
		int tipoDocumento;
		double sueldo;
		
		int numHorasPorDia, diasLaborales;
		double pagoPorHora;
		
		idEmpleado = leerNombre();
		nomEmpleado = leerApellido();
		apelliEmpleado = leerCodigo();
		tipoDocumento = leerTipoDocumento();
		fechaNacimiento = leerFecha();
		genero = leerGenero();
		usuario = leerUsuario();
		numeroDocumento = leerNumDoc();
		pass = leerContra();
		
		sueldo = leerSueldo();
		
		pagoPorHora = leerPagoHora();
		diasLaborales = leerHorasLab();
		numHorasPorDia = leerDiasLab();
		
		if (OpcionEmpleado == 1) {
			leerSueldo();
		}else {
			leerPagoHora();
			leerHorasLab();
			leerDiasLab();	
		}
		
		
		EmpleadoRecep ep = new EmpleadoRecep();
		ep.setIdEmpleado(idEmpleado);
		ep.setNombreEmpleado(nomEmpleado);
		ep.setApellidoEmpleado(apelliEmpleado);
		ep.setGenero(genero);
		ep.setFechaNacimiento(fechaNacimiento);
		ep.setUser(usuario);
		ep.setPass(pass);
		ep.setNumeroDocumento(numeroDocumento);
		ep.setIdTipoDocumento(tipoDocumento);
		ep.setNumHorasPorDia(numHorasPorDia);
		ep.setPagoPorHora(pagoPorHora);
		ep.setDiasLaborales(diasLaborales);
		
		if (idEmpleado == null || nomEmpleado == null || apelliEmpleado == null || genero == null || fechaNacimiento == null
				|| usuario == null || pass == null || numeroDocumento == null || tipoDocumento == 0 || numHorasPorDia == 0
						|| pagoPorHora == 0 || diasLaborales== 0 ) {
			JOptionPane.showMessageDialog(this, "Ingrese TODOS los datos requeridos");
		}else {
			GestionEmpleado e = new GestionEmpleado();
			int rs = e.registrarEmpleadoRecep(ep);
			JOptionPane.showMessageDialog(this, "Empleado " + "'" + ep.getNombreEmpleado() + " " 
										+ ep.getApellidoEmpleado() + "'" + " Registrado");

		}
	
		
	}
	protected void actionPerformedbtnNuevoRegistro(ActionEvent arg0) {
		dispose();
		frmPrincipal.panelContenedor.removeAll();
		FrmRegistroEmpleadosMenu frm = new FrmRegistroEmpleadosMenu();
		frm.setBounds(100, 100, 480, 300);
		frmPrincipal.panelContenedor.add(frm);
		frm.setVisible(true);
		
	}
	
	/******************************
	 * 
	 */
	
	/***** Numero de Registro   *********/
	private String ObtenerCodEmpleado() {

		return new GestionEmpleado().generarCodigo(OpcionEmpleado);
	}
	
	/******* COMBO *******/
	void listadoCombo() {
		ArrayList<TipoDocumento> lstTdocumento = new GestionMantenimiento().listadoDeDocumento();
		
		cboTipoDocumento.addItem("--> Seleccione");
		for (TipoDocumento td : lstTdocumento) {
			cboTipoDocumento.addItem(td.getIdTipoDocumento() + ".- " + td.getDescripcion());
		}
	}
	
	private String leerCodigo() {

		return txtCodigo.getText();
	}
	
	private String leerNombre() {
		if (txtNombres.getText().length()==0) {
			JOptionPane.showMessageDialog(this, "Nombre es un campo OBLIGATORIO");
			return null;
		}
		
		if(!txtNombres.getText().matches("^[a-zA-Záéíóú ]{3,50}$")) {
			JOptionPane.showMessageDialog(this, "Ingrese Caracteres correctos en Nombre", "Aviso", 2);
			return null;
		}
		
		
		return txtNombres.getText();
	}
	
	private String leerApellido() {
		
		if (txtApellidos.getText().length()==0) {
			JOptionPane.showMessageDialog(this, "Apellido es un campo OBLIGATORIO");
			return null;
		}
		
		if(!txtApellidos.getText().matches("^[a-zA-Záéíóú ]{3,50}$")) {
			JOptionPane.showMessageDialog(this, "Ingrese Caracteres correctos en Apellido", "Aviso", 2);
			return null;
		}
		
		return txtApellidos.getText();
	}
	
	private int leerTipoDocumento() {
		if (cboTipoDocumento.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Seleccione un Tipo de Documento", "Aviso",2);
			return 0;
		}
		return cboTipoDocumento.getSelectedIndex();
	}
	
	private String leerNumDoc() {
		
		if (txtNroDocumento.getText().length()==0) {
			JOptionPane.showMessageDialog(this, "El número de Documento es un campo OBLIGATORIO");
			return null;
			
		}else {
			switch (cboTipoDocumento.getSelectedItem() + "" ) {
			
			case "DNI": {
				if(!txtNroDocumento.getText().matches("^[0-9]{​​​​​8}​​​​​​$")) {
					JOptionPane.showMessageDialog(this, "DNI incorrecto", "Aviso", 2);
					return null;
				}
			}
			case "PASAPORTE":
				if(!txtNroDocumento.getText().matches("^[A-Z]{​​​​​1}​​​​​​[0-9]$")) {
					JOptionPane.showMessageDialog(this, "Pasaporte Incorrecto", "Aviso", 2);
					return null;
				}
			}
		}
		
		return txtNroDocumento.getText();
	}
	
	private String leerFecha() {
		
		if(dtFecha.getDate() == null){
			JOptionPane.showMessageDialog(this, "Seleccione fecha es obligatorio", "Alerta", 2);
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); 
		return sdf.format(dtFecha.getDate());
	}
	
	private String leerGenero() {
		
		if (txtGenero.getText().length()==0) {
			JOptionPane.showMessageDialog(this, "Genero es un campo OBLIGATORIO");
			return null;
		}
		
		if(!txtGenero.getText().matches("^[a-zA-Záéíóú ]{3,50}$")) {
			JOptionPane.showMessageDialog(this, "Ingrese Caracteres correctos en Genero", "Aviso", 2);
			return null;
		}
		
		return txtGenero.getText();
	}
	
	private String leerUsuario() {
		
		if (txtUsuario.getText().length()==0) {
			JOptionPane.showMessageDialog(this, "Usuario es un campo OBLIGATORIO");
			return null;
		}
		
		if(!txtUsuario.getText().matches("")) {/*^[A-Z]{​​​​​2}[0-9]​​​​​{​​​​​2}$*/
			JOptionPane.showMessageDialog(this, "Ingrese Caracteres correctos en Usuario", "Aviso", 2);
			return null;
		}
		
		return txtUsuario.getText();

	}
	
	private String leerContra() {
		
		if (String.valueOf(passwordField.getPassword()).length()==0) {
			JOptionPane.showMessageDialog(this, "Contraseña es un campo OBLIGATORIO");
			return null;
		}
		
		if(!String.valueOf(passwordField.getPassword()).matches("")) { /*^[A-Z0-9]{​​​​​7}$*/
			JOptionPane.showMessageDialog(this, "Ingrese Caracteres correctos en Contraseña", "Aviso", 2);
			return null;
		}
		
		return String.valueOf(passwordField.getPassword());
	}
	
	private double leerSueldo() {
		if (txtSueldo.getText().length()==0) {
			JOptionPane.showMessageDialog(this, "Sueldo es un campo OBLIGATORIO");
			return 0;
		}
		
		if(!txtSueldo.getText().matches("^[0-9]{1,2}+([.][0-9]{1,2})?$")) {
			JOptionPane.showMessageDialog(this, "Ingrese Caracteres correctos en el Sueldo", "Aviso", 2);
			return 0;
		}
		return Double.parseDouble(txtSueldo.getText());
	}
	
	
	private double leerPagoHora(){
		if (txtPagoPorHora.getText().length()==0) {
			JOptionPane.showMessageDialog(this, "Pago Por Hora es un campo OBLIGATORIO");
			return 0;
		}
		
		if(!txtPagoPorHora.getText().matches("^[0-9]{1,2}+([.][0-9]{1,2})?$")) {
			JOptionPane.showMessageDialog(this, "Ingrese Caracteres correctos en el Pago Por Hora", "Aviso", 2);
			return 0;
		}
		return Double.parseDouble(txtPagoPorHora.getText());
	}
	
	private int leerHorasLab(){
		if (txtNumHorasPorDia.getText().length()==0) {
			JOptionPane.showMessageDialog(this, "Horas Por Dia es un campo OBLIGATORIO");
			return 0;
		}
		
		if(!txtNumHorasPorDia.getText().matches("^[0-9]{1,2}$")) {
			JOptionPane.showMessageDialog(this, "Ingrese Caracteres correctos en el Horas Por Dia", "Aviso", 2);
			return 0;
		}
		return Integer.parseInt(txtNumHorasPorDia.getText());
	}
	
	private int leerDiasLab(){
		
		if (txtDiasLaborales.getText().length()==0) {
			JOptionPane.showMessageDialog(this, "Dias Laborales es un campo OBLIGATORIO");
			return 0;
		}
		
		if(!txtDiasLaborales.getText().matches("^[0-9]{1,2}$")) {
			JOptionPane.showMessageDialog(this, "Ingrese Caracteres correctos en Dias Laborales", "Aviso", 2);
			return 0;
		}
		return Integer.parseInt(txtDiasLaborales.getText());
	}
	
	
	
	
	
	
	
	
}
