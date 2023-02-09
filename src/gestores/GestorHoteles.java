package gestores;

import java.sql.SQLException;
import java.util.Scanner;

import utilidades.FormularioDeDatos;
import utilidades.Menu;
import utilidades.Visor;

public class GestorHoteles {

		public void run(Scanner scan) throws ClassNotFoundException, SQLException {
			GestorBBDD bbdd = new GestorBBDD();
			int opcion;
		
			do {
				Menu.mostrarMenuHoteles();
				opcion = Integer.parseInt(scan.nextLine());
				switch (opcion) {
				case Menu.REGISTRAR_HOTEL:
					bbdd.altaHotel(FormularioDeDatos.datosHotel(scan));
					break;
					
				case Menu.REGISTRAR_HABITACION:
					bbdd.altaHabitacion(FormularioDeDatos.datosHabitacion(scan));
					break;
				default:
					Visor.mostrarMensaje(opcion + " no es un valor valido");
					break;
				}
			} while (opcion != 0);
			
		}
	
}
