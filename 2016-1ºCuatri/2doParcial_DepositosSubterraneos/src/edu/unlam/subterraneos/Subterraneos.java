package edu.unlam.subterraneos;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import edu.unlam.subterraneos.model.Planta;

public class Subterraneos extends EjercicioOIA {

	public Subterraneos(File entrada, File salida) {
		super(entrada, salida);
	}

	@Override
	public void resolver() {
		Planta planta = new Planta(entrada);
		double rebalsados = planta.rebalsa();
		if (rebalsados > 0) {
			escribirRebalsado(rebalsados);
		} else {
			planta.cargar();
		}
		
	}

	private void escribirRebalsado(double rebalsados) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		
		try {
			fichero = new FileWriter(salida);
			pw = new PrintWriter(fichero);

			pw.println("Rebasan: " + rebalsados);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
