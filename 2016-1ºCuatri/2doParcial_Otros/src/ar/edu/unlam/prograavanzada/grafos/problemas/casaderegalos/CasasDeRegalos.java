package ar.edu.unlam.prograavanzada.grafos.problemas.casaderegalos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CasasDeRegalos {

	private Integer cantidadTiendas;
	private Integer[][] matrizCercania;
	private List<NodoTienda> posiblesTiendas;
	
	private Integer mayorCantidadDeTiendasConUnColor=0;
	private Integer colorConMasTiendas=0;
	
	private List<NodoTienda> tiendas;
	
	public CasasDeRegalos(final String fileInPath) {
		
		FileReader fr = null;
		BufferedReader br = null;
		try{
			
			fr = new FileReader(new File(fileInPath));
			br = new BufferedReader(fr);
			
			
			this.cantidadTiendas = Integer.valueOf(br.readLine().split(" ")[0]);

			this.matrizCercania = new Integer[this.cantidadTiendas][this.cantidadTiendas];
			this.posiblesTiendas = new ArrayList<NodoTienda>();
			
			for(int i=0; i<this.cantidadTiendas; i++){
				String[] linea = br.readLine().split(" ");
				
				Integer numeroTienda = Integer.valueOf(linea[0])-1;
				this.posiblesTiendas.add(new NodoTienda(numeroTienda));
				
				for(int j=1; j<linea.length-1; j++){
					Integer tiendaCercana = Integer.valueOf(linea[j])-1;
					this.matrizCercania[numeroTienda][tiendaCercana]=1;
					this.matrizCercania[tiendaCercana][numeroTienda]=1;
				}
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
		this.completarGradoNodos();
		this.colorear();
		
		this.tiendas = new ArrayList<NodoTienda>();
		for(NodoTienda posibleTienda : this.posiblesTiendas){
			if(posibleTienda.getColor()==this.colorConMasTiendas){
				this.tiendas.add(posibleTienda);
			}
		}
	}

	private void completarGradoNodos(){
		for(NodoTienda nodo : this.posiblesTiendas){
			Integer gradoNodo=0;
			for(int i=0; i<this.cantidadTiendas; i++){
				if(this.matrizCercania[nodo.getNroTienda()][i]!=null){
					gradoNodo++;
				}
			}
			nodo.setGrado(gradoNodo);
		}
	}
	
	private void colorear() {
		
//		Collections.sort(this.posiblesTiendas);
		
		Integer color=0, coloreos=0;
		
		while(coloreos<this.cantidadTiendas){
			color++;
			Integer tiendasConColor=0;
			Integer indice=0;
			while(indice<this.cantidadTiendas && coloreos<this.cantidadTiendas){
				NodoTienda tiendaAEvaluar = this.posiblesTiendas.get(indice);
				if(tiendaAEvaluar.getColor()==0 && this.permiteColorear(tiendaAEvaluar.getNroTienda(), color)){
					tiendaAEvaluar.setColor(color);
					coloreos++;
					tiendasConColor++;
				}
				indice++;
				if(this.mayorCantidadDeTiendasConUnColor<tiendasConColor){
					this.mayorCantidadDeTiendasConUnColor=tiendasConColor;
					this.colorConMasTiendas=color;
				}
			}
			
		}
	}

	private boolean permiteColorear(Integer nroTienda, Integer color) {
		for(int i=0; i<this.cantidadTiendas; i++){
			if(this.matrizCercania[nroTienda][i]!=null && this.posiblesTiendas.get(i).getColor()==color){
				return false;
			}
		}
		return true;
	}

	public void grabarResultado(final String fileOutPath){
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		try{
			fileWriter = new FileWriter(new File(fileOutPath));
			printWriter = new PrintWriter(fileWriter);
			printWriter.println(this.cantidadTiendas.toString());
			String strTiendas = "";
			for(NodoTienda tienda : this.tiendas){
				strTiendas+=(tienda.getNroTienda()+1)+" ";
			}
			printWriter.println(strTiendas);
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try{
				if(fileWriter!=null)
					fileWriter.close();
				if(printWriter!=null)
					printWriter.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
