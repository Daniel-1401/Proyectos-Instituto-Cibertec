package GUIs;

import Clases.Curso;
import Clases.Matricula;
import Libreria.Lib;
import Arreglos.ArregloCurso;
import Arreglos.ArregloMatricula;
import FuncionGenerales.FuncionesGenerales;


import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.event.MouseMotionListener;

public class DlgMantenimiento_Curso extends JDialog implements ActionListener, KeyListener, MouseListener, MouseMotionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtAsignatura;
	private JTextField txtCreditos;
	private JTextField txtHoras;
	private JButton btnCerrar;
	private JButton btnAceptar;
	private JButton btnBuscar;
	private JButton btnConsultar;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JComboBox<String> cboCicloCurso;
	private DefaultTableModel modelo;
	private int xx, xy;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgMantenimiento_Curso dialog = new DlgMantenimiento_Curso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgMantenimiento_Curso() {
		setUndecorated(true);
		setTitle("Mantenimiento | Curso");
		setSize(700,500);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCodigo = new JLabel("CODIGO: ");
			lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCodigo.setBounds(10, 38, 64, 17);
			contentPanel.add(lblCodigo);
		}
		{
			JLabel lblAsignatura = new JLabel("ASIGNATURA:");
			lblAsignatura.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAsignatura.setBounds(10, 68, 91, 17);
			contentPanel.add(lblAsignatura);
		}
		{
			JLabel lblCiclo = new JLabel("CICLO:");
			lblCiclo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCiclo.setBounds(10, 98, 46, 17);
			contentPanel.add(lblCiclo);
		}
		{
			JLabel lblCreditos = new JLabel("CREDITOS:");
			lblCreditos.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCreditos.setBounds(10, 143, 73, 17);
			contentPanel.add(lblCreditos);
		}
		{
			JLabel lblHoras = new JLabel("HORAS:");
			lblHoras.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblHoras.setBounds(10, 188, 50, 17);
			contentPanel.add(lblHoras);
		}
		{
			JButton btnNewButton = new JButton("New button");
			btnNewButton.setBounds(705, 10, 85, 21);
			contentPanel.add(btnNewButton);
		}
		{
			JLabel lblNewLabel = new JLabel("MANTENIMIENO | CURSO");
			lblNewLabel.setForeground(Color.DARK_GRAY);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel.setBounds(10, 5, 208, 20);
			contentPanel.add(lblNewLabel);
		}
		{
			btnCerrar = new JButton("");
			btnCerrar.setRolloverIcon(new ImageIcon("imagenes\\BOTON_CERRAR_2.png"));
			btnCerrar.addActionListener(this);
			btnCerrar.setPressedIcon(new ImageIcon("imagenes\\BOTON_CERRAR_1.png"));
			btnCerrar.setRolloverSelectedIcon(null);
			btnCerrar.setIcon(new ImageIcon("imagenes\\BOTON_CERRAR_1.png"));
			btnCerrar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnCerrar.setContentAreaFilled(false);
			btnCerrar.setBorderPainted(false);
			btnCerrar.setBounds(662, 5, 28, 28);
			contentPanel.add(btnCerrar);
		}
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(105, 38, 102, 20);
		contentPanel.add(txtCodigo);
		
		txtAsignatura = new JTextField();
		txtAsignatura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAsignatura.setEditable(false);
		txtAsignatura.setColumns(10);
		txtAsignatura.setBounds(105, 68, 220, 20);
		contentPanel.add(txtAsignatura);
		
		txtCreditos = new JTextField();
		txtCreditos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCreditos.setEditable(false);
		txtCreditos.setColumns(10);
		txtCreditos.setBounds(105, 143, 102, 20);
		contentPanel.add(txtCreditos);
		
		txtHoras = new JTextField();
		txtHoras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtHoras.setEditable(false);
		txtHoras.setColumns(10);
		txtHoras.setBounds(105, 188, 102, 20);
		contentPanel.add(txtHoras);
		
		cboCicloCurso = new JComboBox();
		cboCicloCurso.setBounds(105, 98, 102, 20);
		cboCicloCurso.setModel(new DefaultComboBoxModel <String> (Lib.cicloCurso));
		cboCicloCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPanel.add(cboCicloCurso);
		
		
		JLabel lblImgCurso = new JLabel("");
		lblImgCurso.setIcon(new ImageIcon("imagenes\\Curso_img.png"));
		lblImgCurso.setBounds(366, 57, 155, 155);
		contentPanel.add(lblImgCurso);
		{
			btnAceptar = new JButton("ACEPTAR");
			btnAceptar.addMouseListener(this);
			btnAceptar.addActionListener(this);
			btnAceptar.setContentAreaFilled(false);
			btnAceptar.setBorderPainted(false);
			btnAceptar.setSelectedIcon(new ImageIcon("imagenes\\BotonAceptar1.png"));
			btnAceptar.setRolloverIcon(new ImageIcon("imagenes\\BotonAceptar2.png"));
			btnAceptar.setIcon(new ImageIcon("imagenes\\BotonAceptar1.png"));
			btnAceptar.setVerticalTextPosition(SwingConstants.CENTER);
			btnAceptar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnAceptar.setFont(new Font("Consolas", Font.BOLD, 16));
			btnAceptar.setFocusable(false);
			btnAceptar.setFocusTraversalKeysEnabled(false);
			btnAceptar.setFocusPainted(false);
			btnAceptar.setEnabled(false);
			btnAceptar.setBorder(null);
			btnAceptar.setBackground(Color.LIGHT_GRAY);
			btnAceptar.setBounds(217, 98, 110, 110);
			contentPanel.add(btnAceptar);
		}
		{
			btnBuscar = new JButton("BUSCAR");
			btnBuscar.addMouseListener(this);
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
			btnBuscar.setBounds(229, 18, 110, 40);
			contentPanel.add(btnBuscar);
		}
		{
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
			btnConsultar.setBounds(580, 38, 110, 40);
			contentPanel.add(btnConsultar);
		}
		{
			btnAdicionar = new JButton("ADICIONAR");
			btnAdicionar.addMouseListener(this);
			btnAdicionar.addActionListener(this);
			btnAdicionar.setPressedIcon(new ImageIcon("imagenes\\BOTON_AME_1.png"));
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
			btnAdicionar.setBounds(580, 88, 110, 40);
			contentPanel.add(btnAdicionar);
		}
		{
			btnModificar = new JButton("MODIFICAR");
			btnModificar.addMouseListener(this);
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
			btnModificar.setBounds(580, 138, 110, 40);
			contentPanel.add(btnModificar);
		}
		{
			btnEliminar = new JButton("ELIMINAR");
			btnEliminar.addMouseListener(this);
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
			btnEliminar.setBounds(580, 188, 110, 40);
			contentPanel.add(btnEliminar);
		}		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 248, 675, 242);
		contentPanel.add(scrollPane);
		
		tblCurso = new JTable();
		tblCurso.addKeyListener(this);
		tblCurso.addMouseListener(this);
		tblCurso.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblCurso);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("codCurso");
		modelo.addColumn("asignatura");
		modelo.addColumn("ciclo");
		modelo.addColumn("creditos");
		modelo.addColumn("horas");

		tblCurso.setModel(modelo);
		txtCodigo.setEditable(false);
		
		Listar();
		editarFila();
		HabilitarEntrada(false);
		btnBuscar.setEnabled(false);
		{
			MOVIMIENTO = new JLabel("");
			MOVIMIENTO.addMouseMotionListener(this);
			MOVIMIENTO.addMouseListener(this);
			MOVIMIENTO.setBounds(0, 0, 643, 28);
			contentPanel.add(MOVIMIENTO);
		}
	}
	
	ArregloCurso arregloCurso = new ArregloCurso();
	private JTable tblCurso;
	private JScrollPane scrollPane;
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnConsultar) {
			CONSULTAR(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			CERRAR(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			BUSCAR(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			ADICIONAR(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			MODIFICAR(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			ACEPTAR(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			ELIMINAR(arg0);
		}
	}
	protected void CERRAR(ActionEvent arg0) {
		this.dispose();
	}

	protected void CONSULTAR(ActionEvent arg0) {
		FuncionesGenerales.HabilitarBotones(true, btnAceptar, btnAdicionar, btnEliminar, btnModificar, btnBuscar);
		btnConsultar.setEnabled(false);
		btnAceptar.setEnabled(false);
		limpieza();
		txtCodigo.setEditable(true);
		txtCodigo.requestFocus();
	}

	protected void BUSCAR(ActionEvent arg0) {
		FuncionesGenerales.HabilitarBotones(true, btnAdicionar, btnConsultar, btnEliminar, btnModificar, btnBuscar);
		try {
			int codigoCurso = leerCodigoCurso();
			MostrarBusqueda(codigoCurso);
		}
		catch (Exception e) {
			FuncionesGenerales.error("No se encuentra algun curso con ese codigo");
			txtCodigo.requestFocus();
		}
	}
	
	protected void ADICIONAR(ActionEvent arg0) {
		FuncionesGenerales.HabilitarBotones(true, btnAceptar, btnBuscar, btnConsultar, btnEliminar, btnModificar);
		btnAdicionar.setEnabled(false);
		btnBuscar.setEnabled(false);
		txtCodigo.setEditable(true);
		limpieza();
		HabilitarEntrada(true);
		txtCodigo.requestFocus();
	}
	
	protected void MODIFICAR(ActionEvent arg0) {
		FuncionesGenerales.HabilitarBotones(true, btnAceptar, btnAdicionar, btnConsultar, btnEliminar, btnModificar);
		btnBuscar.setEnabled(false);
		btnModificar.setEnabled(false);
		if (arregloCurso.tamaño() == 0) {
			btnAceptar.setEnabled(false);
			HabilitarEntrada(false);
			FuncionesGenerales.error("No existen cursos");
			btnModificar.setEnabled(true);
		}else {
			editarFila();
			HabilitarEntrada(true);
			txtCodigo.setEditable(false);
			txtAsignatura.requestFocus();
		}
	}
	
	protected void ACEPTAR(ActionEvent arg0) {
		try {
			int codigo = leerCodigoCurso();
			if ((Codigo_4_Digitos(codigo)) && NoHayRepetidos(codigo) ) {
				try{
					String asignatura = leerAsignaturaCurso();
					int ciclo = leerCicloCurso();
					try {
						int creditos = leerCreditos();
						try {
							int horas = leerHoras();
							if (btnAdicionar.isEnabled() == false) {
								Curso nuevo = new Curso(codigo, asignatura, ciclo, creditos, horas);
								arregloCurso.adicionar(nuevo);
								btnAdicionar.setEnabled(true);
							}
							if (btnModificar.isEnabled() == false) {
								Curso curso = arregloCurso.buscar(codigo);
								curso.setAsignatura(asignatura);
								curso.setCiclo(ciclo);
								curso.setCreditos(creditos);
								curso.setHoras(horas);
								arregloCurso.actualizarArchivo();
								btnModificar.setEnabled(true);
							}
							Listar();
							HabilitarEntrada(false);
						}catch (Exception e) {
							FuncionesGenerales.error("DEBE INGRESAR LAS HORAS PARA EL CURSO");
							txtHoras.setText("");
							txtHoras.requestFocus();
						}
					}catch (Exception e) {
						FuncionesGenerales.error("DEBE INGRESAR UN NUMERO DE CREDITOS PARA EL CURSO");
						txtCreditos.setText("");
						txtCreditos.requestFocus();
					}
					
				}catch (Exception e) {
					FuncionesGenerales.error("DEBE INGRESAR EL NOMBRE DE LA ASIGNATURA");
				}
			}else {
				if (Codigo_4_Digitos(codigo) == false) {
					FuncionesGenerales.error("DEBE SER UN CODIGO DE 4 DIGITOS");
				}else {
					FuncionesGenerales.error("YA EXISTE ESE CODIGO");					
				}
				txtCodigo.requestFocus();

			}
		}catch (Exception e) {
			FuncionesGenerales.error("DEBES INGRESAR UN CODIGO PARA EL CURSO");
			txtCodigo.requestFocus();
		}
	}
	
	protected void ELIMINAR(ActionEvent arg0) {
		FuncionesGenerales.HabilitarBotones(true, btnAceptar, btnAdicionar, btnCerrar, btnConsultar, btnModificar);
		btnEliminar.setEnabled(false);
		btnBuscar.setEnabled(false);
		if (arregloCurso.tamaño() == 0) {
			FuncionesGenerales.error("No existen cursos para eliminar");
			btnEliminar.setEnabled(true);
		}
		else {
			editarFila();
			HabilitarEntrada(false);
			int codCurso = leerCodigoCurso();
			Curso C = arregloCurso.buscar(codCurso);
			if (ExistenAlumno(codCurso)) {
				int confirmacion = FuncionesGenerales.confirmar("Desea eliminar este curso");
				if (confirmacion == 0) {
					arregloCurso.eliminar(arregloCurso.buscar(codCurso));
					Listar();
					editarFila();
				}
				btnEliminar.setEnabled(true);
			}
			else {
				FuncionesGenerales.error("No se puede eliminar el curso " + C.getAsignatura() + "\nPorque hay alumnos registrados");
			}
			btnEliminar.setEnabled(true);
		}
	}

	ArregloMatricula arregloMatricula = new ArregloMatricula();
	private JLabel MOVIMIENTO;
	private boolean ExistenAlumno(int codCurso){
		for (int i = 0; i < arregloMatricula.tamaño(); i++) {
			Matricula m = arregloMatricula.obtener(i);
			if (codCurso == m.getcodCurso()) {
				return false;
			}
		}
		return true;
	}

	private void Listar() {
		int posFila = 0;
		modelo.setRowCount(0);
		Curso C;
		for (int i = 0; i < arregloCurso.tamaño(); i++) {
			C = arregloCurso.obtener(i);
			Object[] fila = {
					C.getCodCurso(),
					C.getAsignatura(),
					getCicloTxt(C.getCiclo()),
					C.getCreditos(),
					C.getHoras()};
			modelo.addRow(fila);
		}
		if (arregloCurso.tamaño() > 0) {
			tblCurso.getSelectionModel().setSelectionInterval(posFila, posFila);
		}
	}
	private boolean Codigo_4_Digitos(int cod) {
		if (cod >= 1000 && cod <= 9999) {
			return true;
		}
		return false;
	}
	
	private boolean NoHayRepetidos(int cod) {
		if (btnAdicionar.isEnabled() == false) {
			for (int i = 0; i < arregloCurso.tamaño(); i++) {
				if (cod == arregloCurso.obtener(i).getCodCurso()) {
					return false;
				}
			}
		}
		return true;
	}
	
	private void  editarFila() {
		if (arregloCurso.tamaño() == 0) {
			limpieza();
		}
		else {
			Curso C = arregloCurso.obtener(tblCurso.getSelectedRow());
			txtCodigo.setText("" + C.getCodCurso());
			txtAsignatura.setText(C.getAsignatura());
			cboCicloCurso.setSelectedIndex(C.getCiclo());
			txtCreditos.setText("" + C.getCreditos());
			txtHoras.setText("" + C.getHoras());
		}
	}
	
	private void HabilitarEntrada(boolean X){
		btnAceptar.setEnabled(X);
		txtCodigo.setEditable(X);
		txtAsignatura.setEditable(X);
		cboCicloCurso.setEditable(X);
		txtCreditos.setEditable(X);
		txtHoras.setEditable(X);
	}
	
	private void MostrarBusqueda(int codigo) {
		Curso C =arregloCurso.buscar(codigo);
		txtAsignatura.setText(C.getAsignatura());
		cboCicloCurso.setSelectedIndex(C.getCiclo());
		txtCreditos.setText("" + C.getCreditos());
		txtHoras.setText("" + C.getHoras());
	}
	
	private void limpieza() {
		txtCodigo.setText("");
		txtAsignatura.setText("");
		cboCicloCurso.setSelectedIndex(0);
		txtCreditos.setText("");
		txtHoras.setText("");
	}
	
	private int leerCodigoCurso() {
		return Integer.parseInt(txtCodigo.getText());
	}
	private String leerAsignaturaCurso() {
		return FuncionesGenerales.MayCorrespondiente(txtAsignatura.getText());
	}
	private int leerCicloCurso() {	
		return cboCicloCurso.getSelectedIndex();
	}
	private int leerCreditos() {
		return Integer.parseInt(txtCreditos.getText());
	}
	private int leerHoras() {
		return Integer.parseInt(txtHoras.getText());
	}
	private String getCicloTxt(int C) {
		return cboCicloCurso.getItemAt(C);
	}
	
	
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getSource() == tblCurso) {
			keyPressedTblCurso(arg0);
		}
	}
	public void keyReleased(KeyEvent arg0) {
		arg0.consume();
		editarFila();
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == MOVIMIENTO) {
			mouseClickedMOVIMIENTO(arg0);
		}
		if (arg0.getSource() == tblCurso) {
			mouseClickedTblCurso(arg0);
		}
	}
	protected void mouseClickedTblCurso(MouseEvent arg0) {
		HabilitarEntrada(false);
		FuncionesGenerales.HabilitarBotones(true, btnAdicionar, btnConsultar, btnEliminar, btnModificar, btnConsultar);
		txtCodigo.setEditable(false);
		editarFila();
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
		if (e.getSource() == tblCurso) {
			SeleccionarTblCurso(e);
		}
		if (e.getSource() == btnBuscar) {
			SeleccionarBtnBuscar(e);
		}
		if (e.getSource() == btnConsultar) {
			SeleccionarBtnConsultar(e);
		}
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
	protected void SeleccionarTblCurso(MouseEvent e) {
		tblCurso.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void SeleccionarBtnBuscar(MouseEvent e) {
		btnBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void SeleccionarBtnConsultar(MouseEvent e) {
		btnConsultar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	public void mouseExited(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
		
	}
	protected void keyPressedTblCurso(KeyEvent arg0) {
	}
	
	protected void mouseClickedMOVIMIENTO(MouseEvent arg0) {
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
