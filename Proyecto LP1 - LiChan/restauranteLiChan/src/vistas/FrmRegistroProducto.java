package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantemiento.GestionMantenimiento;
import modelos.RegistroProducto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class FrmRegistroProducto extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtCodProducto;
	private JTextField txtNombreProd;
	private JTextField txtPrecioProd;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroProducto frame = new FrmRegistroProducto();
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
	public FrmRegistroProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JLabel lblNewLabel = new JLabel("Registro de Producto");
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
		lblNewLabel.setBounds(152, 16, 238, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo de Producto:");
		lblNewLabel_1.setBounds(37, 63, 127, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre:");
		lblNewLabel_1_1.setBounds(37, 99, 86, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Precio:");
		lblNewLabel_1_2.setBounds(37, 138, 46, 14);
		contentPane.add(lblNewLabel_1_2);
		
		txtCodProducto = new JTextField();
		txtCodProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCodProducto.setEditable(true);
			}
		});
		txtCodProducto.setEditable(false);
		txtCodProducto.setBounds(163, 60, 155, 20);
		contentPane.add(txtCodProducto);
		txtCodProducto.setColumns(10);
		
		txtNombreProd = new JTextField();
		txtNombreProd.setColumns(10);
		txtNombreProd.setBounds(163, 95, 157, 20);
		contentPane.add(txtNombreProd);
		
		txtPrecioProd = new JTextField();
		txtPrecioProd.setColumns(10);
		txtPrecioProd.setBounds(163, 135, 158, 20);
		contentPane.add(txtPrecioProd);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrar();
			}
		});
		btnRegistrar.setBounds(112, 196, 89, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarProducto();
			}
		});
		btnEliminar.setBounds(387, 57, 103, 23);
		contentPane.add(btnEliminar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarPrdoucto();
			}
		});
		btnBuscar.setBounds(386, 92, 104, 23);
		contentPane.add(btnBuscar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actulizarProductos();
			}
		});
		btnActualizar.setBounds(385, 131, 105, 23);
		contentPane.add(btnActualizar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevoProducto();
			}
		});
		btnLimpiar.setBounds(305, 196, 89, 23);
		contentPane.add(btnLimpiar);
		
		txtCodProducto.setText(ObtenerCodProducto());
		
		btnCerrar = new JButton("");
		btnCerrar.addActionListener(this);
		btnCerrar.setSelectedIcon(new ImageIcon(FrmRegistroProducto.class.getResource("/img/BOTON_CERRAR_1.png")));
		btnCerrar.setRolloverIcon(new ImageIcon(FrmRegistroProducto.class.getResource("/img/BOTON_CERRAR_2.png")));
		btnCerrar.setIcon(new ImageIcon(FrmRegistroProducto.class.getResource("/img/BOTON_CERRAR_1.png")));
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setBorderPainted(false);
		btnCerrar.setBounds(498, 10, 28, 28);
		contentPane.add(btnCerrar);
	}
	
	/********** Buscar *******/
	void buscarPrdoucto() {
		String idProducto = leerIdProd();
		
		RegistroProducto rpo = new GestionMantenimiento().buscarProducto(idProducto);
		
		if(rpo == null) {
			JOptionPane.showMessageDialog(this, "Producto "+ idProducto + " No existe");
		}else {
			txtCodProducto.setText(rpo.getIdProducto());
			txtNombreProd.setText(rpo.getNombreProducto());
			txtPrecioProd.setText(rpo.getPrecioProducto() + "");
			
		}
	}
	
	/******************** Eliminar **********************/
	void eliminarProducto() {
		String idProducto;
		idProducto = leerIdProd();
		
		int rs = new GestionMantenimiento().eliminarProducto(idProducto);
		
		if(rs == 0) {
			JOptionPane.showMessageDialog(this, "Error al Eliminar Producto");
		}else {
			JOptionPane.showMessageDialog(this, "Producto " + idProducto + " a sido Eliminado");
		}
	}
	
	void registrar() {
		String idProducto, nombreProducto;
		double precioProducto;
		
		idProducto = leerIdProd();
		nombreProducto = leerNomProd();
		precioProducto = leerPrecioProd();
		
		RegistroProducto rp = new RegistroProducto();
		rp.setIdProducto(idProducto);
		rp.setNombreProducto(nombreProducto);
		rp.setPrecioProducto(precioProducto);
		
		if(idProducto == null || nombreProducto == null || precioProducto == 0) {
			JOptionPane.showMessageDialog(this, "Ingrese TODOS los datos requeridos");
			
		}else {
			GestionMantenimiento gm = new GestionMantenimiento();
			int rs = gm.registro(rp);
			JOptionPane.showMessageDialog(this, "Prodcuto " + "'" + rp.getNombreProducto() + "'" 
			+ " Registrado");
			
			nuevoProducto();
		}	
	}
	
	void actulizarProductos() {
		
	}
	
	/******* NUEVO PRODUCTO *******/
	
	void nuevoProducto() {
		txtNombreProd.setText("");
		txtPrecioProd.setText("");
		
		txtCodProducto.setText(ObtenerCodProducto());
	}

	
	/******* VALIDACIONES *******/
	
	private String leerIdProd() {
	
		return txtCodProducto.getText();
	}

	private String leerNomProd() {
		
		if (txtNombreProd.getText().length()==0) {
			JOptionPane.showMessageDialog(this, "Nombre de Producto es un campo OBLIGATORIO");
			return null;
		}
		
		if(!txtNombreProd.getText().matches("^[a-zA-Záéíóú ]{3,50}$")) {
			JOptionPane.showMessageDialog(this, "Ingrese Caracteres correctos en Nombre", "Aviso", 2);
			return null;
		}
		
		return txtNombreProd.getText();
	}
	

	private double leerPrecioProd() {
		
		if (txtPrecioProd.getText().length()==0) {
			JOptionPane.showMessageDialog(this, "Precio es un campo OBLIGATORIO");
			return 0;
		}
		
		if(!txtPrecioProd.getText().matches("^[0-9]{1,2}+([.][0-9]{1,2})?$")) { 

			JOptionPane.showMessageDialog(this, "Ingrese Caracteres correctos en Precio", "Aviso", 2);
			return 0;
		}
		
		return Double.parseDouble(txtPrecioProd.getText());
	}

	/***** Numero de Registro   *********/
	private String ObtenerCodProducto() {
		return new GestionMantenimiento().generarCodigoProducto();
	}
	
	
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	}
}
