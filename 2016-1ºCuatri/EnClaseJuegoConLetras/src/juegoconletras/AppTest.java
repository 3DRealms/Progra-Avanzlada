package juegoconletras;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AppTest {

	public static void main(String[] args) {
		try {
			String [] lista = Lucas.listarIn();
			for (int i=0; i < lista.length; i++){
				System.out.println("");
				Rapigrama objeto = new Rapigrama (lista[i] + ".in");
				System.out.println(lista[i]);
				Calendar tIni= new GregorianCalendar();
				objeto.resolverJuego();
				Calendar tFin= new GregorianCalendar();			
				Long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();			
				System.out.println("La solucion fue:");
				objeto.escribirArchivo(lista[i] + ".out");
				System.out.println("el tiempo que tarda en resolver es: " +diff);
				
			}
			}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
