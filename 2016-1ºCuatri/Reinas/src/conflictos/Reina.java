package conflictos;

import java.util.ArrayList;

public class Reina {
	
	private int id;
	private int fila;
	private int columna;
	private ArrayList<Integer> conflictosCon = new ArrayList<Integer>();
	
	public Reina(){
		this.id = 0;
		this.fila = 0;
		this.columna = 0;
	}
	
	public Reina(int id, int fila, int columna) {
		super();
		this.id = id;
		this.fila = fila;
		this.columna = columna;
	}
	
	/*
	public Reina(int id, int fila, int columna, ArrayList<Integer> conflictosCon) {
		super();
		this.id = id;
		this.fila = fila;
		this.columna = columna;
		this.conflictosCon = conflictosCon;
	}*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public ArrayList<Integer> getConflictosCon() {
		return conflictosCon;
	}

	public void setConflictosCon(ArrayList<Integer> conflictosCon) {
		this.conflictosCon = conflictosCon;
	}
	
	
}
