package GUIs;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

import Arreglos.ArregloCurso;
import Arreglos.ArregloMatricula;
import Arreglos.ArregloAlumno;
import Clases.Curso;
import Clases.Alumno;
import Clases.Matricula;
import FuncionGenerales.FuncionesGenerales;
import Libreria.Fecha;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionListener;

public class DlgRegistro_Matricula extends JDialog implements ActionListener, MouseListener, KeyListener, MouseMotionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnAceptar;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnCerrar;
	private JButton btnBuscar;
	private JButton btnConsultar;
	private JLabel lblNewLabel;
	private JLabel lblNummatricula;
	private JLabel lblCodigoAlumno;
	private JLabel lblCodigoCurso;
	private JTextField txtNumMatricula;
	private JTextField txtCodAlumno;
	private JTextField txtCodCurso;
	private JComboBox<String> cboCodCurso;
	private JComboBox<String> cboCodAlumno;
	private JComboBox<String> cboNumMatricula;
	private JTable tblMatricula;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	private JLabel MoverVentana;
	private int xx, xy;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRegistro_Matricula dialog = new DlgRegistro_Matricula();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRegistro_Matricula() {
		setUndecorated(true);
		setResizable(false);
		setBounds(100,100,700,500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(this);
		btnAceptar.setIcon(new ImageIcon("imagenes\\BotonAceptar1.png"));
		btnAceptar.setRolloverIcon(new ImageIcon("imagenes\\BotonAceptar2.png"));
		btnAceptar.setPressedIcon(new ImageIcon("imagenes\\BotonAceptar1.png"));
		btnAceptar.setVerticalTextPosition(SwingConstants.CENTER);
		btnAceptar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAceptar.setFont(new Font("Consolas", Font.BOLD, 16));
		btnAceptar.setFocusable(false);
		btnAceptar.setFocusTraversalKeysEnabled(false);
		btnAceptar.setFocusPainted(false);
		btnAceptar.setEnabled(false);
		btnAceptar.setContentAreaFilled(false);
		btnAceptar.setBorderPainted(false);
		btnAceptar.setBorder(null);
		btnAceptar.setBackground(Color.LIGHT_GRAY);
		btnAceptar.setBounds(238, 103, 110, 110);
		contentPanel.add(btnAceptar);
		
		btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setRolloverIcon(new ImageIcon("imagenes\\BOTON_AME_2.png"));
		btnAdicionar.setPressedIcon(new ImageIcon("imagenes\\BOTON_AME_1.png"));
		btnAdicionar.setIcon(new ImageIcon("imagenes\\BOTON_AME_1.png"));
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
		btnAdicionar.setBounds(575, 103, 110, 40);
		contentPanel.add(btnAdicionar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setRolloverIcon(new ImageIcon("imagenes\\BOTON_AME_2.png"));
		btnModificar.setPressedIcon(new ImageIcon("imagenes\\BOTON_AME_1.png"));
		btnModificar.setIcon(new ImageIcon("imagenes\\BOTON_AME_1.png"));
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
		btnModificar.setBounds(575, 153, 110, 40);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setRolloverIcon(new ImageIcon("imagenes\\BOTON_AME_2.png"));
		btnEliminar.setPressedIcon(new ImageIcon("imagenes\\BOTON_AME_1.png"));
		btnEliminar.setIcon(new ImageIcon("imagenes\\BOTON_AME_1.png"));
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
		btnEliminar.setBounds(575, 203, 110, 40);
		contentPanel.add(btnEliminar);
		
		lblNewLabel = new JLabel("REGISTRO | MATRICULA");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 10, 220, 20);
		contentPanel.add(lblNewLabel);
		
		btnCerrar = new JButton("");
		btnCerrar.addActionListener(this);
		btnCerrar.setPressedIcon(new ImageIcon("imagenes\\BOTON_CERRAR_1.png"));
		btnCerrar.setRolloverIcon(new ImageIcon("imagenes\\BOTON_CERRAR_2.png"));
		btnCerrar.setIcon(new ImageIcon("imagenes\\BOTON_CERRAR_1.png"));
		btnCerrar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setBorderPainted(false);
		btnCerrar.setBounds(662, 10, 28, 28);
		contentPanel.add(btnCerrar);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(this);
		btnBuscar.setRolloverIcon(new ImageIcon("imagenes\\BOTON_AME_2.png"));
		btnBuscar.setPressedIcon(new ImageIcon("imagenes\\BOTON_AME_1.png"));
		btnBuscar.setIcon(new ImageIcon("imagenes\\BOTON_AME_1.png"));
		btnBuscar.setVerticalTextPosition(SwingConstants.CENTER);
		btnBuscar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBuscar.setFont(new Font("Consolas", Font.BOLD, 16));
		btnBuscar.setFocusable(false);
		btnBuscar.setFocusTraversalKeysEnabled(false);
		btnBuscar.setFocusPainted(false);
		btnBuscar.setEnabled(false);
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setBorderPainted(false);
		btnBuscar.setBorder(null);
		btnBuscar.setBackground(Color.LIGHT_GRAY);
		btnBuscar.setBounds(238, 31, 110, 40);
		contentPanel.add(btnBuscar);
		
		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(this);
		btnConsultar.setRolloverIcon(new ImageIcon("imagenes\\BOTON_AME_2.png"));
		btnConsultar.setPressedIcon(new ImageIcon("imagenes\\BOTON_AME_1.png"));
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
		btnConsultar.setBounds(575, 53, 110, 40);
		contentPanel.add(btnConsultar);
		
		lblNummatricula = new JLabel("NumMatricula");
		lblNummatricula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNummatricula.setBounds(10, 40, 86, 17);
		contentPanel.add(lblNummatricula);
		
		lblCodigoAlumno = new JLabel("Codigo Alumno");
		lblCodigoAlumno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigoAlumno.setBounds(10, 76, 97, 17);
		contentPanel.add(lblCodigoAlumno);
		
		lblCodigoCurso = new JLabel("Codigo Curso");
		lblCodigoCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigoCurso.setBounds(10, 153, 85, 17);
		contentPanel.add(lblCodigoCurso);
		
		txtCodAlumno = new JTextField();
		txtCodAlumno.setBounds(11, 124, 96, 19);
		contentPanel.add(txtCodAlumno);
		txtCodAlumno.setColumns(10);
		
		txtCodCurso = new JTextField();
		txtCodCurso.setColumns(10);
		txtCodCurso.setBounds(10, 203, 96, 19);
		contentPanel.add(txtCodCurso);

		txtNumMatricula = new JTextField();
		txtNumMatricula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNumMatricula.setEditable(false);
		txtNumMatricula.setColumns(10);
		txtNumMatricula.setBounds(106, 40, 102, 20);
		contentPanel.add(txtNumMatricula);
		
		cboCodCurso = new JComboBox <String>();
		cboCodCurso.addActionListener(this);
		cboCodCurso.setBounds(106, 173, 115, 20);
		contentPanel.add(cboCodCurso);
		obtenerCodCursos();
		
		cboCodAlumno = new JComboBox <String>();
		cboCodAlumno.addActionListener(this);
		cboCodAlumno.setBounds(106, 96, 115, 20);
		contentPanel.add(cboCodAlumno);
		obtenerCodAlumno();
		
		cboNumMatricula = new JComboBox<String>();
		cboNumMatricula.addActionListener(this);
		cboNumMatricula.setEnabled(false);
		cboNumMatricula.setBounds(106, 40, 115, 20);
		contentPanel.add(cboNumMatricula);
		obtenerNumMatricula();
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 253, 680, 243);
		contentPanel.add(scrollPane);
		
		tblMatricula = new JTable();
		tblMatricula.addKeyListener(this);
		tblMatricula.addMouseListener(this);
		tblMatricula.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblMatricula);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("NumMatricula");
		modelo.addColumn("CodAlumno");
		modelo.addColumn("CodCurso");
		modelo.addColumn("Fecha");
		modelo.addColumn("Hora");
		tblMatricula.setModel(modelo);
		
		txtNumMatricula.setEditable(false);
		txtCodAlumno.setEditable(false);
		txtCodCurso.setEditable(false);
		
		Listar();
		editarFila();
		HabilitarEntradas(false);
		cboNumMatricula.setEnabled(false);
		
		MoverVentana = new JLabel("");
		MoverVentana.addMouseMotionListener(this);
		MoverVentana.addMouseListener(this);
		MoverVentana.setBounds(0, 0, 623, 28);
		contentPanel.add(MoverVentana);
		cboNumMatricula.setVisible(false);
	}
	
	ArregloMatricula am = new ArregloMatricula();
	ArregloAlumno aa = new ArregloAlumno();
	ArregloCurso ac = new ArregloCurso();

	private void obtenerNumMatricula() {
		Matricula m;
		cboNumMatricula.removeAllItems();
		if (am.tamaño() == 0) {
			cboNumMatricula.addItem("NO HAY");
		}else {
			for (int i = 0; i < am.tamaño(); i++) {
				m = am.obtener(i);
				cboNumMatricula.addItem("" + m.getnumMatricula());
			}	
		}
	}
	private void obtenerCodAlumno() {
		Alumno a;
		cboCodAlumno.removeAllItems();
		for (int i = 0; i < aa.tamaño(); i++) {
			a = aa.obtener(i);
			if (a.getEstado() == 0) {
				cboCodAlumno.addItem("" + a.getCodAlumno());
			}
		}
	}
	private void obtenerCodCursos(){
		Curso c;
		cboCodCurso.removeAllItems();
		for (int i = 0; i < ac.tamaño(); i++) {
			c = ac.obtener(i);
			cboCodCurso.addItem("" + c.getCodCurso());
		}
	}
	
	
	
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == btnCerrar) {
			CERRAR(arg0);
		}
		if (arg0.getSource() == cboCodCurso) {
			COLOCAR_COD_CURSO(arg0);
		}
		if (arg0.getSource() == cboCodAlumno) {
			COLOCAR_COD_ALUMNO(arg0);
		}
		if (arg0.getSource() == cboNumMatricula) {
			COLOCAR_NUM_MATRICULA(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			MODIFICAR(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			ADICIONAR(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			ELIMINAR(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			CONSULTAR(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			ACEPTAR(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			BUSCAR(arg0);
		}
	}
	
	
	protected void BUSCAR(ActionEvent arg0) {
		btnConsultar.setEnabled(true);
		try {
			int numMatricula = Integer.parseInt((String) cboNumMatricula.getSelectedItem());
			FuncionesGenerales.MostrarDatos(Datos(numMatricula));
		}catch (Exception e) {
		}
	}
	private String Datos(int numMatricula) {
		Matricula m = am.buscar(numMatricula);
		Alumno a = aa.buscar(m.getcodAlumno());
		Curso c = ac.buscar(m.getcodCurso());
		String Dato = "Alumno: " + a.getNombre() + " " + a.getApellidos() + "\n" +
					  "Curso: " + c.getAsignatura();
		return Dato;
	}
	protected void ACEPTAR(ActionEvent arg0) {
		try {
			int numMatricula = leerNumMatricula();
			try {
				int codAlumno = leerCodAlumno();
				try {
					int codCurso = leerCodCurso();
					String fecha = Fecha.fechaActual();
					String hora = Fecha.horaActual();
					if (btnAdicionar.isEnabled() == false) {
						Matricula nueva = new Matricula(numMatricula, codAlumno, codCurso, fecha, hora);
						am.adicionar(nueva);
						btnAdicionar.setEnabled(true);

						Alumno a = aa.buscar(codAlumno);
						a.setEstado(1);
						aa.actualizarArchivo();
						obtenerCodAlumno();
						obtenerNumMatricula();
					}
					if (btnModificar.isEnabled() == false) {
						Matricula m = am.buscar(numMatricula);
						m.setcodCurso(codCurso);
						am.actualizarArchivo();
						btnModificar.setEnabled(true);
					}
					Listar();
					HabilitarEntradas(false);
				} catch (Exception e) {
					FuncionesGenerales.error("SELECCIONA UN CURSOS");
				}
			}catch (Exception e) {
				FuncionesGenerales.error("SELECCIONA UN ALUMNOS PARA AGREGAR");
			}			
		}catch (Exception e) {
		}
	}
	
	protected void CONSULTAR(ActionEvent arg0) {
		FuncionesGenerales.HabilitarBotones(true, btnAceptar, btnBuscar, btnAdicionar, btnEliminar, btnModificar);
		btnConsultar.setEnabled(false);
		btnAceptar.setEnabled(false);
		txtNumMatricula.setVisible(false);
		cboNumMatricula.setVisible(true);
		cboNumMatricula.setEnabled(true);
		HabilitarEntradas(false);
		obtenerNumMatricula();
	}
	protected void ELIMINAR(ActionEvent arg0) {
		FuncionesGenerales.HabilitarBotones(true, btnAceptar, btnBuscar, btnAdicionar, btnConsultar, btnModificar);
		btnEliminar.setEnabled(false);
		btnBuscar.setEnabled(false);
		if (am.tamaño() == 0) {
			FuncionesGenerales.error("No existen matriculas para eliminar");
			btnEliminar.setEnabled(true);
		}
		else {
			editarFila();
			HabilitarEntradas(false);
			if (SE_PUEDE_ELIMINAR()) {
				int confirmacion = FuncionesGenerales.confirmar("DESEA ELIMINAR ESTA MATRICULA?");
				if (confirmacion == 0) {
					Alumno a = aa.buscar(leerCodAlumno());
					am.eliminar(am.buscar(leerNumMatricula()));
					Listar();
					editarFila();
					a.setEstado(0);
					aa.actualizarArchivo();
					obtenerCodAlumno();
				}
				btnEliminar.setEnabled(true);
			}
			else {
				FuncionesGenerales.error("NO SE PUEDE ELIMINAR ESTA MATRICULA");
			}
		}
	}
	private boolean SE_PUEDE_ELIMINAR() {
		Alumno a = aa.buscar(leerCodAlumno());
		if (a.getEstado() != 2) {
			return true;
		}
		return false;
		
	}
	protected void ADICIONAR(ActionEvent arg0) {
		FuncionesGenerales.HabilitarBotones(true, btnAceptar, btnBuscar, btnConsultar, btnEliminar, btnModificar);
		btnAdicionar.setEnabled(false);
		btnBuscar.setEnabled(false);
		cboCodAlumno.setEnabled(true);
		cboCodCurso.setEnabled(true);
		cboNumMatricula.setVisible(false);
		txtNumMatricula.setVisible(true);
		limpieza();
		HabilitarEntradas(true);
	}
	protected void MODIFICAR(ActionEvent arg0) {
		FuncionesGenerales.HabilitarBotones(true, btnAceptar, btnAdicionar, btnConsultar, btnEliminar, btnModificar);
		btnModificar.setEnabled(false);
		btnBuscar.setEnabled(false);
		if (ac.tamaño() == 0) {
			btnAceptar.setEnabled(false);
			HabilitarEntradas(false);
			FuncionesGenerales.error("No existen Matriculas");
			btnModificar.setEnabled(true);
		}else {
			editarFila();
			cboCodCurso.setEnabled(true);
		}
	}
	
	protected void COLOCAR_COD_ALUMNO(ActionEvent arg0) {
		txtCodAlumno.setText("" + cboCodAlumno.getSelectedItem());
	}
	protected void COLOCAR_COD_CURSO(ActionEvent arg0) {
		txtCodCurso.setText("" + cboCodCurso.getSelectedItem());
	}
	protected void COLOCAR_NUM_MATRICULA(ActionEvent arg0) {
		txtNumMatricula.setText("" + cboNumMatricula.getSelectedItem());
	}
	
	protected void CERRAR(ActionEvent arg0) {
		this.dispose();
	}
	
	private void Listar() {
		int posFila = 0;
		modelo.setRowCount(0);
		Matricula M;
		for (int i = 0; i < am.tamaño(); i++) {
			M = am.obtener(i);
			Object[] fila = {
					M.getnumMatricula(),
					M.getcodAlumno(),
					M.getcodCurso(),
					M.getFecha(),
					M.getHora()};
			modelo.addRow(fila);
		}
		if (am.tamaño() > 0) {
			tblMatricula.getSelectionModel().setSelectionInterval(posFila, posFila);
		}
	}
	
	private void editarFila() {
		if (am.tamaño() == 0) {
			limpieza();
		}
		else{
			Matricula m = am.obtener(tblMatricula.getSelectedRow());
			txtNumMatricula.setText("" + m.getnumMatricula());
			txtCodAlumno.setText("" + m.getcodAlumno());
			txtCodCurso.setText("" + m.getcodCurso());
		}
	}
	
	private void limpieza() {
		txtNumMatricula.setText("" + am.codigoCorrelativo());
		txtCodAlumno.setText("");
		txtCodCurso.setText("");
	}
	
	private int leerNumMatricula() {
		return Integer.parseInt(txtNumMatricula.getText());
	}
	
	private int leerCodAlumno() {
		return Integer.parseInt(txtCodAlumno.getText());
	}
	
	private int leerCodCurso() {
		return Integer.parseInt(txtCodCurso.getText());
	}
	
	private void HabilitarEntradas(boolean X) {
		btnAceptar.setEnabled(X);
		cboCodAlumno.setEnabled(X);
		cboCodCurso.setEnabled(X);
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == MoverVentana) {
			mouseClickedMoverVentana(e);
		}
		if (e.getSource() == tblMatricula) {
			mouseClickedTblMatricula(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
		tblMatricula.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTblMatricula(MouseEvent e) {
		txtNumMatricula.setEditable(false);
		HabilitarEntradas(false);
		FuncionesGenerales.HabilitarBotones(true, btnAdicionar, btnConsultar, btnEliminar, btnModificar, btnConsultar);
		cboNumMatricula.setVisible(false);
		txtNumMatricula.setVisible(true);
		editarFila();
	}
	public void keyPressed(KeyEvent e) {
		if (e.getSource() == tblMatricula) {
			keyPressedTblMatricula(e);
		}
		
	}
	public void keyReleased(KeyEvent e) {
		e.consume();
		editarFila();
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyPressedTblMatricula(KeyEvent e) {
	}
	protected void actionPerformedCboNumMatricula(ActionEvent arg0) {
	}
	protected void mouseClickedMoverVentana(MouseEvent e) {
	}
	protected void mouseDraggedMoverVentana(MouseEvent e) {
	}
	public void mouseMoved(MouseEvent e) {
		if (e.getSource() == MoverVentana) {
			MOVER_VENTANA(e);
		}
	}
	protected void MOVER_VENTANA(MouseEvent e) {
		xx = e.getX();
		xy = e.getY();
	}
	public void mouseDragged(MouseEvent e) {
		if (e.getSource() == MoverVentana) {
			MOVE(e);
		}
	}
	
	protected void MOVE(MouseEvent e) {
		int x = e.getXOnScreen();
		int y = e.getYOnScreen();
		
		this.setLocation(x-xx, y-xy);
	}
}
