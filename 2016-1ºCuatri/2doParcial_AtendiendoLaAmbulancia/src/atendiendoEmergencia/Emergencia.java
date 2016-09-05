package atendiendoEmergencia;

import java.io.*;
import java.util.*;

public class Emergencia {
	
	private int nodos;
	private MatrizAdyacencia ma;
	private Integer Distancias[][];
	
	private int Inicio;
	private int nodoFin;
	private final int INF= Integer.MAX_VALUE;

	public Emergencia(String path){
		
		
		File archivo=null;
		FileReader fr=null;
		BufferedReader br=null;
		
	try {
			archivo=new File(path);
			fr= new FileReader(archivo);
			br= new BufferedReader(fr);
			
			String linea=br.readLine();
			String line[]=linea.split(" ");
			
			int cant_nodos=Integer.parseInt(line[0]);
			this.nodos=cant_nodos;
			int cant_aristas=Integer.parseInt(line[1]);
			int nodInicio=Integer.parseInt(line[2]);
			this.Inicio=nodInicio-1;
			int nodoFin=Integer.parseInt(line[3]);
			this.nodoFin=nodoFin-1;

		
			ma= new MatrizAdyacencia(nodos,false);

			//CARGO LA MATRIZ CON LOS PESOS	

			 for(int i = 0; i < cant_aristas; i++){
					linea = br.readLine();
					line = linea.split(" ");
					ma.agregarArista(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]));
					
				}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

public void Dijkstra(int nodoInicio){
		

		Distancias = new Integer[nodos][nodos];
		
		for(int i = 0 ; i < nodos ; i++){
			if(!ma.sonAdyacentes(Inicio, i))
				Distancias[Inicio][i] = INF;
			else                                                                 
				Distancias[Inicio][i] = ma.getCosto(Inicio, i);                                 
				
			}
		ma.Visto(Inicio);
		Distancias[Inicio][Inicio] = 0;

		while(ma.noEstanVistosTodos()){
			//minima arista
			int v = minimo(); 
			ma.Visto(v);
			
for(int i = 0; i < nodos ; i++){
				if(ma.adyacenciaNoVista(v,i))
					if(Distancias[Inicio][i] > (Distancias[Inicio][v] + ma.getCosto(v,i))){
						Distancias[Inicio][i] = Distancias[Inicio][v] + ma.getCosto(v,i);
					}
			}  			
		}
	}

	 public void mostrarMatriz(){
		 
		 for(int i=0;i<nodos;i++){
			 for(int j=0;j<nodos;j++){
				 System.out.print(ma.getCosto(i, j)+" ");
			 }
				
			 System.out.println();
		 }
			 
	 }


		private int minimo() {
			int s = 0, arista = 0;
			Integer min = 0;
			for (int i = 0; i < nodos; i++) {
				if ((Distancias[Inicio][i] <= min || s == 0) && ma.noEstaVisto(i)) {
					s = 1;
					min = Distancias[Inicio][i];
					arista = i;
				}
			}
			return arista;
		}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path="grafo.in";
		Vector<Integer> adyacentes= new Vector<Integer>();

		Emergencia e1=new Emergencia(path);
		e1.mostrarMatriz();
		int costo=0;
		int cant_caminos=0;
		
		adyacentes= e1.ma.getnodos(e1.Inicio);
		
		for(int i=0;i<adyacentes.size();i++)
		System.out.println(adyacentes.get(i));
	

		e1.Dijkstra(1);
		
		System.out.println("Distancia de 1 a 7 es: "+e1.Distancias[e1.Inicio][e1.nodoFin]);

		
		
		//Calculo del Camino mas corto
		
		
	}

}
