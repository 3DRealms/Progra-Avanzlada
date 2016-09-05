package ordenadora;

public class TestOrdenadora {

	public static void main(String[] args) {
		String[] lista = Lucas.listarIn(".in");
		long time_inicio, time_final;
		for (int i = 0; i < lista.length; i++) {
			Ordenadora vector = new Ordenadora(lista[i] + ".in");
			time_inicio = System.currentTimeMillis();
			// vector.seleccion();
			// vector.burbujaConBandera();
			// vector.insercionConCentinela();
			// vector.insercionSinCentinela();
			// vector.shell();
			// vector.quicksortMedio(0, vector.getTam() - 1);
			// vector.fusion(0, vector.getTam() - 1);
			time_final = System.currentTimeMillis();
			System.out.println("Tarda " + (time_final - time_inicio) + "ms, el metodo seleccion del archivo " + lista[i]);
			vector.GrabarVectorOrdenado(lista[i] + ".out");
		}
	}
}
