package ar.edu.unlam.prograavanzada.grafos.entidades;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grafo {

	private static final int dimensionPorDefecto = 10;
	
	private int matriz[][];
	private int dimension;
	
	private int aristas;
	private int maxAristas;
	
	private double porcentajeAdyacencia;
	
	private int gradoMax;
	private int gradoMin;
	
	List<Nodo> nodos = null;
	
	private int cantidadColores;
	
	public Grafo(){
		this(dimensionPorDefecto);
	}
	
	public Grafo(int dimension){
		this.dimension=dimension;
		this.matriz = new int[this.dimension][this.dimension];
		
		for(int i=0; i<this.dimension;i++)
			for(int j=0;j< this.dimension;j++)
				this.matriz[i][j]=0;
		
		this.gradoMin = this.dimension;
		this.gradoMax = 0;
		
		this.maxAristas = ((this.dimension-1)*this.dimension)/2;
	}
	
	public void generarPorProbabilidadDeAristas(int probabilidadAristas){
		Random random = new Random();
		int aristas = 0;
		
		int grados[] = new int[this.dimension];
		for (int i=0;i<this.dimension;i++){
			grados[i]=0;
		}
		
		for(int i=0; i < this.dimension-1;i++){
			for(int j=i+1;j < this.dimension;j++){
				if (random.nextDouble()*100 <= probabilidadAristas){
					this.matriz[i][j] = this.matriz[j][i] = 1;
					grados[i]++;
					grados[j]++;
					aristas++;
				}
			}
		}
		this.porcentajeAdyacencia = ((double)aristas/maxAristas)*100;
		
		this.obtenerGradosMinYMax(grados);
	}

	public void generarPorPorcentajeDeAdyacencia(int porcentajeAdyacencia){
		this.porcentajeAdyacencia = porcentajeAdyacencia;
		
		int aristasDeseadas = (int)(this.porcentajeAdyacencia*this.maxAristas)/100;
		
		int grados[] = new int[this.dimension];
		for (int i=0;i<this.dimension;i++){
			grados[i]=0;
		}
		
		while(this.aristas < aristasDeseadas){
			for(int i=0; i < this.dimension; i++){
				for(int j=i+1; j < this.dimension; j++){
					if(this.aristas < aristasDeseadas && this.matriz[i][j]!=1 && Math.random() <= 0.5){
						this.matriz[i][j] = this.matriz[j][i] = 1;
						this.aristas++;
						
						grados[i]++;
						grados[j]++;
					}
				
				}
			}
		}
		
		this.obtenerGradosMinYMax(grados);
	}
	
	public void generarRegularPorGrado(int gradoDeseado) throws Exception {
		
		if(gradoDeseado>=this.dimension)
			throw new Exception("Error! el grado debe ser menor a la dimension.");
		
		this.gradoMin = this.gradoMax = gradoDeseado;
		this.porcentajeAdyacencia = 100;
		this.aristas = (this.dimension * gradoDeseado) / 2;
		
		int[] grados = new int[this.dimension];
		for (int i=0;i<this.dimension;i++){
			grados[i]=0;
		}
		
		boolean generar = true;
		while(generar){
			generar = false;
			for(int i=0; i < this.dimension-1;i++){
				for(int j=i+1;j < this.dimension;j++){
					if (grados[i]<gradoDeseado && grados[j]<gradoDeseado){
						this.matriz[i][j] = this.matriz[j][i] = 1;
						grados[i]++;
						grados[j]++;
						generar = true;
					}
				}
			}
		}
	}
	
	public void generarRegularNPartito(int particiones) throws Exception {
		
		if(this.dimension % particiones > 0)
			throw new Exception("No se puede generar un grafo regular de un numero "
					+ "de particiones que no sea divisor de su dimension.");
		
		int[] grados = new int[this.dimension];
		for (int i=0;i<this.dimension;i++){
			grados[i]=0;
		}
		
		int cantidadNodosPorParticion = this.dimension / particiones;
		
		int[] nodosAgrupadosPorParticion = new int[this.dimension];
		
		for(int i=0; i<this.dimension; i++){
			nodosAgrupadosPorParticion[i]= (int)i/cantidadNodosPorParticion;
		}
		
		for(int i=0; i < this.dimension-1;i++){
			for(int j=i+1;j < this.dimension;j++){
				if (nodosAgrupadosPorParticion[i]!=nodosAgrupadosPorParticion[j]){
					this.matriz[i][j] = this.matriz[j][i] = 1;
					
					grados[i]++;
					grados[j]++;
					this.aristas++;
				}
			}
		}
		this.porcentajeAdyacencia = ((double)this.aristas/this.maxAristas)*100;
		
		this.obtenerGradosMinYMax(grados);
	}
	
	private void obtenerGradosMinYMax(int[] grados) {
		for (int i=0;i<this.dimension;i++){
			if (grados[i]<this.gradoMin)
				this.gradoMin=grados[i];
			if (grados[i]>gradoMax)
				this.gradoMax=grados[i];
		}
	}
	
	public void grabarArchivo(final String rutaArchivo){
		FileWriter fileWriter=null;
		PrintWriter printWriter=null;
		try {
			fileWriter = new FileWriter(rutaArchivo);
			printWriter = new PrintWriter(fileWriter);
			
			printWriter.println(
					String.format("%d %d %.2f %d %d",
							this.dimension,
							this.aristas,
							this.porcentajeAdyacencia,
							this.gradoMax,
							this.gradoMin
						)
				);
			
			for(int i=0; i < this.dimension-1; i++){
				for(int j=i+1; j < this.dimension; j++){
					if(this.matriz[i][j]==1)
						printWriter.println(i+" "+j);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(fileWriter!=null)
					fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Nodo> getNodos(){
		
		if(nodos==null){
			nodos = new ArrayList<Nodo>();
			
			int grado=0;
			for(int i=0;i<this.dimension;i++){
				for(int j=i+1;j<this.dimension;j++){
					if(this.matriz[i][j]>0){
						grado++;
					}
				}
				nodos.add( new Nodo(i, grado) );
				grado=0;
			}
		}
		return nodos;
	}
	
	public int[][] getMatriz() {
		return matriz;
	}
	public int getDimension() {
		return dimension;
	}
	public int getAristas() {
		return aristas;
	}
	public int getMaxAristas() {
		return maxAristas;
	}
	public double getPorcentajeAdyacencia() {
		return porcentajeAdyacencia;
	}
	public int getGradoMax() {
		return gradoMax;
	}
	public int getGradoMin() {
		return gradoMin;
	}

	public int getCantidadColores() {
		return cantidadColores;
	}
	public void setCantidadColores(int cantidadColores) {
		this.cantidadColores = cantidadColores;
	}

}
