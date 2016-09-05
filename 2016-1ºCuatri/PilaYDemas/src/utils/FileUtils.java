package utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;


public class FileUtils {

	public static int[] leerArchivo(String path){
	File f = null;
	FileReader fr = null;
	BufferedReader br = null;

	
	try	{   
		f = new File(path);
		fr = new FileReader(f);
		br = new BufferedReader(fr);		
		String linea = br.readLine();
		
		if(linea != null) {
				int cantLineas = Integer.parseInt(linea);
				
				if(cantLineas < 0) {
					System.out.println("Error de dimension de archivo");
					System.exit(1);
				}
				int[] datos= new int[cantLineas];	
				int i=1;
				datos[0]=cantLineas;
				while((linea = br.readLine()) != null) {
				datos[i]=Integer.parseInt(linea);
				i++;
				}
				return datos;
			}
		
		
		
	
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	finally	{
		try	{ 
			if(fr!= null)
				fr.close();
		} catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	return null;
	}

	
	public static void escribirArchivo(String path, String cadena){
	      FileWriter fichero = null;
	        PrintWriter pw = null;
	        try
	        {
	            fichero = new FileWriter(path);
	            pw = new PrintWriter(fichero);
	           {
	            	pw.println(cadena);	            	
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