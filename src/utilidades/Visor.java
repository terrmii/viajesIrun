package utilidades;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import clases.Cliente;
import gestores.GestorClientes;
import gestores.GestorReservas;

public class Visor {

	public static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
	
	public static void mostrarClientes(ArrayList<Cliente> cliente) {
		System.out.println("DNI | NOMBRE | APELLIDOS | DIRECCION | LOCALIDAD");
		for (int i = 0; i < cliente.size(); i++) {
			System.out.println(cliente.get(i).getDni() +" | "+ cliente.get(i).getNombre() + " | " + cliente.get(i).getApellidos() +" | "+ cliente.get(i).getDireccion() +" | "+ cliente.get(i).getLocalidad());}
		}
		
		public static void comprobarClientes(ArrayList<Cliente> cliente, String comprobar, Scanner scan) throws ClassNotFoundException, SQLException, ParseException {
	
			Boolean bol = false;
			for (int i = 0; i < cliente.size(); i++) {
				if(comprobar.contains(cliente.get(i).getDni()) ) {
					System.out.println("El cliente existe");
					bol = true;
				}
				
			}
			if(bol == false) {
				System.out.println("El dni que ha introducido no existe.\nSALIENDO...");
				new GestorReservas().run(scan);
			}
				
				
				
			
			
	}
}
