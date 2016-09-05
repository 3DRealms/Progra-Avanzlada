

package ar.edu.unlam.prograavanzada.grafos.problemas.rescatandoprincesa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import ar.edu.unlam.prograavanzada.grafos.algoritmos.Dijkstra;

public class RescatandoALaPrincesa {

	private DatosRescate datos;
	
	private Integer[][] matrizGrafo;
	
	private String resultado;

	public RescatandoALaPrincesa(final String fileInPath){
		this.cargarDatosDeArchivo(fileInPath);
	}
	
	private void cargarDatosDeArchivo(final String filePath){
		this.datos = new DatosRescate();
		
		FileReader fileReader = null;
		BufferedReader bufferReader = null;
		try{
			fileReader = new FileReader(new File(filePath));
			bufferReader = new BufferedReader(fileReader);
			
			String[] linea = bufferReader.readLine().split(" ");
			this.datos.setCantClaros(Integer.valueOf(linea[0]));
			this.datos.setCantSenderos(Integer.valueOf(linea[1]));
			this.datos.setCantDragones(Integer.valueOf(linea[2]));
			
			linea = bufferReader.readLine().split(" ");
			this.datos.setClaroPrincesa(Integer.valueOf(linea[0])-1);
			this.datos.setClaroPrincipe(Integer.valueOf(linea[1])-1);
			
			linea = bufferReader.readLine().split(" ");
			for(String claroConDragon : linea){
				this.datos.getClarosConDragones().add(Integer.valueOf(claroConDragon)-1);
			}
			
			for(int i=0; i<this.datos.getCantSenderos(); i++){
				linea = bufferReader.readLine().split(" ");
				this.datos.getSenderos().add(
						new Sendero(
								Integer.valueOf(linea[0])-1, 
								Integer.valueOf(linea[1])-1, 
								Integer.valueOf(linea[2])
							)
					);                                                                                                                                                                                                                        
			}
					
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(fileReader!=null)
					fileReader.close();
				if(bufferReader!=null)
					bufferReader.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public void resolver() {
		
		this.matrizGrafo = obtenerMatrizAdyacenciaPonderada();
		
		Dijkstra dijkstra = new Dijkstra(this.matrizGrafo);
		dijkstra.resolver(this.datos.getClaroPrincesa());
		
		Integer[] distanciasAPrincesa = dijkstra.getDistanciasMinimas();
		
		Integer distanciaPrincipe = distanciasAPrincesa[this.datos.getClaroPrincipe()];
		
		if(distanciaPrincipe<=0){
			this.resultado = "NO HAY CAMINO";
		} else {
			
			Boolean principeTieneMenorDistancia=true;
			Iterator<Integer> dragonesIterator = datos.getClarosConDragones().iterator();
			
			while(dragonesIterator.hasNext() && principeTieneMenorDistancia){
				
				Integer distanciaDragon = distanciasAPrincesa[dragonesIterator.next()];
				
				if(distanciaDragon>0 && distanciaDragon<=distanciaPrincipe){
					principeTieneMenorDistancia=false;
				}
			}
			
			if(principeTieneMenorDistancia){
				this.resultado="";
				List<Integer> caminoAPrincesa = dijkstra.obtenerCamino(this.datos.getClaroPrincipe());
				for(Integer claro : caminoAPrincesa){
					this.resultado+=(claro+1)+" ";
				}
			} else {
				this.resultado = "INTERCEPTADO";
			}
			
		}
	}

	private Integer[][] obtenerMatrizAdyacenciaPonderada() {
		Integer[][] matrizGrafo = new Integer[datos.getCantClaros()][datos.getCantClaros()];
		
		for(Sendero sendero : datos.getSenderos()){
			matrizGrafo[sendero.getClaroInicial()][sendero.getClaroFinal()]=sendero.getLargo();
			matrizGrafo[sendero.getClaroFinal()][sendero.getClaroInicial()]=sendero.getLargo();
		}
		
		return matrizGrafo;
	}
	
	public void grabarResultado(final String fileOutPath){
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		try{
			fileWriter = new FileWriter(new File(fileOutPath));
			printWriter = new PrintWriter(fileWriter);
			printWriter.println(this.resultado);
			
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
