package ejercicioComplejo;

import java.util.ArrayList;
import java.util.Arrays;

public class Complejo implements Comparable {

	private double imaginario;
	private double real;

	public Complejo() {
		imaginario = 0;
		real = 0;
	}

	public Complejo(double real, double img) {
		this.imaginario = img;
		this.real = real;
	}

	public String toString() {
		return real + "+" + imaginario + "i";
	}

	public double modulo() {
		return Math.sqrt((Math.pow(2, real) + Math.pow(2, imaginario)));
	}
	
	@Override
	public int compareTo(Object arg0) {
		  
		double aux = this.modulo() - ( (Complejo)arg0).modulo() ;
		if  ( aux  > 0) 
			return 1;
		else if(aux < 0 )
			return -1;
		
		return 0;
	}
	
	public static void main(String[] args) {

		Complejo[] vecComplejo = new Complejo[10];

		int cantidad = 10;
		inicializarVector(cantidad,vecComplejo);
		mostrar(cantidad,vecComplejo);
		
		Arrays.sort(vecComplejo);
		
		System.out.println("ORDENAR");
		mostrar(cantidad,vecComplejo);
	}

	private static void mostrar(int cant,Complejo[] vecComplejo) {
		for (int i = 0; i < cant; i++) {
			System.out.println(vecComplejo[i]);
		}
	}

	private static void inicializarVector(int cant,Complejo[] vecComplejo) {
		for (int i = 0; i < cant; i++) {
			vecComplejo[i] = new Complejo( 10-i,10-i );
		}
	}

}
