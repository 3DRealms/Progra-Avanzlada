package red;

public class Intersecciones implements Comparable<Intersecciones>{

	public Integer linea;
	public int distancia;
	public String pasaPor;
	
	public Intersecciones(Integer linea,  int distancia, String pasaPor){
		this.linea = linea;
		this.distancia = distancia;
		this.pasaPor = pasaPor;
	}
	
	@Override
	public int compareTo(Intersecciones arg0) {
		if (this.distancia < arg0.distancia)
			return -1;
		if (this.distancia > arg0.distancia)
			return 1;
		return 0;
	}
	
	public boolean equals(Object obj) {
		Intersecciones inter = (Intersecciones) obj;
		if (linea.intValue() ==inter.linea.intValue())
			return true;
		return false;
	}

}