package juego;

import java.util.LinkedList;

public class BatallonHumano extends Batallon {

	public BatallonHumano(int cant) {
		super(cant);
		batallon =  new LinkedList<Personaje>();

		for (int i = 0; i < cant; i++) {	
			batallon.add(new Humano());
		}
	}

	public void atacar(Batallon victimas){
		int i = 0;
		Personaje victima;
		// System.out.println("�HUMANOS ATACA!");
		for (Personaje humano: this.batallon) {
			if( victimas.cantidad < i )
				i=0;
			victima = victimas.batallon.get(i);
			humano.atacar( victima );
			victimas.serAtacado( victima );
			i++;

		}
	}


}