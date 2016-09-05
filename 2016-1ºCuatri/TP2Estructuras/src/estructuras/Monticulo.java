package estructuras;

public class Monticulo {
	private int vector[];
	private int ultimo;
	
	public Monticulo(int tam){
		vector = new int[tam];
		ultimo = 0;
	}
	
	public void poner(int x){
		if (ultimo != vector.length){
				vector[ultimo+1] = x;
				if(vector[ultimo] > vector[ultimo/2]){
					int aux;
					aux = vector[ultimo];
					vector[ultimo] = vector[ultimo/2];
					vector[ultimo/2] = aux;
			}	
		}
	}
}
