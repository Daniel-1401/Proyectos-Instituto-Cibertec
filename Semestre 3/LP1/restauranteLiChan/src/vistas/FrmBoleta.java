package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import mantemiento.GestionMantenimiento;
import mantemiento.GestionVenta;
import modelos.Boleta;
import modelos.BoletaDetalle;
import modelos.DetalleBoleta;
import modelos.ProductosSeleccionados_Temporal;

import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class FrmBoleta extends JInternalFrame  {

	private JPanel contentPane;
	private JTextField txtNumBoleta;
	private JTextField txtFecha;
	private JTextField txtTotal;
	public static JTextField txtNomCliente;
	public static JTextField txtidCliente;
	public static JTextField txtTelefono;
	public static JTextField txtDocumento;
	public static JTextField txtDireccion;
	public static JTextField txtCantidad;
	public static JTextField txtNomProducto;
	public static JTextField txtPrecioProducto;
	public static JTextField txtCodProduccto;
	public static JButton btnConsultarProducto;
	public static JButton btnAgregar;
	private JButton btnImprimir;
	private JTable tblProductosSeleccionados;
	private JScrollPane scrollPane;
	private JButton btnEliminarProducto;

	DefaultTableModel modelo = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBoleta frame = new FrmBoleta();
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
	public FrmBoleta() {
		//setUndecorated(true);
		setBackground(Color.RED);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 735, 565);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chifa Li Chan");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(261, 11, 197, 38);
		contentPane.add(lblNewLabel);
		
		JPanel panelDatosCliente = new JPanel();
		panelDatosCliente.setLayout(null);
		panelDatosCliente.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos Cliente", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panelDatosCliente.setBackground(Color.WHITE);
		panelDatosCliente.setBounds(29, 131, 675, 99);
		contentPane.add(panelDatosCliente);
		
		JLabel lblIdCliente = new JLabel("Id Cliente:");
		lblIdCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdCliente.setBounds(328, 27, 68, 19);
		panelDatosCliente.add(lblIdCliente);
		
		JLabel lblNombreCliente = new JLabel("Nombre:");
		lblNombreCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreCliente.setBounds(10, 27, 135, 19);
		panelDatosCliente.add(lblNombreCliente);
		
		JLabel lblDireccionCliente = new JLabel("Direcci\u00F3n:");
		lblDireccionCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDireccionCliente.setBounds(444, 63, 68, 19);
		panelDatosCliente.add(lblDireccionCliente);
		
		JLabel lblTelefonoCliente = new JLabel("Telefono:");
		lblTelefonoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefonoCliente.setBounds(10, 63, 135, 19);
		panelDatosCliente.add(lblTelefonoCliente);
		
		JLabel lblDocumentoCliente = new JLabel("Documento:");
		lblDocumentoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDocumentoCliente.setBounds(233, 63, 135, 19);
		panelDatosCliente.add(lblDocumentoCliente);
		
		txtNomCliente = new JTextField();
		txtNomCliente.setEditable(false);
		txtNomCliente.setBounds(70, 28, 248, 20);
		panelDatosCliente.add(txtNomCliente);
		txtNomCliente.setColumns(10);
		
		txtidCliente = new JTextField();
		txtidCliente.setEditable(false);
		txtidCliente.setBounds(398, 28, 86, 20);
		panelDatosCliente.add(txtidCliente);
		txtidCliente.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(70, 64, 153, 20);
		panelDatosCliente.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtDocumento = new JTextField();
		txtDocumento.setEditable(false);
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(318, 64, 116, 20);
		panelDatosCliente.add(txtDocumento);
		
		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(521, 64, 144, 20);
		panelDatosCliente.add(txtDireccion);
		
		JButton btnConsultarCliente = new JButton("");
		btnConsultarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgCliente d = new DlgCliente();
				d.setVisible(true);
			
			}
		});
		btnConsultarCliente.setIcon(new ImageIcon(FrmBoleta.class.getResource("/img/ClientesBoleta.png")));
		btnConsultarCliente.setContentAreaFilled(false);
		btnConsultarCliente.setBorderPainted(false);
		btnConsultarCliente.setBorder(null);
		btnConsultarCliente.setBounds(539, 20, 37, 37);
		panelDatosCliente.add(btnConsultarCliente);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(186, 32, 65, 108);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(FrmBoleta.class.getResource("/img/logoResto.png")));
		
		JLabel lblNumBoleta = new JLabel("Numero de Boleta:");
		lblNumBoleta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumBoleta.setBounds(306, 51, 136, 38);
		contentPane.add(lblNumBoleta);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(306, 99, 55, 23);
		contentPane.add(lblFecha);
		
		txtNumBoleta = new JTextField();
		txtNumBoleta.setEditable(false);
		txtNumBoleta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNumBoleta.setBounds(438, 60, 108, 20);
		contentPane.add(txtNumBoleta);
		txtNumBoleta.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFecha.setColumns(10);
		txtFecha.setBounds(352, 99, 108, 20);
		contentPane.add(txtFecha);
		
		JPanel panelDatosProductos = new JPanel();
		panelDatosProductos.setLayout(null);
		panelDatosProductos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos Productos", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panelDatosProductos.setBackground(Color.WHITE);
		panelDatosProductos.setBounds(29, 235, 675, 71);
		contentPane.add(panelDatosProductos);
		
		JLabel lblPlato = new JLabel("Plato:");
		lblPlato.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlato.setBounds(10, 27, 68, 19);
		panelDatosProductos.add(lblPlato);
		
		JLabel lblPrecioPlato = new JLabel("Precio:");
		lblPrecioPlato.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecioPlato.setBounds(279, 27, 68, 19);
		panelDatosProductos.add(lblPrecioPlato);
		
		txtCantidad = new JTextField();
		txtCantidad.setEditable(false);
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(512, 28, 77, 20);
		panelDatosProductos.add(txtCantidad);
		
		txtNomProducto = new JTextField();
		txtNomProducto.setEditable(false);
		txtNomProducto.setColumns(10);
		txtNomProducto.setBounds(48, 28, 184, 20);
		panelDatosProductos.add(txtNomProducto);
		
		txtPrecioProducto = new JTextField();
		txtPrecioProducto.setEditable(false);
		txtPrecioProducto.setColumns(10);
		txtPrecioProducto.setBounds(324, 28, 103, 20);
		panelDatosProductos.add(txtPrecioProducto);
		
		JButton btnConsultarCliente_1 = new JButton("");
		btnConsultarCliente_1.setContentAreaFilled(false);
		btnConsultarCliente_1.setBorderPainted(false);
		btnConsultarCliente_1.setBorder(null);
		btnConsultarCliente_1.setBounds(539, 20, 37, 37);
		panelDatosProductos.add(btnConsultarCliente_1);
		
		btnConsultarProducto = new JButton("");
		btnConsultarProducto.setEnabled(false);
		btnConsultarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgProducto p = new DlgProducto();
				p.setVisible(true);
				
			}
		});
		btnConsultarProducto.setIcon(new ImageIcon(FrmBoleta.class.getResource("/img/box.png")));
		btnConsultarProducto.setContentAreaFilled(false);
		btnConsultarProducto.setBorderPainted(false);
		btnConsultarProducto.setBorder(null);
		btnConsultarProducto.setBounds(235, 20, 37, 37);
		panelDatosProductos.add(btnConsultarProducto);
		
		JLabel lblCantidadPlato = new JLabel("Cantidad:");
		lblCantidadPlato.setBounds(441, 27, 135, 19);
		panelDatosProductos.add(lblCantidadPlato);
		lblCantidadPlato.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnEliminarProducto = new JButton("");
		btnEliminarProducto.setEnabled(false);
		btnEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarProdcutoSeleccionado();
			}
		});
		btnEliminarProducto.setIcon(new ImageIcon(FrmBoleta.class.getResource("/img/deletProduct.png")));
		btnEliminarProducto.setContentAreaFilled(false);
		btnEliminarProducto.setBorderPainted(false);
		btnEliminarProducto.setBounds(640, 316, 64, 64);
		contentPane.add(btnEliminarProducto);

		btnAgregar = new JButton("");
		btnAgregar.setEnabled(false);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(leerCantidad() >= 1) {
					agregarProducto();
					btnEliminarProducto.setEnabled(true);
					txtCantidad.setText("");
					txtNomProducto.setText("");
					txtPrecioProducto.setText("");
					btnAgregar.setEnabled(false);
				}
			}
		});
		btnAgregar.setIcon(new ImageIcon(FrmBoleta.class.getResource("/img/venta.png")));
		btnAgregar.setContentAreaFilled(false);
		btnAgregar.setBorderPainted(false);
		btnAgregar.setBorder(null);
		btnAgregar.setBounds(603, 10, 37, 37);
		panelDatosProductos.add(btnAgregar);
		
		JLabel lblNewLabel_4 = new JLabel("A\u00F1adir");
		lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_4.setBounds(599, 43, 54, 14);
		panelDatosProductos.add(lblNewLabel_4);
		
		txtCodProduccto = new JTextField();
		txtCodProduccto.setVisible(false);
		txtCodProduccto.setBounds(324, 10, 96, 19);
		panelDatosProductos.add(txtCodProduccto);
		txtCodProduccto.setColumns(10);
		
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(587, 454, 117, 20);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		JLabel lblTotalVenta = new JLabel("Total:");
		lblTotalVenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotalVenta.setBounds(536, 454, 41, 19);
		contentPane.add(lblTotalVenta);
		
		btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarComprobante();
			}
		});
		btnImprimir.setEnabled(false);
		btnImprimir.setBounds(307, 454, 89, 23);
		contentPane.add(btnImprimir);
		
		//setLocationRelativeTo(null);
		
		txtNumBoleta.setText(obtenerNumBoleta());
		txtFecha.setText(obtenerFecha());
		
		JButton btnCerrar = new JButton("");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setRolloverIcon(new ImageIcon(FrmBoleta.class.getResource("/img/BOTON_CERRAR_2.png")));
		btnCerrar.setPressedIcon(new ImageIcon(FrmBoleta.class.getResource("/img/BOTON_CERRAR_1.png")));
		btnCerrar.setIcon(new ImageIcon(FrmBoleta.class.getResource("/img/BOTON_CERRAR_1.png")));
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setBorderPainted(false);
		btnCerrar.setBounds(697, 11, 28, 28);
		contentPane.add(btnCerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 316, 601, 108);
		contentPane.add(scrollPane);
		
		tblProductosSeleccionados = new JTable();
		tblProductosSeleccionados.setModel(modelo);
		modelo.addColumn("idItem");
		modelo.addColumn("codProducto");
		modelo.addColumn("descripcion");
		modelo.addColumn("cantidad");
		modelo.addColumn("precioUnd");
		modelo.addColumn("importeTotal");
		scrollPane.setViewportView(tblProductosSeleccionados);
		
		lblIdRecepcionista = new JLabel("Id Recepcionista:");
		lblIdRecepcionista.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdRecepcionista.setBounds(470, 98, 117, 23);
		contentPane.add(lblIdRecepcionista);
		
		txtIdRecepcionista = new JTextField();
		txtIdRecepcionista.setEditable(false);
		txtIdRecepcionista.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIdRecepcionista.setColumns(10);
		txtIdRecepcionista.setBounds(587, 99, 108, 20);
		txtIdRecepcionista.setText(obtenerIdRecepcionista(frmLogin.user.getIdUsuario()));
		contentPane.add(txtIdRecepcionista);
		
	}
	
	
	double total = 0;
	int numeroItem = 1;
	private JLabel lblIdRecepcionista;
	private JTextField txtIdRecepcionista;
	
	
	void agregarProducto() {
		
		String idBoleta;
		String idCliente;
		String idProducto;
		int cantidadProducto;
		double totalProductoSeleccionado;
		String nombreProducto;
		double precioUnitProducto;
		
		idBoleta = leerNroBoleta();
		idCliente = leerIdCli();
		idProducto = txtCodProduccto.getText();
		cantidadProducto = leerCantidad();
		precioUnitProducto = leerPrecio();
		totalProductoSeleccionado = (cantidadProducto * precioUnitProducto);
		nombreProducto = leerNomProd();
		ProductosSeleccionados_Temporal nuevo = new ProductosSeleccionados_Temporal(numeroItem, idBoleta, idCliente, idProducto, cantidadProducto, totalProductoSeleccionado, nombreProducto, precioUnitProducto);
		int rs = new GestionVenta().insertarProductosSeleccionadosTemporal(nuevo,numeroItem);
		if(rs == 0) {
			JOptionPane.showMessageDialog(this, "ERROR AL AGREGAR PRODUCTO AL CARRITO");
		}
		listarProductosSeleccionados();
		sumaTotalProductoSeleccionado(idCliente);
		btnImprimir.setEnabled(true);
		numeroItem++;
	}
	private void sumaTotalProductoSeleccionado(String idCliente) {
		
		total = new GestionVenta().sumaTotalProductosSeleccionados(idCliente);
		txtTotal.setText(total+"");
	}
	private void eliminarProdcutoSeleccionado() {
		String idCliente;
		int numItem = -1;
		int fila = tblProductosSeleccionados.getSelectedRow();
		if (fila == -1) {
			JOptionPane.showMessageDialog(this, "Seleccione un producto");
		}else {
			idCliente = leerIdCli();
			numItem = Integer.parseInt(tblProductosSeleccionados.getValueAt(fila, 0).toString());
			int eliminar = new GestionVenta().eliminarProductoSeleccionado(idCliente, numItem);
			if(eliminar == 0) {
				System.out.println("ERROR AL ELIMINAR PRODUCTO SELECCIONADO:FrmBoleta.eliminarProdcutoSeleccionado()");
			}else {
				listarProductosSeleccionados();
				sumaTotalProductoSeleccionado(idCliente);
			}
		}
		
	}
	private void listarProductosSeleccionados() {
		ArrayList<ProductosSeleccionados_Temporal> lstProductosTemporal = new GestionVenta().lstProductosSeleccionados();
		modelo.setRowCount(0);
		for(ProductosSeleccionados_Temporal pt : lstProductosTemporal) {
			Object datos[] = {pt.getNumItem(), pt.getIdProducto(), pt.getNombreProducto(),pt.getCantidadProducto(), pt.getPrecioUnitProducto(), pt.getTotalProductoSeleccionado()};
			modelo.addRow(datos);
		}
	}
	
	private void generarComprobante() {
		String idBoleta = leerNroBoleta();
		String fecha	= obtenerFecha();
		String idCliente = leerIdCli();
		String idRecepcionista = leerIdRecep();
		String idProducto;
		int cantidadProducto;
		double precioTotalProducto;
		
		Boleta nuevaBoleta = new Boleta(idBoleta, fecha, idCliente, idRecepcionista);
		int resultadoBoleta = new GestionVenta().registrarBoleta(nuevaBoleta);
		if(resultadoBoleta == 0) {
			JOptionPane.showMessageDialog(this, "ERROR AL REGISTRAR NUEVA BOLETA");
		}else {
			
			for (int i = 0; i < tblProductosSeleccionados.getRowCount(); i++) {
				idProducto = tblProductosSeleccionados.getValueAt(i, 1).toString();
				cantidadProducto = Integer.parseInt(tblProductosSeleccionados.getValueAt(i, 3).toString());
				precioTotalProducto = Double.parseDouble(tblProductosSeleccionados.getValueAt(i, 5).toString());
				BoletaDetalle nuevoBoletaDetalle = new BoletaDetalle(idBoleta, idProducto, cantidadProducto, precioTotalProducto);
				int resultadoBoletaDetalle = new GestionVenta().registrarBoletaDetalle(nuevoBoletaDetalle);
				if(resultadoBoletaDetalle == 0) {
					JOptionPane.showMessageDialog(this, "ERROR AL REGISTRAR NUEVA BOLETA DETALLE");
				}
			}
			txtNomCliente.setText("");
			txtidCliente.setText("");
			txtTelefono.setText("");
			txtDocumento.setText("");
			txtDireccion.setText("");
			txtNomProducto.setText("");
			txtCodProduccto.setText("");
			txtPrecioProducto.setText("");
			txtCantidad.setText("");
			txtTotal.setText(0.0+"");
			btnConsultarProducto.setEnabled(false);
			btnAgregar.setEnabled(false);
			btnEliminarProducto.setEnabled(false);
			btnImprimir.setEnabled(false);
			JOptionPane.showMessageDialog(this, "BOLETA REGISTRADA");
		}
	}
	
	private String obtenerNumBoleta() {		
		
		return new GestionVenta().generaNumeroBoleta();
	}
	
	private String obtenerFecha() {
		
		return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
	}
	
	private String obtenerIdRecepcionista(int idUsuario) {
		String id = new GestionVenta().obtenerRecepcionista(idUsuario);
		System.out.println(id);
		return id;
	}
	
	//-----------------------------------------
	private String leerNomCli() {
		return txtNomCliente.getText();
	}
	
	private String leerIdCli() {
		return txtidCliente.getText();
	}
	private String leerIdRecep() {
		return txtIdRecepcionista.getText();
	}
	private int leerTelefono() {
		return Integer.parseInt(txtTelefono.getText());
	}
	
	private String leerDocumento() {
		return txtDocumento.getText();
	}
	
	private String LeerDireccion() {
		return txtDireccion.getText();
	}
	
	private String leerNomProd() {
		return txtNomProducto.getText();
	}
	
	private double leerPrecio() {

		return Double.parseDouble(txtPrecioProducto.getText());
	}
	
	private int leerCantidad() {
		
		if (txtCantidad.getText().length()==0) {
			JOptionPane.showMessageDialog(this, "Ingrese una Canidad");
			return 0;
		}
		
		if(txtCantidad.getText().matches("^[0-9]{2}$")) {
			JOptionPane.showMessageDialog(this, "Ingrese Caracteres correctos en la Cantidad", "Aviso", 2);
			return 0;
		}	
		return Integer.parseInt(txtCantidad.getText());
	}
	
	private double leerTotal() {
		return Double.parseDouble(txtTotal.getText());
	}
	private String leerNroBoleta() {
		return txtNumBoleta.getText();
	}
	
	
	
}
