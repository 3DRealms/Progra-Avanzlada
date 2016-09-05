package principal;

import interfaces.Pila;
import clasesBases.Lista;
import exceptions.PilaException;

public class PilaHL<E> extends Lista<E> implements Pila<E>{

	
	public PilaHL(){
		super();
	}
	
	@Override
	public boolean vacia() {
		return super.vacia();
	}

	@Override
	public void apilar(E obj) {

		super.insertarAlPrincipio(obj);
	}

	@Override
	public E desapilar() {
		
		E desapilado= super.buscar(0);
		super.borrarPrimero();
		return desapilado;
	}

	@Override
	public E verTope()  {
		
		return super.buscar(0);
	}
	
	

}
