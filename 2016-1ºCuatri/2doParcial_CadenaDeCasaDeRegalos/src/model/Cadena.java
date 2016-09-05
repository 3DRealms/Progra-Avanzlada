package model;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Cadena extends Coloreo {
	private List<Integer> ubicaciones;
	private int cantUbicaciones;

	public Cadena(File in) {
		super(in);
		ubicaciones = new ArrayList<Integer>();
		cantUbicaciones = 0;
	}

	public void ubicacionesAdecuadas() {
		colorear();
		int colorMax = colorMasUsado();

		for (int i = 0; i < nodos.length; i++) {
			if (nodos[i].getColor() == colorMax) {
				ubicaciones.add(nodos[i].getIndice());
				cantUbicaciones++;
			}
		}
	}

	public void escribirResultado(File salida) {
		FileWriter fw = null;
		PrintWriter pw = null;
		StringBuffer sb = null;

		try {
			fw = new FileWriter(salida);
			pw = new PrintWriter(fw);
			sb = new StringBuffer();

			pw.println(cantUbicaciones);
			for (Integer ubicacion : ubicaciones) {
				sb.append((ubicacion + 1) + " ");
			}
			pw.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
