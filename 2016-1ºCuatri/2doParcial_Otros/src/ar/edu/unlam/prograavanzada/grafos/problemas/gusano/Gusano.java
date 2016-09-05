package ar.edu.unlam.prograavanzada.grafos.problemas.gusano;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Gusano {

	private Integer cantidadPc;
	private Integer[][] matrizRed;
	private List<DatoInfeccion> datosInfeccion;
	private ArrayList<Integer> posiblesOrigenes;
	
	public Gusano(final String archivoEntrada){
		
		FileReader fr = null;
		BufferedReader br = null;
		try{
			fr = new FileReader(new File(archivoEntrada));
			br = new BufferedReader(fr);
			
			String[] linea = br.readLine().split(" ");
			this.cantidadPc = Integer.valueOf(linea[0]);
			
			this.matrizRed = new Integer[this.cantidadPc][this.cantidadPc];
			
			for(int i=0; i<this.cantidadPc; i++){
				linea = br.readLine().split(" ");
				
				Integer pcDesde = Integer.valueOf(linea[0]);
				Integer tiempoTransmision = Integer.valueOf(linea[1]);
				Integer pcHasta = Integer.valueOf(linea[2]);
				
				this.matrizRed[pcDesde-1][pcHasta-1]=tiempoTransmision;
				this.matrizRed[pcHasta-1][pcDesde-1]=tiempoTransmision;
			}
			
			this.datosInfeccion = new ArrayList<DatoInfeccion>();
			
			linea = br.readLine().split(" ");
			Integer cantDatosInfeccion = Integer.valueOf(linea[0]);
			
			for(int i=0; i<cantDatosInfeccion; i++){
				linea = br.readLine().split(" ");
				
				Integer nroPcInfectada = Integer.valueOf(linea[0])-1;
				Integer demoraInfeccion = Integer.valueOf(linea[1]);
				
				this.datosInfeccion.add(
					new DatoInfeccion( nroPcInfectada, demoraInfeccion )
				);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(br!=null)
					br.close();
				if(fr!=null)
					fr.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	
	public void resolver(){
		
		this.posiblesOrigenes = new ArrayList<Integer>();
		for(Integer nroPc=0; nroPc<this.cantidadPc; nroPc++){
			posiblesOrigenes.add(nroPc);
		}
		
		for(DatoInfeccion datoInfeccion : this.datosInfeccion){
			
			if(datoInfeccion.getDemoraInfeccion()>0){
				posiblesOrigenes.remove(datoInfeccion.getNroPc());
			}
			
			Integer[] demorasDijkstra = this.demorasDijkstra(datoInfeccion.getNroPc());
			for(Integer i=0; i<demorasDijkstra.length; i++){
				if(demorasDijkstra[i]!=datoInfeccion.getDemoraInfeccion()){
					posiblesOrigenes.remove(i);
				}
			}
			
		}
		
	}
	
	private Integer[] demorasDijkstra(Integer nroPcInfectada){
		Integer[] demorasMinimasDijkstra = new Integer[this.cantidadPc];
		demorasMinimasDijkstra[nroPcInfectada]=0;
		
		List<Integer> pcsPorEvaluar = new ArrayList<Integer>();
		for(Integer i=0; i<this.cantidadPc; i++){
			pcsPorEvaluar.add(i);
		}
		pcsPorEvaluar.remove(nroPcInfectada);
		
		Integer pcEnEvaluacion = nroPcInfectada;
		while(!pcsPorEvaluar.isEmpty() && pcEnEvaluacion!=null){
			
			for(Integer pcPorEvaluar : pcsPorEvaluar){
				
				if(pcEnEvaluacion!=pcPorEvaluar
					&& this.matrizRed[pcEnEvaluacion][pcPorEvaluar]!=null){
					
					Integer pcAdyacente = pcPorEvaluar;
					
					Integer posibleMenorDemora =
							this.matrizRed[pcEnEvaluacion][pcAdyacente]
							+ demorasMinimasDijkstra[pcEnEvaluacion];
					
					if(demorasMinimasDijkstra[pcAdyacente]==null
						|| demorasMinimasDijkstra[pcAdyacente]>posibleMenorDemora){
						
						demorasMinimasDijkstra[pcAdyacente]=posibleMenorDemora;
					}
				}
			}
			pcsPorEvaluar.remove(pcEnEvaluacion);
			Integer proximaPcAEvaluar=null;
			
			for(Integer pcPorEvaluar : pcsPorEvaluar){
				if(demorasMinimasDijkstra[pcPorEvaluar]!=null
					&& (proximaPcAEvaluar==null || demorasMinimasDijkstra[pcPorEvaluar]<demorasMinimasDijkstra[proximaPcAEvaluar]) ){
					proximaPcAEvaluar=pcPorEvaluar;
				}
			}
			
			pcEnEvaluacion = proximaPcAEvaluar;
		}
		
		return demorasMinimasDijkstra;
	}
	
	public void grabarResultado(final String archivoSalida){
		FileWriter fw = null;
		PrintWriter pw = null;
		try{
			
			fw = new FileWriter(new File(archivoSalida));
			pw = new PrintWriter(fw);
			
			for(Integer posibleOrigen : this.posiblesOrigenes){
				pw.println(posibleOrigen+1);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pw!=null)
					pw.close();
				if(fw!=null)
					fw.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	
}
