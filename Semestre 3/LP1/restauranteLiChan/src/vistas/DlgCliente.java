package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.xml.XmlToTxt;

import interfaces.ConsultaInterface;
import mantemiento.GestionConsultas;
import modelos.RegistroCliente;
import modelos.RegistroProducto;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DlgCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	DefaultTableModel modelo = new DefaultTableModel();
	private JTable tblSalida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCliente dialog = new DlgCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCliente() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
		});
		scrollPane.setBounds(10, 11, 414, 206);
		contentPanel.add(scrollPane);
		
		setLocationRelativeTo(null);
		
		tblSalida = new JTable();
		tblSalida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				enviarDatos();
			}
		});
		tblSalida.setModel(modelo);
		modelo.addColumn("Nombre Compl.");
		modelo.addColumn("Codigo");
		modelo.addColumn("Direccion");
		modelo.addColumn("Telefono");
		modelo.addColumn("Documento");
		scrollPane.setViewportView(tblSalida);
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

		
		ArrayList<RegistroCliente> lstConsultaCli = new GestionConsultas().listadoCliente();
		
		if(lstConsultaCli == null || lstConsultaCli.size() == 0) {
			JOptionPane.showMessageDialog(this, "Listado Vacio");
		}else {
			for (RegistroCliente r : lstConsultaCli) {
				Object aDatos[] = {r.getNombreCliente() + " " + r.getApellidoCliente(),r.getIdCliente(),r.getDireccionCliente(),
								r.getNumeroTelefonico(),r.getNumeroDocumento()};
				modelo.addRow(aDatos);
			}
		}

	}
	
	
	
	
	

	void enviarDatos() {
		int fila = tblSalida.getSelectedRow();
		
		if (fila == -1) {
			JOptionPane.showMessageDialog(this, "Seleccione un Cliente");
			return ;
		}
		
		FrmBoleta.txtNomCliente.setText(tblSalida.getValueAt(fila, 0).toString());
		FrmBoleta.txtidCliente.setText(tblSalida.getValueAt(fila, 1).toString());
		FrmBoleta.txtDireccion.setText(tblSalida.getValueAt(fila, 2).toString());
		FrmBoleta.txtTelefono.setText(tblSalida.getValueAt(fila, 3).toString());
		FrmBoleta.txtDocumento.setText(tblSalida.getValueAt(fila, 4)+"");
		dispose();
		FrmBoleta.btnConsultarProducto.setEnabled(true);
	}
	
	
	
}



