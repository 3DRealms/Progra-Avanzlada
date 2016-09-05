package integrador.punto5.PilaDinamica;

public class PilaDinamica implements Pila{
	
	//Clase Privada Nodo
	private class Nodo{
		private Object dato;
		private Nodo siguiente;
		private Nodo(Object x, Nodo y){
			this.dato = x;
			this.siguiente = y;
		}
	}
	
	//Objeto de la Pila Dinamica
	private Nodo tope;
	
	//Constructor de Pila Dinamica
	public PilaDinamica(){
		tope = null;
	}
	
	//Metodos de Pila Dinamica
	public boolean empty(){
		//pila vacia
		if (tope == null)
			return true;
		return false;
	}
	public void push (Object x){
		//poner en pila
		tope = new Nodo (x, tope);
	}
	public Object pop(){
		//sacar de pila
		if ( empty() )
			return null;
		Object extraido = tope.dato;
		if (tope.siguiente == null)
			tope = null;
		else
			tope = tope.siguiente;
		return extraido;	
	}
	public Object peek(){
		//ver tope
		if (tope == null)
			return null;
		return tope.dato;
	}
	public void clear(){
		//limpiar pila
		tope = null;
	}
}