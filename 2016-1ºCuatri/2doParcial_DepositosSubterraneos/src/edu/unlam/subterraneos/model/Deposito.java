package edu.unlam.subterraneos.model;

public class Deposito implements Comparable<Deposito> {

	private double superficie;
	private double profundidad;
	private double volumen;
	
	public Deposito(double superficie, double profundidad) {
		super();
		this.superficie = superficie;
		this.profundidad = profundidad;
		this.volumen = this.superficie * this.profundidad; 
	}
	
	public void cargar(double petroleo) {
		this.volumen -= petroleo;
	}
	
	public boolean utilizado() {
		return volumen != superficie * profundidad;
	}
	
	public double getVolumen() {
		return volumen;
	}
	
	public double getProfundidad() {
		return volumen / superficie;
	}

	@Override
	public int compareTo(Deposito d) {
		if (d.getVolumen() < this.getVolumen())
			return 1;
		else if (d.getVolumen() > this.getVolumen())
			return -1;
		else
			return 0;
	}
}
