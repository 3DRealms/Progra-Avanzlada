package ar.edu.unlam.prograavanzada.grafos.problemas.arbol;

import java.util.ArrayList;
import java.util.List;

public class NodoArbol {

	private Integer nroNodo;
	
	private List<Integer> predecesores;
	private List<Integer> precedidos;
	
	public NodoArbol(Integer nroNodo) {
		this.nroNodo = nroNodo;
		this.predecesores = new ArrayList<Integer>();
		this.precedidos = new ArrayList<Integer>();
	}

	public List<Integer> getPredecesores() {
		return predecesores;
	}

	public List<Integer> getPrecedidos() {
		return precedidos;
	}

	public Integer getNroNodo() {
		return nroNodo;
	}

}
