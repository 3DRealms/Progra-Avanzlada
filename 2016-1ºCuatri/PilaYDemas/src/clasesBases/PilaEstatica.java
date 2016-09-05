package clasesBases;

import interfaces.Pila;
import exceptions.PilaException;

public class PilaEstatica<E> implements Pila<E> {

	private int tam;
	private int tope;
	private E[] pila;
	
	
	public PilaEstatica(int tam){
		
		this.tam = tam;
		tope=-1;
		pila= (E[])new Object[tam];
	}
	
	public PilaEstatica()
	{
		this(1);
	}
	@Override
	public boolean vacia() {
		return (tope==-1);
	}
	

	@Override
	public void apilar(E obj) {
		
		if(tope==tam-1)
			pila=redimensionar(pila);
		pila[++tope]= obj;
		
		
	}

	private E[] redimensionar(E[] pila) {
		
		E[] pilaNueva = (E[]) new Object[tam*2];
		
		for(int i=0; i<tam;i++)
			pilaNueva[i]=pila[i];
		tam*=2;
		
		
		return pilaNueva;
	}



	@Override
	public E verTope() {
		if(tope==-1)
			return null;
		return pila[tope];
		
	}

	@Override
	public void vaciar() {
			tope=-1;
			pila= (E[]) new Object[1];
	}

	@Override
	public E desapilar() {
		if(tope==-1)
			return null;
		
		if(tope+1==tam/2){
			pila=redimensionarMenos(pila);
		}
		return pila[tope--];
	}

	private E[] redimensionarMenos(E[] pila2) {
		
		E[] pilaNueva = (E[])new Object[tam/2];
		
			for(int i=0;i<tam/2;i++){
				pilaNueva[i]=pila[i];
			}
			tam/=2;
			return pilaNueva;
	}
	
	

}
