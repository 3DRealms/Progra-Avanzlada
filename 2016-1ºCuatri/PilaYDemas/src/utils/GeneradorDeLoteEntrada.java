package utils;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

public class GeneradorDeLoteEntrada {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random r = new Random();
		
		String path="..\\Prueba\\LoteDeEntrada.in";
		int cantidadEnteros = 1000000;
		FileWriter fichero = null;
        PrintWriter pw = null;
       	 
        
        try
        {
            fichero = new FileWriter(path);
            pw = new PrintWriter(fichero);
            pw.println(cantidadEnteros);
            for(int i=0;i<cantidadEnteros-1;i++){
            	pw.println(r.nextInt(999)+1);	            	
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }

	}

	}
}
