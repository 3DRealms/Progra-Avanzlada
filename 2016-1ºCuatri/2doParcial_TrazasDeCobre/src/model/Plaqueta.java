package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Plaqueta {
	private int cantLeds;
	private int cantControl;
	
	List<Conexion> conexiones;
	Punto puntos;
	Punto first;
	String secuencia;
	
	public Plaqueta(File entrada){
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(entrada);
			br = new BufferedReader(fr);
			
			// leo la primer linea con la cantidad de puntos pero no la utilizo para nada
			br.readLine(); 
			
			secuencia = br.readLine();
			
			// Cargo la cola con implementación de lista circular
	        puntos = new Punto();
	        Punto primerPunto = null;
	        int i = 1;
	        for (char punto : secuencia.toCharArray()) {
	        	if (punto == 'L') {
					cantLeds++;
				}else{
					cantControl++;
				}
	            Punto node = new Punto(punto, i, puntos);
	            if (i == 1) {
	                primerPunto = node;
	            }
	            puntos = node;
	            i++;
	        }
	        primerPunto.setSiguiente(puntos);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void crearConexiones(){
		if (cantLeds > 0 && cantControl > 0) {
			int laps = 0;
			conexiones = new ArrayList<Conexion>();
	        while (laps < secuencia.length()) {
	            
	        	// Ir al primer CONTROL encontrado de atras hacia adelante
	            while (puntos.isLed()) {
	                puntos = puntos.getSiguiente();
	            }
	        	
	        	Punto match = null;
	            Punto aux = puntos.getSiguiente();
	            
	            // Mientras haya siguiente (el componente no sea él mismo)...
	            while (!puntos.equals(aux)) {
	                if (aux.isLed()) {
	                    // ...es una posible conexión
	                    match = aux;
	                }
	                aux = aux.getSiguiente();
	            }
	            
	            // Si ninguno de los dos componentes (Control y LED) fue utilizado previamente...
	            if (puntos.isNotUsed() && match != null && match.isNotUsed()) {
	            	conexiones.add(new Conexion(match.getOrden(),puntos.getOrden()));
	                puntos.use();
	                match.use();
	            }
	            laps++;
	            puntos = puntos.getSiguiente();
	        }
		}

	}
	
	public void escribirResultad(File salida){
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter(salida);
			pw = new PrintWriter(fw);

			pw.println(conexiones.size());
			
			ListIterator<Conexion> iterador = conexiones.listIterator(conexiones.size());
			
			while(iterador.hasPrevious()){
				pw.println(iterador.previous());
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fw) {
					fw.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
