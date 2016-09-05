package calles.resolucion;

import java.util.ArrayList;
import java.util.List;

import calles.clasesmodelo.Adyacencia;
import calles.clasesmodelo.Grafo;
import calles.resolucion.Dijsktra.ResultadoDijkstra;
import calles.utils.FileUtils;

public class CallesRunner {

	public static void main(String[] args) {

		System.out.println("CORRIENDO EL CASO: " + args[0]);
		
		List<String> salida = new ArrayList();
		
		InterpreteCalles interprete = new InterpreteCalles();
		
		Grafo grafo = interprete.leerYGenerarGrafoDeCalles(args[0]);
		
		ResultadoDijkstra resultado = Dijsktra.analizarDistancias(grafo, grafo.obtenerNodoEsquinaOrigenColectivo());
		Integer costoOriginal =  resultado.getDistancias().get(grafo.obtenerNodoEsquinaEscuela());
		
		if(costoOriginal.equals(Integer.MAX_VALUE)){
			// Cargo en la salida el costo del camino mas corto original
			salida.add("NO HAY CAMINO");
			FileUtils.escribirArchivo(args[1], salida);
			return;
		}else{
			// Cargo en la salida el costo del camino mas corto original
			salida.add(""+costoOriginal);
		}
		
		
//		System.out.println(resultado.getDistancias().get(grafo.obtenerNodoEsquinaEscuela()));
		
		// Recorro cada calle, y pruebo caminos distintos
		int nroCalleMenor = -1;
		Integer costoCalleMenor = costoOriginal;
		
		for (int i=0; i < interprete.getCantidadCalles();i++){
			Adyacencia calle = interprete.obtenerCalle(i);

			// Invierto adyacencia iterada
			grafo.invertirAdyacencia(calle);
			
			ResultadoDijkstra resultadoCalle = Dijsktra.analizarDistancias(grafo, grafo.obtenerNodoEsquinaOrigenColectivo());	
			
			Integer costoCalleIt = resultadoCalle.getDistancias().get(grafo.obtenerNodoEsquinaEscuela());
			
			if( ( costoCalleIt>0 ) && (costoCalleIt < costoCalleMenor)){
				nroCalleMenor = i;
				costoCalleMenor = costoCalleIt;
			}
			
			// Vuelvo a estado normal
			grafo.invertirAdyacencia(grafo.obtenerAdyacencia(calle.getHasta(), calle.getDesde()));
		}
		
		if(nroCalleMenor == -1){
			salida.add("NO ES POSIBLE MEJORAR");
		}else{
			salida.add(""+costoCalleMenor);
			salida.add(""+(nroCalleMenor+1));
		}
		
		
		FileUtils.escribirArchivo(args[1], salida);
		
	}

}
