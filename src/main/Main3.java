package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) throws ParseException {

		System.out.println("Introduzca una fecha: ");
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = sdf.parse(scan.nextLine());
		sdf.format(fecha);
		
	}
}
