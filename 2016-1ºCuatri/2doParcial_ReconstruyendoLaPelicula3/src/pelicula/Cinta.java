package pelicula;

public class Cinta {
	
	private int inicio;
	private int fin;
	private int nodo;
	
	public int getNodo() {
		return nodo;
	}

	public void setNodo(int nodo) {
		this.nodo = nodo;
	}

	public Cinta(int nodo,int ini,int fin){
		this.inicio=ini;
		this.nodo=nodo;
		this.fin=fin;
	}
	


	public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}

}
