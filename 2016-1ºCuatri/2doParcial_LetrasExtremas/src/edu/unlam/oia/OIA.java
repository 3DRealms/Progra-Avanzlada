package edu.unlam.oia;

import java.io.File;

public abstract class OIA {

	protected File entrada;
	protected File salida;
	
	public OIA(File entrada, File salida) {
		this.entrada = entrada;
		this.salida = salida;
	}
	
	public abstract void resolver();
}
