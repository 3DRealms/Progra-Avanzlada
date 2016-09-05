package edu.unlam.oia;

import java.io.File;

import model.Plaqueta;

public class Ejercicio extends OIA{

	public Ejercicio(File entrada, File salida) {
		super(entrada, salida);
	}

	@Override
	public void resolver() {
		Plaqueta plaqueta = new Plaqueta(entrada);
		plaqueta.crearConexiones();
		plaqueta.escribirResultad(salida);
	}

}
