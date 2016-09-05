package unidad6Ej10;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class FactorialRecursivo {
	
	public static BigInteger factorial (BigInteger numero) {
		if (numero.equals(BigInteger.ZERO)) return BigInteger.ONE;
		else return numero.multiply ( factorial( numero.subtract(BigInteger.ONE ) ) );	
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar tIni= new GregorianCalendar();
		BigInteger dato = new BigInteger("15000"); 
		BigInteger resultado = new BigInteger("1"); 
		resultado = factorial( dato );
		//System.out.println( factorial( dato  ) );
		//System.out.println(factorial( dato ));
		Calendar tFin= new GregorianCalendar();		
		Long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();	
		//System.out.println(resultado);
		System.out.println("el tiempo que tarda en resolver es: " +diff);
	}

}
/*
public class Main {
	static int factorial (int numero) {
		if (numero == 0) return 1;
		else return numero * factorial(numero-1);
	}
	public static void main(String[] args) {
		System.out.println("Factorial de 5 es: " + factorial(5));
	}
}

*/