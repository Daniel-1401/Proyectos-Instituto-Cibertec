package GUIs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

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

import Arreglos.*;
import Clases.*;
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

public class DlgRegistro_Retiro extends JDialog implements ActionListener, KeyListener, MouseListener, MouseMotionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNumeroRetiro;
	private JTextField txtNumMatricula;
	private JTextField txtCodCurso;
	private JButton btnAceptar;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnConsultar;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JButton btnCerrar;
	private JComboBox<String> cboNumeroRetiro;
	private JComboBox<String> cboCodCurso;
	private JComboBox<String> cboNumMatricula;
	private JTable tblRetiro;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	private JLabel MoverVentana;
	int xx, xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRegistro_Retiro dialog = new DlgRegistro_Retiro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	/**
	 * Create the dialog.
	 */
	public DlgRegistro_Retiro() {
		setUndecorated(true);
		setResizable(false);
		setBounds(100,100,700,500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblMantenimienoRetiro = new JLabel("REGISTRO | RETIRO");
		lblMantenimienoRetiro.setForeground(Color.DARK_GRAY);
		lblMantenimienoRetiro.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMantenimienoRetiro.setBounds(10, 5, 220, 20);
		contentPanel.add(lblMantenimienoRetiro);

		JLabel lblNumeroRetiro = new JLabel("N° DE RETIRO");
		lblNumeroRetiro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroRetiro.setBounds(10, 38, 110, 20);
		contentPanel.add(lblNumeroRetiro);
		
		JLabel lnlNumeroMatricula = new JLabel("N° MATRICULA");
		lnlNumeroMatricula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lnlNumeroMatricula.setBounds(10, 68, 110, 20);
		contentPanel.add(lnlNumeroMatricula);
		
		JLabel lblCodigoCurso = new JLabel("CODIGO CURSO");
		lblCodigoCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigoCurso.setBounds(10, 103, 110, 20);
		contentPanel.add(lblCodigoCurso);
		
		MoverVentana = new JLabel("");
		MoverVentana.addMouseMotionListener(this);
		MoverVentana.addMouseListener(this);
		MoverVentana.setBounds(0, 0, 652, 34);
		contentPanel.add(MoverVentana);	
		
		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(this);
		btnConsultar.setPressedIcon(new ImageIcon("imagenes\\BOTON_AME_2.png"));
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
		btnConsultar.setBounds(557, 29, 110, 40);
		contentPanel.add(btnConsultar);
		
		btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setPressedIcon(new ImageIcon("imagenes\\BOTON_AME_2.png"));
		btnAdicionar.setRolloverIcon(new ImageIcon("imagenes\\BOTON_AME_2.png"));
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
		btnAdicionar.setBounds(557, 79, 110, 40);
		contentPanel.add(btnAdicionar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setPressedIcon(new ImageIcon("imagenes\\BOTON_AME_1.png"));
		btnModificar.setRolloverIcon(new ImageIcon("imagenes\\BOTON_AME_2.png"));
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
		btnModificar.setBounds(557, 130, 110, 40);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setPressedIcon(new ImageIcon("imagenes\\BOTON_AME_1.png"));
		btnEliminar.setRolloverIcon(new ImageIcon("imagenes\\BOTON_AME_2.png"));
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
		btnEliminar.setBounds(557, 180, 110, 40);
		contentPanel.add(btnEliminar);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(this);
		btnBuscar.setPressedIcon(new ImageIcon("imagenes\\BOTON_AME_1.png"));
		btnBuscar.setRolloverIcon(new ImageIcon("imagenes\\BOTON_AME_2.png"));
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
		btnBuscar.setBounds(141, 168, 110, 40);
		contentPanel.add(btnBuscar);
		
		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(this);
		btnAceptar.setPressedIcon(new ImageIcon("imagenes\\BotonAceptar1.png"));
		btnAceptar.setRolloverIcon(new ImageIcon("imagenes\\BotonAceptar2.png"));
		btnAceptar.setIcon(new ImageIcon("imagenes\\BotonAceptar1.png"));
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
		btnAceptar.setBounds(10, 133, 110, 110);
		contentPanel.add(btnAceptar);
		
		btnCerrar = new JButton("");
		btnCerrar.addActionListener(this);
		btnCerrar.setPressedIcon(new ImageIcon("imagenes\\BOTON_CERRAR_1.png"));
		btnCerrar.setRolloverIcon(new ImageIcon("imagenes\\BOTON_CERRAR_2.png"));
		btnCerrar.setIcon(new ImageIcon("imagenes\\BOTON_CERRAR_1.png"));
		btnCerrar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setBorderPainted(false);
		btnCerrar.setBounds(662, 5, 28, 28);
		contentPanel.add(btnCerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 253, 680, 243);
		contentPanel.add(scrollPane);
		
		tblRetiro = new JTable();
		tblRetiro.addMouseListener(this);
		tblRetiro.addKeyListener(this);
		tblRetiro.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblRetiro);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("NumRetiro");
		modelo.addColumn("NumMatricula");
		modelo.addColumn("Fecha");
		modelo.addColumn("Hora");
		tblRetiro.setModel(modelo);
		
		cboNumeroRetiro = new JComboBox<String>();
		cboNumeroRetiro.addActionListener(this);
		cboNumeroRetiro.setBounds(263, 29, 112, 20);
		contentPanel.add(cboNumeroRetiro);
		obtenerNumerosRetiro();
		
		cboCodCurso = new JComboBox<String>();
		cboCodCurso.addActionListener(this);
		cboCodCurso.setBounds(141, 98, 112, 20);
		contentPanel.add(cboCodCurso);
		obtenerCodigosCurso();
		
		cboNumMatricula = new JComboBox<String>();
		cboNumMatricula.addActionListener(this);
		cboNumMatricula.setBounds(141, 68, 112, 20);
		contentPanel.add(cboNumMatricula);
		obtenerNumMatricula();
		
		txtNumeroRetiro = new JTextField();
		txtNumeroRetiro.setEditable(false);
		txtNumeroRetiro.setColumns(10);
		txtNumeroRetiro.setBounds(141, 35, 86, 20);
		contentPanel.add(txtNumeroRetiro);
		
		txtNumMatricula = new JTextField();
		txtNumMatricula.setEditable(false);
		txtNumMatricula.setColumns(10);
		txtNumMatricula.setBounds(141, 68, 86, 20);
		contentPanel.add(txtNumMatricula);
		
		txtCodCurso = new JTextField();
		txtCodCurso.setEditable(false);
		txtCodCurso.setColumns(10);
		txtCodCurso.setBounds(141, 100, 86, 20);
		contentPanel.add(txtCodCurso);
		
		APAGAR_ENTRADAS();
		txtNumeroRetiro.setVisible(true);
		txtNumMatricula.setVisible(true);
		txtCodCurso.setVisible(true);
		Listar();
		editarFila();
		
	}
	
	ArregloRetiro ar = new ArregloRetiro(); 
	ArregloMatricula am = new ArregloMatricula();
	ArregloAlumno aa = new ArregloAlumno();
	ArregloCurso ac = new ArregloCurso();
	
	private void obtenerNumerosRetiro() {
		Retiro r;
		cboNumeroRetiro.removeAllItems();
		if (ar.tamaño() == 0) {
			cboNumeroRetiro.addItem("NO HAY");
		}else {
			cboNumeroRetiro.addItem("SELECCIONAR");
			for (int i = 0; i < ar.tamaño(); i++) {
				r = ar.obtener(i);
				cboNumeroRetiro.addItem("" + r.getNumRetiro());
			}
		}
	}
	private void obtenerNumMatricula() {
		Matricula m;
		cboNumMatricula.removeAllItems();
		if (am.tamaño() == 0) {
			cboNumMatricula.addItem("NO HAY");
		}else {
			cboNumMatricula.addItem("SELECCIONAR");
			for (int i = 0; i < am.tamaño(); i++) {
				m = am.obtener(i);
				if (aa.buscar(m.getcodAlumno()).getEstado() == 1) {
				cboNumMatricula.addItem("" + m.getnumMatricula());
				}
			}
			if (cboNumMatricula.getItemCount() == 1) {
				cboNumMatricula.removeAllItems();
				cboNumMatricula.addItem("NO HAY");
				cboNumMatricula.setEnabled(false);
			}
		}
	}
	private void obtenerCodigosCurso() {
		Curso c;
		cboCodCurso.removeAllItems();
		if (ac.tamaño() == 0) {
			cboCodCurso.addItem("NO HAY");
		}else {
			cboCodCurso.addItem("SELECCIONAR");
			for (int i = 0; i < ac.tamaño(); i++) {
				c = ac.obtener(i);
				cboCodCurso.addItem("" + c.getCodCurso());
			}
			
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			CERRAR(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			ACEPTAR(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			BUSCAR(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			CONSULTAR(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			ADICIONAR(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			MODIFICAR(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			ELIMINAR(arg0);
		}
		if (arg0.getSource() == cboNumeroRetiro) {
			COLOCAR_NUMERO_RETIRO(arg0);
		}
		if (arg0.getSource() == cboNumMatricula) {
			COLOCAR_NUMERO_MATRICULA(arg0);
		}
		if (arg0.getSource() == cboCodCurso) {
			COLOCAR_CODIGO_CURSO(arg0);
		}
	}
	
	protected void CERRAR(ActionEvent arg0) {
		this.dispose();
	}
	protected void ACEPTAR(ActionEvent arg0) {
		try {
			int numRetiro = leerNumeroRetiro();
			try {
				int numMatricula = leerNumeroMatricula();
				if (btnAdicionar.isEnabled()== false) {
					String fecha = Fecha.fechaActual();
					String hora = Fecha.horaActual();
					Retiro nuevo = new Retiro(numRetiro, numMatricula, fecha, hora);
					ar.adicionar(nuevo);
					int codAlumno = am.buscar(numMatricula).getcodAlumno();
					Alumno a = aa.buscar(codAlumno);
					a.setEstado(2);
					aa.actualizarArchivo();
					obtenerNumMatricula();
					if (cboNumMatricula.getSelectedItem() == "NO HAY") {
						btnAceptar.setEnabled(false);
						btnAdicionar.setEnabled(true);
					}
					limpieza();
				}
				if (btnModificar.isEnabled()==false) {
					try {
						int codCurso = leerCodigoCurso();
						am.buscar(numMatricula).setcodCurso(codCurso);
						am.actualizarArchivo();
						cboNumeroRetiro.setBounds(141, 35, 112, 20);
						cboNumeroRetiro.setVisible(false);
						cboCodCurso.setVisible(false);
						txtNumeroRetiro.setEditable(false);
						txtNumeroRetiro.setText("");
						txtNumMatricula.setText("");
						btnAceptar.setEnabled(false);
						FuncionesGenerales.mensaje("SE CAMBIO EL CODIGO DE CURSO DE LA MATRICULA: " + numMatricula);
						btnModificar.setEnabled(true);
					}catch (Exception e) {
						FuncionesGenerales.error("DEBE SELECCIONAR UN CURSO");
					}
				}
				Listar();
			}catch (Exception e) {
				FuncionesGenerales.error("DEBE SELECCIONAR UNA MATRICULA");
			}
		}catch (Exception e) {
			FuncionesGenerales.error("DEBE COLOCAR UN NUMERO DE RETIRO");
		}
		
	}
	protected void BUSCAR(ActionEvent arg0) {
		try {
			Retiro r = ar.buscar(leerNumeroRetiro());
			String Mnsj;
			Mnsj =  "El retiro numero " + r.getNumRetiro() + "\n" +
					"con el numero de matricula " + r.getNumMatricula() + ".\n" + 
					"Se registro el dia " + r.getFecha() + "\n" + 
					"A las " + r.getHora();
			FuncionesGenerales.mensaje(Mnsj);
		}catch (Exception e) {
			FuncionesGenerales.error("DEBE SELECCIONAR UN NRO DE RETIRO");
		}
	}
	protected void CONSULTAR(ActionEvent arg0) {
		HABILITAR_BOTONES(btnConsultar, btnBuscar);
		APAGAR_ENTRADAS();
		obtenerNumerosRetiro();
		btnAceptar.setEnabled(false);
		cboNumeroRetiro.setBounds(141, 35, 112, 20);
		cboNumeroRetiro.setVisible(true);
		if (cboNumeroRetiro.getItemCount() >= 1) {
			cboNumeroRetiro.setSelectedIndex(0);
		}
		if (cboNumeroRetiro.getSelectedItem() == "NO HAY") {
			btnBuscar.setEnabled(false);
			cboNumeroRetiro.setEnabled(false);
			FuncionesGenerales.mensaje("NO HAY RETIROS PARA CONSULTAR");
		}
	}
	protected void ADICIONAR(ActionEvent arg0) {
		HABILITAR_BOTONES(btnAdicionar, btnAceptar);
		APAGAR_ENTRADAS();
		obtenerNumMatricula();
		btnBuscar.setEnabled(false);
		txtNumeroRetiro.setVisible(true);
		txtNumeroRetiro.setEditable(false);
		cboNumMatricula.setVisible(true);
		cboNumMatricula.setEnabled(true);
		if (cboNumMatricula.getItemCount() > 1) {
			cboNumMatricula.setSelectedIndex(0);
		}
		if (cboNumMatricula.getSelectedItem() == "NO HAY") {
			btnAceptar.setEnabled(false);
			cboNumMatricula.setEnabled(false);
		}
		limpieza();
	}
	protected void MODIFICAR(ActionEvent arg0) {
		HABILITAR_BOTONES(btnModificar, btnAceptar);
		APAGAR_ENTRADAS();
		obtenerNumerosRetiro();
		btnBuscar.setEnabled(false);
		cboCodCurso.setVisible(true);
		cboCodCurso.setEnabled(true);
		txtNumeroRetiro.setVisible(true);
		txtNumeroRetiro.setEditable(true);
		txtNumeroRetiro.setText("");
		txtNumMatricula.setVisible(true);
		txtNumMatricula.setEditable(false);
		cboNumeroRetiro.setBounds(230, 35, 112, 20);
		cboNumeroRetiro.setVisible(true);
		cboNumeroRetiro.setEnabled(true);
		if (cboNumeroRetiro.getItemCount() > 1) {
			cboNumeroRetiro.setSelectedIndex(0);
		}
		if (cboNumeroRetiro.getSelectedItem() == "NO HAY") {
			btnBuscar.setEnabled(false);
			btnAceptar.setEnabled(false);
			cboNumeroRetiro.setEnabled(false);
			cboCodCurso.setEnabled(false);
			txtNumeroRetiro.setEditable(false);
			FuncionesGenerales.mensaje("NO HAY RETIROS PARA MODIFICAR");
		}
		txtNumeroRetiro.setText("");
	}
	protected void ELIMINAR(ActionEvent arg0) {
		try {
			int numRetiro = leerNumeroRetiro();
			int NumMatricula = leerNumeroMatricula();
			if (SE_PUEDE_ELIMINAR(NumMatricula)) {
				int confimacion = FuncionesGenerales.confirmar("DESEA CANCELAR ESTE RETIRO");
				if (confimacion == 0) {
					Retiro r = ar.buscar(numRetiro);
					Matricula m = am.buscar(r.getNumMatricula());
					int codAlumno = m.getcodAlumno();
					Alumno a = aa.buscar(codAlumno);
					a.setEstado(1);
					aa.actualizarArchivo();
					ar.eliminar(r);
				}
				Listar();
			}
			
		}catch (Exception e) {
			FuncionesGenerales.error("NO HAY RETIROS POR CANCELAR");
		}
	}
	
	void HABILITAR_BOTONES(JButton btnDESHABILITAR, JButton btnACTIVAR) {
		FuncionesGenerales.HabilitarBotones(true, btnConsultar, btnAdicionar, btnModificar, btnEliminar, btnACTIVAR);
		btnDESHABILITAR.setEnabled(false);
	}
	void APAGAR_ENTRADAS() {
		cboNumeroRetiro.setVisible(false);
		cboNumMatricula.setVisible(false);
		cboCodCurso.setVisible(false);
		txtNumeroRetiro.setVisible(false);
		txtNumMatricula.setVisible(false);
		txtCodCurso.setVisible(false);
	}
	
	boolean SE_PUEDE_ELIMINAR(int NumMatricula) {
		Matricula m = am.buscar(NumMatricula);
		int codAlumno = m.getcodAlumno();
		Alumno a = aa.buscar(codAlumno);
		int estadoAlumno = a.getEstado();
		if (estadoAlumno == 2) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	void Listar(){
		int posFila = 0;
		modelo.setRowCount(0);
		Retiro R;
		for (int i=0; i<ar.tamaño(); i++) {
			R = ar.obtener(i);
			Object[] fila = {
					R.getNumRetiro(),
					R.getNumMatricula(),
					R.getFecha(),
					R.getHora()};
			modelo.addRow(fila);
		}
		if (ar.tamaño() > 0) {
			tblRetiro.getSelectionModel().setSelectionInterval(posFila, posFila);
		}
	}
	void editarFila(){
		if (ar.tamaño() == 0)
			limpieza();
		else {
			Retiro r = ar.obtener(tblRetiro.getSelectedRow());
			txtNumeroRetiro.setText("" + r.getNumRetiro());
			txtNumMatricula.setText("" + r.getNumMatricula());
		}
	}
	void limpieza(){
		txtNumeroRetiro.setText("" + ar.codigoCorrelativo());
		txtNumMatricula.setText("");
		txtCodCurso.setText("");
	}

	int leerNumeroRetiro(){
		return Integer.parseInt(txtNumeroRetiro.getText());
	}
	int leerNumeroMatricula(){
		return Integer.parseInt(txtNumMatricula.getText());
	}
	int leerCodigoCurso(){
		return Integer.parseInt(txtCodCurso.getText());
	}
	
	protected void COLOCAR_NUMERO_RETIRO(ActionEvent arg0) {
		try {
			txtNumeroRetiro.setText("" + cboNumeroRetiro.getSelectedItem());
			if (btnModificar.isEnabled() == false) {
				txtNumMatricula.setText("" + ar.buscar(
				Integer.parseInt((String) cboNumeroRetiro.getSelectedItem())
				).getNumMatricula());
			}
		}catch (Exception e) {
		}
	}
	protected void COLOCAR_NUMERO_MATRICULA(ActionEvent arg0) {
		try {
			txtNumMatricula.setText("" + cboNumMatricula.getSelectedItem());			
		}catch (Exception e) {
		}
	}
	protected void COLOCAR_CODIGO_CURSO(ActionEvent arg0) {
		try {
			txtCodCurso.setText("" + cboCodCurso.getSelectedItem());
		}catch (Exception e) {
		}
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		e.consume();
		editarFila();
	}
	public void keyTyped(KeyEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblRetiro) {
			OBTENER_DATOS_TABLA(e);
		}
	}
	protected void OBTENER_DATOS_TABLA(MouseEvent arg0) {
		HABILITAR_BOTONES(btnAceptar, btnEliminar);
		btnBuscar.setEnabled(false);
		APAGAR_ENTRADAS();
		txtNumeroRetiro.setVisible(true);
		txtNumeroRetiro.setEditable(false);
		txtNumMatricula.setVisible(true);
		txtNumMatricula.setEditable(false);
		editarFila();
	}
	public void mouseMoved(MouseEvent e) {
	}
	

	public void mousePressed(MouseEvent e) {
		if (e.getSource() == MoverVentana) {
			MOVER_VENTANA(e);
		}
	}
	public void mouseDragged(MouseEvent e) {
		if (e.getSource() == MoverVentana) {
			MOVER(e);
		}
	}

	protected void MOVER_VENTANA(MouseEvent e) {
		xx = e.getX();
		xy = e.getY();
	}
	protected void MOVER(MouseEvent e) {
		int x = e.getXOnScreen();
		int y = e.getYOnScreen();
		
		this.setLocation(x-xx, y-xy);
	}
}
