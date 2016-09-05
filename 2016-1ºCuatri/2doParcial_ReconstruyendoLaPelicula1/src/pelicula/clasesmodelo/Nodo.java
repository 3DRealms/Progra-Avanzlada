package pelicula.clasesmodelo;

public class Nodo {
	
	int nroSegmento; //Indice
	int escenaDesde;
	int escenaHasta;
	
	public Nodo(int nroSegmento, int escenaDesde, int escenaHasta) {
		this.nroSegmento = nroSegmento;
		this.escenaDesde = escenaDesde;
		this.escenaHasta = escenaHasta;
	}

	public int getNroSegmento() {
		return nroSegmento;
	}

	public int getEscenaDesde() {
		return escenaDesde;
	}

	public int getEscenaHasta() {
		return escenaHasta;
	}

	public boolean contenidoEn(Nodo otroNodo){
		return ( this.escenaHasta >= otroNodo.getEscenaDesde() ) && ( this.escenaHasta < otroNodo.getEscenaHasta() ); 
	}

	public boolean esSegmentoOrigen(){
		return escenaDesde == 1;
	}
	
	public boolean terminaCon(int escenaHasta){
		return this.escenaHasta == escenaHasta;
	}

	
	public String toString(){
		return ""+this.nroSegmento;
	}
}
