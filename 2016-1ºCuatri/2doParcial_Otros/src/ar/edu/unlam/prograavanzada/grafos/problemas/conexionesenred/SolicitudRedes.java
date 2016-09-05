package ar.edu.unlam.prograavanzada.grafos.problemas.conexionesenred;

public class SolicitudRedes {

	private String tipo;
	private Integer pcDesde;
	private Integer pcHasta;
	
	public SolicitudRedes(String tipo, Integer pcDesde, Integer pcHasta) {
		this.tipo = tipo;
		this.pcDesde = pcDesde;
		this.pcHasta = pcHasta;
	}

	public String getTipo() {
		return tipo;
	}

	public Integer getPcDesde() {
		return pcDesde;
	}

	public Integer getPcHasta() {
		return pcHasta;
	}
	
}
