package ar.edu.unlam.prograavanzada.grafos.problemas.minotauro;

public class Main {

	public static void main(String[] args) {
		Minotauro minotauro;
		try {
			minotauro = new Minotauro("minotauro.in");
			minotauro.resolver();
			minotauro.grabar("minotauro.out");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}