package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.xml.XmlToTxt;

import mantemiento.GestionConsultas;
import modelos.RegistroProducto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DlgProducto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tblSalida;
	
	DefaultTableModel modelo = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgProducto dialog = new DlgProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgProducto() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 414, 206);
			contentPanel.add(scrollPane);
			{
				tblSalida = new JTable();
				tblSalida.setModel(modelo);
				modelo.addColumn("Codigo");
				modelo.addColumn("Nombre Producto");
				modelo.addColumn("Precio");
				tblSalida.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						enviarDatos();
					}
				});
				scrollPane.setViewportView(tblSalida);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						enviarDatos();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		listado();
	}
	
	void listado() {
		ArrayList<RegistroProducto> lstConsultaPro = new GestionConsultas().listadoProducto();
		
		if(lstConsultaPro == null|| lstConsultaPro.size() == 0) {
			JOptionPane.showMessageDialog(this, "Listado Vacio");
		}else {
			for (RegistroProducto p : lstConsultaPro) {
				Object aDatos[] = {p.getIdProducto(), p.getNombreProducto(), p.getPrecioProducto()};
				modelo.addRow(aDatos);
			}
		}
	}
	
	void enviarDatos() {
		int fila = tblSalida.getSelectedRow();
		
		if (fila == -1) {
			JOptionPane.showMessageDialog(this, "Seleccione un producto");
			return ;
		}
		FrmBoleta.txtCodProduccto.setText(tblSalida.getValueAt(fila, 0).toString());
		FrmBoleta.txtNomProducto.setText(tblSalida.getValueAt(fila, 1).toString());
		FrmBoleta.txtPrecioProducto.setText(tblSalida.getValueAt(fila, 2).toString());
		dispose();
		FrmBoleta.txtCantidad.setEditable(true);
		FrmBoleta.btnAgregar.setEnabled(true);
	}

}
