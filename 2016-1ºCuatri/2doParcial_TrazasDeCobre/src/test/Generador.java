package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Generador {
	private String secuencia;

	public Generador(String secuencia) {
		this.secuencia = secuencia;
	}
	
	public static File getFileIn(String secuencia, String fileName){
		File entrada = new File("src/test/"+fileName);
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter(entrada);
			pw = new PrintWriter(fw);
			
			pw.println(secuencia.length());
			pw.print(secuencia);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fw) {
					fw.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return entrada;
	}
	
	public static File getFileOut(String fileName){
		File salida = new File("src/test/"+fileName);
		
		return salida;
	}
}
