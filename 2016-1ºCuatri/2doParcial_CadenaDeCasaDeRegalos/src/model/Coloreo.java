package model;

import java.io.File;
import java.util.Arrays;

public class Coloreo extends Grafo {
	protected int cantidadColores;
	protected int[] frecuenciaColor;
	
	public Coloreo(File in) {
		super(in);
		frecuenciaColor = new int[nodos.length + 1];
		Arrays.fill(frecuenciaColor, 0);
	}
	
	private void clean(){
		for (int i = 0; i < nodos.length; i++) {
			nodos[i].clean();
		}
	}

	private boolean puedoColorear(int indice, int color) {
		if (nodos[indice].getColor() != 0) {
			return false;
		}

		for (int i = 0; i < nodos.length; i++) {
			if (indice != i) {
				if (isAdyacentes(nodos[indice].getIndice(), nodos[i].getIndice())) {
					if (nodos[i].getColor() == color) {
						return false;
					}
				}
			}
		}

		return true;
	}

	public void colorear() {
		int coloreados = 0;
		int color = 0;
		clean();
		Arrays.sort(nodos);
		
		while (coloreados < nodos.length) {
			color++;
			for (int indice = 0; indice < nodos.length; indice++) {
				if (puedoColorear(indice, color)) {
					nodos[indice].setColor(color);
					frecuenciaColor[color]++;
					coloreados++;
				}
			}			
		}
		cantidadColores = color;
	}
	
	protected int colorMasUsado(){
		int max = 0;
		for (int i = 0; i < frecuenciaColor.length; i++) {
			if (frecuenciaColor[i] > frecuenciaColor[max]) {
				max = i;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		File in = new File("entrada.in");
		Coloreo grafo = new Coloreo(in);
		grafo.colorear();
		System.out.println(Arrays.toString(grafo.getNodos()));
	}

}
