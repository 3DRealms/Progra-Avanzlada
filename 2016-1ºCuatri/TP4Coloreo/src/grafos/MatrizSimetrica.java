package grafos;

import java.util.Random;

public class MatrizSimetrica {
	private boolean[] vectorEquivalente;
	private int dimension;
	private int n;// orden de la matriz
	private int tam;// tamaño del vector

	public MatrizSimetrica(int dimension) {
		this.dimension = dimension;
		Double aux;

		if (dimension < 0)
			dimension = 1;

		tam = (dimension * (dimension - 1)) / 2;
		vectorEquivalente = new boolean[tam];
		aux = ((1 + Math.sqrt(1 + 8 * vectorEquivalente.length)) / 2);
		n = aux.intValue();
	}

	// Generar
	public void generarGrafo(double porcAdy) {
		Random r = new Random();
		int rand;
		Double aux = (porcAdy * this.tam) / 100;
		;
		int cantAristas = (int) Math.round(aux);
		for (int i = 0; i < cantAristas; i++) {
			if (vectorEquivalente[rand = r.nextInt(cantAristas + 1)] == true)
				i--;
			else
				vectorEquivalente[rand] = true;
		}
	}

	public boolean getValor(int f, int c) {
		if (f == c)
			return true;
		int i;
		if (f > c)
			i = (c * n) + f - ((c * c) + (3 * c) + 2) / 2;
		else
			i = (f * n) + c - ((f * f) + (3 * f) + 2) / 2;
		return vectorEquivalente[i];
	}

	public boolean getValor(int i) {
		return vectorEquivalente[i];
	}

	public int getDimension() {
		return dimension;
	}

	public void setValor(int f, int c, boolean val) {
		if (f == c)
			return;
		int i;
		if (f > c)
			i = (c * n) + f - ((c * c) + (3 * c) + 2) / 2;
		else
			i = (f * n) + c - ((f * f) + (3 * f) + 2) / 2;
		vectorEquivalente[i] = val;
	}

	public void setValor(int i, boolean val) {
		vectorEquivalente[i] = val;
	}

	public void mostrarMatriz() {
		System.out.print(" ");
		for (int i = 0; i < dimension; i++) {
			System.out.print("|" + i + "\t");
		}
		System.out.println("|");
		for (int i = 0; i < dimension; i++) {
			System.out.print(i);
			for (int j = 0; j < dimension; j++) {
				System.out.print("|" + getValor(i, j) + "\t");
			}
			System.out.println("|");
		}
	}

	public int getTam() {
		return tam;
	}
}