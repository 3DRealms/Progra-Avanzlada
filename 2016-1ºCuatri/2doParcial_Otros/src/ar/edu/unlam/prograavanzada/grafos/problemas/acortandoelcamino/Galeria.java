package ar.edu.unlam.prograavanzada.grafos.problemas.acortandoelcamino;

public class Galeria {

	private Integer bifurcacionDesde;
	private Integer bifurcacionHasta;
	
	private Integer distancia;
	
	public Galeria(Integer bifurcacionDesde, Integer bifurcacionHasta, Integer distancia) {
		this.bifurcacionDesde = bifurcacionDesde;
		this.bifurcacionHasta = bifurcacionHasta;
		
		this.distancia = distancia;
	}

	public Integer getBifurcacionDesde() {
		return bifurcacionDesde;
	}
	public Integer getBifurcacionHasta() {
		return bifurcacionHasta;
	}
	public Integer getDistancia() {
		return distancia;
	}
	
}
