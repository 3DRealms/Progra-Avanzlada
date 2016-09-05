package ar.edu.unlam.prograavanzada.grafos.problemas.vecinos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import ar.edu.unlam.prograavanzada.grafos.algoritmos.Dijkstra;

public class Vecinos {

	private Integer cantidadVecinos;
	
	private Integer vecinoX;
	private Integer vecinoY;
	
	private Integer[][] matrizAmistad;
	
	private Integer cantAmigosX=0;
	private Integer cantAmigosY=0;
	
	public Vecinos(final String archivoEntrada){
		
		FileReader fr = null;
		BufferedReader br = null;
		try{
			fr = new FileReader(new File(archivoEntrada));
			br = new BufferedReader(fr);
			
			String[]linea = br.readLine().split(" ");
			
			this.cantidadVecinos = Integer.valueOf(linea[0]);
			Integer cantidadAmistades = Integer.valueOf(linea[1]);
			this.vecinoX = Integer.valueOf(linea[2]);
			this.vecinoY = Integer.valueOf(linea[3]);
			
			this.matrizAmistad=new Integer[this.cantidadVecinos][this.cantidadVecinos];
			for(int i=0; i<cantidadAmistades; i++){
				linea = br.readLine().split(" ");
				
				Integer vecinoA = Integer.valueOf(linea[0])-1;
				Integer vecinoB = Integer.valueOf(linea[1])-1;
				Integer fuerzaAmistad = Integer.valueOf(linea[2]);
				
				this.matrizAmistad[vecinoA][vecinoB]=fuerzaAmistad;
				this.matrizAmistad[vecinoB][vecinoA]=fuerzaAmistad;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(fr!=null)
					fr.close();
				if(br!=null)
					br.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	
	public void resolver(){
		
		Dijkstra dijkstraX = new Dijkstra(this.matrizAmistad); 
		Dijkstra dijkstraY = new Dijkstra(this.matrizAmistad);
		
		dijkstraX.resolver(this.vecinoX);
		dijkstraY.resolver(this.vecinoY);
		
		Integer[] fuerzasAmistadX = dijkstraX.getDistanciasMinimas();
		Integer[] fuerzasAmistadY = dijkstraY.getDistanciasMinimas();
		
		for(int nroVecino=0; nroVecino<this.cantidadVecinos; nroVecino++){
			
			if(nroVecino!=this.vecinoX && nroVecino!=this.vecinoY){
				Integer fuerzaAmistadVecinoAX = fuerzasAmistadX[nroVecino];
				
				Integer fuerzaAmistadVecinoAY = fuerzasAmistadY[nroVecino];
				
				if(fuerzaAmistadVecinoAX!=null && fuerzaAmistadVecinoAX>0
					&& fuerzaAmistadVecinoAY!=null && fuerzaAmistadVecinoAY>0){
					
					if(fuerzaAmistadVecinoAX>fuerzaAmistadVecinoAY){
						this.cantAmigosX++;
					} else if(fuerzaAmistadVecinoAY>fuerzaAmistadVecinoAX){
						this.cantAmigosY++;
					}
				} else if (fuerzaAmistadVecinoAX!=null && fuerzaAmistadVecinoAX>0
						&& (fuerzaAmistadVecinoAY==null || fuerzaAmistadVecinoAY==0) ){
					this.cantAmigosX++;
				} else if (fuerzaAmistadVecinoAY!=null && fuerzaAmistadVecinoAY>0
						&& (fuerzaAmistadVecinoAX==null || fuerzaAmistadVecinoAX==0) ){
					this.cantAmigosY++;
				}
			}
		}
	}
	
	public void grabar(final String archivoSalida){
		FileWriter fw = null;
		PrintWriter pw = null;
		try{
			fw = new FileWriter(new File(archivoSalida));
			pw = new PrintWriter(fw);
			pw.println(String.format("%d %d", this.cantAmigosX, this.cantAmigosY));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(fw!=null)
					fw.close();
				if(pw!=null)
					pw.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
