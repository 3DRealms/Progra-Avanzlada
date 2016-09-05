package paquete;

import java.util.ArrayList;

public class Nodo {
private int nombre;
ArrayList <Integer> estaciones;
private int cantEstaciones;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Nodo(int nombre) {
		super();
		this.nombre = nombre;
		this.cantEstaciones=0;
		this.estaciones=new ArrayList<Integer>();
	}
	public int getCantEstaciones() {
		return cantEstaciones;
	}
	public void setCantEstaciones(int cantEstaciones) {
		this.cantEstaciones = cantEstaciones;
	}
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

}
