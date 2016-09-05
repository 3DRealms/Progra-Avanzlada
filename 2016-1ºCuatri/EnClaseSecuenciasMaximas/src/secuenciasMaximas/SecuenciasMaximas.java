package secuenciasMaximas;
import java.io.*;

public class SecuenciasMaximas {

	public static void main(String[] args) {
		
		//Variables para cargar archivo, trozarlo en un array y generar operaciones
		File f = null;
		FileReader fr = null;
		BufferedReader br =null;
		int [] vec = null;
		int pos = 0;
		int cont = 0;
		int sec = 0;
		int sec_tmp = 0;
			
		//Try	
		try
		{
			f = new File("secuencias.in");
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String linea;
			// br.readLine() lee sobre br una linea entera de String
			//Integer.parseInt() transforma en enteros la cadena de String
			//vec = new int [] crea el objeto vector de enteros pero necesita la longitud que toma de la primer linea del archivo parseado segun enunciado
			vec = new int [Integer.parseInt(br.readLine())];
			//Lee las siguientes lineas hasta fin de archivo
			while( ( linea=br.readLine() ) != null ){
				//carga transformado a int los datos en el vector por posicion			
				vec[pos] = Integer.parseInt(linea);
				pos++;
			}
			//como un foreach hasta fin de longitud de vector hace las comparaciones de enunciadoi			
			for( int i = 0; i < vec.length; i++ ){
				//Condicion dada en enunciado
				if( vec[i] % 2 != 0 && vec[i] % 3 != 0 && vec[i] % 5 != 0 ){
					cont++;
					sec_tmp++;
					System.out.println("Dentro del contador");
					System.out.println(cont);
					System.out.println(sec);
				}
				else{
					if(sec == 0 || sec < sec_tmp){
						sec = sec_tmp;	
					}
					
					System.out.println("Fuera del contador");
					System.out.println(cont);
					System.out.println(sec);
				}
			}
			if(sec < sec_tmp){
				sec = sec_tmp;	
			}
			System.out.println("Salida");
			System.out.println(cont);
			System.out.println(sec);
			
			//Grabar archivo
	        FileWriter fichero = null;
	        PrintWriter pw = null;
	        try
	        {
	            fichero = new FileWriter("secuencias.out");
	            pw = new PrintWriter(fichero);

	            pw.println(cont);
	            pw.println(sec);

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
		//Catch	
		catch(Exception e){
	        e.printStackTrace();
		}
	}
}

		
