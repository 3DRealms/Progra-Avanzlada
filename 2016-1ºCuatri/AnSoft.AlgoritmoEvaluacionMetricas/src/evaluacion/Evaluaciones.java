package evaluacion;

public enum Evaluaciones {
	BUENA(2),
	MALA(0),
	REGULAR(1),
	;
	private int valor;
	private Evaluaciones(int v) {
		valor = v;
	}
	public int getValue() {
		return valor;
	}
}
