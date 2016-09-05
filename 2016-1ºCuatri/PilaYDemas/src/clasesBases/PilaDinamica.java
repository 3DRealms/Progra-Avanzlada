package clasesBases;

import interfaces.Pila;
import exceptions.PilaException;

public class PilaDinamica<E> implements Pila<E> {
	
	private Nodo<E> top;
	
	private static class Nodo<T>{
	private T dato;
	private Nodo<T> sig;
	
	private Nodo(T dato,Nodo<T> sig){
		
		this.dato = dato;
		this.sig=sig;
	}
	}
	
	
	public PilaDinamica(){
		
		top=null;
	}
	
	@Override
	public boolean vacia() {
		return (top==null);
	}

	@Override
	public void apilar(E obj) {
		
		top = new Nodo<E>(obj,top);
	}

	@Override
	public E desapilar() {
				
			if(vacia())
			return null;
			E nuevo = top.dato;
			if(top.sig==null)
				top=null;
			else
				top=top.sig;
			
			return nuevo;
	}

	@Override
	public E verTope() {
		if(top==null)
			  return null;
		return top.dato;
	}

	@Override
	public void vaciar() {
		
		top=null;
		
	}
}
