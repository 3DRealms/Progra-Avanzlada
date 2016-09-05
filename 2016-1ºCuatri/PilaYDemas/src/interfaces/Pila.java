package interfaces;

import exceptions.PilaException;

public interface Pila<E> {

	
	public boolean vacia();
	public void apilar(E obj);
	public E desapilar() ;
	public E verTope();
	public void vaciar();
}
