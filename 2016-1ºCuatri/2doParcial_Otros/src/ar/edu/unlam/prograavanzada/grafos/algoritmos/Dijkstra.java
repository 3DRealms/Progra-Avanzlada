package ar.edu.unlam.prograavanzada.grafos.algoritmos;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nicolas
 * O(n^3)
 */
public class Dijkstra {
	
	private Integer[][] matriz;
	
	private Integer[] distanciasMinimas;
	private Integer[] predecesores;
	
	private Integer nodoInicial;
	
    public Dijkstra(Integer[][] matrizAdyacenciaPonderada) {
		this.matriz = matrizAdyacenciaPonderada;
	}

	public void resolver(Integer nodoInicial) {
    	
		this.nodoInicial=nodoInicial;
		
    	Integer cantidadNodos = this.matriz.length;
    	
    	//Distancias mínimas almacenará la menor distancia desde
    	//cualquier nodo hacia el nodo inicial, si existe camino
    	this.distanciasMinimas = new Integer[cantidadNodos];
        this.distanciasMinimas[this.nodoInicial] = 0;
        
        //Predecesores permite obtener el nodo anterior a cualquier 
        //nodo en el camino de mínima distancia hacia el nodo inicial
        this.predecesores = new Integer[cantidadNodos];
        
        //Lista de nodos restantes a evaluar en algoritmo de Djikstra
        //Es el conjunto de nodos, menos el inicial.
        //En cada iteración se quita del conjunto restante el nodo de menor distancia hacia el inicial
        List<Integer> nodosRestantesAEvaluar = new ArrayList<Integer>();
        for (Integer i = 0; i < cantidadNodos; i++) {
            nodosRestantesAEvaluar.add(i);
        }
        nodosRestantesAEvaluar.remove(this.nodoInicial);
        
        //Se toma como primer nodo a evaluar el nodo inicial
        Integer nodoActual = this.nodoInicial;
        
        //Mientras haya nodos restantes a evaluar..
        while (!nodosRestantesAEvaluar.isEmpty() && nodoActual!=null ) {
            
        	//Se verifica si existe algún camino mas corto para llegar al nodo inicial 
        	//desde cada nodo restante, pasando por el nodo actual (debe ser adyacente)
        	
        	for(Integer nodoRestante : nodosRestantesAEvaluar){
        		if (nodoRestante!=nodoActual
    				&& this.matriz[nodoActual][nodoRestante]!=null 
    				&& this.matriz[nodoActual][nodoRestante]!=0) {
        			
        			Integer adyacente = nodoRestante;
        	
                	Integer posibleMenorDistancia = 
                			this.matriz[nodoActual][adyacente] 
                			+ this.distanciasMinimas[nodoActual];
                    
                    if (this.distanciasMinimas[adyacente] == null 
                    		|| posibleMenorDistancia < this.distanciasMinimas[adyacente]) {
                    	
                    	//Se determina que la distancia menor desde el adyacente al inicial es a través del nodo actual
                        this.distanciasMinimas[adyacente] = posibleMenorDistancia;
                        this.predecesores[adyacente] = nodoActual;
                    }
                }
            }
        	
            nodosRestantesAEvaluar.remove(nodoActual);
            Integer proximoNodo = null;
            
            //Se selecciona como proximo nodo a evaluar dentro de los restantes
            //al que tenga mas proximidad al nodo inicial
            for (Integer nodoRestanteAEvaluar : nodosRestantesAEvaluar) { 
                if ( this.distanciasMinimas[nodoRestanteAEvaluar]!=null &&
	            		( proximoNodo == null || 
	            		  this.distanciasMinimas[nodoRestanteAEvaluar] < this.distanciasMinimas[proximoNodo] ) ) {
                	proximoNodo = nodoRestanteAEvaluar;
                }
            }
            nodoActual = proximoNodo;
        }
    }

    public List<Integer> obtenerCamino(Integer nodoFinal) {
		
		List<Integer> camino = new ArrayList<Integer>();
        camino.add(nodoFinal);
        while (nodoFinal != this.nodoInicial) {
        	nodoFinal = this.predecesores[nodoFinal];
            camino.add(nodoFinal);
        }
        return camino;
	}

	public Integer[] getDistanciasMinimas() {
		return distanciasMinimas;
	}

	public Integer[] getPredecesores() {
		return predecesores;
	}

}
