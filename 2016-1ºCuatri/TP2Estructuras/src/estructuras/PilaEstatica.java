package estructuras;

import java.util.Arrays;

public class PilaEstatica implements Pila {
	private NodoDinamico[] nodos;
	private int tope;
	
	//pila_vacia
	public boolean empty() {
		return tope == -1;
	}
	//poner_en_pila
	public void push(Object dato) {
		if (tope == nodos.length-1) {
			nodos = Arrays.copyOf(nodos, nodos.length * 2);
		}
		NodoDinamico aux = new NodoDinamico(dato,null);
		nodos[tope].setSiguiente(aux);
		tope++;
	}
	//sacar_de_pila
	public Object pop() {
		if (tope == -1)
			return null;
		if (tope == 0){			
			Object aux = nodos[tope].getDatos();
			nodos = new NodoDinamico[1];
			return aux;
		}
		
		return nodos[--tope].getDatos();
	}
	//ver_el_tope
	public Object peek() {
		if (tope == -1)
			return null;
		return nodos[tope];
	}
	//vaciar_pila
	public void vaciar() {
		tope = -1;
	}
}
