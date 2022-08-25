package GUIs;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import Clases.*;
import Arreglos.*;
import FuncionGenerales.FuncionesGenerales;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DIgConsulta_MatriculasyRetiro extends JDialog implements ActionListener, MouseListener, KeyListener, MouseMotionListener{
	private JLabel lblNewLabel0;
	private JLabel lblNewLabel1;
	private JLabel lblNewLabel2;
	private JLabel lblNewLabel3;
	private JTextField txtCodMatricula;
	private JTextField txtCodRetiro;
	private JButton btnConsultarMatricula;
	private JButton btnConsultarRetiro;
	private JButton btnCerrar;
	private JTable tblMatricula, tblRetiro;
	private DefaultTableModel modeloMatricula, modeloRetiro;
	private JComboBox<String> cboCodMatricula;
	private JComboBox<String> cboCodRetiro;
	private String[] Estados = {"REGISTRADO", "MATRICULADO", "RETIRADO"};
	private String[] Ciclos  = {"PRIMERO", "SEGUNDO", "TERCERO", "CUARTO", "QUINTO", "SEXTO"};
	private ArregloMatricula am = new ArregloMatricula();
	private ArregloRetiro 	 ar = new ArregloRetiro();
	private ArregloAlumno 	 aa = new ArregloAlumno();
	private ArregloCurso 	 ac = new ArregloCurso();
	private JLabel MoverVentana;
	private JLabel lblNewLabel;
	private int xx, xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DIgConsulta_MatriculasyRetiro dialog = new DIgConsulta_MatriculasyRetiro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DIgConsulta_MatriculasyRetiro() {
		setUndecorated(true);
		setSize(800,565);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		{
			JLabel lblAlumno = new JLabel("MATRICULA");
			lblAlumno.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblAlumno.setBounds(101, 60, 120, 21);
			getContentPane().add(lblAlumno);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("CODIGO:");
			lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_1.setBounds(24, 91, 78, 19);
			getContentPane().add(lblNewLabel_1);
		}
		{
			txtCodMatricula = new JTextField();
			txtCodMatricula.setColumns(10);
			txtCodMatricula.setBounds(111, 91, 102, 20);
			getContentPane().add(txtCodMatricula);
		}
		{
			txtCodRetiro = new JTextField();
			txtCodRetiro.setColumns(10);
			txtCodRetiro.setBounds(514, 91, 102, 20);
			getContentPane().add(txtCodRetiro);
		}
		{
			JLabel lblCurso = new JLabel("RETIRO");
			lblCurso.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblCurso.setBounds(512, 60, 80, 21);
			getContentPane().add(lblCurso);
		}
		{
			JLabel lblNewLabel_1_1 = new JLabel("CODIGO:");
			lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_1_1.setBounds(423, 91, 78, 19);
			getContentPane().add(lblNewLabel_1_1);
		}
		{	
			JScrollPane scrollPaneAlumno = new JScrollPane();
			scrollPaneAlumno.setBounds(10, 155, 400, 400);
			getContentPane().add(scrollPaneAlumno);
			{
				modeloMatricula = new DefaultTableModel();
				modeloMatricula.addColumn("numMatricula");
				modeloMatricula.addColumn("codAlumno");
				modeloMatricula.addColumn("codCurso");
				modeloMatricula.addColumn("fecha");
				modeloMatricula.addColumn("hora");
				
				tblMatricula = new JTable();
				tblMatricula.setFillsViewportHeight(true);
				tblMatricula.setModel(modeloMatricula);
				scrollPaneAlumno.setViewportView(tblMatricula);
				
			}
		}
		
		{
			JScrollPane scrollPaneCurso = new JScrollPane();
			scrollPaneCurso.setBounds(418, 155, 370, 400);
			getContentPane().add(scrollPaneCurso);
			{
				modeloRetiro = new DefaultTableModel();
				modeloRetiro.addColumn("numRetiro");
				modeloRetiro.addColumn("numMatricula");
				modeloRetiro.addColumn("fecha");
				modeloRetiro.addColumn("hora");
				
				tblRetiro = new JTable();
				tblRetiro.setFillsViewportHeight(true);
				tblRetiro.setModel(modeloRetiro);
				scrollPaneCurso.setViewportView(tblRetiro);
			}
		}
		
		lblNewLabel = new JLabel("CONSULTA | MATRICULA Y RETIRO");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 10, 277, 20);
		getContentPane().add(lblNewLabel);
		
		btnCerrar = new JButton("");
		btnCerrar.addActionListener(this);
		btnCerrar.setPressedIcon(new ImageIcon("imagenes\\BOTON_CERRAR_1.png"));
		btnCerrar.setRolloverIcon(new ImageIcon("imagenes\\BOTON_CERRAR_2.png"));
		btnCerrar.setIcon(new ImageIcon("imagenes\\BOTON_CERRAR_1.png"));
		btnCerrar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setBorderPainted(false);
		btnCerrar.setBounds(760, 10, 28, 28);
		getContentPane().add(btnCerrar);
		
		MoverVentana = new JLabel("");
		MoverVentana.addMouseMotionListener(this);
		MoverVentana.addMouseListener(this);
		MoverVentana.setBounds(0, 0, 755, 28);
		getContentPane().add(MoverVentana);
		
		btnConsultarMatricula = new JButton("CONSULTAR");
		btnConsultarMatricula.setPressedIcon(new ImageIcon("imagenes\\BOTON_AME_1.png"));
		btnConsultarMatricula.setRolloverIcon(new ImageIcon("imagenes\\BOTON_AME_2.png"));
		btnConsultarMatricula.setIcon(new ImageIcon("imagenes\\BOTON_AME_1.png"));
		btnConsultarMatricula.setVerticalTextPosition(SwingConstants.CENTER);
		btnConsultarMatricula.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConsultarMatricula.setFont(new Font("Consolas", Font.BOLD, 16));
		btnConsultarMatricula.setFocusable(false);
		btnConsultarMatricula.setFocusTraversalKeysEnabled(false);
		btnConsultarMatricula.setFocusPainted(false);
		btnConsultarMatricula.setContentAreaFilled(false);
		btnConsultarMatricula.setBorderPainted(false);
		btnConsultarMatricula.setBorder(null);
		btnConsultarMatricula.setBackground(Color.LIGHT_GRAY);
		btnConsultarMatricula.setBounds(258, 83, 110, 40);
		btnConsultarMatricula.addActionListener(this);
		getContentPane().add(btnConsultarMatricula);
		
		btnConsultarRetiro = new JButton("CONSULTAR");
		btnConsultarRetiro.setPressedIcon(new ImageIcon("imagenes\\BOTON_AME_1.png"));
		btnConsultarRetiro.setRolloverIcon(new ImageIcon("imagenes\\BOTON_AME_2.png"));
		btnConsultarRetiro.setIcon(new ImageIcon("imagenes\\BOTON_AME_1.png"));
		btnConsultarRetiro.setVerticalTextPosition(SwingConstants.CENTER);
		btnConsultarRetiro.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConsultarRetiro.setFont(new Font("Consolas", Font.BOLD, 16));
		btnConsultarRetiro.setFocusable(false);
		btnConsultarRetiro.setFocusTraversalKeysEnabled(false);
		btnConsultarRetiro.setFocusPainted(false);
		btnConsultarRetiro.setContentAreaFilled(false);
		btnConsultarRetiro.setBorderPainted(false);
		btnConsultarRetiro.setBorder(null);
		btnConsultarRetiro.setBackground(Color.LIGHT_GRAY);
		btnConsultarRetiro.setBounds(648, 83, 110, 40);
		btnConsultarRetiro.addActionListener(this);
		getContentPane().add(btnConsultarRetiro);
		
		cboCodMatricula = new JComboBox<String>();
		cboCodMatricula.setBounds(111, 121, 124, 20);
		cboCodMatricula.addActionListener(this);
		getContentPane().add(cboCodMatricula);
		obtenerCodigosMatricula();
		
		cboCodRetiro = new JComboBox<String>();
		cboCodRetiro.setBounds(514, 121, 124, 20);
		cboCodRetiro.addActionListener(this);
		getContentPane().add(cboCodRetiro);
		obtenerCodigosRetiro();
		
		ListarMatricula();
		ListarRetiro();
		txtCodMatricula.setText("");
		txtCodRetiro.setText("");
	}
	private void NO_HAY_CODIGOS(JComboBox<String> cbo, JButton btn, JTextField txt) {
		cbo.addItem("NO HAY");
		cbo.setEnabled(false);
		btn.setEnabled(false);
		txt.setEditable(false);
	}	
	private void obtenerCodigosMatricula() {
		Matricula m;
		if (am.tamaño() == 0) {
			NO_HAY_CODIGOS(cboCodMatricula, btnConsultarMatricula, txtCodMatricula);
		}
		else {
			cboCodMatricula.addItem("SELECCIONAR");
			for (int i = 0; i < am.tamaño(); i++) {
				m = am.obtener(i);
				cboCodMatricula.addItem("" + m.getnumMatricula());
			}
			if (cboCodMatricula.getItemCount() == 1) {
				NO_HAY_CODIGOS(cboCodMatricula, btnConsultarMatricula, txtCodMatricula);
			}
		}
	}
	private void obtenerCodigosRetiro() {
		Retiro r;
		if (ar.tamaño() == 0) {
			NO_HAY_CODIGOS(cboCodRetiro, btnConsultarRetiro, txtCodRetiro);
		}
		else {
			cboCodRetiro.addItem("SELECCIONAR");
			for (int i = 0; i < ar.tamaño(); i++) {
				r = ar.obtener(i);
				cboCodRetiro.addItem("" + r.getNumRetiro());
			}
		}
	}
	
	private void ListarMatricula(){
		Matricula m;
		for (int i = 0; i < am.tamaño(); i++) {
			m = am.obtener(i);
			Object[] Fila = {
					m.getnumMatricula(),
					m.getcodAlumno(),
					m.getcodCurso(),
					m.getFecha(),
					m.getHora()};
			modeloMatricula.addRow(Fila);
		}
	}
	private void ListarRetiro() {
		Retiro r;
		for (int i = 0; i < ar.tamaño(); i++) {
			r = ar.obtener(i);
			Object[] Fila = {
					r.getNumRetiro(),
					r.getNumMatricula(),
					r.getFecha(),
					r.getHora()};
			modeloRetiro.addRow(Fila);
		}
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			CERRAR(arg0);
		}
		if (arg0.getSource() == btnConsultarMatricula) {
			MOSTRAR_BUSQUEDA_MATRICULA(arg0);
		}
		if (arg0.getSource() == btnConsultarRetiro) {
			MOSTRAR_BUSQUEDA_RETIRO(arg0);
		}
		if (arg0.getSource() == cboCodMatricula) {
			COLOCAR_CODIGO_MATRICULA(arg0);
		}
		if (arg0.getSource() == cboCodRetiro) {
			COLOCAR_CODIGO_RETIRO(arg0);
		}
	}
	protected void CERRAR(ActionEvent arg0) {
		this.dispose();
	}
	protected void COLOCAR_CODIGO_MATRICULA(ActionEvent arg0) {
		try{
			txtCodMatricula.setText("" + cboCodMatricula.getSelectedItem());
		}catch (Exception e) {
		}
	}
	protected void COLOCAR_CODIGO_RETIRO(ActionEvent arg0) {
		try {
			txtCodRetiro.setText("" + cboCodRetiro.getSelectedItem());
		} catch (Exception e) {
		}
	}
	private String DatosAlumno(Alumno a) {
		
		String DATOS_ALUMNO = 
									"______________________\n" +
									"│ DATOS DEL ALUMNO │\n"    +
									"¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n" +
						 	  		"¤ NOMBRES Y APELLIDOS________"    + a.getNombre()  + " "  + a.getApellidos() + "\n" +
						 	  		"¤ DNI___________________________" + a.getDni()     + "\n" +
						 	  		"¤ EDAD_________________________"  + a.getEdad()    + "\n" + 
						 	  		"¤ CELULAR______________________"  + a.getCelular() + "\n" +
						 	  		"¤ ESTADO_______________________"  + Estados[a.getEstado()] + "\n";
		return DATOS_ALUMNO;
	}
	private String DatosCurso(Curso c) {
		String DATOS_CURSO =  
									"_____________________\n" +
									"│ DATOS DEL CURSO │\n"     +
									"¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n" + 
	 	  							"¤ NOMBRE DEL CURSO___________" 	+ c.getAsignatura() + "\n" +
	 	  							"¤ CICLO_________________________"  + Ciclos[c.getCiclo()] + "\n" +
	 	  							"¤ CREDITOS DEL CURSO_________" 	+ c.getCreditos() + "\n" +
	 	  							"¤ HORAS DEL CURSO_____________" 	+ c.getHoras() + "\n" ;
		return DATOS_CURSO;
	}
	private String DatosMatricula(Matricula m) {
		String DATOS_MATRICULA = 
									"________________________\n"  +
									"│ DATOS DE MATRICULA │\n" +
									"¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n"  +
									"¤ NUMERO DE MATRICULA_________"   + m.getnumMatricula() + "\n" +
									"¤ CODIGO DEL ALUMNO___________"   + m.getcodAlumno() + "\n" +
									"¤ CODIGO DEL CURSO_____________"  + m.getcodCurso() + "\n" +
									"¤ FECHA DE LA MATRICULA________"  + m.getFecha() + "\n" +
									"¤ HORA DE LA MATRICULA________"   + m.getHora() + "\n";
		return DATOS_MATRICULA;
	}
	private String DatosRetiro(Retiro r) {
		String DATOS_RETIRO = 
									"_____________________\n"  +
									"│ DATOS DEL RETIRO │\n"   +
									"¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n"  +
									"¤ NUMERO DE RETIRO______________"     + r.getNumRetiro() + "\n" +
									"¤ NUMERO DE MATRICULA__________"  + r.getNumMatricula() + "\n" +
									"¤ FECHA DEL RETIRO_______________"     + r.getFecha() + "\n" +
									"¤ HORA DEL RETIRO________________"      + r.getHora() + "\n";
		return DATOS_RETIRO;
	}
	protected void MOSTRAR_BUSQUEDA_MATRICULA(ActionEvent arg0) {
		btnConsultarMatricula.setEnabled(false);
		try {
			int numMatricula = LeerNumMatricula();
			Matricula m = am.buscar(numMatricula);
			Alumno a = aa.buscar(m.getcodAlumno());
			Curso  c = ac.buscar(m.getcodCurso());
			
			String DATOS_MATRICULA = DatosMatricula(m);
			String DATOS_ALUMNO    = DatosAlumno(a);
			String DATOS_CURSO     = DatosCurso(c);
			
			FuncionesGenerales.mensaje(DATOS_MATRICULA + DATOS_ALUMNO + DATOS_CURSO);
			btnConsultarMatricula.setEnabled(true);
		}catch (Exception e) {
			FuncionesGenerales.error("DEBE SELECCIONAR UN NUMERO DE MATRICULA");
			btnConsultarMatricula.setEnabled(true);
		}
	}
	protected void MOSTRAR_BUSQUEDA_RETIRO(ActionEvent arg0) {
		btnConsultarRetiro.setEnabled(false);
		try {
			int numRetiro = LeerNumRetiro();
			Retiro r = ar.buscar(numRetiro);
			Matricula m = am.buscar(r.getNumMatricula());
			Alumno a = aa.buscar(m.getcodAlumno());
			Curso  c = ac.buscar(m.getcodCurso());
			
			String DATOS_RETIRO    = DatosRetiro(r);
			String DATOS_ALUMNO    = DatosAlumno(a);
			String DATOS_CURSO     = DatosCurso(c);
			
			FuncionesGenerales.mensaje(DATOS_RETIRO + DATOS_ALUMNO + DATOS_CURSO);
			btnConsultarRetiro.setEnabled(true);
		} catch (Exception e) {
			FuncionesGenerales.error("DEBE SELECCIONAR UN NUMERO DE RETIRO");
			btnConsultarRetiro.setEnabled(true);
		}
	}
	private int LeerNumMatricula() {
		return Integer.parseInt(txtCodMatricula.getText());
	}
	private int LeerNumRetiro() {
		return Integer.parseInt(txtCodRetiro.getText());
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

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
