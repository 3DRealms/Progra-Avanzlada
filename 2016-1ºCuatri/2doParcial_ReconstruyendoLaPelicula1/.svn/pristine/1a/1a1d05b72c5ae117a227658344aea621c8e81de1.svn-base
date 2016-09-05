package pelicula.clasesmodelo;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	Adyacencia[][] matrizAdyacencia;
	List<Nodo> nodos;
	
	int cantNodos;
	int escenaFinal;
	
	
	public Grafo(int cantNodos, int escenaFinal){
		matrizAdyacencia = new Adyacencia[cantNodos][cantNodos];
		nodos = new ArrayList<Nodo>(cantNodos);
		this.cantNodos   = cantNodos;
		this.escenaFinal = escenaFinal; 
	}
	
	
	public void agregarNodo(Nodo nodoNuevo){
		if(grafoLleno()){
			throw new RuntimeException("EL GRAFO ESTA LLENO, NO SE PUEDE AGREGAR MAS NADA");
		}
		
		nodos.add(nodoNuevo);
	}
	
	
	public boolean grafoLleno(){
		return nodos.size() == cantNodos;
	}

	public Nodo obtenerNodo(int posicion){
		return nodos.get(posicion);
	}

	public void agregarAdyacencia(int i, int j, Adyacencia adyacencia){
		matrizAdyacencia[i][j] = adyacencia;
	}
	
	public List<Nodo> obtenerNodosOrigen(){
		List<Nodo> origenes = new ArrayList<Nodo>();

		for(int i=0;i<cantNodos;i++){
			Nodo nodo = nodos.get(i);
			if(nodo.esSegmentoOrigen()){
				origenes.add(nodo);
			}
		}
		
		return origenes;
	}
	
	public List<Nodo> obtenerNodosDestino(){
		List<Nodo> destinos = new ArrayList<Nodo>();

		for(int i=0;i<cantNodos;i++){
			Nodo nodo = nodos.get(i);
			if(nodo.terminaCon(escenaFinal)){
				destinos.add(nodo);
			}
		}
		
		return destinos;
	}
		
	
	public List<Nodo> getNodos(){
		return nodos;
	}
	
	public int getCantidadNodos(){
		return cantNodos;
	}
	
	public boolean sonAdyacentes(Nodo nodo1, Nodo nodo2){
		return matrizAdyacencia[nodo1.getNroSegmento()][nodo2.getNroSegmento()] != null;
	}
	
	public Adyacencia obtenerAdyacencia(Nodo nodo1, Nodo nodo2){
		return matrizAdyacencia[nodo1.getNroSegmento()][nodo2.getNroSegmento()];
	}
}
