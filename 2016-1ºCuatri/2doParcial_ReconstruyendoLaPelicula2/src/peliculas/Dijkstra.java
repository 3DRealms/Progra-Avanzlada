package peliculas;
import java.util.*;

public class Dijkstra {
	//Attributes
		Grafo grafo;
		int[] distancia;
		int[] procedencia;
		int nodoOrigen;
		
		//Constructors
		public Dijkstra (Grafo grafo, int nodoOrigen){
			this.grafo = grafo;
			this.nodoOrigen = nodoOrigen;
			this.distancia = new int [grafo.getCantidadNodos()];   
			this.procedencia = new int [grafo.getCantidadNodos()];    
			boolean[] visitado = new boolean [grafo.getCantidadNodos()];
			  
			for (int i=0; i<this.distancia.length; i++){
				this.distancia[i] = Integer.MAX_VALUE;
				this.procedencia[i] = i;	  
				visitado[i] = false;
			}
			
			distancia[nodoOrigen] = 0;	      
			for (int i=0; i < this.distancia.length; i++)	  
			{
		    	int siguiente = obtenerNodoMenorCosto(visitado);	    	
		    	if(siguiente != -1)
		    	{	    	 
		    		visitado[siguiente] = true;
		    	    int [] nodosAdys = grafo.obtenerNodosAdyacentes(siguiente);
		    	    for (int j=0; j<nodosAdys.length; j++)
		    	    {
		    	    	int unNodoAdy = nodosAdys[j];
		    		    int d = this.distancia[siguiente] + grafo.obtenerCosto(siguiente,unNodoAdy);
		    		    if (this.distancia[unNodoAdy] > d) 
		    		    {
		    		    	this.distancia[unNodoAdy] = d;
		    		    	this.procedencia[unNodoAdy] = siguiente;
		    		    }
		    	    }
		    	}
			}		
		}
		
		//Public Methods
		public ArrayList<Nodo> obtenerCamino (int nodoDestino){
		      ArrayList<Nodo> camino = new ArrayList<Nodo>();	      
		      if( nodoDestino == this.procedencia[nodoDestino]){
		    	  camino.add(0, this.grafo.getNodos()[nodoOrigen].clone());
		    	  return camino;
		      }
		      
		      int nodoDestinoTemp = nodoDestino;
			  while (nodoDestinoTemp != this.nodoOrigen) 		  
			  {		  
				  camino.add(0, this.grafo.getNodos()[nodoDestinoTemp].clone());		    	
				  nodoDestinoTemp = this.procedencia[nodoDestinoTemp];		     
			  }		  
			  camino.add(0, this.grafo.getNodos()[this.nodoOrigen].clone());		 
			  return camino;	   
		   }
		public int obtenerCosto(int nodoDestino){
			return this.distancia[nodoDestino];
		}	
		
		//Private Methods
		private int obtenerNodoMenorCosto(boolean[] visitado) 
		   {
		      int menorDistancia = Integer.MAX_VALUE;
		      int nodoMenorCosto = -1; 
		      for (int i=0; i < distancia.length; i++) 
		    	  if (!visitado[i] && distancia[i] < menorDistancia) 
		    	  {
		    		  nodoMenorCosto = i; 
		    		  menorDistancia = distancia[i];
		    	  }
		      return nodoMenorCosto;
		   }

}
