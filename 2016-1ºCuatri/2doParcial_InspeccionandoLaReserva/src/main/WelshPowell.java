package main;

import io.Archivo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import matriz.MatrizAdyacencia;
import matriz.MatrizSimetrica;

public class WelshPowell {
	private static final Double infinito = Double.POSITIVE_INFINITY; 
	private String pathIN;
	private String pathOut;

	
	public WelshPowell(String in,String out){
		
		pathIN =in;
		pathOut=out;
	}
	
	
		private class Nodo implements Comparable<Nodo>{
			
			private int nodo;
			private int grado;
			private int color;
			
		public Nodo(int nodo,int grado,int color){
			
			this.nodo=nodo;
			this.grado=grado;
			this.color = color;
		}
		
		public String toString(){
			return String.valueOf(nodo);
		}
	
		public int compareTo(Nodo otro) {
				return Double.compare(otro.grado,this.grado);
		}
			
		}
	
	public void Resolver(){
		
		try {
			
			MatrizSimetrica matriz = Archivo.leerArchivoAMatrizSim(pathIN);
			ReemplazarPorInfinito(matriz);
			List<Nodo> lista= listaDegrados(matriz);
			List<Integer> colores= new ArrayList<Integer>();
			lista.get(0).color=0;
			int color=0;
			for (int i = 1; i < lista.size(); i++) {
				for (int j = 0; j < i; j++) {
					
					if(matriz.getValor(lista.get(i).nodo-1,lista.get(j).nodo-1)!=infinito)
						colores.add(lista.get(j).color);
				}
				
				while(colores.contains(color)){
				color++;
				}
				lista.get(i).color=color;
				colores.clear();
				color=0;
			}
			
			for (int i = 0; i < lista.size(); i++) {
				System.out.println(lista.get(i).nodo+" "+lista.get(i).color);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

	private List<Nodo> listaDegrados(MatrizSimetrica matriz) {
		List<Nodo> lista = new ArrayList<Nodo>();
		int grado=0;
		for (int i = 0; i < matriz.getDim(); i++) {
			for (int j = 0; j < matriz.getDim(); j++) {
				if(matriz.getValor(i, j)!=infinito){
					grado++;
				}
			}
			lista.add(new Nodo(i+1,grado,-1));
			grado=0;
		}
		
		//Collections.sort(lista);
		//Collections.reverse(lista);
		return lista;
	}

	private void ReemplazarPorInfinito(MatrizSimetrica matriz) {
		for (int i = 0; i < matriz.getDim(); i++) {
			for (int j = 0; j < matriz.getDim(); j++) {
				
				if(matriz.getValor(i, j)==0){
					matriz.setearAdyacencia(i, j, infinito);
				}
			}
		}
		
	}
	
}
