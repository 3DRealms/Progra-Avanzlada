package principal;

import interfaces.Cola;
import clasesBases.Lista;
import exceptions.ColaException;

public class ColaCL<E> implements Cola<E>{

	private Lista<E> lista;
	
	
	
	public ColaCL(){
		
	 lista = new Lista<E>();
	}
	@Override
	public boolean vacia() {
		return lista.vacia();
	}

	@Override
	public void acolar(E obj) {
		
		lista.insertarAlFinal(obj);
		
	}

	@Override
	public E desacolar() {
		
		E desacolado = lista.buscar(0);
		lista.borrarPrimero();
		
		return desacolado;
	}

	@Override
	public E verPrimero() {
		// TODO Auto-generated method stub
		return lista.buscar(0);
	}

	@Override
	public void vaciar() {
		
		lista.vaciar();
		
	}

	
}
