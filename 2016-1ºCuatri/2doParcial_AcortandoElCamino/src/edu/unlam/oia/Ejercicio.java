package edu.unlam.oia;

import java.io.File;

import model.Camino;

public class Ejercicio extends OIA{

	public Ejercicio(File entrada, File salida) {
		super(entrada, salida);
	}

	@Override
	public void resolver() {
		Camino camino = new Camino(entrada);
		camino.analizarCamino();
		camino.escribirResultado(salida);
	}

}
