package edu.unlam.oia;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		File entrada = new File("entrada.in");
		File salida = new File("salida.out");
		
		Ejercicio ejer = new Ejercicio(entrada,salida);
		
		ejer.resolver();
	}
}
