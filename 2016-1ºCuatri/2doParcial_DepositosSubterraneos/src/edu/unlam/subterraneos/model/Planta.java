package edu.unlam.subterraneos.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Planta {
	
	private List<Deposito> depositos;
	private double volumen;

	public Planta(File archivo) {
		FileReader fr = null;
		try {
			fr = new FileReader(archivo);

			BufferedReader br = new BufferedReader(fr);
			String datos[];
			
			int cantDepositos = Integer.parseInt(br.readLine());
			this.depositos = new ArrayList<Deposito>();
			for (int i = 0; i < cantDepositos; i++) {
				datos = br.readLine().split(" ");
				this.depositos.add(new Deposito(Double.parseDouble(datos[0]), Double.parseDouble(datos[2])));
			}
			Collections.sort(depositos);
			this.volumen = Double.parseDouble(br.readLine());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null)
					fr.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	/**
	 * Devuelve un valor mayor a cero si es que rebalsa. Lo que devuelve es la cantidad de petroleo rebalsado.
	 * @return
	 */
	public double rebalsa() {
		return volumen - getCapacidad();		
	}

	private double getCapacidad() {
		double capacidad = 0;
		for (Deposito deposito : depositos) {
			capacidad += deposito.getVolumen();
		}
		return capacidad;
	}

	public void cargar() {
		for (Deposito deposito : depositos) {
			deposito.cargar(volumen);
		}
	}
}
