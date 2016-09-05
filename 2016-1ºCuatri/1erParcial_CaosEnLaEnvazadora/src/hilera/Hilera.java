package hilera;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Hilera {
	private String[] datos;
	private int[] mayor1;
	private int[] mayor2;
	private int distancia;

	public Hilera(String path) {
		File f = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			f = new File(path);
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			
			this.datos = br.readLine().split(" ");
			this.mayor1 = new int[2];
			this.mayor2 = new int[2];
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fr != null)
					fr.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void resolver(){
		int i = 0;
		int secuencia = 0;
		while(!(this.datos[i].contentEquals("F"))){
			if(this.datos[i].contentEquals("G")){
				secuencia++;
			} else {
				if(secuencia > mayor1[0]){
					mayor2[0] = mayor1[0];
					mayor2[1] = mayor1[1];
					mayor1[0] = secuencia;
					mayor1[1] = i-1;
				} else if(secuencia > mayor2[0]) {
					mayor2[0] = secuencia;
					mayor2[1] = i-1;
				}
				secuencia = 0;
			}
			i++;
		}
		if(mayor1[1] > mayor2[1])
			this.distancia = mayor1[1] - mayor2[1] - mayor1[0];
		else
			this.distancia = mayor2[1] - mayor1[1] - mayor2[0];
	}
	
	public void escribirSalida(String path){
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter(path);
			pw = new PrintWriter(fw);
			
			pw.println(this.datos.length-1);
			pw.println(this.mayor1[0]);
			pw.println(this.mayor2[0]);
			pw.println(this.distancia);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fw != null)
				try {
					fw.close();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		}
	}
	
	public static void main(String[] args) {
		Hilera h = new Hilera("entrada.in");
		
		for (int i = 0; i < h.datos.length; i++) {
			System.out.print(h.datos[i] + " ");
		}
		
		h.resolver();
		System.out.println(" ");
		System.out.println(h.datos.length-1);
		System.out.println(h.mayor1[0]);
		System.out.println(h.mayor2[0]);
		System.out.println(h.distancia);
		
		h.escribirSalida("salida.out");
		//System.out.println(h.datos[0].contentEquals(h.datos[7]));
	}

}
