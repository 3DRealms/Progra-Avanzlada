package model;

public class Nodo implements Comparable<Nodo> {
	private int indice;
	private int grado;
	private int color;

	public Nodo(int indice, int grado, int color) {
		this.indice = indice;
		this.grado = grado;
		this.color = color;
	}

	public void addGrado() {
		this.grado++;
	}
	
	public void clean(){
		this.color = 0;
	}

	public int getIndice() {
		return indice;
	}

	public int getGrado() {
		return grado;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "[" + indice + ", g=" + grado + ", c=" + color + "]";
	}

	@Override
	public int compareTo(Nodo otro) {
		if (this.indice < otro.getIndice()) {
			return -1;
		} else if (this.indice > otro.getIndice()) {
			return 1;
		} else {
			return 0;
		}
	}
}
