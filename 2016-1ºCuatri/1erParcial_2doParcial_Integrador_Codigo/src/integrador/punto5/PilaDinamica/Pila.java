package integrador.punto5.PilaDinamica;

public interface Pila {
	public boolean empty();	//pila vacia
	public void push (Object x);	//poner en pila
	public Object pop(); 	//sacar de pila
	public Object peek(); 	//ver tope
	public void clear(); 	//limpiar pila
}
