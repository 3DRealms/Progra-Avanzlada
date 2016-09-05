package principal;

import interfaces.Pila;
import clasesBases.Lista;
import exceptions.PilaException;

public class PilaCL<E> implements Pila<E> {

	private Lista<E> lista = new Lista<E>();
	
	@Override
	public boolean vacia() {
		// TODO Auto-generated method stub
		return lista.vacia();
	}

	@Override
	public void apilar(E obj) {
		
		lista.insertarAlPrincipio(obj);
		
	}

	@Override
	public E desapilar() {

		E desapilado= lista.buscar(0);
		lista.borrarPrimero();
		return desapilado;
		
	}

	@Override
	public E verTope() {
		return lista.buscar(0);
	}

	@Override
	public void vaciar() {

		lista.vaciar();
		
	}

}
