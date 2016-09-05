package grafo;

public class GrafoNDNP implements Cloneable{
	private boolean [][]matriz;
	private int cantNodos;
	public GrafoNDNP(int cantNodos) {
		this.cantNodos = cantNodos;
		matriz = new boolean[cantNodos][cantNodos];
	}
	
	public void setArista(boolean flag, int nodoOrigen, int nodoDestino) {
		if(nodoOrigen > cantNodos || nodoOrigen < 0) 
			throw new ArrayIndexOutOfBoundsException(nodoOrigen);
		if(nodoDestino> cantNodos || nodoDestino < 0) 
			throw new ArrayIndexOutOfBoundsException(nodoDestino);
		if(nodoOrigen != nodoDestino) {
			matriz[nodoOrigen][nodoDestino] = flag;
			matriz[nodoDestino][nodoOrigen] = flag;			
		}
		
	}
	
	public boolean getArista(int nodoOrigen, int nodoDestino) {
		if(nodoOrigen > cantNodos || nodoOrigen < 0) 
			throw new ArrayIndexOutOfBoundsException(nodoOrigen);
		if(nodoDestino> cantNodos || nodoDestino < 0) 
			throw new ArrayIndexOutOfBoundsException(nodoDestino);
		if(nodoOrigen != nodoDestino) {
			return matriz[nodoOrigen][nodoDestino];			
		}
		return false;
	}
	
	@Override
	public GrafoNDNP clone() {
		GrafoNDNP nuevoGrafo = new GrafoNDNP(cantNodos);
		for(int i = 0; i < cantNodos; i++) {
			System.arraycopy(this.matriz[i], 0, nuevoGrafo.matriz[i], 0, cantNodos);
		}
		return nuevoGrafo;
	}
	
	public int getCantNodos() {
		return cantNodos;
	}
	
}
