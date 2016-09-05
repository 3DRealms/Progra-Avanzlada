package model;

import java.io.File;
import java.util.Arrays;

public class Dijkstra extends Grafo {
	final static int INFINITO = 1000000;
	protected int[] distancias;
	protected int[] camino;
	protected boolean[] vistos;
	protected int[][] matrizCostos;

	public Dijkstra(File in) {
		super(in);
		distancias = new int[nodos.length];
		camino = new int[nodos.length];
		vistos = new boolean[nodos.length];
		matrizCostos = new int[nodos.length][nodos.length];
		Arrays.fill(distancias, INFINITO);
		Arrays.fill(camino, -1);
		Arrays.fill(vistos, false);

		for (int i = 0; i < matrizCostos.length; i++) {
			for (int j = 0; j < matrizCostos.length; j++) {
				matrizCostos[i][j] = INFINITO;
			}
		}
		for (Arista arista : aristas) {
			int origen = arista.getNodoOrigen();
			int destino = arista.getNodoDestino();
			int costo = arista.getCosto();
			if (matrizCostos[origen][destino] > costo) {
				matrizCostos[origen][destino] = costo;
			} else if(matrizCostos[origen][destino] == costo && arista.isLibre()) {
				matrizCostos[origen][destino] = costo;
			}
		}
	}

	@Override
	protected boolean isAdyacentes(int nodoOrigen, int nodoDestino) {
		return matrizCostos[nodoOrigen][nodoDestino] != INFINITO;
	}

	private int nextMenor(int actual) {
		int next = -1;
		int costoMenor = INFINITO;
		for (int i = 0; i < nodos.length; i++) {
			if (actual != i) {
				if (!vistos[i] && costoMenor >= distancias[i]) {
					next = nodos[i];
					costoMenor = distancias[i];
				}
			}
		}
		return next;
	}

	private void distanciasMenores(int nodoOrigen) {
		for (int i = 0; i < nodos.length; i++) {
			if (nodoOrigen != i) {
				if (isAdyacentes(nodoOrigen, i)) {
					if (!vistos[i]) {
						int acum = distancias[nodoOrigen] + matrizCostos[nodoOrigen][i];
						if (distancias[i] > acum) {
							distancias[i] = acum;
							camino[i] = nodoOrigen;
						}
					}
				}
			}
		}
	}

	protected void resolverDijkstra() {
		int origen = -1;
		boolean first = true;
		int nodosVistos = 0;
		while (nodosVistos < nodos.length) {
			if (first) {
				origen = 0;
				distancias[0] = 0;
				camino[0] = 0;
				first = false;
			} else {
				origen = nextMenor(origen);
			}

			vistos[origen] = true;
			nodosVistos++;
			distanciasMenores(origen);
		}
	}

	public int[] getDistancias() {
		return distancias;
	}

	public boolean[] getVistos() {
		return vistos;
	}

	public int[] getCamino() {
		return camino;
	}
}
