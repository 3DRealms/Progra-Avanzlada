package funcion;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test extends Resolver {
	
	//Expresion test;
	public Test(){
		
	}
	
	public static void main(String[] args) {
		
		try {
			// Abro carpeta test/input
			File directorio = new File("test\\input");
			
			String nombre;
			// Recorro los archivos uno a uno
			for (File archivo : directorio.listFiles()) {

				// Obtengo el nombre del archivo
				nombre = archivo.getName();
				Calendar tIni = new GregorianCalendar();
				// Abro el archivo de entrada
				Resolver test = new Test();
				try {
					test.Cargar("test\\input\\" + nombre);
					test.resolver();
				} catch (Exception e) {
					e.printStackTrace();
				}

				Calendar tFin = new GregorianCalendar();

				// Escribo el archivo de salida
				nombre = nombre.split("\\.")[0];
				test.toFile("test\\output\\" + nombre + ".out");

				// Muestro tiempo utilizado
				System.out.println(nombre + ": "
						+ (tFin.getTimeInMillis() - tIni.getTimeInMillis())
						+ " ms");
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
