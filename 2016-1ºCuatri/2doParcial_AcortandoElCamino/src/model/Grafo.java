package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Grafo {
	protected MatrizSimetrica matrizAdyacencia;
	protected int[] nodos;
	protected Arista[] aristas;
	
	public Grafo(File in){
		FileReader fr = null;
		BufferedReader br = null;
		int cantidadNodos;
		int cantidadAristasOk;
		int cantidadAristasMal;
		
		try {
			fr = new FileReader(in);
			br = new BufferedReader(fr);
			
			String linea;
			String[] data;
			
			linea = br.readLine();
			data = linea.split(" ");
			cantidadNodos = Integer.parseInt(data[0]);
			cantidadAristasOk = Integer.parseInt(data[1]);
			cantidadAristasMal = Integer.parseInt(data[2]);
			nodos = new int[cantidadNodos];
			aristas = new Arista[cantidadAristasOk + cantidadAristasMal];
			initNodos();
			matrizAdyacencia = new MatrizSimetrica(cantidadNodos);
			
			for (int i = 0; i < cantidadAristasOk; i++) {
				data = br.readLine().split(" ");
				int origen = Integer.parseInt(data[0]) - 1;
				int destino = Integer.parseInt(data[1]) - 1;
				matrizAdyacencia.setNodo(origen, destino);
				int costo = Integer.parseInt(data[2]);
				aristas[i] = new Arista(i, origen, destino, costo, true);
			}
			for (int i = cantidadAristasOk; i < (cantidadAristasOk + cantidadAristasMal); i++) {
				data = br.readLine().split(" ");
				int origen = Integer.parseInt(data[0]) - 1;
				int destino = Integer.parseInt(data[1]) - 1;
				matrizAdyacencia.setNodo(origen, destino);
				int costo = Integer.parseInt(data[2]);
				aristas[i] = new Arista((i - cantidadAristasOk), origen, destino, costo, false);
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
	
	protected boolean isAdyacentes(int nodoOrigen, int nodoDestino){
		return matrizAdyacencia.isAdyacentes(nodoOrigen, nodoDestino);
	}

	private void initNodos() {
		for (int i = 0; i < nodos.length; i++) {
			nodos[i] = i;
		}
	}

	public MatrizSimetrica getMatrizAdyacencia() {
		return matrizAdyacencia;
	}

	public int[] getNodos() {
		return nodos;
	}

	public Arista[] getAristas() {
		return aristas;
	}
	
	protected Arista getArista(int origen, int destino){
		Arista aux = null;
		boolean first = true;
		for (int i = 0; i < aristas.length; i++) {
			if (aristas[i].getNodoOrigen() == origen && aristas[i].getNodoDestino() == destino) {
				if (first) {
					aux = aristas[i];
					first = false;
				} else {
					if(aux.getCosto() > aristas[i].getCosto()) {
						aux = aristas[i];	
					} else if(aux.getCosto() == aristas[i].getCosto() && !aux.isLibre() && aristas[i].isLibre()) {
						aux = aristas[i];
					}
				}
				
			}
		}
		return aux;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < nodos.length; i++)
			for (int j = i + 1; j < nodos.length; j++) {
				if (matrizAdyacencia.isAdyacentes(i, j)) {
					sb.append((i+1) + " " + (j+1) + "\n");
				}
			}
		return sb.toString();
	}	
}
