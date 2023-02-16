package gestores;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import utilidades.Visor;
import utilidades.FormularioDeDatos;
import utilidades.Menu;

/**
 * 
 * @author ${Arnold Bermell}
 *
 */

public class GestorReservas {

		public void run(Scanner scan) throws ClassNotFoundException, SQLException, ParseException {
			int opcion;
			GestorBBDD bbdd = new GestorBBDD();
			do {
				Menu.mostrarMenuReservas();
				opcion = Integer.parseInt(scan.nextLine());
				switch (opcion) {
				case Menu.REALIZAR_RESERVA:
					Visor.comprobarClientes(bbdd.visualizarCliente(), FormularioDeDatos.comprobarCliente(scan), scan);
					bbdd.realizarReserva(FormularioDeDatos.pedirIdHabitacion(scan), FormularioDeDatos.pedirDniCliente(scan), FormularioDeDatos.pedirFecha(scan), FormularioDeDatos.pedirFecha(scan));
					break;	
				case Menu.ANULAR_RESERVA:
					bbdd.anularReserva(FormularioDeDatos.pedirIdReserva(scan));
					break;
				default:
					Visor.mostrarMensaje(opcion + " no es un valor valido");
					break;
				}
			} while (opcion != 0);
		}
	
}
