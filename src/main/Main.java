package main;

import java.sql.SQLException;
import java.text.ParseException;

import gestores.GestorViajes;

/**
 * 
 * @author ${Arnold Bermell}
 *
 */
public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		new GestorViajes().run();
	}
}
