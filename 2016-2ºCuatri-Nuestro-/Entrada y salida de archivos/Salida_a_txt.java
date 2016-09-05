import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// esto es un ejemplo minimo para  grabar sus datos en un archivo  de texto
public class Salida_a_txt {

	public static void main(String[] args)	throws IOException {
		
		String miPath = "\\gus\\programas\\workspace\\";
		
		PrintWriter salida = new PrintWriter(new FileWriter(miPath+"complejos.txt"));  //  preparo el arch de salida
	     
	    int z=50;
	    String s="dni:";
	    salida.print(s);      
		salida.println(" "+z); 
		salida.close(); //esto escribe : dni: 50

	}

}
