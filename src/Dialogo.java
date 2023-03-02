import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Caret;

import clases.Cliente;
import gestores.GestorBBDD;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class Dialogo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldDni;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldDireccion;
	private JTextField textFieldLocalidad;
	
	JButton btnModificar = new JButton("MODIFICAR");
	JButton btnEliminar = new JButton("ELIMINAR");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the dialog.
	 */
	public Dialogo() {
		setBounds(100, 100, 547, 341);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("DNI");
			lblNewLabel.setBounds(10, 42, 74, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			textFieldDni = new JTextField();
			textFieldDni.setBounds(112, 39, 74, 20);
			textFieldDni.setColumns(10);
			contentPanel.add(textFieldDni);
		}
		{
			JLabel lblNombre = new JLabel("NOMBRE");
			lblNombre.setBounds(10, 76, 92, 14);
			contentPanel.add(lblNombre);
		}
		{
			textFieldNombre = new JTextField();
			textFieldNombre.setBounds(112, 70, 148, 20);
			textFieldNombre.setEnabled(false);
			textFieldNombre.setColumns(10);
			contentPanel.add(textFieldNombre);
		}
		{
			JLabel lblApellidos = new JLabel("APELLIDOS");
			lblApellidos.setBounds(10, 109, 92, 14);
			contentPanel.add(lblApellidos);
		}
		{
			textFieldApellidos = new JTextField();
			textFieldApellidos.setBounds(112, 106, 148, 20);
			textFieldApellidos.setEnabled(false);
			textFieldApellidos.setColumns(10);
			contentPanel.add(textFieldApellidos);
		}
		{
			JLabel lblDireccion = new JLabel("DIRECCION");
			lblDireccion.setBounds(10, 149, 92, 14);
			contentPanel.add(lblDireccion);
		}
		{
			textFieldDireccion = new JTextField();
			textFieldDireccion.setBounds(112, 146, 148, 20);
			textFieldDireccion.setEnabled(false);
			textFieldDireccion.setColumns(10);
			contentPanel.add(textFieldDireccion);
		}
		{
			JLabel lblLocalidad = new JLabel("LOCALIDAD");
			lblLocalidad.setBounds(10, 180, 92, 14);
			contentPanel.add(lblLocalidad);
		}
		{
			textFieldLocalidad = new JTextField();
			textFieldLocalidad.setBounds(112, 177, 149, 20);
			textFieldLocalidad.setEnabled(false);
			textFieldLocalidad.setColumns(10);
			contentPanel.add(textFieldLocalidad);
		}
		{
			JButton btnNewButton_1 = new JButton("Cargar datos");
			btnNewButton_1.setBounds(281, 38, 95, 23);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GestorBBDD bbdd = new GestorBBDD();
					Cliente cliente = bbdd.visualizarClienteJFrame(textFieldDni.getText());
					textFieldNombre.setText(cliente.getNombre());
					textFieldApellidos.setText(cliente.getApellidos());
					textFieldDireccion.setText(cliente.getDireccion());
					textFieldLocalidad.setText(cliente.getLocalidad());
					
					textFieldNombre.setEnabled(true);
					textFieldApellidos.setEnabled(true);
					textFieldDireccion.setEnabled(true);
					textFieldLocalidad.setEnabled(true);
			
					btnModificar.setEnabled(true);
					btnEliminar.setEnabled(true);
				}
			});
			contentPanel.add(btnNewButton_1);
		}
		
		JLabel TITULO = new JLabel("MODIFICAR/ELIMINAR");
		TITULO.setHorizontalAlignment(SwingConstants.CENTER);
		TITULO.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 17));
		TITULO.setBounds(35, 11, 374, 14);
		contentPanel.add(TITULO);
		
		JTextPane verClientes = new JTextPane();
		verClientes.setBounds(281, 76, 240, 169);
		contentPanel.add(verClientes);
		
		JButton btnCargarUsuarios = new JButton("Cargar Usuarios");
		btnCargarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				HACER QUE CARGEN EN EL TEXTO DE ABAJO
				
				GestorBBDD bbdd = new GestorBBDD();
				
				verClientes.setCaret((Caret) bbdd.visualizarCliente());
			}
		});
		btnCargarUsuarios.setBounds(386, 38, 135, 23);
		contentPanel.add(btnCargarUsuarios);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar.setEnabled(false);
				
				buttonPane.add(btnModificar);
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Cliente cliente = new Cliente();
						cliente.setDni(textFieldDni.getText());
						cliente.setNombre(textFieldNombre.getText());
						cliente.setApellidos(textFieldApellidos.getText());
						cliente.setDireccion(textFieldDireccion.getText());
						cliente.setLocalidad(textFieldLocalidad.getText());
						
						GestorBBDD bbdd = new GestorBBDD();
						bbdd.modificarClienteJframe(textFieldDni.getText(), cliente);
//					Dejarlos a null =>
						textFieldDni.setText(null);
						textFieldNombre.setText(null);
						textFieldApellidos.setText(null);
						textFieldDireccion.setText(null);
						textFieldLocalidad.setText(null);
						
						JOptionPane.showMessageDialog(null, "Cliente modificado ");
					}
				});
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				{
					btnEliminar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Cliente cliente = new Cliente();
							cliente.setDni(textFieldDni.getText());
							cliente.setNombre(textFieldNombre.getText());
							cliente.setApellidos(textFieldApellidos.getText());
							cliente.setDireccion(textFieldDireccion.getText());
							cliente.setLocalidad(textFieldLocalidad.getText());
							
							GestorBBDD bbdd = new GestorBBDD();
							bbdd.bajaCliente(textFieldDni.getText());
							
							textFieldDni.setText(null);
							textFieldNombre.setText(null);
							textFieldApellidos.setText(null);
							textFieldDireccion.setText(null);
							textFieldLocalidad.setText(null);
							
							JOptionPane.showMessageDialog(cancelButton, "Cliente eliminado");
						}
					});
					
					btnEliminar.setEnabled(false);
					buttonPane.add(btnEliminar);
				}
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
