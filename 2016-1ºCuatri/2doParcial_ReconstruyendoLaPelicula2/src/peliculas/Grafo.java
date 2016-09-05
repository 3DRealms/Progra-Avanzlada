package peliculas;


	public class Grafo {

		private int[][] arcos;
		private Nodo[] nodos;
		private int cantidadNodos;
		private boolean esDirigido;
		
		//Getters-Setters
		public Nodo[] getNodos() {
			return nodos;
		}
		public int getCantidadNodos() {
			return cantidadNodos;
		}
		
		//Constructors
		public Grafo(int cantidadNodos, boolean esDirigido){
			this.esDirigido = esDirigido;
			this.cantidadNodos = cantidadNodos;
			this.arcos = new int[cantidadNodos][cantidadNodos];
			this.nodos = new Nodo[cantidadNodos];
			for (int i=0; i<cantidadNodos; i++){
				this.nodos[i] = new Nodo(0,0, "Nodo " + i);
				for (int j=0; j<cantidadNodos; j++)
					this.arcos[i][j] = 0;
			}		
		}	
		
		//Public Methods
		public void crearArco(int nodoOrigen, int nodoDestino, int costo){
			if (nodoOrigen != nodoDestino && costo != 0){
				this.arcos[nodoOrigen][nodoDestino] = costo;
				this.nodos[nodoOrigen].incrementarGrado();
				if (!this.esDirigido){
					this.arcos[nodoDestino][nodoOrigen] = costo;
					this.nodos[nodoDestino].incrementarGrado();
				}
			}
		}	
		public void eliminarArco(int nodoOrigen, int nodoDestino){
			if (nodoOrigen != nodoDestino){
				this.arcos[nodoOrigen][nodoDestino] = 0;
				this.nodos[nodoOrigen].decrementarGrado();
				if (!this.esDirigido){
					this.arcos[nodoDestino][nodoOrigen] = 0;
					this.nodos[nodoOrigen].decrementarGrado();
				}
			}
		}
		public boolean verificarAdyacencia(int nodoOrigen, int nodoDestino){
			boolean returnValue = false;
			if (nodoOrigen != nodoDestino){
				if (this.arcos[nodoOrigen][nodoDestino] != 0) 
					returnValue = true;
			}
			return returnValue;
		}
		public int[] obtenerNodosAdyacentes(int nodo){
			int[]nodosAdys = new int[this.nodos[nodo].getGrado()];      
			int count = 0;      
			for (int i=0; i<this.arcos[nodo].length; i++) 
				if (this.arcos[nodo][i] > 0) 
					nodosAdys[count++] = i;
			return nodosAdys;		    
		}
		public int obtenerCosto(int nodoOrigen, int nodoDestino){
			return this.arcos[nodoOrigen][nodoDestino];		    
		}
		public String toString() {
			String returnValue = "Matriz de Adyacencia\n";		
			for (int i=0; i<this.cantidadNodos; i++)
				returnValue += "\t" + this.nodos[i].getEtiqueta();		
			for (int i=0; i<this.cantidadNodos; i++){
					returnValue += "\n" + this.nodos[i].getEtiqueta();			 
				for (int j=0; j<this.cantidadNodos; j++)
					returnValue += "\t" + this.arcos[i][j]; 
			}		
			return returnValue;
		}
	}