package maven;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Cliente;
import gestores.GestorBBDD;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Window.Type;

@SuppressWarnings("serial")
public class ventanaMain extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDni;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldDireccion;
	private JTextField textFieldLocalidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
					ventanaMain frame = new ventanaMain();
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
	public ventanaMain() {
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 371, 272);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DNI");
		lblNewLabel.setBounds(30, 44, 29, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(30, 76, 68, 21);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setBounds(30, 108, 68, 21);
		contentPane.add(lblApellidos);
		
		JLabel lblDireccion = new JLabel("DIRECCION");
		lblDireccion.setBounds(30, 140, 68, 21);
		contentPane.add(lblDireccion);
		
		JLabel lblLocalidad = new JLabel("LOCALIDAD");
		lblLocalidad.setBounds(30, 172, 68, 21);
		contentPane.add(lblLocalidad);
		
		textFieldDni = new JTextField();
		textFieldDni.setBounds(131, 44, 150, 20);
		contentPane.add(textFieldDni);
		textFieldDni.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(131, 76, 150, 20);
		contentPane.add(textFieldNombre);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setColumns(10);
		textFieldApellidos.setBounds(131, 108, 150, 20);
		contentPane.add(textFieldApellidos);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(131, 141, 150, 20);
		contentPane.add(textFieldDireccion);
		
		textFieldLocalidad = new JTextField();
		textFieldLocalidad.setColumns(10);
		textFieldLocalidad.setBounds(131, 172, 150, 20);
		contentPane.add(textFieldLocalidad);
		
		JButton btnInsertarCliente = new JButton("INSERTAR CLIENTE");
		btnInsertarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				cliente.setDni(textFieldDni.getText());
				cliente.setNombre(textFieldNombre.getText());
				cliente.setApellidos(textFieldApellidos.getText());
				cliente.setDireccion(textFieldDireccion.getText());
				cliente.setLocalidad(textFieldLocalidad.getText());
				
				GestorBBDD bbdd = new GestorBBDD();
				bbdd.registrarClientes(cliente);
//				Dejarlos a null =>
				textFieldDni.setText(null);
				textFieldNombre.setText(null);
				textFieldApellidos.setText(null);
				textFieldDireccion.setText(null);
				textFieldLocalidad.setText(null);
			}
		});
		btnInsertarCliente.setBounds(114, 203, 153, 23);
		contentPane.add(btnInsertarCliente);
		
		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Dialogo dialog = new Dialogo();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(9, 203, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblAgenciaViajes = new JLabel("AGENCIA VIAJES");
		lblAgenciaViajes.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgenciaViajes.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 17));
		lblAgenciaViajes.setBounds(0, 11, 355, 14);
		contentPane.add(lblAgenciaViajes);
		
		JButton btnNewButton_1 = new JButton("SALIR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(277, 203, 68, 23);
		contentPane.add(btnNewButton_1);
	}
}
