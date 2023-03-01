package utilidades;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import clases.Cliente;
import clases.Hotel;
import gestores.GestorClientes;
import gestores.GestorReservas;

public class Visor {

	public static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
	
	public static void mostrarClientes(ArrayList<Cliente> cliente) {
		System.out.println("DNI | NOMBRE | APELLIDOS | DIRECCION | LOCALIDAD");

		for (Cliente cliente2 : cliente) {
			System.out.println(cliente2.getDni() + " | " + cliente2.getNombre() + " | "+ cliente2.getApellidos() + " | " + cliente2.getDireccion() + " | " +cliente2.getLocalidad());
		}
		}
	
	public static void mostrarHoteles(ArrayList<Hotel> hotel) {
		System.out.println("ID | CIF | NOMBRE | GERENTE | ESTRELLAS | COMPANIA");
		for (int i = 0; i < hotel.size(); i++) {
			System.out.println(hotel.get(i).getId() +" | "+ hotel.get(i).getCif() + " | " + hotel.get(i).getNombre() +" | "+ hotel.get(i).getGerente() +" | "+ hotel.get(i).getEstrellas() + " | " + hotel.get(i).getCompania());}
		for (Hotel hotel2 : hotel) {
			System.out.println(hotel2.getId() + " | "+ hotel2.getCif() +" | "+ hotel2.getNombre() +" | "+ hotel2.getGerente() +" | "+ hotel2.getEstrellas() +" | "+ hotel2.getCompania());
		}
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
		
		 public static void ordenarPorApellido(ArrayList<Cliente> cliente) {
		     	cliente.sort((o1, o2) -> o1.getApellidos().compareTo(o2.getApellidos().toLowerCase()));
		     	;
		     	
		        for (Cliente clientee: cliente) {
		            System.out.println(clientee.getApellidos() + " | " + clientee.getNombre());
		        }
		 }}

		

