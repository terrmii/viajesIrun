package gestores;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import clases.Cliente;
import utilidades.Menu;
import utilidades.Visor;

public class GestorConsultasCliente {

	public void run(Scanner scan) throws ClassNotFoundException, SQLException, ParseException {
		
		int opcion;
		GestorBBDD bbdd = new GestorBBDD();
		do {
			Menu.mostrarMenuConsultasCliente();
			opcion = Integer.parseInt(scan.nextLine());
			switch (opcion) {
			case Menu.ORDENADO_APELLIDOS:
				
				ArrayList<Cliente> clientesA = bbdd.visualizarCliente();
				Visor.ordenarPorApellido(clientesA);
				break;
			case Menu.ORDENADO_NOMBRE:
				
				break;
				
			case Menu.ATRAS:
				new GestorClientes().run(scan);
				break;
			default:
				Visor.mostrarMensaje(opcion + " no es un valor valido");
			}

		} while (opcion != 0);
	}

}
