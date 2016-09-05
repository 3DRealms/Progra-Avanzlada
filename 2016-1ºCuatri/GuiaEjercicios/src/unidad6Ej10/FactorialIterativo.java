package unidad6Ej10;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class FactorialIterativo{
	public static void main(String[]args){
		double numero = 15000; //Es el numero a sacar su factorial
		BigInteger resultado =new BigInteger("1");
		BigInteger contador =new BigInteger("15000");
		//double res=1; //Guardara el valor de la operacion en cada iteracion
		Calendar tIni= new GregorianCalendar();
		if ( numero == 0 || numero == 1)
			System.out.println("12");
			//Se realizan los casos base si n es igual a 0 o 1 se imprime 1
		for(double i=numero; i>=0; i--){ //Se realiza la iteracion mientras i sea menor o igual a n se entrara al ciclo y se realizara la operacion ya despues se imprime el resultado del factorial
			contador.subtract(BigInteger.ONE);
			resultado = resultado.multiply(contador);
		}
		//System.out.println(resultado);
		Calendar tFin= new GregorianCalendar();		
		Long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();			
		System.out.println("el tiempo que tarda en resolver es: " +diff);  
   }
}


