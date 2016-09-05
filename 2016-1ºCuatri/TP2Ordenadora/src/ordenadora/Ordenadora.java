package ordenadora;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class Ordenadora {

	private int vector[];
	private int tam;

	public int[] getVector() {
		return vector;
	}

	public void setVector(int[] vector) {
		this.vector = vector;
	}

	public int getTam() {
		return tam;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}

	public Ordenadora(String path) {

		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		int i;

		try {
			archivo = new File(path);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			tam = Integer.parseInt(br.readLine());
			vector = new int[tam];
			for (i = 0; i < tam; i++) {
				vector[i] = Integer.parseInt(br.readLine());
			}
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
		}
	}

	public void seleccion() {
		int i, j, aux, pos;

		for (j = 0; j < (tam - 1); j++) {
			pos = j;

			for (i = j + 1; i < tam; i++) {
				if (vector[i] < vector[pos])
					pos = i;
			}

			aux = vector[pos];
			vector[pos] = vector[j];
			vector[j] = aux;
		}
	}

	public void insercionSinCentinela() {

		int i, j;

		for (i = 1; i < tam; i++) {
			int aux = vector[i];

			for (j = i - 1; j >= 0 && vector[j] > aux; j--)
				vector[j + 1] = vector[j];

			vector[j + 1] = aux;
		}
	}

	public void insercionConCentinela() {

		int i, j, aux;

		for (i = tam - 1; i > 0; i--) {
			if (vector[i] < vector[i - 1]) {
				intercambiar(i);
			}
		}

		for (i = 2; i < tam; i++) {
			aux = vector[i];
			j = i - 1;
			while (aux < vector[j]) {
				vector[j + 1] = vector[j--];
			}
			vector[j + 1] = aux;
		}
	}

	private void intercambiar(int i) {
		int aux;
		aux = vector[i];
		vector[i] = vector[i - 1];
		vector[i - 1] = aux;
	}

	public void burbujaSinBandera() {

		for (int i = 1; i < tam; i++) {

			for (int k = tam - 1; k >= i; k--) {

				if (vector[k] < vector[k - 1]) {
					intercambiar(k);
				}
			}
		}
	}

	public void burbujaConBandera() {
		int temp, j, cota = tam, k = 1;

		while (k != 0) {
			k = 0;

			for (j = 1; j < cota; j++) {

				if (vector[j - 1] > vector[j]) {
					temp = vector[j - 1];
					vector[j - 1] = vector[j];
					vector[j] = temp;
					k = j;
				}
			}

			cota = k;
		}
	}

	// QuickSort, elijiendo pivote el del medio
	public void quicksortMedio(int primero, int ultimo) {
		int i = primero, j = ultimo, aux;
		int pivote = vector[(primero + ultimo) / 2];

		do {
			while (vector[i] < pivote)
				i++;
			while (vector[j] > pivote)
				j--;

			if (i <= j) {
				aux = vector[j];
				vector[j--] = vector[i];
				vector[i++] = aux;
			}

		} while (i <= j);

		if (primero < j)
			quicksortMedio(primero, j);
		if (ultimo > i)
			quicksortMedio(i, ultimo);
	}

	public void shell() {

		int i, j, p, tmp;

		for (p = vector.length / 2; p > 0; p = p == 2 ? 1 : (int) (p / 2.2)) {

			for (i = p; i < vector.length; i++) {
				tmp = vector[i];

				for (j = i; j >= p && tmp < vector[j - p]; j -= p) {
					vector[j] = vector[j - p];
				}

				vector[j] = tmp;
			}
		}
	}

	public void fusion(int pri, int ult) {

		int n = (ult + 1) - pri;
		if (n > 2) {
			int m = (int) n / 2 + pri;
			fusion(pri, m - 1);
			fusion(m, ult);
			merge(pri, m, ult);
		} else {
			if (vector[pri] > vector[ult]) {
				int aux = vector[pri];
				vector[pri] = vector[ult];
				vector[ult] = aux;
			}
		}
	}

	public void fusion() {
		fusion(0, tam - 1);
	}

	private void merge(int pri, int m, int ult) {

		int[] aux = new int[(ult + 1) - pri];
		int i, j, p, k = 0;

		for (i = pri; i <= ult; i++) {
			aux[k] = vector[i];
			k++;
		}

		i = 0;
		j = (m - pri);
		p = pri;

		while (i < (m - pri)) {

			while (j < aux.length && aux[i] > aux[j]) {
				vector[p++] = aux[j++];
			}

			vector[p++] = aux[i++];
		}

		while (j < aux.length) {
			vector[p++] = aux[j++];
		}
	}

	// Aux

	public void mostrar() {
		System.out.println("Los valores son: ");
		for (int i = 0; i < tam; i++)
			System.out.println(vector[i]);

	}

	@Override
	public String toString() {
		return "Ordenadora [vector=" + Arrays.toString(vector) + "]";
	}

	public void clonar(int[] clon, int[] modelo) {
		for (int i = 0; i < clon.length; i++)
			clon[i] = modelo[i];

	}

	public void GrabarVectorOrdenado(String Ruta) {

		FileWriter archivo = null;
		PrintWriter pw = null;

		try {
			archivo = new FileWriter(Ruta);
			pw = new PrintWriter(archivo);

			pw.println(tam);

			for (int i = 0; i < tam; i++) {
				pw.println(vector[i]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != archivo)
					archivo.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}