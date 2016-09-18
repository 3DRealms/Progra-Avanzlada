package juego;

public abstract class Personaje implements Atacable {

	protected int energia = 100;
	protected int salud = 100;
	
	public final void atacar(Atacable atacado) {
		if (puedeAtacar()) {
			atacado.serAtacado(calcularPuntosDeAtaque());
			energia -= calcularPuntosDeAtaque();
			despuesDeAtacar();
		}
	}

	protected void despuesDeAtacar() { }
	
	protected abstract boolean puedeAtacar();
	protected abstract int calcularPuntosDeAtaque();
	
	public void serAtacado(int danio) {
		this.salud -= danio;
	}

	public void serCurado() {
		this.salud = 100;
	}

	public void serEnergizado() {
		this.energia = 100;
	}
	@Override
	public void morir() {
		
	}

	public boolean estaMuerto() {
		return salud == 0;
	}

}
