package decorator_JuegoRPG;

public class Explorador implements Personaje {
	private int puntosDeAtaque = 1;
	
		
	public int getPuntosDeAtaque() {
		return puntosDeAtaque;
	}

	public void setPuntosDeAtaque(int puntosDeAtaque) {
		this.puntosDeAtaque = puntosDeAtaque;
	}

	
	public int obtenerPuntosDeAtaque(){
		return getPuntosDeAtaque();
	}
}
