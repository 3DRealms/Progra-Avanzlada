package metro;

public class Grafo {	
	int cantNodos;
	int cantAristas;
	int mat[][];	
	public Grafo(int cantNodos, int cantAri) {
		this.cantNodos = cantNodos;
		this.cantAristas = cantAri;
		this.mat = new int[cantNodos][cantNodos];
		for(int i = 0; i < cantNodos; i++){
			for(int j = 0; j < cantNodos; j++){
				mat[i][j] = -1;
			}
			
		}
	}
	public void nuevaArista(int nodoOrigen, int nodoDestino, int i) {
		mat[nodoOrigen-1][nodoDestino-1] = i;
		mat[nodoDestino-1][nodoOrigen-1] = i;
		cantAristas++;
	}



	public int Prim(int nodoIni){
		ColaPrioridad cola = new ColaPrioridad();
		int []vectVisit= new int [cantNodos];
		for(int i=0;i<cantNodos;i++){
			vectVisit[i]=0;
		}
		int u = nodoIni, costoMin=0, uAnt = u, cont = 0;
		Arista arista, sacado;
		vectVisit[nodoIni]=1;
		cont++;
		while(cont < cantNodos){
			for(int i=0;i<cantNodos;i++){
				if(mat[u][i] != -1){
					arista = new Arista(u,i,mat[u][i]);
					cola.offer(arista);
				}
			}
			uAnt = u;
			while(u == uAnt){
				sacado = (Arista)cola.peek(); 
				if(vectVisit[sacado.getFin()] != 1){
					costoMin += sacado.getCosto();
					u = sacado.getFin();
					vectVisit[u]=1;
					cont++;
				}
				cola.poll();				
			}
		}
		return costoMin;
	}
}
