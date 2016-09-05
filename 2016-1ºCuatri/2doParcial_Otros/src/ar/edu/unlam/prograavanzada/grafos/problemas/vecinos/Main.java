package ar.edu.unlam.prograavanzada.grafos.problemas.vecinos;

public class Main {

	public static void main(String[] args) {
		Vecinos vecinos = new Vecinos("vecinos.in");
		vecinos.resolver();
		vecinos.grabar("vecinos.out");
	}

}
