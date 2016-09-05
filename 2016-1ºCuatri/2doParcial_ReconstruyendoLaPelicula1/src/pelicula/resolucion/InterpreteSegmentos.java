package pelicula.resolucion;

import java.util.Iterator;
import java.util.List;

import pelicula.clasesmodelo.Adyacencia;
import pelicula.clasesmodelo.Grafo;
import pelicula.clasesmodelo.Nodo;
import pelicula.utils.FileUtils;

public class InterpreteSegmentos {

	
	public static Grafo leerYGenerarGrafoSegmentos(String path){
		List<String> fileSegmentos = FileUtils.leerArchivo(path);
		
		Iterator<String> iSegmentos = fileSegmentos.iterator();
		
		
		String primeraLinea = iSegmentos.next();
		
		String[] camposPrimeraLinea = primeraLinea.split(" ");
		
		int cantSegmentos = Integer.parseInt(camposPrimeraLinea[0]);
		int escenaFinal = Integer.parseInt(camposPrimeraLinea[1]);
		
		Grafo grafo = new Grafo(cantSegmentos, escenaFinal);

		// Cargo los nodos(Segmentos) al grafo
		while(iSegmentos.hasNext()){
			String lineaSegmento = iSegmentos.next();
			String[] camposLineaSegmento = lineaSegmento.split(" ");
			
			Nodo segmento = new Nodo(Integer.parseInt(camposLineaSegmento[0])-1, Integer.parseInt(camposLineaSegmento[1]), Integer.parseInt(camposLineaSegmento[2]));
			
			grafo.agregarNodo(segmento);
		}
		
		
		
		// Recorro el grafo evaluando costos para generar adyacencias
		for(int i=0;i<cantSegmentos;i++){
			Nodo segmentoI = grafo.obtenerNodo(i);
			for(int j=0; j<cantSegmentos; j++){
				Nodo segmentoJ = grafo.obtenerNodo(j);	
				
				if(segmentoI.contenidoEn(segmentoJ)){
					Adyacencia adyacenciaNueva = new Adyacencia(segmentoI.getNroSegmento(), segmentoJ.getNroSegmento(), costoEntre(segmentoI, segmentoJ));
					grafo.agregarAdyacencia(i, j, adyacenciaNueva);
				}
				
			}
		}
		
		return grafo;
	}
	
	
	private static int costoEntre(Nodo segmento1, Nodo segmento2){
		if(segmento1.getEscenaHasta() == segmento2.getEscenaDesde()){
			return 1;
		}
		return (segmento1.getEscenaHasta() - segmento2.getEscenaDesde()) + 1 ;
	}
	
}
