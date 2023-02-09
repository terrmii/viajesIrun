package gestores;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import utilidades.Menu;
import utilidades.Visor;

public class GestorViajes {

		public void run() throws ClassNotFoundException, SQLException, ParseException {
			Scanner scan = new Scanner(System.in);
			int opcion;
			
		do {
			Menu.mostrarMenuPrincipal();
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			case Menu.GESTIONAR_CLIENTES:
				
				new GestorClientes().run(scan);
				break;

			case Menu.GESTIONAR_RESERVAS:
				
				new GestorReservas().run(scan);
				break;
				
			case Menu.GESTIONAR_HOTELES_HABITACIONES:
				
				new GestorHoteles().run(scan);
				break;
				
			case Menu.SALIR:
				Visor.mostrarMensaje("Saliendo...");
				System.exit(0);
				break;
			default:
				Visor.mostrarMensaje(opcion + " no es un valor valido");
				break;
			}
		} while (opcion != 0);
		}
	
}
