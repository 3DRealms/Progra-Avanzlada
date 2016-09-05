package ar.edu.unlam.prograavanzada.grafos.problemas.minotauro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Minotauro {

	private Integer[][] matAdyacencia;
	
	private Integer cantidadDescansos;
	
	private List<Pasaje> pasajes;
	
	@SuppressWarnings("resource")
	public Minotauro(final String archivoEntrada) throws Exception {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			
			fr = new FileReader(new File(archivoEntrada));
			br = new BufferedReader(fr);
			
			String[] linea = br.readLine().split(" ");
			
			this.cantidadDescansos = Integer.valueOf(linea[0]);
			
			if(this.cantidadDescansos>=1 && this.cantidadDescansos<=1000){
			
				this.matAdyacencia = new Integer[this.cantidadDescansos][this.cantidadDescansos];
				
				for(int i=0; i<this.cantidadDescansos;i++){
					linea = br.readLine().split(" ");
					
					if(linea.length==this.cantidadDescansos){
						
						for(int j=0; j<this.cantidadDescansos;j++){
							
							Integer pasos = Integer.valueOf(linea[j]);
							
							if(pasos>=0 && pasos<=100000000){
								this.matAdyacencia[i][j]=pasos;
								this.matAdyacencia[j][i]=pasos;
							} else {
								throw new Exception("Cantidad de pasos inválida");
							}
						}
					} else {
						throw new Exception("Insuficientes valores en línea "+(i+1));
					}
				}
			} else {
				throw new Exception("Cantidad de descansos inválida: "+this.cantidadDescansos.toString());
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(fr!=null)
					fr.close();
				if(br!=null)
					br.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	public void resolver(){
		
		this.pasajes = new ArrayList<Pasaje>();
		
		for(int descansoDesde=0; descansoDesde<this.cantidadDescansos; descansoDesde++){
			Integer descansoMasCercano=null;
			Integer menorDistancia=null;
			
			for(int descansoHasta=0; descansoHasta<this.cantidadDescansos; descansoHasta++){
				if(descansoDesde!=descansoHasta){
					Integer distanciaEntreDescansos = this.matAdyacencia[descansoDesde][descansoHasta];
					if(descansoMasCercano==null || menorDistancia>distanciaEntreDescansos){
						descansoMasCercano = descansoHasta;
						menorDistancia = distanciaEntreDescansos;
					}
				}
			}
			
			Pasaje pasaje = new Pasaje(descansoDesde+1, descansoMasCercano+1, menorDistancia);
			
			if(!this.pasajes.contains(pasaje)){
				this.pasajes.add(pasaje);
			}
		}
		
	}
	
	public void grabar(final String archivoSalida){
		FileWriter fw = null;
		PrintWriter pw = null;
		try{
			
			fw = new FileWriter(new File(archivoSalida));
			pw = new PrintWriter(fw);
			
			pw.println(this.pasajes.size());
			for (Pasaje pasaje : this.pasajes) {
				pw.println(pasaje);
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
}