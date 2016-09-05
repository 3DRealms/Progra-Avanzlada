package calles.resolucion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import calles.clasesmodelo.Adyacencia;
import calles.clasesmodelo.Grafo;
import calles.utils.FileUtils;

public class InterpreteCalles {

	List<Adyacencia> todasLasCalles;
	int cantidadCalles;
	
	
	public Grafo leerYGenerarGrafoDeCalles(String path){
		
		
		Iterator<String> archivoIt = FileUtils.leerArchivo(path).iterator();
		
		// Leo los datos de la primera linea del archivo
		String primeraLinea = archivoIt.next(); 
		String[] datosPrimeraLinea = primeraLinea.split(" ");
		
		int cantidadEsquinas = Integer.parseInt(datosPrimeraLinea[0]);
		int esquinaColectivo = Integer.parseInt(datosPrimeraLinea[1]) -1;
		int esquinaEscuela = Integer.parseInt(datosPrimeraLinea[2]) -1;
		
		// Leo los datos de la segunda linea del archivo
		String segundaLinea = archivoIt.next();
		
		cantidadCalles = Integer.parseInt(segundaLinea);
		
		// Genero el grafo con las esquinas(Nodos), y luego las calles(adyacencias)
		Grafo grafo = new Grafo(cantidadEsquinas, esquinaColectivo, esquinaEscuela);
		
		todasLasCalles = new ArrayList<Adyacencia>();
		
		
		while (archivoIt.hasNext()){
			String calleIt = archivoIt.next();
			
			String[] datosCalle = calleIt.split(" ");
			
			int nodoDesde = Integer.parseInt(datosCalle[0])-1;
			int nodoHasta = Integer.parseInt(datosCalle[1])-1;
			int costo = Integer.parseInt(datosCalle[2]);
			
			Adyacencia adyacenciaNueva = new Adyacencia(nodoDesde, nodoHasta, costo);
			grafo.agregarAdyacencia(adyacenciaNueva);
			todasLasCalles.add(adyacenciaNueva);
		}
		
		return grafo;
	}
	
	public int getCantidadCalles(){
		return cantidadCalles;
	}

	public List<Adyacencia> getTodasLasCalles(){
		return todasLasCalles;
	}
	
	public Adyacencia obtenerCalle(int nroCalle){
		if(todasLasCalles.isEmpty())
			return null;
		
		return	todasLasCalles.get(nroCalle);
	}
}
