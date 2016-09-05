package ar.edu.unlam.prograavanzada.grafos.problemas.vecinos;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

public class GeneradorGrafo {

	private Integer[][] matrizAdyacencia;
	private Integer dimension;
	private Integer aristas;
	
	public static void main(String[] args){
		GeneradorGrafo g = new GeneradorGrafo(2000);
		g.generarPorAristasDeseadas(50000);
		g.grabar("vecinos.generador.fatiga.in");
	}
	
	public GeneradorGrafo(Integer dimension){
		this.matrizAdyacencia = new Integer[dimension][dimension];
		this.dimension=dimension;
		this.aristas=0;
	}
	
	public void generarPorGradoYPesoAleatorio(Integer grado){
		
		Integer[] grados = new Integer[this.dimension];
		for(int i=0; i<this.dimension; i++){
			grados[i]=0;
		}
		
		Random random = new Random();
		
		Boolean generar=true;
		while(generar){
			generar=false;
			
			for(int i=0; i<this.dimension; i++){
				for(int j=i+1; j<this.dimension; j++){
					
					if(grados[i]<grado && grados[j]<grado){
						
						Integer peso = (int)random.nextDouble()*10;
						this.matrizAdyacencia[i][j]=peso; 
						this.matrizAdyacencia[j][i]=peso; 
						
						this.aristas++;
						
						generar=true;
					}
				}
			}
		}
	}
	
	public void generarPorAristasDeseadas(int aristasDeseadas){
		
		while(this.aristas < aristasDeseadas){
			for(int i=0; i < this.dimension; i++){
				for(int j=i+1; j < this.dimension; j++){
					if(this.aristas < aristasDeseadas && this.matrizAdyacencia[i][j]!=null && Math.random() <= 0.5){
						this.matrizAdyacencia[i][j] = this.matrizAdyacencia[j][i] = (int)Math.random()*100;
						this.aristas++;
					}
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
			
			pw.println(String.format("%d %d X Y",this.dimension, this.aristas));
			
			for(int i=0; i<this.dimension; i++){
				for(int j=i+1; j<this.dimension; j++){
					
					if(this.matrizAdyacencia[i][j]!=null){
						pw.println(String.format("%d %d %d", i, j, this.matrizAdyacencia[i][j]));
					}
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(fw!=null){
					fw.close();
				}
				if(pw!=null){
					pw.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public Integer[][] getMatrizAdyacencia() {
		return matrizAdyacencia;
	}
	
}
