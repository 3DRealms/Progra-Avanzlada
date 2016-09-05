package edu.unlam.oia;

import java.io.File;

import model.Poema;

public class Ejercicio extends OIA {

	public Ejercicio(File entrada, File salida) {
		super(entrada, salida);
	}

	@Override
	public void resolver() {
		Poema letrasExtremas = new Poema(entrada);
		letrasExtremas.analizar();
		letrasExtremas.escribirResultado(salida);
	}

}
