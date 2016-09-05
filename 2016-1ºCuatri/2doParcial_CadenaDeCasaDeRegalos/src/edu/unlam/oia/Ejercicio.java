package edu.unlam.oia;

import java.io.File;

import model.Cadena;

public class Ejercicio extends OIA{

	public Ejercicio(File entrada, File salida) {
		super(entrada, salida);
	}

	@Override
	public void resolver() {
		Cadena cadena = new Cadena(entrada);
		cadena.ubicacionesAdecuadas();
		cadena.escribirResultado(salida);
	}

}
