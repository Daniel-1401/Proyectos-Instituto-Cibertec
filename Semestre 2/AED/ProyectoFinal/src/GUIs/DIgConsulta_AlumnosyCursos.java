package GUIs;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import Arreglos.ArregloAlumno;
import Arreglos.ArregloCurso;
import Arreglos.ArregloMatricula;
import Clases.Alumno;
import Clases.Curso;
import Clases.Matricula;
import FuncionGenerales.FuncionesGenerales;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;

public class DIgConsulta_AlumnosyCursos extends JDialog implements ActionListener, MouseListener, KeyListener, MouseMotionListener {
	private JButton btnConsultarAlumno, btnConsultarCurso, btnCerrar;
	private JTextField txtCodAlumno;
	private JTextField txtCodCurso;
	private JComboBox<String> cboCodAlumno;
	private JComboBox<String> cboCodCurso;
	private JTable tblAlumno, tblCurso;
	private DefaultTableModel modeloAlumno , modeloCurso;
	private String[] Estados = {"REGISTRADO", "MATRICULADO", "RETIRADO"};
	private String[] Ciclos  = {"PRIMERO", "SEGUNDO", "TERCERO", "CUARTO", "QUINTO", "SEXTO"};
	private ArregloAlumno    aa = new ArregloAlumno();
	private ArregloCurso     ac = new ArregloCurso();
	private ArregloMatricula am = new ArregloMatricula();
	private JLabel MoverVentana;
	private JLabel lblNewLabel;
	private int xx, xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DIgConsulta_AlumnosyCursos dialog = new DIgConsulta_AlumnosyCursos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DIgConsulta_AlumnosyCursos() {
		setUndecorated(true);
		setSize(800,565);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		{
			JLabel lblAlumno = new JLabel("ALUMNO");
			lblAlumno.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblAlumno.setBounds(101, 60, 79, 21);
			getContentPane().add(lblAlumno);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("CODIGO:");
			lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_1.setBounds(24, 91, 78, 19);
			getContentPane().add(lblNewLabel_1);
		}
		{
			txtCodAlumno = new JTextField();
			txtCodAlumno.setColumns(10);
			txtCodAlumno.setBounds(111, 91, 102, 20);
			getContentPane().add(txtCodAlumno);
		}
		{
			txtCodCurso = new JTextField();
			txtCodCurso.setColumns(10);
			txtCodCurso.setBounds(514, 91, 102, 20);
			getContentPane().add(txtCodCurso);
		}
		{
			JLabel lblCurso = new JLabel("CURSO");
			lblCurso.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblCurso.setBounds(512, 60, 60, 21);
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
				modeloAlumno = new DefaultTableModel();
				modeloAlumno.addColumn("CodAlumno");
				modeloAlumno.addColumn("Nombre");
				modeloAlumno.addColumn("Apellido");
				modeloAlumno.addColumn("DNI");
				
				tblAlumno = new JTable();
				tblAlumno.setFillsViewportHeight(true);
				tblAlumno.setModel(modeloAlumno);
				scrollPaneAlumno.setViewportView(tblAlumno);
				
			}
		}
		
		{
			JScrollPane scrollPaneCurso = new JScrollPane();
			scrollPaneCurso.setBounds(418, 155, 370, 400);
			getContentPane().add(scrollPaneCurso);
			{
				modeloCurso = new DefaultTableModel();
				modeloCurso.addColumn("codCurso");
				modeloCurso.addColumn("Asignatura");
				modeloCurso.addColumn("Creditos");
				
				tblCurso = new JTable();
				tblCurso.setFillsViewportHeight(true);
				tblCurso.setModel(modeloCurso);
				scrollPaneCurso.setViewportView(tblCurso);
			}
		}
		
		lblNewLabel = new JLabel("CONSULTA | ALUMNO Y CURSO");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 10, 246, 20);
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
		
		btnConsultarAlumno = new JButton("CONSULTAR");
		btnConsultarAlumno.setPressedIcon(new ImageIcon("imagenes\\BOTON_AME_1.png"));
		btnConsultarAlumno.setRolloverIcon(new ImageIcon("imagenes\\BOTON_AME_2.png"));
		btnConsultarAlumno.setIcon(new ImageIcon("imagenes\\BOTON_AME_1.png"));
		btnConsultarAlumno.setVerticalTextPosition(SwingConstants.CENTER);
		btnConsultarAlumno.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConsultarAlumno.setFont(new Font("Consolas", Font.BOLD, 16));
		btnConsultarAlumno.setFocusable(false);
		btnConsultarAlumno.setFocusTraversalKeysEnabled(false);
		btnConsultarAlumno.setFocusPainted(false);
		btnConsultarAlumno.setContentAreaFilled(false);
		btnConsultarAlumno.setBorderPainted(false);
		btnConsultarAlumno.setBorder(null);
		btnConsultarAlumno.setBackground(Color.LIGHT_GRAY);
		btnConsultarAlumno.setBounds(258, 83, 110, 40);
		btnConsultarAlumno.addActionListener(this);
		getContentPane().add(btnConsultarAlumno);
		
		btnConsultarCurso = new JButton("CONSULTAR");
		btnConsultarCurso.setPressedIcon(new ImageIcon("imagenes\\BOTON_AME_1.png"));
		btnConsultarCurso.setRolloverIcon(new ImageIcon("imagenes\\BOTON_AME_2.png"));
		btnConsultarCurso.setIcon(new ImageIcon("imagenes\\BOTON_AME_1.png"));
		btnConsultarCurso.setVerticalTextPosition(SwingConstants.CENTER);
		btnConsultarCurso.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConsultarCurso.setFont(new Font("Consolas", Font.BOLD, 16));
		btnConsultarCurso.setFocusable(false);
		btnConsultarCurso.setFocusTraversalKeysEnabled(false);
		btnConsultarCurso.setFocusPainted(false);
		btnConsultarCurso.setContentAreaFilled(false);
		btnConsultarCurso.setBorderPainted(false);
		btnConsultarCurso.setBorder(null);
		btnConsultarCurso.setBackground(Color.LIGHT_GRAY);
		btnConsultarCurso.setBounds(648, 91, 110, 40);
		btnConsultarCurso.addActionListener(this);
		getContentPane().add(btnConsultarCurso);
		
		cboCodAlumno = new JComboBox<String>();
		cboCodAlumno.addActionListener(this);
		cboCodAlumno.setBounds(111, 121, 124, 20);
		getContentPane().add(cboCodAlumno);
		obtenerCodAlumno();
		
		cboCodCurso = new JComboBox<String>();
		cboCodCurso.addActionListener(this);
		cboCodCurso.setBounds(514, 121, 124, 20);
		getContentPane().add(cboCodCurso);
		obtenerCodCurso();
		
		ListarAlumno();
		ListarCurso();
		
	}
	private void NO_HAY_CODIGOS(JComboBox<String> cbo, JButton btn, JTextField txt) {
		cbo.addItem("NO HAY");
		cbo.setEnabled(false);
		btn.setEnabled(false);
		txt.setEditable(false);
	}	
	private void obtenerCodAlumno() {
		Alumno a;
		if (aa.tamaño() == 0) {
			NO_HAY_CODIGOS(cboCodAlumno, btnConsultarAlumno, txtCodAlumno);
		}
		else {
			cboCodAlumno.addItem("SELECCIONAR");
			for (int i = 0; i < aa.tamaño(); i++) {
				a = aa.obtener(i);
				cboCodAlumno.addItem("" + a.getCodAlumno());
			}
			if (cboCodAlumno.getItemCount() == 1) {
				cboCodAlumno.removeAllItems();
				NO_HAY_CODIGOS(cboCodAlumno, btnConsultarAlumno, txtCodAlumno);
			}
		}
	}
	private void obtenerCodCurso() {
		Curso c;
		if (ac.tamaño() == 0) {
			NO_HAY_CODIGOS(cboCodCurso, btnConsultarCurso, txtCodCurso);
		}
		else {
			cboCodCurso.addItem("SELECCIONAR");
			for (int i = 0; i < ac.tamaño(); i++) {
				c = ac.obtener(i);
				cboCodCurso.addItem("" + c.getCodCurso());
			}
			if (cboCodCurso.getItemCount() == 1) {
				cboCodCurso.removeAllItems();
				NO_HAY_CODIGOS(cboCodCurso, btnConsultarCurso, txtCodCurso);
			}
		}	
	}
	private int leerCodigoAlumno() {
		return Integer.parseInt(txtCodAlumno.getText());
	}
	private int leerCodigoCurso() {
		return Integer.parseInt(txtCodCurso.getText());
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
		String TITULO ="";
		if (btnConsultarAlumno.isEnabled() == false) {
			TITULO = "___________________________________\n" +
					 "│ DATOS DEL CURSO MATRICULADO │\n"     +
					 "¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n";
		}
		if (btnConsultarCurso.isEnabled() == false) {
			TITULO = "_____________________\n" +
					"│ DATOS DEL CURSO │\n"     +
					"¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n";
		}
		
		String DATOS_CURSO_ALUMNO =  
	 	  							 TITULO + 
	 	  							"¤ NOMBRE DEL CURSO___________" 	+ c.getAsignatura() + "\n" +
	 	  							"¤ CICLO_________________________"  + Ciclos[c.getCiclo()] + "\n" +
	 	  							"¤ CREDITOS DEL CURSO_________" 	+ c.getCreditos() + "\n" +
	 	  							"¤ HORAS DEL CURSO_____________" 	+ c.getHoras() + "\n" ;
		return DATOS_CURSO_ALUMNO;
	}
	
	private void ListarAlumno() {
		Alumno a;
		for (int i = 0; i < aa.tamaño(); i++) {
			a = aa.obtener(i);
			Object[] Fila = {
					a.getCodAlumno(),
					a.getNombre(),
					a.getApellidos(),
					a.getDni()};
		modeloAlumno.addRow(Fila);
		}
	}
	private void ListarCurso() {
		Curso c;
		for (int i = 0; i < ac.tamaño(); i++) {
			c = ac.obtener(i);
			Object[] Fila = {
					c.getCodCurso(),
					c.getAsignatura(),
					c.getCreditos()};
			modeloCurso.addRow(Fila);
		}
	}	
	
	private int BUSCAR_CodCURSO_ALUMNO(int codAlumno) {
		for (int i = 0; i < am.tamaño(); i++) {
			Matricula m = am.obtener(i);
			if (codAlumno == m.getcodAlumno()) {
				return m.getcodCurso();
			}
		}
		return -1;
	}
	protected void MOSTRAR_BUSQUEDA_ALUMNO(ActionEvent arg0) {
		btnConsultarAlumno.setEnabled(false);
		try {
			int codAlumno = leerCodigoAlumno();
			Alumno alumno = aa.buscar(codAlumno);
			String DATOS_ALUMNO = DatosAlumno(alumno);
			String DATOS_CURSO_ALUMNO = "";
			
			if (alumno.getEstado() == 1) {
				int codCurso 		= BUSCAR_CodCURSO_ALUMNO(codAlumno);
				Curso curso  		= ac.buscar(codCurso);
				DATOS_CURSO_ALUMNO 	= DatosCurso(curso);
			}
			
			FuncionesGenerales.mensaje(DATOS_ALUMNO + DATOS_CURSO_ALUMNO );
			btnConsultarAlumno.setEnabled(true);
		}catch (Exception e) {
			FuncionesGenerales.error("DEBES SELECCIONAR UN CODIGO");
		}
	}
	protected void MOSTRAR_BUSQUEDA_CURSO(ActionEvent arg0) {
		btnConsultarCurso.setEnabled(false);
		try {
			int codCurso = leerCodigoCurso();
			Curso curso = ac.buscar(codCurso);
			String DATOS_CURSO = DatosCurso(curso);
			
			FuncionesGenerales.mensaje(DATOS_CURSO);
			btnConsultarCurso.setEnabled(true);
		}catch (Exception e) {
			FuncionesGenerales.error("DEBES SLECCIONAR UN CODIGO");
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			CERRAR(arg0);
		}
		if (arg0.getSource() == cboCodCurso) {
			COLOCAR_CODIGO_CURSO(arg0);
		}
		if (arg0.getSource() == cboCodAlumno) {
			COLOCAR_CODIGO_ALUMNO(arg0);
		}
		if (arg0.getSource() == btnConsultarAlumno) {
			MOSTRAR_BUSQUEDA_ALUMNO(arg0);
		}
		if (arg0.getSource() == btnConsultarCurso) {
			MOSTRAR_BUSQUEDA_CURSO(arg0);
		}
	}
	protected void CERRAR(ActionEvent arg0) {
		this.dispose();
	}
	protected void COLOCAR_CODIGO_CURSO(ActionEvent arg0) {
		try{
			txtCodCurso.setText("" + cboCodCurso.getSelectedItem());
		}catch (Exception e) {
		}
	}
	protected void COLOCAR_CODIGO_ALUMNO(ActionEvent arg0) {
		try {
			txtCodAlumno.setText("" + cboCodAlumno.getSelectedItem());
		} catch (Exception e) {
		}
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
