package imagenes_espaciales;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.io.BufferedReader;

public class Compresion {
	private String comprimido;
	private String sinComprimir;
	private LinkedList<String> pilaDeCaracteres = new LinkedList<String>();
	private LinkedList<String> desapilaDeCaracteres = new LinkedList<String>();
	
	
	public String getComprimido() {
		return comprimido;
	}
	public void setComprimido(String comprimido) {
		this.comprimido = comprimido;
	}
	public String getSinComprimir() {
		return sinComprimir;
	}
	public void setSinComprimir(String sinComprimir) {
		this.sinComprimir = sinComprimir;
	}
	
	public Compresion (String path){
		File f = null;
		FileReader fr=  null;
		BufferedReader br = null;
		
		try{
			f = new File(path);
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String linea;
			
			//Leer Archivo
			linea = br.readLine();
			setSinComprimir (linea);
			linea = br.readLine();
			setComprimido(linea);
			
			//Cerrar Archivo
			if( fr != null ){
				fr.close();
			}
			
		}
		//Capturar Excepcion del archivo
		catch (Exception e1) {
			e1.printStackTrace();
		}
		
	    //Cerrar archivo si fue mal abierto  
		finally{
			try{
				if( null != fr ){
					fr.close();
				}                  
		    }
			catch (Exception e2){
				e2.printStackTrace();
			}
		}
	}

	public void ResolversinComprimir(){
		boolean primeraVez = true;
		int contador = 0;
		char letra = ' ';
		
		for(int i=0; i< sinComprimir.length();i++){
			//Analizo B
			if( primeraVez == true){
				primeraVez = false;
				letra = sinComprimir.charAt(i);
				contador++;				
			}
			else{
				if( letra == sinComprimir.charAt(i)){
					contador++;
				}
				else{
					//Esta parte es cuando cambia la secuencia de letra repetida
					if( contador > 4 ){
						//Agrego a la pila el dato comprimido
						pilaDeCaracteres.push("("+letra+contador+")");											
					}
					//esta parte es cuando cambia el contador pero no alcanza 4
					else{
						pilaDeCaracteres.push(""+letra);						
					}
					//ahora si modifico los datos para la proxima consulta
					letra=sinComprimir.charAt(i);
					contador=1;	
				}				
			}				
			//System.out.println(sinComprimir.charAt(i));

		}//sale for
		if( contador > 4 ){
		//Agrego a la pila el dato comprimido
			pilaDeCaracteres.push("("+letra+contador+")");											
		}
		//esta parte es cuando cambia el contador pero no alcanza 4
		else{
			pilaDeCaracteres.push(""+letra);						
		}
		/* Ver desapilando si quedo bien
		 * while( !pilaDeCaracteres.isEmpty()){
		 * 		System.out.println(pilaDeCaracteres.pop());
		 * }
		 */
	}
	

	public void ResolverComprimido(){
		int cantidad = 0;
		char letra = ' ';
		int i=0;
		while ( i<comprimido.length()){
			//Caracteres Unicos
			if( "N".equals(""+comprimido.charAt(i)) ||
				"B".equals(""+comprimido.charAt(i)) ||
				"R".equals(""+comprimido.charAt(i)) ||
				"A".equals(""+comprimido.charAt(i)) ||
				"V".equals(""+comprimido.charAt(i)) ){
				desapilaDeCaracteres.push(""+comprimido.charAt(i));
			}
			//Caracteres comprimidos
			else{
				//dentro del parentesis
				if( "(".equals(""+comprimido.charAt(i)) ){
					i++;
					letra = comprimido.charAt(i);
					i++;
					cantidad = Integer.parseInt(""+comprimido.charAt(i));
					for (int j=0;j<cantidad;j++){
						desapilaDeCaracteres.push(""+letra);
					
					}
					i++;
				}
			}
			i++;
		}
		/*Ver desapilando si esta bien cardado
		 *while( !desapilaDeCaracteres.isEmpty()){
		 *	System.out.println(desapilaDeCaracteres.pop());
		 *}
		 */
	}
	
	public void guardarArchivoComprimido(String path){
		FileWriter fw = null;
		PrintWriter pw = null;
		try{
			fw = new FileWriter(path);
			pw = new PrintWriter(fw);
			String raw = "";
			while( !pilaDeCaracteres.isEmpty()){
				raw+=pilaDeCaracteres.removeLast();
			}
			pw.println(raw);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				fw.close();
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void guardarArchivoDescomprimido(String path){
		FileWriter fw = null;
		PrintWriter pw = null;
		try{
			fw = new FileWriter(path);
			pw = new PrintWriter(fw);
			String raw = "";
			while( !desapilaDeCaracteres.isEmpty()){
				raw+=desapilaDeCaracteres.removeLast();
			}
			pw.println(raw);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				fw.close();
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
