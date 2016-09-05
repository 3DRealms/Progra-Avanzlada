package metro;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GeneradorFatiga {
	public static void main(String[] arg0){
		File archivo;
		FileWriter fw;
		PrintWriter pw;
		String path = "C:/Documents and Settings/lab4/Escritorio/Casos/IN/7fatiga.in";
		try {
			archivo = new File(path);
			fw = new FileWriter(archivo);
			pw = new PrintWriter(fw);
			int aux;
			
			pw.println("8000 8000 8000");
			for(int i = 1; i < 8000; i++){
				aux = 1+i;
				pw.println(i + " " + aux);
			}
			pw.println(8000 + " " + 1);
			
			for(int i = 1; i < 7999; i++){
				aux = i+2;
				pw.println(i + " " + aux);
			}
			pw.println(7999 + " " + 1);
			pw.println(8000 + " " + 2);
			
			pw.close();
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}