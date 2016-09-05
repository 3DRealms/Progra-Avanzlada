package model;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Camino extends Dijkstra{
	private int puertaEntrada;
	private int puertaSalida;
	private List<Arista> galerias;
	private int obstruidas;
	private int largoTotal;
	
	public Camino(File in) {
		super(in);
		galerias = new ArrayList<Arista>();
		obstruidas = 0;
		largoTotal = 0;
		puertaEntrada = 0;
		puertaSalida = nodos.length - 1;
	}
	
	private void armarCamino(int origen, int destino){
		Arista aux = null;
		int i = destino;
		while((aux = getArista(camino[i], i)) != null){
			galerias.add(aux);
			i = camino[i];
		}
	}
	
	public void analizarCamino() {
		resolverDijkstra();
		armarCamino(puertaEntrada, puertaSalida);
		
		for (Arista galeria : galerias) {
			if (!galeria.isLibre()) {
				obstruidas++;
			}
			largoTotal += galeria.getCosto();
		}
	}
	
	public void escribirResultado(File out){
		FileWriter fw = null;
		PrintWriter pw = null;
		StringBuffer sb = null;
		
		try {
			fw = new FileWriter(out);
			pw = new PrintWriter(fw);
			sb = new StringBuffer();
			
			sb.append((obstruidas + 1) + " ");

			Collections.sort(galerias);
			if (obstruidas > 0) {
				for (Arista galeria : galerias) {
					if (!galeria.isLibre()) {
						sb.append((galeria.getId() + 1) + " ");
					}
				}
			}
			
			sb.append(largoTotal);
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
