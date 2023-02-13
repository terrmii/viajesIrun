package utilidades;

import java.util.ArrayList;

import clases.Cliente;

public class Visor {

	public static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
	
	public static void mostrarClientes(ArrayList<Cliente> cliente) {
		System.out.println("DNI | NOMBRE | APELLIDOS | DIRECCION | LOCALIDAD");
		for (int i = 0; i < cliente.size(); i++) {
			System.out.println(cliente.get(i).getDni() +" | "+ cliente.get(i).getNombre() + " | " + cliente.get(i).getApellidos() +" | "+ cliente.get(i).getDireccion() +" | "+ cliente.get(i).getLocalidad());
		}
	}
}
