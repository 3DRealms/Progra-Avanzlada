package main;

import java.io.IOException;
import java.util.Stack;

import io.Archivo;
import matriz.MatrizAdyacencia;

public class Solucion {

private String pathIn;



public Solucion(String in){
	
	pathIn=in;
	
}

public void resolver(){
	
	
	
	try {
		
		MatrizAdyacencia matriz = Archivo.leerArchivoAMatrizAdy(pathIn);
		int inicio = 0;
		int fin = matriz.getDim()-1;
		
		Stack<Integer> pila = new Stack<Integer>();
		pila.add(inicio); //apilo el nodo de inicio
		int cantCaminos=0;
		
		while(!pila.isEmpty()){
			
			Integer nodo = pila.pop();
			if(nodo==fin){ //Si el nodo es el "fin" sumo 1 a la cant de caminos
				cantCaminos++;
			}else{
				apilarAdyacencias(nodo,pila,matriz); //Como no es el fin, que siga apilando adyacencias
			}
			
			}
			
		System.out.println("Cantidad de caminos: "+cantCaminos);
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}

private void apilarAdyacencias(Integer nodo, Stack<Integer> pila, MatrizAdyacencia matriz) {
	
		/*for (int j = matriz.getDim()-1; j>=0; j--) { //Lo hice asi, porque me parecia mas prolijo de pensar
			if(matriz.getValor(nodo, j)!=0){
					pila.add(j);			
						}
		}*/
	
	for (int j = 0; j<matriz.getDim(); j++) {	//Pero asi también funciona
	if(matriz.getValor(nodo, j)!=0){
			pila.add(j);			
				}
}
	
	}
	
}
