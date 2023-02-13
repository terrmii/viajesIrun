package gestores;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import clases.Cliente;
import utilidades.FormularioDeDatos;
import utilidades.Menu;
import utilidades.Visor;

public class GestorClientes {

	@SuppressWarnings("static-access")
	public void run(Scanner scan) throws ClassNotFoundException, SQLException ,ParseException{
		int opcion;
		
		GestorBBDD bbdd = new GestorBBDD();
		
		do {
			Menu.mostrarMenuClientes();
			opcion = Integer.parseInt(scan.nextLine());
			Cliente cliente = new Cliente();
			
			switch (opcion) {
			case Menu.REGISTRAR_CLIENTE:
				cliente = new FormularioDeDatos().pedirDatosCliente(scan);
				
				bbdd.registrarClientes(cliente);
				break;

			case Menu.BAJA_CLIENTE:

				bbdd.bajaCliente(FormularioDeDatos.pedirDniCliente(scan));
				break;
			case Menu.MODIFICAR_CLIENTE:
				bbdd.modificarCliente(FormularioDeDatos.pedirDniCliente(scan), FormularioDeDatos.pedirModificarCliente(scan), FormularioDeDatos.nuevoValor(scan));
				
				break;
			case Menu.LISTA_CLIENTE:
				Visor.mostrarClientes(bbdd.visualizarCliente());
				break;
			case Menu.ATRAS:
				new GestorViajes().run();
			default:
				Visor.mostrarMensaje(opcion + " no es un valor valido");
			}
		} while (opcion != 0);
	}

}
