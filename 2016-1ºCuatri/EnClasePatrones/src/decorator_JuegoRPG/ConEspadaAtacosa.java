package decorator_JuegoRPG;

public class ConEspadaAtacosa extends PersonajeDecorator {
	private int puntosDeAtaque = 5;
	
	public int getPuntosDeAtaque() {
		return puntosDeAtaque;
	}
	public void setPuntosDeAtaque(int puntosDeAtaque) {
		this.puntosDeAtaque = puntosDeAtaque;
	}
	
	public ConEspadaAtacosa(Personaje link) {
		super(link);
		setPuntosDeAtaque( link.getPuntosDeAtaque() + getPuntosDeAtaque() );  
	}
	
	@Override
	public int obtenerPuntosDeAtaque() {
		return getPuntosDeAtaque();
	}
	
}
