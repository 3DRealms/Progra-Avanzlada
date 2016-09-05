package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import matriz.MatrizAdyacencia;
import matriz.MatrizSimetrica;

public class Archivo {
	public static MatrizSimetrica leerArchivoAMatrizSim(String in) throws IOException{
		File f =null;
		FileReader fr =null;
		BufferedReader br=null;
		MatrizSimetrica matriz = null;
		
		try {
			f = new File(in);
			fr= new FileReader(f);
			br = new BufferedReader(fr);
			
			String line;
			String[] linea;
			
			linea=br.readLine().split(" ");
			matriz = new MatrizSimetrica(Integer.valueOf(linea[0]));
			
			while((line=br.readLine())!=null){
				linea= line.split(" ");
				matriz.setearAdyacencia(Integer.valueOf(linea[0])-1,Integer.valueOf(linea[1])-1, Integer.valueOf(linea[2]));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally{
				if(fr!=null)
					fr.close();
				if(br!=null)
					br.close();
		}
	
		
		return matriz;
	}

	public static MatrizAdyacencia leerArchivoAMatrizAdy(String in) throws IOException{
		File f =null;
		FileReader fr =null;
		BufferedReader br=null;
		MatrizAdyacencia matriz = null;
		
		try {
			f = new File(in);
			fr= new FileReader(f);
			br = new BufferedReader(fr);
			
			String line;
			String[] linea;
			
			linea=br.readLine().split(" ");
			matriz = new MatrizAdyacencia(Integer.valueOf(linea[0]));
			
			while((line=br.readLine())!=null){
				linea= line.split(" ");
				matriz.setearAdyacencia(Integer.valueOf(linea[0])-1,Integer.valueOf(linea[1])-1, Integer.valueOf(linea[2]));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally{
				if(fr!=null)
					fr.close();
				if(br!=null)
					br.close();
		}
	
		
		return matriz;
	}

}
