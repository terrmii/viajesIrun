package gestores;

import utilidades.Conector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import clases.Cliente;
import clases.Habitacion;
import clases.Hotel;

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
	
	public ArrayList<Cliente> visualizarCliente() throws ClassNotFoundException, SQLException{
		con.conectar();
		ps = con.getCon().prepareStatement("SELECT * from clientes");
		ResultSet res = ps.executeQuery();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		while(res.next()) {
			Cliente cliente = new Cliente();
			cliente.setDni(res.getString("dni"));
			cliente.setNombre(res.getString("nombre"));
			cliente.setApellidos(res.getString("apellidos"));
			cliente.setDireccion(res.getString("direccion"));
			cliente.setLocalidad(res.getString("localidad"));
			
			clientes.add(cliente);
		}
		return clientes;
	}
	
//	public void comprobarCliente(String comprobar, String atributo) throws ClassNotFoundException, SQLException {
//		con.conectar();
//		ps = con.getCon().prepareStatement("SELECT * from clientes WHERE ? = ?");
//		ps.setString(1, atributo);
//		ps.setString(2, comprobar);
//		ps.execute();
//		
//	}
	
	public ArrayList<Cliente> comprobarCliente(String comprobar, String valor) throws ClassNotFoundException, SQLException {
		con.conectar();
		ps = con.getCon().prepareStatement("SELECT * from clientes WHERE ? = ?");
		ps.setString(1, comprobar);
		ps.setString(2, valor);
		ps.execute();
		
		ResultSet res = ps.executeQuery();
		ArrayList<Cliente> clientes = new ArrayList();
		while(res.next()) {
			Cliente cliente = new Cliente();
			cliente.setDni(res.getString("dni"));
			cliente.setNombre(res.getString("nombre"));
			cliente.setApellidos(res.getString("apellidos"));
			cliente.setDireccion(res.getString("direccion"));
			cliente.setLocalidad(res.getString("localidad"));
			
			clientes.add(cliente);
			if(clientes.contains(comprobar)) {
				ps = con.getCon().prepareStatement("SELECT * from clientes WHERE ? = ?");
				ps.setString(1, comprobar);
				ps.setString(2, valor);
				ps.execute();
				
				return clientes;
			}
		}
		return clientes;
	}
	
	public void realizarReserva(int id_habitacion, String dni, Date desde, Date hasta) throws ClassNotFoundException, SQLException {
		con.conectar();
		ps = con.getCon().prepareStatement("INSERT INTO reservas (id_habitacion, dni, desde, hasta) VALUES (?, ?, ?, ?)");
		ps.setInt(1, id_habitacion);
		ps.setString(2, dni);
		ps.setDate(3, (java.sql.Date) desde);
		ps.setDate(4, (java.sql.Date) hasta);
		ps.execute();
	}
	
	public void anularReserva(int id) throws ClassNotFoundException, SQLException {
		con.conectar();
		ps = con.getCon().prepareStatement("DELETE FROM reservas WHERE `reservas`.`id` = ?");
		ps.setInt(1, id);
		ps.execute();
	}
	
	public void altaHotel(Hotel hotel) throws ClassNotFoundException, SQLException {
		con.conectar();
		ps = con.getCon().prepareStatement("INSERT INTO hoteles (cif, nombre, gerente, estrellas, compania) VALUES (?, ?, ? , ?, ?)");
		ps.setString(1, hotel.getCif());
		ps.setString(2, hotel.getNombre());
		ps.setString(3, hotel.getGerente());
		ps.setInt(4, hotel.getEstrellas());
		ps.setString(5, hotel.getCompania());
		ps.execute();
	}
	
	public void altaHabitacion(Habitacion habitacion) throws SQLException, ClassNotFoundException {
		con.conectar();
		ps = con.getCon().prepareStatement("INSERT INTO habitaciones VALUES (?, ?, ?, ? , ?)");
		ps.setInt(1, habitacion.getId());
		ps.setInt(2, habitacion.getId_hotel());
		ps.setString(3, habitacion.getNumero());
		ps.setString(4, habitacion.getDescripcion());
		ps.setDouble(5, habitacion.getPrecio());
		ps.execute();
	}
	
	public ArrayList<Cliente> ordenarApellido() throws ClassNotFoundException, SQLException{
		con.conectar();
		ps = con.getCon().prepareStatement("SELECT * from clientes");
		ResultSet res = ps.executeQuery();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		while(res.next()) {
			Cliente cliente = new Cliente();
			cliente.setDni(res.getString("dni"));
			cliente.setNombre(res.getString("nombre"));
			cliente.setApellidos(res.getString("apellidos"));
			cliente.setDireccion(res.getString("direccion"));
			cliente.setLocalidad(res.getString("localidad"));
			
			clientes.add(cliente);
		}
		return clientes;
		
	}
}
