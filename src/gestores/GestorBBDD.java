package gestores;

import utilidades.Conector;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import clases.Cliente;

public class GestorBBDD {
	
	Conector con = new Conector();
	PreparedStatement ps;
	
	public void registrarClientes(Cliente cliente) throws ClassNotFoundException, SQLException {
		con.conectar();
		ps = con.getCon().prepareStatement("INSERT INTO clientes (dni, nombre, apellidos, direccion, localidad) VALUES (?, ? , ?, ?, ?)");
		ps.setString(1, cliente.getDni());
		ps.setString(2, cliente.getNombre());
		ps.setString(3, cliente.getApellidos());
		ps.setString(4, cliente.getDireccion());
		ps.setString(5, cliente.getLocalidad());
		ps.execute();
	}
	
	public void bajaCliente(String dni) throws ClassNotFoundException, SQLException {
		con.conectar();
		ps = con.getCon().prepareStatement("DELETE FROM clientes WHERE `clientes`.`dni` = ?");
		ps.setString(1, dni);
		ps.execute();
	}
	
	public void modificarCliente(String dni, String modificar, String nuevoValor) throws ClassNotFoundException, SQLException {
		con.conectar();
		ps = con.getCon().prepareStatement("UPDATE clientes SET "+modificar+" = ? WHERE `clientes`.`dni` = ?");
		ps.setString(1, nuevoValor);
		ps.setString(2, dni);
		ps.execute();
	}
	
	public void realizarReserva(int id_habitacion, String dni, Date desde, Date hasta) throws ClassNotFoundException, SQLException {
		con.conectar();
		ps = con.getCon().prepareStatement("INSERT INTO reservas (id_habitacion, dni, desde, hasta) VALUES (?, ?, ?, ?)");
		ps.setInt(1, id_habitacion);
		ps.setString(2, dni);
		ps.setDate(3, (java.sql.Date) desde);
		ps.setDate(4, (java.sql.Date) hasta);
	}
}
