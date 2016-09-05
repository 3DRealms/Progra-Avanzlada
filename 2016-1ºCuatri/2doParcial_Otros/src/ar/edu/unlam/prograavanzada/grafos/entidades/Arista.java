package ar.edu.unlam.prograavanzada.grafos.entidades;

public class Arista {

	private Integer nodoDesde;
	private Integer nodoHasta;
	
	private Integer peso;

	public Arista(Integer nodoDesde, Integer nodoHasta) {
		super();
		this.nodoDesde = nodoDesde;
		this.nodoHasta = nodoHasta;
	}

	public Arista(Integer nodoDesde, Integer nodoHasta, Integer peso) {
		this(nodoDesde, nodoHasta);
		this.peso = peso;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Integer getNodoDesde() {
		return nodoDesde;
	}

	public Integer getNodoHasta() {
		return nodoHasta;
	}

	@Override
	public String toString() {
		return String.format("%d %d %d", this.nodoDesde, this.nodoHasta, this.peso);
	}
	
}
