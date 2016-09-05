package ordenadora;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;

public class GeneradorDeCasos {

	private int cantElementos;
	private int vector[];

	public GeneradorDeCasos(int cantElementos) {
		this.cantElementos = cantElementos;
		vector = new int[cantElementos];
	}

	public void generarCasoOrdenado() {
		int i;
		for (i = 0; i < cantElementos; i++)
			vector[i] = i;
	}

	public void generarCasoAleatorio() {
		int i;
		Random r = new Random();
		for (i = 0; i < cantElementos; i++)
			vector[i] = r.nextInt(cantElementos + 1);
	}

	public void generarCasoInvertido() {
		int i, j;
		for (i = 0, j = cantElementos - 1; i < cantElementos; i++, j--)
			vector[i] = j;
	}

	public void mostrarVector() {
		int i;
		for (i = 0; i < cantElementos; i++)
			System.out.print(vector[i] + " ");
	}

	@SuppressWarnings("resource")
	public void grabarArchivo(String path) {
		int i;
		FileWriter archivo = null;
		try {
			archivo = new FileWriter(path);
			PrintWriter pw = new PrintWriter(archivo);
			pw.println(cantElementos);
			for (i = 0; i < cantElementos; i++)
				pw.println(vector[i]);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (archivo != null) {
					archivo.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		int cant = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out
				.println("Programa Generador de Vectores:\n-------------------------------\n");
		System.out
				.println("Ingrese la Cantidad de Elementos: ");
		try {
			cant = Integer.parseInt(br.readLine());
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		GeneradorDeCasos caso1 = new GeneradorDeCasos(cant);
		caso1.generarCasoInvertido();
		caso1.grabarArchivo("vector_Invertido_" + cant + ".in");
		GeneradorDeCasos caso2 = new GeneradorDeCasos(cant);
		caso2.generarCasoOrdenado();
		caso2.grabarArchivo("vector_Ordenado_" + cant + ".in");
		GeneradorDeCasos caso3 = new GeneradorDeCasos(cant);
		caso3.generarCasoAleatorio();
		caso3.grabarArchivo("vector_Random_" + cant + ".in");
		}
	}