package seleccion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class GeneradorInputSEL {

	private int[] dimensiones = null;

	private int[] LeerArchivoDimensiones(String nomArch) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			archivo = new File(nomArch);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			int cantDimensiones = Integer.parseInt(br.readLine());
			dimensiones = new int[cantDimensiones];
			for (int i = 0; i < cantDimensiones; i++)
				dimensiones[i] = Integer.parseInt(br.readLine());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			// return dimensiones;
		}
		return dimensiones;
	}

	public void GenerarArchivosInput(String nomArchDimensiones) {
		this.dimensiones = LeerArchivoDimensiones(nomArchDimensiones);
		String[] input = null;
		for (int n : dimensiones) {
			// iteracion por cada caso de input
			input = new String[1 + n * n + n];
			input[0] = String.valueOf(n);
			int linea = 1;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					input[linea] = String.valueOf(i) + " " + String.valueOf(j)
							+ " " + String.valueOf(Math.random() * 10);
					linea++;
				}
			}

			for (int k = 0; k < n; k++) {
				input[linea] = String.valueOf(Math.random() * 10);
				linea++;
			}
			//Guardo los casos generados en un archivo .IN
			GrabarArchivoGenerado(input, n);
			System.out.println("Caso " + String.format("%04d", n));
			
			
			
		}
	}

	private void GrabarArchivoGenerado(String[] datos, int numeroCaso) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter("Caso " + String.format("%04d", numeroCaso)
					+ ".in");

			pw = new PrintWriter(fichero);

			for (String linea : datos) {
				pw.println(linea);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}


}
