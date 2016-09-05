package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import utils.Palabra;

public class Poema{
	LetrasExtremas solucion;
	Map<Character, LetrasExtremas> extremas = new HashMap<Character, LetrasExtremas>();

	public Poema(File entrada){
		FileReader fr = null;
		BufferedReader br = null;
		int cantPalabras = 0;
		
		try {
			fr = new FileReader(entrada);
			br = new BufferedReader(fr);
			cantPalabras = Integer.parseInt(br.readLine());
			//palabras = new String[cantPalabras];
			String palabra;
			for (int i = 0; i < cantPalabras; i++) { 

				palabra = br.readLine();
				LetrasExtremas aux;
				
				// Primer Letra
				if (extremas.get(Palabra.primerLetra(palabra)) == null) {
					aux = new LetrasExtremas(Palabra.primerLetra(palabra), palabra);
				}else{
					aux = extremas.get(Palabra.primerLetra(palabra));
					aux.addOcurrence(palabra);
				}
				extremas.put(Palabra.primerLetra(palabra), aux);
				
				// Ultima Letra
				if (extremas.get(Palabra.ultimaLetra(palabra)) == null) {
					aux = new LetrasExtremas(Palabra.ultimaLetra(palabra), palabra);
				}else{
					aux = extremas.get(Palabra.ultimaLetra(palabra));
					aux.addOcurrence(palabra);
				}
				extremas.put(Palabra.ultimaLetra(palabra), aux);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
	}

	public void analizar() {
		LetrasExtremas[] arrayAux = new LetrasExtremas[extremas.size()];
		Collection<LetrasExtremas> collectionAux = extremas.values();
		Iterator<LetrasExtremas> iteLetrasExtremas = collectionAux.iterator();
		
		int i = 0;
		while (iteLetrasExtremas.hasNext()) {
			arrayAux[i] = (LetrasExtremas)iteLetrasExtremas.next();
			i++;
		}
		
		Arrays.sort(arrayAux, Collections.reverseOrder());
		
		solucion = arrayAux[0];
	}

	public void escribirResultado(File salida) {
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter(salida);
			pw = new PrintWriter(fw);
			
			pw.println(solucion.getOcurrencias());
			for (String palabra : solucion.getPalabras()) {
				pw.println(palabra);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fw) {
					fw.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
