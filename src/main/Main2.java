package main;

import java.sql.SQLException;
import java.util.Scanner;

import clases.Hotel;
import gestores.GestorBBDD;
import utilidades.FormularioDeDatos;

public class Main2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		Scanner scan = new Scanner(System.in);

		System.out.println("Introduce el nombre del hotel: ");
		String nombreHotel = scan.nextLine();
		
		GestorBBDD bbdd = new GestorBBDD();
		Hotel hotel = new Hotel();
		
		FormularioDeDatos.comprobarHotel(nombreHotel, bbdd, bbdd.visualizarHotel());
		
		
	}
}
