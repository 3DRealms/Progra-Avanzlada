package juego;

import java.util.LinkedList;

public class BatallonOrco extends Batallon {

	public BatallonOrco(int cant) {
		super(cant);
		batallon =  new LinkedList<Personaje>();
		
		for (int i = 0; i < cant; i++) {
			batallon.add( new Orco() );
		}	
	}

	public void atacar(Batallon victimas){
	//	System.out.println("�ORCOS ATACA!");
		for (Personaje Orco: batallon) {
			Personaje victima = victimas.batallon.get(0);
			Orco.atacar( victima );
			victimas.serAtacado( victima );			
		}
	}
}