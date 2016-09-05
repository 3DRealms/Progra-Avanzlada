package calles.clasesmodelo;

public class Adyacencia {

	int desde;
	int hasta;
	int costo;
	
	public Adyacencia(int desde, int hasta, int costo) {
		this.desde = desde;
		this.hasta = hasta;
		this.costo = costo;
	}
	
	public int getDesde() {
		return desde;
	}
	public int getHasta() {
		return hasta;
	}
	public int getCosto() {
		return costo;
	}

	public String toString(){
		return "("+desde+"-"+hasta+":"+costo+")";
	}
}
