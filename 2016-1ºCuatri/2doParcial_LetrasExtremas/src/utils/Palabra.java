package utils;

public class Palabra {

	public static char primerLetra(String palabra){
		return palabra.charAt(0);
	}
	
	public static char ultimaLetra(String palabra){
		return palabra.charAt(palabra.length()-1);
	}
}
