package calles.clasesmodelo;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	List<Nodo> nodos;
	Adyacencia[][] matrizAdyacencia;
	int cantidadNodos;

	int indiceColectivo;
	int indiceEscuela;
	
	public Grafo(int cantidadNodos, int indiceColectivo, int indiceEscuela){
		generarNodos(cantidadNodos);
		matrizAdyacencia = new Adyacencia[cantidadNodos][cantidadNodos];
		this.cantidadNodos = cantidadNodos; 
		this.indiceColectivo = indiceColectivo;
		this.indiceEscuela = indiceEscuela;
	}
	
	private void generarNodos(int cantNodos){
		nodos = new ArrayList<Nodo>(cantNodos);		
		for (int i=0;i<cantNodos;i++){
			nodos.add(new Nodo(i));
		}
	}
	
	public List<Nodo> getNodos(){
		return nodos;
	}
	
	public int getCantidadNodos(){
		return cantidadNodos;
	}
	
	public boolean sonAdyacentes(Nodo nodo1, Nodo nodo2){
		return matrizAdyacencia[nodo1.getEsquina()][nodo2.getEsquina()] != null;
	}
	
	public Adyacencia obtenerAdyacencia(Nodo nodo1, Nodo nodo2){
		return matrizAdyacencia[nodo1.getEsquina()][nodo2.getEsquina()];
	}

	public Adyacencia obtenerAdyacencia(int indice1, int indice2){
		return matrizAdyacencia[indice1][indice2];
	}
	
	public void agregarAdyacencia(Adyacencia adyacencia){
		matrizAdyacencia[adyacencia.getDesde()][adyacencia.getHasta()] = adyacencia;
	}

	public Nodo obtenerNodo(int indice){
		return nodos.get(indice); 
	}
	
	public Nodo obtenerNodoEsquinaOrigenColectivo(){
		return obtenerNodo(indiceColectivo);
	}
	
	public Nodo obtenerNodoEsquinaEscuela(){
		return obtenerNodo(indiceEscuela);
	}
	
	
	public void invertirAdyacencia(Adyacencia adyacencia){
		int desde = adyacencia.getDesde();
		int hasta = adyacencia.getHasta();
		
		matrizAdyacencia[desde][hasta] = null;
		matrizAdyacencia[hasta][desde] = new Adyacencia(hasta, desde, adyacencia.getCosto());
	}
	
}
