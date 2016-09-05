package ar.edu.unlam.prograavanzada.grafos.problemas.casaderegalos;

public class NodoTienda implements Comparable<NodoTienda> {

	private Integer nroTienda;
	
	private Integer grado;
	private Integer color;
	
	public NodoTienda(Integer nroTienda) {
		this.nroTienda = nroTienda;
		this.color=0;
	}

	public Integer getGrado() {
		return grado;
	}

	public void setGrado(Integer grado) {
		this.grado = grado;
	}

	public Integer getColor() {
		return color;
	}

	public void setColor(Integer color) {
		this.color = color;
	}

	public Integer getNroTienda() {
		return nroTienda;
	}

	@Override
	public int compareTo(NodoTienda otroNodo) {
		return this.grado - otroNodo.getGrado();
	}
	
}
