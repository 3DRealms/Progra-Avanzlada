package estructuras;

public class PilaHeredaLista extends Lista implements Pila {
	
	//pila_vacia
	public boolean empty() {
	return super.getNodos().length == 0;
	}
	//poner_en_pila
	public void push(Object dato) {
		NodoDinamico aux =  new NodoDinamico(dato,null);
		super.getNodos()[super.getNodos().length-1].setSiguiente(aux);
	}
	//sacar_de_pila
	public Object pop() {
		Object aux = super.getNodos()[super.getNodos().length-1].getDatos();
		super.getNodos()[super.getNodos().length-2].setSiguiente(null);
		return aux;
	}
	//ver_el_tope
	public Object peek() {
		return super.getNodos()[super.getNodos().length-1].getDatos();
	}
	//vaciar_pila
	public void vaciar() {
		super.setNodos(new NodoDinamico[1]);
	}
}
