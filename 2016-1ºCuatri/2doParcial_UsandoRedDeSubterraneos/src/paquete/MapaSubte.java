package paquete;

import java.io.*;
import java.util.ArrayList;
public class MapaSubte {
private Nodo[] lineas;
private int cantidadLineas;
private int estOrigen;
private int estDestino;
private int[][] matriz;

public MapaSubte(String path) throws IOException{
	File archivo=new File(path);
	FileReader fr=new FileReader(archivo);
	BufferedReader br=new BufferedReader(fr);
	
	String linea=br.readLine();
	String[] dato=linea.split(" ");
	this.cantidadLineas=Integer.parseInt(dato[0]);
	this.lineas=new Nodo[this.cantidadLineas];
	for (int i = 0; i < lineas.length; i++) {
		linea=br.readLine();
		dato=linea.split(" ");
		int cantidadEstaciones=Integer.parseInt(dato[0]);
		this.lineas[i]=new Nodo(i);
		this.lineas[i].setCantEstaciones(cantidadEstaciones);
		for (int j = 0; j < cantidadEstaciones; j++) {
			int estacion=Integer.parseInt(dato[j+1]);
			this.lineas[i].estaciones.add(estacion);
		}
	}
	linea=br.readLine();
	dato=linea.split(" ");
	this.estOrigen=Integer.parseInt(dato[0]);
	this.estDestino=Integer.parseInt(dato[1]);
	this.matriz=new int [this.cantidadLineas][this.cantidadLineas];
	for (int i = 0; i < matriz.length; i++) {
		for (int j = 0; j < matriz.length; j++) {
			this.matriz[i][j]=99999;
		}
	}
	for (int i = 0; i < this.cantidadLineas; i++) {
		
		for (int j = 0; j < this.lineas[i].getCantEstaciones(); j++) {
			this.confirmarAdyacencia(this.lineas[i].estaciones.get(j), i);
		}
	}
	
}
public void confirmarAdyacencia(int estacion,int i){
	
	for (int j = 0; j < lineas.length; j++) {
		if(i!=j&&this.matriz[i][j]!=1&&this.lineas[j].estaciones.contains(estacion)){
			
			this.matriz[i][j]=1;
			this.matriz[j][i]=1;
		}
	}
	
}

public int [] Dijkstra(int origen){
	int[]distancias=new int[this.cantidadLineas];
	int[]previo=new int[this.cantidadLineas];
	int[]visto=new int[this.cantidadLineas];
	for (int i = 0; i < visto.length; i++) {
		distancias[i]=this.matriz[origen][i];
		previo[i]=origen;
		visto[i]=0;
	}
	int actual=origen;
	int siguiente=origen;
	for (int i = 0; i < distancias.length; i++) {
		int menorCosto=99999;
		actual=siguiente;
		visto[actual]=1;
		for (int j = 0; j < distancias.length; j++) {
			if(visto[j]!=1){
				if(menorCosto>distancias[j]){
					siguiente=j;
					menorCosto=distancias[j];
				}
				if(distancias[j]>distancias[actual]+this.matriz[actual][j]){
					distancias[j]=distancias[actual]+this.matriz[actual][j];
					previo[j]=actual;
				}
			}
		}
	}
	return distancias;
}
	public static void main(String[] args) throws IOException {
		MapaSubte mp=new MapaSubte("IN/Subterraneo.in");
		ArrayList<Integer> lineasOrigen=new ArrayList<Integer>();
		ArrayList<Integer> lineasDestino=new ArrayList<Integer>();
		for (int i = 0; i < mp.cantidadLineas; i++) {
			if(mp.lineas[i].estaciones.contains(mp.estOrigen))
				lineasOrigen.add(i);
			if(mp.lineas[i].estaciones.contains(mp.estDestino))
				lineasDestino.add(i);
		}
		for (int i = 0; i < lineasOrigen.size(); i++) {
			int [] taringa=mp.Dijkstra(lineasOrigen.get(i));
			System.out.println();
		}
	}

}
