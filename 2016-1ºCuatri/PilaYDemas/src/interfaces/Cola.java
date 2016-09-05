package interfaces;

import exceptions.ColaException;

public interface Cola<E> {

	
	public boolean vacia();
	public void acolar(E obj);
	public E desacolar();
	public E verPrimero();
	public void vaciar();
}
