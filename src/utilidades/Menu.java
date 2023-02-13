package utilidades;

public class Menu {
	
	public static void mostrarMenuPrincipal() {
		System.out.println("1. Gestionar clientes");
		System.out.println("2. Gestionar reservas");
		System.out.println("3. Gestionar hoteles y habitaciones");
		System.out.println("4. Lista clientes");
		System.out.println("0. Salir");
	}
	
	public static void mostrarMenuClientes() {
		System.out.println("1. Registrar cliente");
		System.out.println("2. Dar de baja cliente");
		System.out.println("3. Modificar cliente");
		System.out.println("0. Atras");
	}
	
	public static void mostrarMenuReservas() {
		System.out.println("1. Realizar reserva");
		System.out.println("2. Anular reserva");
		System.out.println("0. Atras");
	}
	
	public static void mostrarMenuHoteles() {
		System.out.println("1. Registrar nuevo Hotel");
		System.out.println("2. Registrar nueva habitacion");
		System.out.println("0. Atras");
	}
	
	public static final int GESTIONAR_CLIENTES = 1;
	public static final int GESTIONAR_RESERVAS = 2;
	public static final int GESTIONAR_HOTELES_HABITACIONES = 3;
	public static final int SALIR = 0;
	
	public static final int REGISTRAR_CLIENTE = 1;
	public static final int BAJA_CLIENTE = 2;
	public static final int MODIFICAR_CLIENTE = 3;
	public static final int LISTA_CLIENTE = 4;
	
	public static final int REALIZAR_RESERVA = 1;
	public static final int ANULAR_RESERVA = 2;
	
	public static final int REGISTRAR_HOTEL = 1;
	public static final int REGISTRAR_HABITACION = 2;
	
	public static final int ATRAS = 0;
}
