package utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import clases.Cliente;
import clases.Habitacion;

/**
 * 
 * @author ${Arnold Bermell}
 *
 */

public class FormularioDeDatos {
	
	public static Cliente pedirDatosCliente(Scanner scan) {
		Cliente cliente = new Cliente();
		System.out.println("Introduzca el dni: ");
		cliente.setDni(scan.nextLine());
		System.out.println("Introduzca el nombre: ");
		cliente.setNombre(scan.nextLine());
		System.out.println("Introduzca el apellido ");
		cliente.setApellidos(scan.nextLine());
		System.out.println("Introduzca la direccion: ");
		cliente.setDireccion(scan.nextLine());
		System.out.println("Introduzca la localidad ");
		cliente.setLocalidad(scan.nextLine());
		
		return cliente;
		
	}
	
	public static String pedirDniCliente(Scanner scan) {
		System.out.println("Introduce el dni del cliente: ");
		String dni = scan.nextLine();
		
		return dni;
		
	}
	public static String pedirModificarCliente(Scanner scan) {

		System.out.println("Que desea modificar: (nombre, apellidos, direccion, localidad)");
		String modificar = scan.nextLine();

		return modificar;
	}
	public static String nuevoValor(Scanner scan) {
		System.out.println("Introduce el nuevo valor");
		String nuevoValor = scan.nextLine();
	
		return nuevoValor;
	}
	
	public static Date pedirFecha(Scanner scan) throws ParseException {
		System.out.println("Ingrese una fecha (dd/MM/yyyy)");
		String dateString = scan.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = sdf.parse(dateString);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;
	}
	
	public static int pedirIdHabitacion(Scanner scan) {
		System.out.println("Introduzca el id de la habitacion: ");
		int idHabitacion = Integer.parseInt(scan.nextLine());

	
		
		return idHabitacion;
	}
	public static int pedirIdReserva(Scanner scan) {
		System.out.println("Introduce la id de la reserva: ");
		int id = Integer.parseInt(scan.nextLine());
		
		return id;
	}
	
}
