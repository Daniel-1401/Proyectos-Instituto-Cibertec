package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Menu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class frmPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton_3;
	private JButton btnNewButton_2;
	private JButton btnNewButton;
	public static JPanel panelContenedor;
	private JButton btnLogOut;
	private JButton btnSalir;
	private JButton btnEmpleados;
	private JButton btnClientes;
	private JButton btnProductos;
	private JButton btnReporteEmpleados;
	private JButton btnReporteProductos;
	private JButton btnVenta;
	private JButton btnSistema;
	private JButton btnMantenimiento;
	private JButton btnTransacciones;
	private JButton btnReporte;
	private JLabel imgBarra;
	private int BarraMenu = 0;
	private JButton btnReporteCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPrincipal frame = new frmPrincipal();
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
	public frmPrincipal() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	setBounds(100, 100, 950, 750);
		setBounds(100, 100, 950, 750);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCerrar = new JButton("");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCerrar.setPressedIcon(new ImageIcon(frmPrincipal.class.getResource("/img/BOTON_CERRAR_1.png")));
		btnCerrar.setRolloverIcon(new ImageIcon(frmPrincipal.class.getResource("/img/BOTON_CERRAR_2.png")));
		btnCerrar.setIcon(new ImageIcon(frmPrincipal.class.getResource("/img/BOTON_CERRAR_1.png")));
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setBorderPainted(false);
		btnCerrar.setBounds(912, 10, 28, 28);
		contentPane.add(btnCerrar);
		
		panelContenedor = new JPanel();
		panelContenedor.setBorder(new LineBorder(new Color(64, 64, 64), 2, true));
		panelContenedor.setBounds(162, 40, 778, 700);
		contentPane.add(panelContenedor);
		panelContenedor.setLayout(null);
		
		btnLogOut = new JButton("LogOut");
		btnLogOut.addActionListener(this);
		btnLogOut.setVisible(false);
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLogOut.setBounds(162, 97, 130, 35);
		contentPane.add(btnLogOut);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setVisible(false);
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSalir.setBounds(162, 142, 130, 35);
		contentPane.add(btnSalir);
		
		btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(this);
		btnClientes.setVisible(false);
		btnClientes.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnClientes.setBounds(162, 294, 130, 35);
		contentPane.add(btnClientes);
		
		btnEmpleados = new JButton("Empleados");
		btnEmpleados.addActionListener(this);
		btnEmpleados.setVisible(false);
		btnEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnEmpleados.setBounds(162, 249, 130, 35);
		contentPane.add(btnEmpleados);
		
		btnProductos = new JButton("Productos");
		btnProductos.addActionListener(this);
		btnProductos.setVisible(false);
		btnProductos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnProductos.setBounds(162, 339, 130, 35);
		contentPane.add(btnProductos);
		
		btnReporteCliente = new JButton("Cliente");
		btnReporteCliente.addActionListener(this);
		btnReporteCliente.setVisible(false);
		btnReporteCliente.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnReporteCliente.setBounds(162, 582, 130, 35);
		contentPane.add(btnReporteCliente);
		
		btnReporteEmpleados = new JButton("Empleados");
		btnReporteEmpleados.addActionListener(this);
		btnReporteEmpleados.setVisible(false);
		btnReporteEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnReporteEmpleados.setBounds(162, 627, 130, 35);
		contentPane.add(btnReporteEmpleados);
		
		btnReporteProductos = new JButton("Productos");
		btnReporteProductos.addActionListener(this);
		btnReporteProductos.setVisible(false);
		btnReporteProductos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnReporteProductos.setBounds(162, 672, 130, 35);
		contentPane.add(btnReporteProductos);
		
		btnVenta = new JButton("Venta");
		btnVenta.addActionListener(this);
		btnVenta.setVisible(false);
		btnVenta.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnVenta.setBounds(162, 441, 130, 35);
		contentPane.add(btnVenta);
		
		btnSistema = new JButton("");
		btnSistema.addActionListener(this);
		btnSistema.setIcon(new ImageIcon(frmPrincipal.class.getResource("/img/logoSistema.png")));
		btnSistema.setBounds(24, 75, 128, 128);
		btnSistema.setContentAreaFilled(false);
		btnSistema.setBorderPainted(false);
		contentPane.add(btnSistema);
		
		btnMantenimiento = new JButton("");
		btnMantenimiento.addActionListener(this);
		btnMantenimiento.setIcon(new ImageIcon(frmPrincipal.class.getResource("/img/logoMantenimiento.png")));
		btnMantenimiento.setContentAreaFilled(false);
		btnMantenimiento.setBorderPainted(false);
		btnMantenimiento.setBounds(24, 230, 128, 128);
		contentPane.add(btnMantenimiento);
		
		btnTransacciones = new JButton("");
		btnTransacciones.addActionListener(this);
		btnTransacciones.setIcon(new ImageIcon(frmPrincipal.class.getResource("/img/logoTransacciones.png")));
		btnTransacciones.setContentAreaFilled(false);
		btnTransacciones.setBorderPainted(false);
		btnTransacciones.setBounds(24, 395, 128, 128);
		contentPane.add(btnTransacciones);
		
		btnReporte = new JButton("");
		btnReporte.addActionListener(this);
		btnReporte.setIcon(new ImageIcon(frmPrincipal.class.getResource("/img/logoReportes.png")));
		btnReporte.setContentAreaFilled(false);
		btnReporte.setBorderPainted(false);
		btnReporte.setBounds(24, 570, 128, 128);
		contentPane.add(btnReporte);
		
		imgBarra = new JLabel("\r\n");
		imgBarra.setIcon(new ImageIcon(frmPrincipal.class.getResource("/img/barraMenuu.png")));
		imgBarra.setBounds(20, 40, 135, 700);
		contentPane.add(imgBarra);
		
	
		switch (frmLogin.user.getCargoUsuario()) {
		case 1: {
			btnTransacciones.setEnabled(false);break;
		}
		case 2: {
			btnMantenimiento.setEnabled(false);
			btnReporte.setEnabled(false);
			break;
		}
		default:
			break;
		}
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getSource() == btnSistema) {
			AccionBtnSistema(arg0);
		}
		if (arg0.getSource() == btnMantenimiento) {
			AccionMantenimiento(arg0);
		}
		if (arg0.getSource() == btnTransacciones) {
			AccionbtnTransacciones(arg0);
		}
		if (arg0.getSource() == btnReporte) {
			AccionbtnReporte(arg0);
		}
		if (arg0.getSource() == btnLogOut) {
			AccionbtnLogOut(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			AccionbtnSalir(arg0);
		}
		if (arg0.getSource() == btnEmpleados) {
			AccionbtnEmpleados(arg0);
		}
		if (arg0.getSource() == btnClientes) {
			AccionbtnClientes(arg0);
		}
		if (arg0.getSource() == btnProductos) {
			AccionbtnProductos(arg0);
		}
		if (arg0.getSource() == btnVenta) {
			AccionbtnVenta(arg0);
		}
		if (arg0.getSource() == btnReporteCliente) {
			actionPerformedBtnReporteCliente(arg0);
		}
		if (arg0.getSource() == btnReporteEmpleados) {
			AccionbtnReporteEmpleado(arg0);
		}
		if (arg0.getSource() == btnReporteProductos) {
			AccionbtnReporteProducto(arg0);
		}


		
	}
	

	public void AccionBtnSistema(ActionEvent arg0) {
		Abrir_CerrarMenu();
		ApagarMenuItems();
		if(BarraMenu==1) {
			MenuItem(btnLogOut, btnSalir, true);
		}
		
	}
			private void AccionbtnLogOut(ActionEvent arg0) {
				BarraMenu = 0;
				frmLogin login = new frmLogin();
				login.setLocationRelativeTo(null);
				login.setVisible(true);
				dispose();
			}
			private void AccionbtnSalir(ActionEvent arg0) {
				BarraMenu = 0;
				System.exit(0);
			}


	public void AccionMantenimiento(ActionEvent arg0) {
		Abrir_CerrarMenu();
		ApagarMenuItems();
		if(BarraMenu==1) {
			MenuItem(btnEmpleados, btnClientes, btnProductos, true);
		}
	}
			private void AccionbtnEmpleados(ActionEvent arg0) {
				BarraMenu = 0;
				panelContenedor.removeAll();
				ajustarPanelContenidoNormal();
				MenuItem(btnEmpleados, btnClientes,btnProductos, false);
				FrmRegistroEmpleadosMenu frm = new FrmRegistroEmpleadosMenu();
				frm.setBounds(100, 100, 480, 300);
				panelContenedor.add(frm);
				frm.setVisible(true);

			}
			private void AccionbtnClientes(ActionEvent arg0) {
				BarraMenu = 0;
				panelContenedor.removeAll();
				ajustarPanelContenidoNormal();
				MenuItem(btnEmpleados, btnClientes,btnProductos, false);
				FrmRegistroCliente frm = new FrmRegistroCliente();
				frm.setBounds(100, 100, 485, 400);
				panelContenedor.add(frm);
				frm.setVisible(true);

			}
			private void AccionbtnProductos(ActionEvent arg0) {
				BarraMenu = 0;
				panelContenedor.removeAll();
				ajustarPanelContenidoNormal();
				MenuItem(btnEmpleados, btnClientes,btnProductos, false);
				FrmRegistroProducto frm = new FrmRegistroProducto();
				frm.setBounds(100, 100, 550, 300);
				panelContenedor.add(frm);
				frm.setVisible(true);
			}

	
	public void AccionbtnTransacciones(ActionEvent arg0) {
		Abrir_CerrarMenu();
		ApagarMenuItems();
		if(BarraMenu==1) {
			MenuItem(btnVenta, btnVenta, true);
		}
	}
			private void AccionbtnVenta(ActionEvent arg0) {
				BarraMenu = 0;
				panelContenedor.removeAll();
				ajustarPanelContenidoNormal();
				MenuItem(btnVenta, false);
				FrmBoleta frm = new FrmBoleta();
				frm.setBounds(20, 50, 735, 565);
				panelContenedor.add(frm);
				frm.setVisible(true);
				
			}

	private void AccionbtnReporte(ActionEvent arg0) {
		Abrir_CerrarMenu();
		ApagarMenuItems();
		if(BarraMenu==1) {
			MenuItem(btnReporteCliente, btnReporteEmpleados, btnReporteProductos, true);
		}

	}
			private void actionPerformedBtnReporteCliente(ActionEvent arg0) {
				BarraMenu = 0;
				panelContenedor.removeAll();
				ajustarPanelContenidoNormal();
				MenuItem(btnReporteCliente,btnReporteEmpleados, btnReporteProductos, false);
				FrmConsultaCliente frm = new FrmConsultaCliente();
				frm.setBounds(100, 100, 650, 400);
				panelContenedor.add(frm);
				frm.setVisible(true);
			}
			private void AccionbtnReporteProducto(ActionEvent arg0) {
				BarraMenu = 0;
				panelContenedor.removeAll();
				ajustarPanelContenidoNormal();
				MenuItem(btnReporteCliente,btnReporteEmpleados, btnReporteProductos, false);
				FrmConsultaProducto frm = new FrmConsultaProducto();
				frm.setBounds(100, 100, 650, 400);
				panelContenedor.add(frm);
				frm.setVisible(true);
				
			}
		
			private void AccionbtnReporteEmpleado(ActionEvent arg0) {
				BarraMenu = 0;
				panelContenedor.removeAll();
				ajustarPanelContenidoNormal();
				MenuItem(btnReporteCliente,btnReporteEmpleados, btnReporteProductos, false);
//				FrmConsultaCliente frm = new FrmConsultaCliente();
//				frm.setBounds(100,100,550,300);
//				panelContenedor.add(frm);
//				frm.setVisible(true);
				
			}

			
		
		public void Abrir_CerrarMenu() {
			switch(BarraMenu) {
			case 0: ajustarPanelContenidoParaBarraMenu(); BarraMenu = 1; break;
			case 1: ajustarPanelContenidoNormal(); BarraMenu = 0; break;
			default: break;
			}
		}
		public void ApagarMenuItems() {
			btnLogOut.setVisible(false);
			btnSalir.setVisible(false);
			btnEmpleados.setVisible(false);
			btnClientes.setVisible(false);
			btnProductos.setVisible(false);
			btnVenta.setVisible(false);
			btnReporteCliente.setVisible(false);
			btnReporteProductos.setVisible(false);
			btnReporteEmpleados.setVisible(false);
		}
		public void MenuItem(JButton x, JButton y, JButton z, boolean B) {
			x.setVisible(B);
			y.setVisible(B);
			z.setVisible(B);
		}
		public void MenuItem(JButton x, JButton y, boolean B) {
			x.setVisible(B);
			y.setVisible(B);
		}
		public void MenuItem(JButton x, boolean B) {
			x.setVisible(B);
			
		}
		public void ajustarPanelContenidoParaBarraMenu() {
			panelContenedor.setBounds(295, 40, 645, 700);
		}
		public void ajustarPanelContenidoNormal() {
			panelContenedor.setBounds(160, 40, 780, 700);
		}
	
}
