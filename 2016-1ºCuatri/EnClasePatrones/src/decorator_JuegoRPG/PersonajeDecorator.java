package decorator_JuegoRPG;


public abstract class PersonajeDecorator implements Personaje{
	private Personaje personaje;
	
	public PersonajeDecorator(Personaje personaje) {
		super();
		this.personaje = personaje;
	}
	
	//Getter y Setter
	public Personaje getPersonaje() {
		return personaje;
	}
	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}


	public int obtenerPuntosDeAtaque(){
		return personaje.obtenerPuntosDeAtaque();
	}
	
}



