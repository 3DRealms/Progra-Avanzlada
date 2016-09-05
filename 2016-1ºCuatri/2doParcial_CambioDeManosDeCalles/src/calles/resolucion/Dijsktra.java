package calles.resolucion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import calles.clasesmodelo.Adyacencia;
import calles.clasesmodelo.Grafo;
import calles.clasesmodelo.Nodo;

public class Dijsktra {
	
	public static ResultadoDijkstra analizarDistancias(Grafo grafo, Nodo nodoOrigen) {
		
		List<Nodo> nodosDestino = new ArrayList<Nodo>(grafo.getNodos());   // Conjunto V-S
		
		Map<Nodo, Integer> distancias = inicializarMapaDistancias(grafo);
		//La distancia al origen debe ser 0
		distancias.put(nodoOrigen, 0);
		
		Map<Nodo, Nodo> caminos = new HashMap<Nodo, Nodo>(grafo.getCantidadNodos());
		
		Nodo nodoPivote = nodoOrigen;
		
		while ( !nodosDestino.isEmpty() ){
		 
			if(nodoPivote == null){
				nodoPivote = obtenerPivotePorPrioridad(nodosDestino, distancias);
			}
			
			// Elimino de los nodos a recorrer, el pivote, para conformar el conjunto V-S
			nodosDestino.remove(nodoPivote);	

			for (Nodo nodoDestino : nodosDestino) {
					if(grafo.sonAdyacentes(nodoPivote, nodoDestino)){
						
						Integer distanciaPivoteAlOrigen = distancias.get(nodoPivote);
						Integer distanciaDestinoAlOrigen = distancias.get(nodoDestino);
						
						Adyacencia adyacencia = grafo.obtenerAdyacencia(nodoPivote, nodoDestino);
						
						int nuevaDistancia = distanciaPivoteAlOrigen + adyacencia.getCosto();
						
						if(nuevaDistancia < distanciaDestinoAlOrigen){
							distancias.put(nodoDestino, nuevaDistancia);
							caminos.put(nodoDestino, nodoPivote);
						}
					}
			}
			nodoPivote = null;
		}	
	
		
		
		return new ResultadoDijkstra(nodoOrigen, distancias, caminos);
	}
	
	
	//Comienzo con todas las distancias en infinito
	private static Map<Nodo, Integer> inicializarMapaDistancias(Grafo grafo) {
		int cantidadNodos = grafo.getCantidadNodos();
		Map<Nodo, Integer> distancias = new HashMap<Nodo, Integer>(cantidadNodos);
		
		for(Nodo nodo : grafo.getNodos()){
			distancias.put(nodo, Integer.MAX_VALUE);
		}
		
		return distancias;
	}
	
	private static Nodo obtenerPivotePorPrioridad(List<Nodo> nodosDestino, Map<Nodo, Integer> distancias){

		int menor = Integer.MAX_VALUE;
		Nodo menorNodo = nodosDestino.get(0); // PRUEBO CON EL PRIMERO
		
		Iterator<Nodo> iNodos = nodosDestino.iterator();
		
		while(iNodos.hasNext()){
			Nodo nodo = (Nodo) iNodos.next();
			
			int distanciaAlOrigen = distancias.get(nodo);
			
			 if(distanciaAlOrigen < menor){
				 menorNodo = nodo;
				 menor = distanciaAlOrigen;
			 }
			
		}
		return menorNodo;
	}
	
	
	public static class ResultadoDijkstra{
		private Map<Nodo, Integer> distancias;
		private Map<Nodo, Nodo> camino;
		private Nodo origen;
		
		public ResultadoDijkstra(Nodo origen, Map<Nodo, Integer> distancias, Map<Nodo, Nodo> camino) {
			this.distancias = distancias;
			this.camino = camino;
			this.origen = origen;
		}

		public Map<Nodo, Integer> getDistancias() {
			return distancias;
		}

		public Map<Nodo, Nodo> getCamino() {
			return camino;
		}		
	}	
}