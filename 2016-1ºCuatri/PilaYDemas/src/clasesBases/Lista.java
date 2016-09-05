package clasesBases;

public class Lista<E> {

	private Nodo<E> prim;
	private Nodo<E> ult;
	private int contador;
	
	private class Nodo<T>{
		
		private Nodo<T> sig;
		private T dato;
		
		private Nodo(T dato,Nodo<T>sig){
			this.dato=dato;
			this.sig=sig;
			}
		
	}
	
	public Lista(){
		
	prim=null;
	ult=null;
		
	}
	
	public void insertarAlFinal(E dato){
		
		if(ult==null)
			ult= new Nodo<E>(dato,null);
		else{
		ult.sig= new Nodo<E>(dato,null);
		ult=ult.sig;
		}
		if(prim==null)
		prim=ult;
		contador++;
	}
	public void insertarAlPrincipio(E dato){
				
		prim= new Nodo<E>(dato,prim);
		contador++;
		if(ult==null)
			ult=prim;
	}
	
	public void borrarPrimero(){
		
		if(prim!=null){
			prim=prim.sig;
			contador--;	
			if(prim==null)
				ult=null;
		}
		
	}
	public void borrarUltimo(){
		
		if(prim==null)
			return;
		Nodo<E> punteroPrim=prim;
		if(punteroPrim.sig==null)
			{prim=null;
			 ult=null;
			 contador--;
			return;
			}
		while(punteroPrim.sig!=ult)
			punteroPrim=punteroPrim.sig;
		punteroPrim.sig=null;
		contador--;
		
	}
	
	public void eliminar(E obj){
		Nodo<E> puntero=prim;
		Nodo<E> aux;
		
		if(puntero!=null && puntero.dato.equals(obj))
			{prim=prim.sig;
			 contador--;
			}
			
		while(puntero!=null)
		{	
			
			if(puntero.sig!=null && puntero.sig.dato.equals(obj))
					{	aux=puntero.sig;
						puntero.sig=aux.sig;
						contador--;
					}
			puntero=puntero.sig;
			
		}
	
	}
	public void insertar(int pos,E obj){
			
		if(pos>contador || pos<0)
			return;
		
		if(pos==contador){
		insertarAlFinal(obj);
		return;
		}
		
		if(pos==0){
		insertarAlPrincipio(obj);
		return;}
		
		Nodo<E> puntero=prim;
		for(int i=1;i<pos-1;i++){
			puntero=puntero.sig;
		}
		puntero.sig= new Nodo<E>(obj,puntero.sig);
		contador++;
	}	
	
	public void vaciar(){
		
		prim=null;
		ult=null;
		contador=0;
	}
	
	public boolean buscar(E obj){
		
		Nodo<E> puntero=prim;
		
		if(puntero!=null && puntero.dato.equals(obj))
			{return true;
			}
			
		while(puntero!=null)
		{	
			if(puntero.sig!=null && puntero.sig.dato.equals(obj))
				return true;
					
			puntero=puntero.sig;
			
		}
		return false;
	
	}
	
	public E buscar(int pos){
			if(pos>=contador || pos<0)
				return null;
	
			Nodo<E> puntero=prim;
			for(int i=0;i<pos;i++){
				puntero=puntero.sig;
			}
			return puntero.dato;
		}

	public boolean vacia(){
		return prim==null;
	}
	
	public Lista<E> invertir(){
		
		Lista<E> nuevaLista = new Lista<E>();
		Nodo<E> puntero=prim;
		for(int i=0;i<contador;i++){
			nuevaLista.insertarAlPrincipio(puntero.dato);
			puntero=puntero.sig;
		}
		return nuevaLista;
		
	}
	
	public int size() {
		return contador;
	}

	
}


