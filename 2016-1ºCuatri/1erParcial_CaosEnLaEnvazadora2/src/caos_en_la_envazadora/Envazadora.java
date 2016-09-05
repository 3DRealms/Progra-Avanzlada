package caos_en_la_envazadora;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Envazadora {
	private String [] latas;
	private int cantidad;
	private int linea;
	
	private int maximoCant;
	private int maximoIni;
	
	private int maximoParcialCant;
	private int maximoParcialIni;
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String[] getLatas() {
		return latas;
	}
	public void setLatas(String[] latas) {
		this.latas = latas;
	}
	public int getLinea() {
		return linea;
	}
	public void setLinea(int linea) {
		this.linea = linea;
	}
	public int getMaximoCant() {
		return maximoCant;
	}
	public void setMaximoCant(int maximoCant) {
		this.maximoCant = maximoCant;
	}
	public int getMaximoIni() {
		return maximoIni;
	}
	public void setMaximoIni(int maximoIni) {
		this.maximoIni = maximoIni;
	}
	public int getMaximoParcialCant() {
		return maximoParcialCant;
	}
	public void setMaximoParcialCant(int maximoParcialCant) {
		this.maximoParcialCant = maximoParcialCant;
	}
	public int getMaximoParcialIni() {
		return maximoParcialIni;
	}
	public void setMaximoParcialIni(int maximoParcialIni) {
		this.maximoParcialIni = maximoParcialIni;
	}

	public Envazadora (String path){
		//Variables del Constructor
		File f= null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try{
			f = new File(path);
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String linea;
			
			//Leo archivo
			while((linea=br.readLine())!=null){
				setLatas(linea.split(" "));
				setCantidad(getLatas().length);
			}
			
			//Si hubiera que agregar algo mas al constructor
			                      
			if( fr != null ){
				fr.close();
			}
		}
		//Capturar Excepcion del archivo
		catch (Exception e1) {
			e1.printStackTrace();
		}
		
	    //Cerrar archivo si fue mal abierto  
		finally{
			try{
				if( null != fr ){
					fr.close();
				}                  
		    }
			catch (Exception e2){
				e2.printStackTrace();
			}
		}
	}
	
	public int ResolverCaos(){
		int banderaMaximo1 = 0;
		int banderaMaximo2 = 0;
		
		int cantidad = 0;
		int orden = 0;
		int estadoDeCarga = 0;
		
		for (int i = 0; i<getCantidad(); i++){
			if( latas[i].equals("G")){
				if( estadoDeCarga == 0){
					estadoDeCarga = 1;
					orden = i+1;					
				}
				cantidad++;				
			}
			else{
				if ( banderaMaximo1 == 0 ){
					setMaximoCant(cantidad);
					setMaximoIni(orden);
					banderaMaximo1 = 1;
				}
				if ( getMaximoCant() < cantidad){
					setMaximoParcialCant(getMaximoCant());
					setMaximoParcialIni(getMaximoIni());
					setMaximoCant(cantidad);
					setMaximoIni(orden);
				}
				else{
					if( banderaMaximo2 == 0 && getMaximoCant() != cantidad){
						setMaximoParcialCant(cantidad);
						setMaximoParcialIni(orden);
						banderaMaximo2 = 1;
					}
				}
				cantidad = 0;
				estadoDeCarga = 0;
			}
			
		}
		return getCantidad();
	}
	public void grabar(String path) {
		FileWriter fw = null;
		PrintWriter pw = null;
		try{
			fw = new FileWriter(path);
			pw = new PrintWriter(fw);
			pw.println(getCantidad());
			pw.println(getMaximoCant());
			pw.println(getMaximoParcialCant());
			if( getMaximoIni() < getMaximoParcialIni() ){
				pw.println( getMaximoParcialIni() - (getMaximoIni() + getMaximoCant()) );
			}
			else{
				//getMaximoIni() > getMaximoParcialIni()
				pw.println( Math.abs( getMaximoIni() - (getMaximoParcialIni()+getMaximoParcialCant()) ) );
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				fw.close();
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}