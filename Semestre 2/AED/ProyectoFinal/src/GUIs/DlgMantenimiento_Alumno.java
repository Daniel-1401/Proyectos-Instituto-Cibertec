package GUIs;

import Libreria.Lib;
import Clases.Alumno;
import FuncionGenerales.FuncionesGenerales;
import Arreglos.ArregloAlumno;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import ConectorBD.Conexion;


class DlgMantenimiento_Alumno extends JDialog implements ActionListener, KeyListener, MouseListener, MouseMotionListener {
	
	
	private JTextField txtCodigoAlumno;
	private JTextField txtNombresAlumno;
	private JTextField txtApellidoAlumno;
	private JTextField txtDniAlumno;
	private JTextField txtEdadAlumno;
	private JTextField txtCelularAlumno;
	private JTextField txtEstadoAlumno;
	private JTable tblAlumnos;
	private DefaultTableModel modelo;
	private JButton btnAceptar;
	private JButton btnAdicionar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnCerrar;
	private JButton btnBuscar;
	private JButton btnConsultar;
	private JComboBox<String> cboEstadoAlumno;
	private JScrollPane scrollPane;
	private JLabel MOVIMIENTO;
	private int xx, xy;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgMantenimiento_Alumno dialog = new DlgMantenimiento_Alumno();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgMantenimiento_Alumno() {
		setUndecorated(true);
		
		setResizable(false);
		
		setBounds(100, 100, 700, 500);
		getContentPane().setLayout(null);
		
		JLabel lblImgAlumno = new JLabel("");
		lblImgAlumno.setBounds(366, 57, 155, 155);
		lblImgAlumno.setIcon(new ImageIcon("imagenes/Alumno_img.png"));
		getContentPane().add(lblImgAlumno);
		
		JLabel lblCodigo = new JLabel("CODIGO: ");
		lblCodigo.setBounds(10, 38, 64, 20);
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblCodigo);
		
		JLabel lblNombre = new JLabel("NOMBRES:");
		lblNombre.setBounds(10, 68, 70, 20);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblNombre);
		
		JLabel lblApellidos = new JLabel("APELLIDOS:");
		lblApellidos.setBounds(10, 98, 78, 20);
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblApellidos);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(10, 128, 30, 20);
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblDni);
		
		JLabel lblEdad = new JLabel("EDAD:");
		lblEdad.setBounds(10, 158, 41, 20);
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblEdad);
		
		JLabel lblCelular = new JLabel("CELULAR:");
		lblCelular.setBounds(10, 188, 63, 20);
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblCelular);
		
		JLabel lblEstado = new JLabel("ESTADO:");
		lblEstado.setBounds(10, 218, 58, 20);
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblEstado);
		
		MOVIMIENTO = new JLabel("");
		MOVIMIENTO.addMouseMotionListener(this);
		MOVIMIENTO.addMouseListener(this);
		MOVIMIENTO.setBounds(0, 0, 649, 28);
		getContentPane().add(MOVIMIENTO);
		
		txtCodigoAlumno = new JTextField();
		txtCodigoAlumno.setBounds(95, 38, 102, 20);
		txtCodigoAlumno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(txtCodigoAlumno);
		txtCodigoAlumno.setColumns(10);
		
		txtNombresAlumno = new JTextField();
		txtNombresAlumno.setBounds(95, 68, 220, 20);
		txtNombresAlumno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombresAlumno.setColumns(10);
		getContentPane().add(txtNombresAlumno);
		
		txtApellidoAlumno = new JTextField();
		txtApellidoAlumno.setBounds(95, 98, 220, 20);
		txtApellidoAlumno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtApellidoAlumno.setColumns(10);
		getContentPane().add(txtApellidoAlumno);
		
		txtDniAlumno = new JTextField();
		txtDniAlumno.setBounds(95, 128, 102, 20);
		txtDniAlumno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDniAlumno.setColumns(10);
		getContentPane().add(txtDniAlumno);
		
		txtEdadAlumno = new JTextField();
		txtEdadAlumno.setBounds(95, 158, 102, 20);
		txtEdadAlumno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEdadAlumno.setColumns(10);
		getContentPane().add(txtEdadAlumno);
		
		txtCelularAlumno = new JTextField();
		txtCelularAlumno.setBounds(95, 188, 102, 20);
		txtCelularAlumno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCelularAlumno.setColumns(10);
		getContentPane().add(txtCelularAlumno);
		
		cboEstadoAlumno = new JComboBox();
		cboEstadoAlumno.setBounds(95, 218, 102, 20);
		cboEstadoAlumno.setModel(new DefaultComboBoxModel <String> (Lib.categoriaAlumno));
		cboEstadoAlumno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(cboEstadoAlumno);
		
		btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.setBounds(575, 98, 110, 40);
		btnAdicionar.addMouseListener(this);
		btnAdicionar.addActionListener(this);
		btnAdicionar.setPressedIcon(new ImageIcon("imagenes/BOTON_AME_1.png"));
		btnAdicionar.setRolloverIcon(new ImageIcon("imagenes/BOTON_AME_2.png"));
		btnAdicionar.setIcon(new ImageIcon("imagenes/BOTON_AME_1.png"));
		btnAdicionar.setVerticalTextPosition(SwingConstants.CENTER);
		btnAdicionar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAdicionar.setFont(new Font("Consolas", Font.BOLD, 16));
		btnAdicionar.setFocusable(false);
		btnAdicionar.setFocusTraversalKeysEnabled(false);
		btnAdicionar.setFocusPainted(false);
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setBorderPainted(false);
		btnAdicionar.setBorder(null);
		btnAdicionar.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(btnAdicionar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(575, 148, 110, 40);
		btnModificar.addMouseListener(this);
		btnModificar.addActionListener(this);
		btnModificar.setPressedIcon(new ImageIcon("imagenes/BOTON_AME_1.png"));
		btnModificar.setRolloverIcon(new ImageIcon("imagenes/BOTON_AME_2.png"));
		btnModificar.setIcon(new ImageIcon("imagenes/BOTON_AME_1.png"));
		btnModificar.setVerticalTextPosition(SwingConstants.CENTER);
		btnModificar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnModificar.setFont(new Font("Consolas", Font.BOLD, 16));
		btnModificar.setFocusable(false);
		btnModificar.setFocusTraversalKeysEnabled(false);
		btnModificar.setFocusPainted(false);
		btnModificar.setContentAreaFilled(false);
		btnModificar.setBorderPainted(false);
		btnModificar.setBorder(null);
		btnModificar.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(575, 198, 110, 40);
		btnEliminar.addMouseListener(this);
		btnEliminar.addActionListener(this);
		btnEliminar.setPressedIcon(new ImageIcon("imagenes/BOTON_AME_1.png"));
		btnEliminar.setRolloverIcon(new ImageIcon("imagenes/BOTON_AME_2.png"));
		btnEliminar.setIcon(new ImageIcon("imagenes/BOTON_AME_1.png"));
		btnEliminar.setVerticalTextPosition(SwingConstants.CENTER);
		btnEliminar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEliminar.setFont(new Font("Consolas", Font.BOLD, 16));
		btnEliminar.setFocusable(false);
		btnEliminar.setFocusTraversalKeysEnabled(false);
		btnEliminar.setFocusPainted(false);
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setBorderPainted(false);
		btnEliminar.setBorder(null);
		btnEliminar.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(btnEliminar);
		
		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setBorderPainted(false);
		btnAceptar.setContentAreaFilled(false);
		btnAceptar.setBounds(205, 128, 110, 110);
		btnAceptar.addMouseListener(this);
		btnAceptar.addActionListener(this);
		btnAceptar.setPressedIcon(new ImageIcon("imagenes/BotonAceptar1.png"));
		btnAceptar.setRolloverIcon(new ImageIcon("imagenes/BotonAceptar2.png"));
		btnAceptar.setIcon(new ImageIcon("imagenes/BotonAceptar1.png"));
		btnAceptar.setVerticalTextPosition(SwingConstants.CENTER);
		btnAceptar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAceptar.setFont(new Font("Consolas", Font.BOLD, 16));
		btnAceptar.setFocusable(false);
		btnAceptar.setFocusTraversalKeysEnabled(false);
		btnAceptar.setFocusPainted(false);
		btnAceptar.setBorder(null);
		btnAceptar.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(btnAceptar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 248, 675, 242);
		getContentPane().add(scrollPane);
		
		tblAlumnos = new JTable();
		tblAlumnos.addKeyListener(this);
		tblAlumnos.addMouseListener(this);
		tblAlumnos.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblAlumnos);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("codAlumno");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("DNI");
		modelo.addColumn("Edad");
		modelo.addColumn("Celular");
		modelo.addColumn("Estado");
		
		tblAlumnos.setModel(modelo);
		txtCodigoAlumno.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("MANTENIMIENO | ALUMNO");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 5, 220, 20);
		getContentPane().add(lblNewLabel);
		
		btnCerrar = new JButton("");
		btnCerrar.addActionListener(this);
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setBorderPainted(false);
		btnCerrar.setRolloverIcon(new ImageIcon("imagenes\\BOTON_CERRAR_2.png"));
		btnCerrar.setPressedIcon(new ImageIcon("imagenes\\BOTON_CERRAR_1.png"));
		btnCerrar.setSelectedIcon(null);
		btnCerrar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCerrar.setIcon(new ImageIcon("imagenes\\BOTON_CERRAR_1.png"));
		btnCerrar.setBounds(662, 5, 28, 28);
		getContentPane().add(btnCerrar);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.addMouseListener(this);
		btnBuscar.addActionListener(this);
		btnBuscar.setPressedIcon(new ImageIcon("imagenes\\BOTON_AME_1.png"));
		btnBuscar.setRolloverSelectedIcon(null);
		btnBuscar.setRolloverIcon(new ImageIcon("imagenes\\BOTON_AME_2.png"));
		btnBuscar.setIcon(new ImageIcon("imagenes\\BOTON_AME_1.png"));
		btnBuscar.setVerticalTextPosition(SwingConstants.CENTER);
		btnBuscar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBuscar.setFont(new Font("Consolas", Font.BOLD, 16));
		btnBuscar.setFocusable(false);
		btnBuscar.setFocusTraversalKeysEnabled(false);
		btnBuscar.setFocusPainted(false);
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setBorderPainted(false);
		btnBuscar.setBorder(null);
		btnBuscar.setBackground(Color.LIGHT_GRAY);
		btnBuscar.setBounds(205, 25, 110, 40);
		getContentPane().add(btnBuscar);
		
		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addMouseListener(this);
		btnConsultar.addActionListener(this);
		btnConsultar.setPressedIcon(new ImageIcon("imagenes\\BOTON_AME_1.png"));
		btnConsultar.setRolloverIcon(new ImageIcon("imagenes\\BOTON_AME_2.png"));
		btnConsultar.setIcon(new ImageIcon("imagenes\\BOTON_AME_1.png"));
		btnConsultar.setVerticalTextPosition(SwingConstants.CENTER);
		btnConsultar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConsultar.setFont(new Font("Consolas", Font.BOLD, 16));
		btnConsultar.setFocusable(false);
		btnConsultar.setFocusTraversalKeysEnabled(false);
		btnConsultar.setFocusPainted(false);
		btnConsultar.setContentAreaFilled(false);
		btnConsultar.setBorderPainted(false);
		btnConsultar.setBorder(null);
		btnConsultar.setBackground(Color.LIGHT_GRAY);
		btnConsultar.setBounds(575, 48, 110, 40);
		getContentPane().add(btnConsultar);
		
		
		Listar();
		editarFila();
		HabilitarEntrada(false);
		btnBuscar.setEnabled(false);
		
		
	}
	
	ArregloAlumno arregloAlumno = new ArregloAlumno();

	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			CONSULTAR(e);
		}
		if (e.getSource() == btnCerrar) {
			CERRAR(e);
		}
		if (e.getSource() == btnModificar) {
			MODIFICAR(e);
		}
		if (e.getSource() == btnAceptar) {
			ACEPTAR(e);
		}
		if (e.getSource() == btnAdicionar) {
			ADICIONAR(e);
		}
		if (e.getSource() == btnEliminar) {
			ELIMINAR(e);
		}
		if (e.getSource() == btnBuscar ) {
			BUSCAR(e);
		}
	}
	
	protected void CONSULTAR(ActionEvent e) {
		btnBuscar.setEnabled(true);
		limpieza();
		txtCodigoAlumno.setText("");
		txtCodigoAlumno.setEditable(true);
		txtCodigoAlumno.requestFocus();
		HabilitarBotones(true);
	}
	
	protected void BUSCAR(ActionEvent a) {
		try {
			int codigoAlumno = leerCodAlumno();
			MostrarBusqueda(codigoAlumno);
		}
		catch (Exception e) {
			FuncionesGenerales.error("No se encuentra algun alumno con ese codigo");
			txtCodigoAlumno.requestFocus();
		}
	}
	
	private void MostrarBusqueda(int codigo) {
		Alumno A = arregloAlumno.buscar(codigo);
		txtNombresAlumno.setText(A.getNombre());
		txtApellidoAlumno.setText(A.getApellidos());
		txtDniAlumno.setText(A.getDni());
		txtEdadAlumno.setText("" + A.getEdad());
		txtCelularAlumno.setText("" + A.getCelular());
		cboEstadoAlumno.setSelectedIndex(A.getEstado());
	}
	
	protected void ACEPTAR(ActionEvent a) {
		int codAlumno = leerCodAlumno();
		try {
			String nombre = leerNombreAlumno();
			try {
				String apellidos = leerApellidoAlumno();
					String dni = leerDniAlumno();
					if ( NoHayLetras(dni) && NoHayDNIRepetidos(dni) && dni.length() == 8) {
						try {
							int edad = leerEdadAlumno();
							if (edad > 0 && edad < 81) {
								try {
									int celular = leerCelularAlumno();
									if (celular > 899999999 && celular < 1000000000) {
										int estado = leerEstadoAlumno();
										if (btnAdicionar.isEnabled() == false) {
											
//											try {
//												Connection Con = Conexion.getConexion();
//												PreparedStatement PS = Con.prepareStatement("INSERT INTO Alumno (codAlumno, nombres, apellidos, dni, edad,  																								celular,estado) VALUES(?,?,?,?,?,?,?)");
//												PS.setInt(1, codAlumno);
//												PS.setString(2, nombre);
//												PS.setString(3, apellidos);
//												PS.setString(4, dni);
//												PS.setInt(5, edad);
//												PS.setInt(6, celular);
//												PS.setInt(7, estado);
//												
//												PS.executeUpdate();
//												JOptionPane.showMessageDialog(null, "Registro guardado");
//											}catch (SQLException e) {
//												JOptionPane.showMessageDialog(null, e.toString());
//											}
											
											Alumno nuevo = new Alumno(codAlumno, nombre, apellidos, edad, dni, celular, estado);
											arregloAlumno.adicionar(nuevo);
											btnAdicionar.setEnabled(true);
										}
										if (btnModificar.isEnabled() == false) {
											Alumno alumno = arregloAlumno.buscar(codAlumno);
											alumno.setNombre(nombre);
											alumno.setApellidos(apellidos);
											alumno.setEdad(edad);
											alumno.setCelular(celular);
											alumno.setEstado(estado);
											arregloAlumno.actualizarArchivo();
											btnModificar.setEnabled(true);
										}
										Listar();
										HabilitarEntrada(false);
									}else {
										FuncionesGenerales.error("Debe Ingresar un numero telefonico valido" );
										txtCelularAlumno.setText("");
										txtCelularAlumno.requestFocus();
									}
								}
								catch (Exception e) {
									FuncionesGenerales.error("Debe Ingresar un numero telefonico");
									txtCelularAlumno.setText("");
									txtCelularAlumno.requestFocus();
								}					
							}else {
								FuncionesGenerales.error("Debe colocar una edad mayor a 0 y  menor a 81");
								txtEdadAlumno.requestFocus();
							}
								
						}
						catch (Exception e){
							FuncionesGenerales.error("Debe ingresar una edad");
							txtEdadAlumno.setText("");
							txtEdadAlumno.requestFocus();
						}
					}
					else {
						if(NoHayLetras(dni) == false) {
							FuncionesGenerales.error("Debes ingresar solo numeros ");
							txtDniAlumno.setText("");
							txtDniAlumno.requestFocus();
						}
						else if (NoHayDNIRepetidos(dni)==false) {
							FuncionesGenerales.error("Ya existe un alumno con ese DNI");
							txtDniAlumno.setText("");
							txtDniAlumno.requestFocus();
						}
						else if(dni.length() == 0) {
							FuncionesGenerales.error("Debes ingresar un dni ");
							txtDniAlumno.requestFocus();
						}
						else {
							FuncionesGenerales.error("Debes ingresar un dni valido de 8 digitos ");
							txtDniAlumno.requestFocus();
						}				
					}
			}
			catch (Exception e) {
				FuncionesGenerales.error("Debe ingresa un apellido");
				txtApellidoAlumno.requestFocus();
			}
			
		}
		catch (Exception e) {
			FuncionesGenerales.error("Debe ingresar un nombre");
			txtNombresAlumno.requestFocus();
		}
	}
	protected void ADICIONAR(ActionEvent e) {
		HabilitarBotones(true);
		btnAceptar.setEnabled(true);
		txtCodigoAlumno.setEditable(false);
		limpieza();
		HabilitarEntrada(true);
		txtNombresAlumno.requestFocus();
		btnBuscar.setEnabled(false);
		cboEstadoAlumno.setEnabled(false);
		btnAdicionar.setEnabled(false);
	}
	protected void MODIFICAR(ActionEvent e) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(false);
		btnBuscar.setEnabled(false);
		btnEliminar.setEnabled(true);
		txtCodigoAlumno.setEditable(false);
		if (arregloAlumno.tamaño() == 0) {
			btnAceptar.setEnabled(false);
			HabilitarEntrada(false);
			FuncionesGenerales.error("No existen alumnos");
			btnModificar.setEnabled(true);
		}
		else {
			editarFila();
			btnAceptar.setEnabled(true);
			HabilitarEntrada(true);
			txtDniAlumno.setEditable(false);
			txtNombresAlumno.requestFocus();
			cboEstadoAlumno.setEnabled(false);
		}
	}
	protected void ELIMINAR(ActionEvent e) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnEliminar.setEnabled(false);
		btnBuscar.setEnabled(false);
		txtCodigoAlumno.setEditable(false);
		if(arregloAlumno.tamaño() == 0) {
			FuncionesGenerales.error("No existen Alumnos para eliminar");
			btnEliminar.setEnabled(true);
		}
		else {
			editarFila();
			HabilitarEntrada(false);
			int codigoAlumno = leerCodAlumno();
			Alumno A = arregloAlumno.buscar(codigoAlumno);
			if (A.getEstado() == 0) {
				int confirmacion = FuncionesGenerales.confirmar("Desea eliminar este alumno");
				if (confirmacion == 0) {
					arregloAlumno.eliminar(arregloAlumno.buscar(codigoAlumno));
					Listar();
					editarFila();
				}
				btnEliminar.setEnabled(true);
			}
			else {
				FuncionesGenerales.error("No se puede eliminar el alumno " + A.getNombre() + " " + A.getApellidos() + "(" + A.getCodAlumno() + ")" + "\nporque no esta registrado");
			}
		}
	}
	
	private boolean NoHayLetras(String S) {
		for (int i = 0; i < S.length(); i++) {
			char caracter = S.charAt(i);
			if (caracter < 48 ||  caracter > 57) {
					return false;
			}	
		}
		return true;
	}
	
	private boolean NoHayDNIRepetidos(String nroDNI) {
		if (btnAdicionar.isEnabled() == false) {
			for (int i = 0; i < arregloAlumno.tamaño(); i++) {
				if (nroDNI.equals(arregloAlumno.obtener(i).getDni())) {
					return false;
				}
			}
		}
		return true;
	}


	private int leerCodAlumno() {
		return Integer.parseInt(txtCodigoAlumno.getText().trim());
	}
	private String leerNombreAlumno() {
		return  FuncionesGenerales.MayCorrespondiente(txtNombresAlumno.getText());
	}
	private String leerApellidoAlumno() {
		return FuncionesGenerales.MayCorrespondiente(txtApellidoAlumno.getText());
	}
	private String leerDniAlumno() {
		return txtDniAlumno.getText();
	}
	private int leerEdadAlumno() {
		return Integer.parseInt(txtEdadAlumno.getText());
	}
	private int leerCelularAlumno() {
		return Integer.parseInt(txtCelularAlumno.getText());
	}
	private int leerEstadoAlumno() {
		return cboEstadoAlumno.getSelectedIndex();
	}
	
	
	private void Listar() {
		int posFila = 0;
		modelo.setRowCount(0);
		Alumno A;
		for(int i = 0; i < arregloAlumno.tamaño(); i++) {
			A = arregloAlumno.obtener(i);
			Object[] fila = {
				A.getCodAlumno(),
				A.getNombre(),
				A.getApellidos(),
				A.getDni(),
				A.getEdad(),
				A.getCelular(),
				getEstadoTxt(A.getEstado())};
			modelo.addRow(fila);
		}
		if (arregloAlumno.tamaño() > 0) {
			tblAlumnos.getSelectionModel().setSelectionInterval(posFila, posFila);
		}
	}
	private void editarFila() {
		if (arregloAlumno.tamaño() == 0) {
			limpieza();
		}
		else {
			Alumno A = arregloAlumno.obtener(tblAlumnos.getSelectedRow());
			txtCodigoAlumno.setText("" + A.getCodAlumno());
			txtNombresAlumno.setText(A.getNombre());
			txtApellidoAlumno.setText(A.getApellidos());
			txtDniAlumno.setText(A.getDni());
			txtEdadAlumno.setText("" + A.getEdad());
			txtCelularAlumno.setText("" + A.getCelular());
			cboEstadoAlumno.setSelectedIndex(A.getEstado());
		}
	}
	private void limpieza() {
		txtCodigoAlumno.setText("" + arregloAlumno.codigoCorrelativo());
		txtNombresAlumno.setText("");
		txtEdadAlumno.setText("");
		txtApellidoAlumno.setText("");
		txtDniAlumno.setText("");
		txtCelularAlumno.setText("");
		cboEstadoAlumno.setSelectedIndex(0);
	}
	private void HabilitarEntrada(boolean X){
		btnAceptar.setEnabled(X);
		txtNombresAlumno.setEditable(X);
		txtEdadAlumno.setEditable(X);
		txtApellidoAlumno.setEditable(X);
		txtDniAlumno.setEditable(X);
		txtCelularAlumno.setEditable(X);
		cboEstadoAlumno.setEnabled(X);
	}
	private String getEstadoTxt(int E) {
		return cboEstadoAlumno.getItemAt(E);
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		e.consume();
		editarFila();
	}
	public void keyTyped(KeyEvent e) {
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblAlumnos) {
			mouseClickedTblAlumno(e);
		}
	}

	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == btnAceptar) {
			SeleccionarBtnAceptar(e);
		}
		if (e.getSource() == btnAdicionar) {
			SeleccionarBtnAdicionar(e);
		}
		if (e.getSource() == btnEliminar) {
			SeleccionarBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			SeleccionarBtnModificar(e);
		}
		if (e.getSource() == tblAlumnos) {
			SeleccionarTblAlumno(e);
		}
		if (e.getSource() == btnBuscar) {
			SeleccionarBtnBuscar(e);
		}
		if (e.getSource() == btnConsultar) {
			SeleccionarBtnConsultar(e);
		}
	}
	public void mouseExited(MouseEvent e) {
		
	}
	public void mouseReleased(MouseEvent e) {
		
	}
	protected void mouseClickedTblAlumno(MouseEvent ME) {
		txtCodigoAlumno.setEditable(false);
		HabilitarEntrada(false);
		HabilitarBotones(true);
		editarFila();
	}
	protected void SeleccionarBtnAceptar(MouseEvent e) {
		btnAceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void SeleccionarBtnAdicionar(MouseEvent e) {
		btnAdicionar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void SeleccionarBtnModificar(MouseEvent e) {
		btnModificar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void SeleccionarBtnEliminar(MouseEvent e) {
		btnEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void SeleccionarTblAlumno(MouseEvent e) {
		tblAlumnos.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void SeleccionarBtnBuscar(MouseEvent e) {
		btnBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void SeleccionarBtnConsultar(MouseEvent e) {
		btnConsultar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	void HabilitarBotones(boolean X) {
		btnAdicionar.setEnabled(X);
		btnModificar.setEnabled(X);
		btnEliminar.setEnabled(X);
	}
	protected void CERRAR(ActionEvent e) {
		this.dispose();
	}
	public void mouseMoved(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == MOVIMIENTO) {
			MOVER_VENTANA(e);
		}
		
	}
	protected void MOVER_VENTANA(MouseEvent e) {
		xx = e.getX();
		xy = e.getY();
	}
	public void mouseDragged(MouseEvent e) {
		if (e.getSource() == MOVIMIENTO) {
			MOVE(e);
		}
	}
	
	protected void MOVE(MouseEvent e) {
		int x = e.getXOnScreen();
		int y = e.getYOnScreen();
		
		this.setLocation(x-xx, y-xy);
	}
}
