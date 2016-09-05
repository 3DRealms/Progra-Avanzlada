package metro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class Metro {
	public static void main(String[] args) {
		File archivo;
		File archivo2;
		FileReader fr;
		BufferedReader br;
		FileWriter fw;
		PrintWriter pw;
		String path = "IN/7fatiga";
		try {
			archivo = new File(path + ".in");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea = br.readLine();
			String line[] = linea.split(" ");
			int cant_islas = Integer.parseInt(line[0]);
			int cant_tuneles = Integer.parseInt(line[1]);
			int cant_puentes = Integer.parseInt(line[2]);
			
			Grafo islas = new Grafo(cant_islas, cant_tuneles + cant_puentes);
			for (int i = 0; i < cant_tuneles; i++) {
				linea = br.readLine();
				line = linea.split(" ");
				islas.nuevaArista(Integer.parseInt(line[0]),
						Integer.parseInt(line[1]), 0);
			}
			for (int i = 0; i < cant_puentes; i++) {
				linea = br.readLine();
				line = linea.split(" ");
				islas.nuevaArista(Integer.parseInt(line[0]),
						Integer.parseInt(line[1]), 1);
			}
			fr.close();
			br.close();
			try {
				archivo2 = new File(path + ".out");
				fw = new FileWriter(archivo2);
				pw = new PrintWriter(fw);
				int puentes;
				puentes = islas.Prim(0);
				pw.println(puentes);
				fw.close();
				pw.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
