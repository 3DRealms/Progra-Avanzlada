package juego;

public class Humano extends Personaje {

	@Override
	protected int calcularPuntosDeAtaque() {
		return 10 + (100-energia);
	}

	@Override
	protected boolean puedeAtacar() {
		return energia >= 10;
	}
}
