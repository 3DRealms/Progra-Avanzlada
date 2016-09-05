package metro;

public class Arista{
	
	private int Inicio;
	private int Fin;
	private int Costo;
	
	public Arista(int i, int f, int cost){
		Inicio = i;
		Fin = f;
		Costo = cost;
	}		
	public Arista(int i, int f){
		Inicio = i;
		Fin = f;
		Costo = 1;
	}
	public int getInicio() {
		return Inicio;
	}
	public int getFin() {
		return Fin;
	}
	public int getCosto() {
		return Costo;
	}
}