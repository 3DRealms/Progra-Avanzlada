package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Grafo {
	protected boolean[][] matrizAdyacencia;
	protected Nodo[] nodos;

	public Grafo(File in) {
		FileReader fr = null;
		BufferedReader br = null;
		int FIN_LINEA = -1;
		try {
			fr = new FileReader(in);
			br = new BufferedReader(fr);
			String linea;
			String[] data;
			int cantidadNodos;
			
			linea = br.readLine();
			cantidadNodos = Integer.parseInt(linea);
			initGrafo(cantidadNodos);
			
			for (int i = 0; i < cantidadNodos; i++) {
				linea = br.readLine();
				data = linea.split(" ");
				int origen = Integer.parseInt(data[0]) - 1;
				for (int j = 1; j < data.length; j++) {
					int destino = Integer.parseInt(data[j]);
					if (destino != FIN_LINEA) {
						destino--;
						setNodo(origen, destino);
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	private void initGrafo(int cantidadNodos){
		nodos = new Nodo[cantidadNodos];
		for (int i = 0; i < nodos.length; i++) {
			nodos[i] = new Nodo(i, 0, 0);
		}
		
		matrizAdyacencia = new boolean[cantidadNodos][cantidadNodos];
		for (int i = 0; i < cantidadNodos; i++) {
			for (int j = 0; j < cantidadNodos; j++) {
				matrizAdyacencia[i][j] = false;
			}
		}
	}
	
	private void setNodo(int origen, int destino){
		nodos[origen].addGrado();
		nodos[destino].addGrado();		
		matrizAdyacencia[origen][destino] = true;
		matrizAdyacencia[destino][origen] = true;
	}
	
	protected boolean isAdyacentes(int origen, int destino){
		return matrizAdyacencia[origen][destino];
	}

	public Nodo[] getNodos() {
		return nodos;
	}	
}
