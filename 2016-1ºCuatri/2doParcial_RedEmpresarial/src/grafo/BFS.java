package grafo;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	private GrafoNDNP grafo;
	private int cantNodos;
	private boolean []visto;
	private int []distancia;
	private Queue<Integer> colaNodos;
	
	public BFS(GrafoNDNP grafo) {
		this.grafo = grafo.clone();
		this.cantNodos = this.grafo.getCantNodos();
	}
	
	public int[] getDistancias(int nodoInicio) {
		visto = new boolean[cantNodos];
		distancia = new int[cantNodos];
		colaNodos = new LinkedList<Integer>();
		
		int nodo = nodoInicio;
		distancia[nodo] = 0;
		visto[nodo] = true;
		colaNodos.offer(nodo);
		
		while(!colaNodos.isEmpty()) {
			nodo = colaNodos.poll();
			for(int i = 0; i < cantNodos; i++) {
				if(!visto[i] && grafo.getArista(nodo, i)) {
					visto[i] = true;
					distancia[i] = distancia[nodo]+1;
					colaNodos.offer(i);
				}
			}
		}
		
		int []vectorDistancias = new int[cantNodos];
		System.arraycopy(distancia, 0, vectorDistancias, 0, cantNodos);
		return vectorDistancias;
		
	}
}
