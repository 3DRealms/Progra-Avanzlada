package clasesBases;

import interfaces.Cola;
import exceptions.ColaException;

public class ColaDinamica<E> implements Cola<E>{

	private Nodo<E> prim;
	private Nodo<E>ult;
	
	private class Nodo<T>{
		
		private T dato;
		private Nodo<T> sig;
	
	
	private Nodo(T dato, Nodo<T> siguiente){
		
		this.dato= dato;
		this.sig= siguiente;
	}
	}
	
	public ColaDinamica(){
		
		prim=null;
		ult=null;
	}
	@Override
	public boolean vacia() {
		return prim==null;
	}

	@Override
	public void acolar(E obj) {
		
		ult= new Nodo<E>(obj,ult);
		if(prim==null)
			prim=ult;
	}

	@Override
	public E desacolar() {
		Nodo<E> aux = prim;
		if(prim!=null)
		prim= prim.sig;
		return aux.dato;
		
	}

	@Override
	public E verPrimero() {
		if(prim!=null)
		return prim.dato;
		return null;
	}

	@Override
	public void vaciar() {
		ult=prim=null;		
	}
	

}
