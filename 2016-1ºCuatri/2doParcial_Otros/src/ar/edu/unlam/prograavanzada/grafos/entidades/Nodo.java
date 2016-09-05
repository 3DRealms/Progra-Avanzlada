package ar.edu.unlam.prograavanzada.grafos.entidades;

public class Nodo {

	private int numero;
	private int grado;
	
	private int color;
	
	public Nodo(int numero, int grado) {
		this.numero = numero;
		this.grado = grado;
	}

	public int getNumero() {
		return numero;
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
		return String.format("Numero: %d - Grado: %d - Color: %d", 
				this.numero, this.grado, this.color);
	}
}
