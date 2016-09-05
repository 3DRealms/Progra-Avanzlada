package ar.edu.unlam.prograavanzada.grafos.problemas.rescatandoprincesa;

public class Sendero {

	private Integer claroInicial;
	private Integer claroFinal;
	private Integer largo;
	
	public Sendero(Integer claroInicial, Integer claroFinal, Integer largo) {
		this.claroInicial = claroInicial;
		this.claroFinal = claroFinal;
		this.largo = largo;
	}
	
	public Integer getClaroInicial() {
		return claroInicial;
	}
	public Integer getClaroFinal() {
		return claroFinal;
	}
	public Integer getLargo() {
		return largo;
	}
	
}
