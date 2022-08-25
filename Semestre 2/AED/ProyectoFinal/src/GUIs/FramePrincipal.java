package GUIs;

import java.util.Date;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.SimpleDateFormat;
import java.text.ParseException;

import ConectorBD.Conexion;

public class FramePrincipal extends JFrame implements ActionListener {

	private JPanel 		contentPane;
	private JLabel 		lblFondo;
	private JMenuBar  	MenuBarProyecto;
	private JMenu		mnArchivo;
	private JMenu		mnMantenimiento;
	private JMenu		mnRegistro;
	private JMenu		mnConsulta;
	private JMenu		mnReporte;
	private JMenuItem 	SALIR;
	private JMenuItem 	ALUMNO;
	private JMenuItem 	CURSO;
	private JMenuItem 	MATRICULA;
	private JMenuItem 	RETIRO;
	private JMenuItem 	ALUMNO_Y_CURSO;
	private JMenuItem 	MATRICULAS_Y_RETIROS;
	private JMenuItem 	ALUMNO_CON_MATRICULA_PENDIENTE;
	private JMenuItem 	ALUMNO_CON_MATRICULA_VIGENTE;
	private JMenuItem 	ALUMNO_MATRICULADOS_POR_CURSO;
	
	
	public static Date FechaSistema;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePrincipal frame = new FramePrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
//		try {
//			Statement sql = Conexion.getConexion().createStatement();
//		}catch (SQLException e) {
//			System.out.println(e.toString());
//		}
	}
	
//	 public static Date ParseFecha(String fecha)
//	    {
//	        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//	        Date fechaDate = null;
//	        try {
//	            fechaDate = formato.parse(fecha);
//	        } 
//	        catch (ParseException ex) 
//	        {
//	            System.out.println(ex);
//	        }
//	        return fechaDate;
//	    }

	/**
	 * Create the frame.
	 */
	public FramePrincipal() {
		
		setResizable(false);
		setTitle("Proyecto 2020 - 2");
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes\\Logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(950,600);
		this.setLocationRelativeTo(null);
		
		MenuBarProyecto = new JMenuBar();
		MenuBarProyecto.setSize(70,600);
		setJMenuBar(MenuBarProyecto);
		
		mnArchivo = new JMenu("ARCHIVO");
		mnArchivo.setFont(new Font("Verdana", Font.BOLD, 15));
		MenuBarProyecto.add(mnArchivo);
		
			SALIR = new JMenuItem("SALIR");
			SALIR.setBackground(UIManager.getColor("CheckBox.background"));
			SALIR.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK));
			SALIR.setFont(new Font("Century Gothic", Font.BOLD, 15));
			SALIR.addActionListener(this);
			mnArchivo.add(SALIR);
			
		mnMantenimiento = new JMenu("MANTENIMIENTO");
		mnMantenimiento.setBackground(UIManager.getColor("CheckBox.background"));
		mnMantenimiento.setFont(new Font("Verdana", Font.BOLD, 15));
		MenuBarProyecto.add(mnMantenimiento);
			
			ALUMNO = new JMenuItem("ALUMNOS");
			ALUMNO.setFont(new Font("Century Gothic", Font.BOLD, 15));
			ALUMNO.addActionListener(this);
			mnMantenimiento.add(ALUMNO);
			
			CURSO = new JMenuItem("CURSO");
			CURSO.setFont(new Font("Century Gothic", Font.BOLD, 15));
			CURSO.addActionListener(this);
			mnMantenimiento.add(CURSO);
			
		mnRegistro = new JMenu("REGISTRO");
		mnRegistro.setFont(new Font("Verdana", Font.BOLD, 15));
		MenuBarProyecto.add(mnRegistro);
		
			MATRICULA = new JMenuItem("MATRICULA");
			MATRICULA.setFont(new Font("Century Gothic", Font.BOLD, 15));
			MATRICULA.addActionListener(this);
			mnRegistro.add(MATRICULA);
			
			RETIRO = new JMenuItem("RETIRO");
			RETIRO.setFont(new Font("Century Gothic", Font.BOLD, 15));
			RETIRO.addActionListener(this);
			mnRegistro.add(RETIRO);
		
		mnConsulta = new JMenu("CONSULTA");
		mnConsulta.setFont(new Font("Verdana", Font.BOLD, 15));
		MenuBarProyecto.add(mnConsulta);
		
			ALUMNO_Y_CURSO = new JMenuItem("ALUMNOS Y CURSOS");
			ALUMNO_Y_CURSO.setFont(new Font("Century Gothic", Font.BOLD, 15));
			ALUMNO_Y_CURSO.addActionListener(this);
			mnConsulta.add(ALUMNO_Y_CURSO);
			
			MATRICULAS_Y_RETIROS = new JMenuItem("MATRICULAS Y RETIROS");
			MATRICULAS_Y_RETIROS.setFont(new Font("Century Gothic", Font.BOLD, 15));
			MATRICULAS_Y_RETIROS.addActionListener(this);
			mnConsulta.add(MATRICULAS_Y_RETIROS);
			
		mnReporte = new JMenu("REPORTE");
		mnReporte.setFont(new Font("Verdana", Font.BOLD, 15));
		MenuBarProyecto.add(mnReporte);
		
			ALUMNO_CON_MATRICULA_PENDIENTE = new JMenuItem("ALUMNO CON MATRICULA PENDIENTE");
			ALUMNO_CON_MATRICULA_PENDIENTE.setFont(new Font("Century Gothic", Font.BOLD, 15));
			ALUMNO_CON_MATRICULA_PENDIENTE.addActionListener(this);
			mnReporte.add(ALUMNO_CON_MATRICULA_PENDIENTE);
			
			ALUMNO_CON_MATRICULA_VIGENTE = new JMenuItem("ALUMNO CON MATRICULA VIGENTE");
			ALUMNO_CON_MATRICULA_VIGENTE.setFont(new Font("Century Gothic", Font.BOLD, 15));
			ALUMNO_CON_MATRICULA_VIGENTE.addActionListener(this);
			mnReporte.add(ALUMNO_CON_MATRICULA_VIGENTE);
			
			ALUMNO_MATRICULADOS_POR_CURSO = new JMenuItem("ALUMNO CON MATRICULADOS POR CURSO");
			ALUMNO_MATRICULADOS_POR_CURSO.setFont(new Font("Century Gothic", Font.BOLD, 15));
			ALUMNO_MATRICULADOS_POR_CURSO.addActionListener(this);
			mnReporte.add(ALUMNO_MATRICULADOS_POR_CURSO);
			
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		lblFondo = new JLabel();
		lblFondo.setIcon(new ImageIcon("imagenes\\FondoPrincipal.jpg"));
		lblFondo.setBounds(0, -29, 950, 600);
		getContentPane().add(lblFondo);
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == ALUMNO_MATRICULADOS_POR_CURSO) {
			JDialogALUMNO_MATRICULADOS_POR_CURSO(arg0);
		}
		if (arg0.getSource() == ALUMNO_CON_MATRICULA_VIGENTE) {
			JDialogALUMNO_CON_MATRICULA_VIGENTE(arg0);
		}
		if (arg0.getSource() == ALUMNO_CON_MATRICULA_PENDIENTE) {
			JDialogALUMNO_CON_MATRICULA_PENDIENTE(arg0);
		}
		if (arg0.getSource() == MATRICULAS_Y_RETIROS) {
			JDialogMATRICULAS_Y_RETIROS(arg0);
		}
		if (arg0.getSource() == ALUMNO_Y_CURSO) {
			JDialogALUMNO_Y_CURSO(arg0);
		}
		if (arg0.getSource() == RETIRO) {
			JDialogRETIRO(arg0);
		}
		if (arg0.getSource() == MATRICULA) {
			JDialogMATRICULA(arg0);
		}
		if (arg0.getSource() == CURSO) {
			JDialogCURSO(arg0);
		}
		if (arg0.getSource() == ALUMNO) {
			JDialogAlumno(arg0);
		}
		if (arg0.getSource() == SALIR) {
			JDialogSalir(arg0);
		}
	}
	protected void JDialogSalir(ActionEvent arg0) {
		dispose();
	}
	protected void JDialogAlumno(ActionEvent arg0) {
		DlgMantenimiento_Alumno DMA = new DlgMantenimiento_Alumno();
		DMA.setLocationRelativeTo(null);
		DMA.setVisible(true);
	}
	protected void JDialogCURSO(ActionEvent arg0) {
		DlgMantenimiento_Curso DMC = new DlgMantenimiento_Curso();
		DMC.setLocationRelativeTo(null);
		DMC.setVisible(true);
	}
	protected void JDialogMATRICULA(ActionEvent arg0) {
		DlgRegistro_Matricula DRM = new DlgRegistro_Matricula();
		DRM.setLocationRelativeTo(null);
		DRM.setVisible(true);
		
	}
	protected void JDialogRETIRO(ActionEvent arg0) {
		DlgRegistro_Retiro DRR = new DlgRegistro_Retiro();
		DRR.setLocationRelativeTo(null);
		DRR.setVisible(true);
	}
	protected void JDialogALUMNO_Y_CURSO(ActionEvent arg0) {
		DIgConsulta_AlumnosyCursos DCA_C = new DIgConsulta_AlumnosyCursos();
		DCA_C.setLocationRelativeTo(null);
		DCA_C.setVisible(true);
	}
	protected void JDialogMATRICULAS_Y_RETIROS(ActionEvent arg0) {
		DIgConsulta_MatriculasyRetiro DCM_R = new DIgConsulta_MatriculasyRetiro();
		DCM_R.setLocationRelativeTo(null);
		DCM_R.setVisible(true);
	}
	protected void JDialogALUMNO_CON_MATRICULA_PENDIENTE(ActionEvent arg0) {
		DlgReporte_Matricula_Pendiente DRM_P = new DlgReporte_Matricula_Pendiente();
		DRM_P.setLocationRelativeTo(null);
		DRM_P.setVisible(true);
	}
	protected void JDialogALUMNO_CON_MATRICULA_VIGENTE(ActionEvent arg0) {
		DlgReporte_Matricula_Vigente DRM_V = new DlgReporte_Matricula_Vigente();
		DRM_V.setLocationRelativeTo(null);
		DRM_V.setVisible(true);
	}
	protected void JDialogALUMNO_MATRICULADOS_POR_CURSO(ActionEvent arg0) {
		DlgReporte_Matricula_Curso DRM_C = new DlgReporte_Matricula_Curso();
		DRM_C.setLocationRelativeTo(null);
		DRM_C.setVisible(true);
	}
}
