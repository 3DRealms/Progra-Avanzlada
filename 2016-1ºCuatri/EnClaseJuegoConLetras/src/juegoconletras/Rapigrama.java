package juegoconletras;

//import java.io.BufferedReader;
import java.io.*;

//import java.io.File;
//import java.io.FileReader;
import java.util.ArrayList;

public class Rapigrama {
	private int dimensionCuadro;
	private int cantidadPalabras;
	private char [][] cuadro;
	private char [][] cuadroTraspuesto;
	private String [] palabras;
	private ArrayList<String> solucion = new ArrayList<String>();
	
	public Rapigrama (String caso){
		// despues
		//this.cuadro = new char [dimension][dimension];
		//this.palabras = new String [palabras];
		//archivo
		File f = null;
		FileReader fr = null;
		BufferedReader br =null;
		String linea;
		String[] datos;
		
		try
		{
			f = new File( caso );
			fr = new FileReader(f);
			br = new BufferedReader(fr);

			linea = br.readLine();
			datos = linea.split(" ");
			
			this.dimensionCuadro = Integer.parseInt(datos[0]);
			this.cantidadPalabras = Integer.parseInt(datos[1]);	
			System.out.println(dimensionCuadro);
			System.out.println(cantidadPalabras);
			//HAY QUE INSTANCIAR ESTAS COSAS EN EL CONSTRUCTOR
			cuadro=new char[dimensionCuadro][dimensionCuadro];
			cuadroTraspuesto=new char[dimensionCuadro][dimensionCuadro];
			palabras= new String[cantidadPalabras];
			//cuadro
			for (int i = 0; i < this.dimensionCuadro; i++){
				linea = br.readLine();
				char lineacortada[] = linea.toCharArray();
				
				for ( int j = 0; j < this.dimensionCuadro; j++ ){
					cuadro[i][j] = lineacortada[j];
				}
			}		
			//palabras
			for (int i = 0; i < this.cantidadPalabras; i++){
				linea = br.readLine();
				this.palabras[i] = linea;
			}
			for (int i = 0; i < this.dimensionCuadro; i++)
				for (int j = 0; j < this.dimensionCuadro; j++)
					this.cuadroTraspuesto[j][i] = this.cuadro[i][j];	
		}
			
		catch(Exception e){
	        e.printStackTrace();
		}
	    finally
	    {	
	    	//Cuadro
			for (int i = 0; i < this.dimensionCuadro; i++){
				for (int j = 0; j < this.dimensionCuadro; j++){
					System.out.print(this.cuadro[i][j]+" ");
				}
				System.out.println("");
			}
			//Palabras
			for (int i = 0; i < this.cantidadPalabras; i++){
					System.out.print(this.palabras[i]+" ");
					System.out.println("");
				}
				
	    } 
	}
	
	public int encontrarPalabra ( String palabra){
		
		String lineaNormal="";
		String lineaInvertida="";
		//Buscar alineadamente
		for (int i = 0; i < this.dimensionCuadro; i++){
			for (int j = 0; j < this.dimensionCuadro; j++){
				lineaNormal += cuadro[i][j];
			}
			//lineaNormal = String.valueOf( cuadro[i]);	
			if ( lineaNormal.indexOf( palabra ) != -1 ) {
				return 1;
			}
		
			//Invertido
			for (int j = (this.dimensionCuadro - 1); j >= 0; j--){				
				lineaInvertida += cuadro[i][j];
			}
			if ( lineaInvertida.indexOf( palabra ) != -1 ) {
				return 2;
			}		
		}
		//buscar en traspuesto
		for (int i = 0; i < this.dimensionCuadro; i++){
			for (int j = 0; j < this.dimensionCuadro; j++){
				lineaNormal += cuadroTraspuesto[i][j];
			}
			//lineaNormal = String.valueOf( cuadro[i]);	
			if ( lineaNormal.indexOf( palabra ) != -1 ) {
				return 3;
			}
		
			//Invertido
			for (int j = (this.dimensionCuadro - 1); j >= 0; j--){				
				lineaInvertida += cuadroTraspuesto[i][j];
			}
			if ( lineaInvertida.indexOf( palabra ) != -1 ) {
				return 4;
			}		
		}
		return 0;
		
	}
	
	public void resolverJuego (){
		for (int i = 0; i < this.cantidadPalabras; i++){
			switch (this.encontrarPalabra(palabras[i])){
			case 0:
				break;
			case 1:
				solucion.add((i+1)+" E");
				break;
			case 2:
				solucion.add((i+1)+" O");
				break;
			case 3:
				solucion.add((i+1)+" S");
				break;
			case 4:
				solucion.add((i+1)+" N");
				break;
			}

		}
	}
	
	public int getDimensionCuadro() {
		return dimensionCuadro;
	}

	public int getCantidadPalabras() {
		return cantidadPalabras;
	}
	
	public void setDimensionCuadro(int dimensionCuadro) {
		this.dimensionCuadro = dimensionCuadro;
	}

	public void setCantidadPalabras(int cantidadPalabras) {
		this.cantidadPalabras = cantidadPalabras;
	}
	
	public void escribirArchivo( String caso){
	        FileWriter fichero = null;
	        PrintWriter pw = null;
	        try
	        {
	            fichero = new FileWriter(caso);
	            pw = new PrintWriter(fichero);

	            for (int i = 0; i < solucion.size(); i++)
	                pw.println(solucion.toString());
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           try {
	           // Nuevamente aprovechamos el finally para 
	           // asegurarnos que se cierra el fichero.
	   			for (int i = 0; i < solucion.size(); i++){
					System.out.print(solucion.get(i)+" ");
					System.out.println("");
				}
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }	
	}
}
