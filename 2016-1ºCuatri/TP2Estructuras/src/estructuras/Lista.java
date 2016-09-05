package estructuras;

public class Lista {
	private NodoDinamico[] nodos;

	//Getter-Setter
	public NodoDinamico[] getNodos() {
		return nodos;
	}
	public void setNodos(NodoDinamico[] nodos) {
		this.nodos = nodos;
	}
	
	//Constructor	
	public Lista(int tam) {
		nodos = new NodoDinamico[tam];
	}
	
	//Constructor Especial
	public Lista() {
		nodos = new NodoDinamico[2];
	}

	public void reSize() {
		NodoDinamico[] aux = nodos;
		nodos = new NodoDinamico[nodos.length * 2];
		for (int i = 0; i < nodos.length / 2; i++) {
			nodos[i] = aux[i];
		}
	}
}
