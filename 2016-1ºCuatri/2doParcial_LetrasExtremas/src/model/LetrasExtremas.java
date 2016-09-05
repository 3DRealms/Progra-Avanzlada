package model;

import java.util.*;

public class LetrasExtremas implements Comparable<LetrasExtremas> {
	private char letra;
	private Set<String> palabras = new HashSet<String>();
	private int ocurrencias;
	
	public LetrasExtremas(char letra, String palabra) {
		this.letra = letra;
		this.palabras.add(palabra);
		this.ocurrencias = 1;
	}
	
	public void addOcurrence(String palabra){
		this.palabras.add(palabra);
		this.ocurrencias++;
	}

	public char getLetra() {
		return letra;
	}

	public Set<String> getPalabras() {
		return palabras;
	}

	public int getOcurrencias() {
		return ocurrencias;
	}

	@Override
	public String toString() {
		return "LetrasExtremas [letra=" + letra + ", palabras=" + palabras
				+ ", ocurrencias=" + ocurrencias + "]";
	}

	@Override
	public int compareTo(LetrasExtremas otro) {
		if (this.ocurrencias > otro.getOcurrencias()) {
			return 1;
		}else if (this.ocurrencias < otro.getOcurrencias()) {
			return -1;
		}
		return 0;
	}
	
	
}
