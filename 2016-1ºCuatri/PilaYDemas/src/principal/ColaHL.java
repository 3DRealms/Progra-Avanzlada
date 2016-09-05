package principal;

import interfaces.Cola;
import clasesBases.Lista;
import exceptions.ColaException;

public class ColaHL<E> extends Lista<E> implements Cola<E>{

	
	 public ColaHL(){
		 
		 super();
	 }

	@Override
	public void acolar(E obj) {
		
		super.insertarAlFinal(obj);
		
	}

	@Override
	public E desacolar() {
	
		E desacolado = super.buscar(0);
		super.borrarPrimero();
		return desacolado;
	}

	@Override
	public E verPrimero()  {
		
		return super.buscar(0);
	}


}
