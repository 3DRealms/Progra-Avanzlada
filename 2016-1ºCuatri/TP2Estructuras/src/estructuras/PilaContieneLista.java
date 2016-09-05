package estructuras;

public class PilaContieneLista extends Lista implements Pila {
	Lista lista;
	int tope;

	//Constructor
	public PilaContieneLista(int tam, Lista lista, int tope) {
		super(tam);
		this.lista = lista;
		this.tope = tope;
	}
	
	
	/*
	public PilaContieneLista() {
		super(tam);
		this.lista = lista;
		this.tope = tope;
	}
	*/
	
	//pila_vacia
	public boolean empty() {
		return lista.getNodos().length == 0;
	}
	//poner_en_pila
	public void push(Object dato) {
		if (lista.getNodos().length == tope)
			lista.reSize();
		NodoDinamico aux = new NodoDinamico(dato,null);
		lista.getNodos()[tope++].setSiguiente(aux);
	}
	//sacar_de_pila
	public Object pop() {
	 return lista.getNodos()[tope --];
	}
	//ver_el_tope
	public Object peek() {
	return lista.getNodos()[tope];
	}
	//vaciar_pila
	public void vaciar() {
	lista = null;
	tope = -1;
	}
}
