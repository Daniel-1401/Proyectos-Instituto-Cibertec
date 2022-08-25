package GUIs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Arreglos.ArregloAlumno;
import Arreglos.ArregloCurso;
import Arreglos.ArregloMatricula;
import Clases.Alumno;
import Clases.Curso;
import Clases.Matricula;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class DlgReporte_Matricula_Curso extends JDialog implements ActionListener, MouseListener, KeyListener, MouseMotionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnListar;
	private JTextArea txtResultado;
	private JButton btnCerrar;
	private JLabel lblNewLabel_1;
	private JLabel MoverVentana;
	private int xx, xy;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgReporte_Matricula_Curso dialog = new DlgReporte_Matricula_Curso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgReporte_Matricula_Curso() {
		setUndecorated(true);
		setResizable(false);
		setSize(800,500);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alumnos matriculados por curso ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(32, 48, 329, 22);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("REPORTE | CURSO");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 10, 277, 20);
		contentPanel.add(lblNewLabel_1);
		
		btnCerrar = new JButton("");
		btnCerrar.addActionListener(this);
		btnCerrar.setPressedIcon(new ImageIcon("imagenes\\BOTON_CERRAR_1.png"));
		btnCerrar.setRolloverIcon(new ImageIcon("imagenes\\BOTON_CERRAR_2.png"));
		btnCerrar.setIcon(new ImageIcon("imagenes\\BOTON_CERRAR_1.png"));
		btnCerrar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setBorderPainted(false);
		btnCerrar.setBounds(760, 10, 28, 28);
		contentPanel.add(btnCerrar);
		
		MoverVentana = new JLabel("");
		MoverVentana.addMouseMotionListener(this);
		MoverVentana.addMouseListener(this);
		MoverVentana.setBounds(0, 0, 755, 28);
		contentPanel.add(MoverVentana);
		
		btnListar = new JButton("LISTAR");
		btnListar.setPressedIcon(new ImageIcon("imagenes\\BOTON_AME_1.png"));
		btnListar.setRolloverIcon(new ImageIcon("imagenes\\BOTON_AME_2.png"));
		btnListar.setIcon(new ImageIcon("imagenes\\BOTON_AME_1.png"));
		btnListar.setVerticalTextPosition(SwingConstants.CENTER);
		btnListar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnListar.setFont(new Font("Consolas", Font.BOLD, 16));
		btnListar.setFocusable(false);
		btnListar.setFocusTraversalKeysEnabled(false);
		btnListar.setFocusPainted(false);
		btnListar.setContentAreaFilled(false);
		btnListar.setBorderPainted(false);
		btnListar.setBorder(null);
		btnListar.setBackground(Color.LIGHT_GRAY);
		btnListar.setBounds(361, 46, 110, 40);
		btnListar.addActionListener(this);
		contentPanel.add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 93, 724, 384);
		contentPanel.add(scrollPane);
		
		txtResultado = new JTextArea();
		scrollPane.setViewportView(txtResultado);
	}
		
		void listar() {
			
			
		
		ArregloAlumno arregloAlumno = new ArregloAlumno();
		ArregloCurso arregloCurso = new ArregloCurso();
		ArregloMatricula arregloMatricula = new ArregloMatricula();
		
		txtResultado.append("CODALUMNO" + "\t" + 
				"NOMBRE"+ "\t" +
				"APELLIDOS"+ "\t\t" +
				"CODCURSO" + "\t" +
				"ASIGNATURA"+ "\n");	
		
			for (int j = 0; j < arregloMatricula.tamaño(); j++) {
				Matricula matricula = arregloMatricula.obtener(j);
			Alumno alumno = arregloAlumno.buscar(matricula.getcodAlumno());
			Curso curso = arregloCurso.buscar(matricula.getcodCurso());
			
			txtResultado.append(alumno.getCodAlumno() + "\t" + 
					alumno.getNombre()+ "\t" +
					alumno.getApellidos()+ "\t\t" +
					curso.getCodCurso() + "\t" +
					curso.getAsignatura()+ "\n");
			
			}
			
		
	}
	
	
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnListar) {
			actionPerformedBtnListar(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			CERRAR(arg0);
		}
	}
	protected void CERRAR(ActionEvent arg0) {
		this.dispose();
	}
	protected void actionPerformedBtnListar(ActionEvent arg0) {
		listar();
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
