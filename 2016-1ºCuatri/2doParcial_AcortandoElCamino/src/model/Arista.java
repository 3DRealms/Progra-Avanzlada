package model;

public class Arista implements Comparable<Arista> {
	private int id;
	private int nodoOrigen;
	private int nodoDestino;
	private int costo;
	private boolean libre;

	public Arista(int id, int origen, int destino, int costo, boolean libre) {
		this.id = id;
		this.nodoOrigen = origen;
		this.nodoDestino = destino;
		this.costo = costo;
		this.libre = libre;
	}

	public int getId() {
		return id;
	}

	public int getNodoOrigen() {
		return nodoOrigen;
	}

	public int getNodoDestino() {
		return nodoDestino;
	}

	public int getCosto() {
		return costo;
	}

	public boolean isLibre() {
		return libre;
	}

	@Override
	public int compareTo(Arista otro) {
		if (this.id < otro.getId()) {
			return -1;
		} else if (this.id > otro.getId()) {
			return 1;
		} else {
			return 0;
		}
	}
}
