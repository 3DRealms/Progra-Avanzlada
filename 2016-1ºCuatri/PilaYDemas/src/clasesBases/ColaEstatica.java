package clasesBases;

import interfaces.Cola;
import exceptions.ColaException;

public class ColaEstatica<E> implements Cola<E> {

	private int tam;
	private int prim;
	private int ult;
	private E[] cola;
	
	
	
	public ColaEstatica(int tam){
	
		this.tam=tam;
		cola= (E[]) new Object[tam];
		prim=-1;
		ult=-1;
	}
	
	public ColaEstatica(){
		this(1);
	}
	
	@Override
	public boolean vacia() {
		
		return prim==-1;
	}
	@Override
	public void acolar(E obj) {
		
		if(prim==-1)
		{prim++;
		 ult++;
		cola[ult]= obj;	
		}
		else{
		
		if(prim<=ult){
			
			if(ult==tam-1) {
					if(prim>0) {
						ult=0;
						cola[ult]= obj;	
					}
					else {
						redimensionar(cola);
						cola[++ult]= obj;
					}
				
				} else {
					cola[++ult]= obj;
				}
		} 	else {
			if(prim>ult) {
				
				if(ult+1==prim) {
					redimensionar(cola);
					cola[++ult]= obj;
					} else	{
						cola[++ult]= obj;	
				}
			}
		}
	}
 }
		
	private void redimensionar(E[] cola2) {
		
		E[] colaNueva = (E[]) new Object[tam*2];
		if(ult>=prim){
		for(int i=0; i<=ult;i++)
		{
			colaNueva[i]= cola[prim++];
					}
		ult=prim-1;
		
		}
		else{
			if(ult+1==prim){
				int i=0;
				while(prim<tam)
					colaNueva[i++]= cola[prim++];
				prim=0;
				while(prim<ult)
					colaNueva[i++]= cola[prim++];
				
				ult=i-1;
				
			}
		}
		prim=0;
		cola=colaNueva;
		tam*=2;
	}

	@Override
	public E desacolar() {
			
		 if(prim==-1)
			return null;
		E aux=null;
		aux= cola[prim];
		
		if(prim<ult) {
			prim++;
		}
		else {
			if(prim==ult) {
				prim=-1;
				ult=-1;
			} else {
				if(prim>ult) {
					if(prim+1==tam){
						prim=0;
					} else {
						prim++;
					}
				}	
			}
		}
		
		if((prim!=-1 && tam>1 && (ult-prim<tam/2) || prim-(ult+1)>tam/2))
			redimensionarMenos(cola);
		return aux;
	}
	
	private void redimensionarMenos(E[] cola2) {
		
		E[] colaNueva = (E[]) new Object[tam/2];
		
		if(ult>=prim){
			for(int i=0; prim<=ult;i++)
			{
				colaNueva[i]= cola[prim++];
				
						}
			ult=colaNueva.length-1;
		
			}
			else{
					int i=0;
					while(prim<tam)
						colaNueva[i++]= cola[prim++];
					prim=0;
					while(prim<ult)
						colaNueva[i++]= cola[prim++];
					
					ult=i-1;
					
				
			}
			prim=0;
			cola=colaNueva;
			tam/=2;
	}

	@Override
	public E verPrimero() {
	 if(prim==-1)
		return null;
	return cola[prim];
	}
	@Override
	public void vaciar() {
		
		cola= (E[]) new Object[1];
		tam=1;
		prim=ult=-1;
		
	}
	
	
	
}
