package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
private Connection con;
	
	private static final String host = "localhost";
	private static final String bbdd = "agencia_viajes";
	private static final String username = "root";
	private static final String password = "";
	
	public void conectar() throws SQLException, ClassNotFoundException {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://" + host + "/" + bbdd, username, password);
	}
	public void cerrar() throws SQLException {
		con.close();
	}
	
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
}
