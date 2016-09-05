package red;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Subterraneos {
	
	public int subtes[][];
	public int salida;
	public int llegada;
	
	public int cantLineas;
	public int estaciones;
	
	public int conexiones[][];
	ArrayList<Integer> lineas;
	
	public String lineasRecorridas;
	public int cantLineasRecorridas;

	public void camino(){
		//conexiones
		lineas = new ArrayList<Integer>();
		conexiones = new int[cantLineas][cantLineas];
		for (int i = 0; i < cantLineas; i++){
			lineas.add(new Integer(i));
			for (int k = 0; k < cantLineas; k++) {
				if (i == k)
					continue;
				for (int j = 0; j < estaciones; j++) 
					if (subtes[i][j]==1 && subtes[k][j]==1) {
						conexiones[i][k] = 1;
				}
				}
			}
		//busqueda estaciones partida
		int lineaSalida=0;
		for (int i = 0; i < cantLineas; i++){
			if (subtes[i][salida-1]==1) {
				lineaSalida = i;
				break;
			}
		}	
			
		//busqueda estaciones llegada
		int lineaLlegada=0;
		for (int i = 0; i < cantLineas; i++)
			if (subtes[i][llegada - 1] == 1) {
				lineaLlegada = i;
				break;
			}
		
		this.busquedaCaminoDikjstra(lineas.get(lineaSalida), lineas.get(lineaLlegada));
		if (lineaSalida == lineaLlegada) {
			cantLineasRecorridas = 1;
			lineasRecorridas = (lineaSalida + 1) + " ";
		} else if (conexiones[lineaSalida][lineaLlegada] == 1) {
			cantLineasRecorridas = 1;
			lineasRecorridas = (lineaSalida + 1) +" "+ (lineaLlegada + 1);
		} else {

			lineasRecorridas = (lineaSalida + 1) + " ";
			cantLineasRecorridas = 1;
			lineasRecorridas = this.busquedaCaminoDikjstra(lineaSalida, lineaLlegada);

		}
	}
	
	
	private String busquedaCaminoDikjstra(Integer linea, Integer llegada) {
		ArrayList<Intersecciones> lineasVistas = new ArrayList<Intersecciones>();
		PriorityQueue<Intersecciones> lineasPendientes = new PriorityQueue<Intersecciones>();
		// agrego la primer interseccion
		lineasPendientes.add(new Intersecciones(linea, 0, (linea+1)+" "));
		while (!lineasPendientes.isEmpty()) {
			Intersecciones inter = lineasPendientes.poll();
			// agrego la linea a las ya vistas
			lineasVistas.add(inter);
			for (int i = 0; i < this.cantLineas; i++) {
				// para cada nodo adyacente
				if (conexiones[inter.linea.intValue()][i] == 1) {
					int distancia = conexiones[inter.linea.intValue()][i];
					Intersecciones nuevo = new Intersecciones(
							this.lineas.get(i), inter.distancia + distancia, inter.pasaPor +
							(this.lineas.get(i) + 1) + " ");
					// si ya esta en los nodos procesados se lo saltea
					if (lineasVistas.contains(nuevo))
						continue;
					// si no esta en la cola lo agrega
					if (!lineasPendientes.contains(nuevo)) {
						lineasPendientes.add(nuevo);
						continue;
					}
					// actualizo
					for (Intersecciones x : lineasPendientes) {
						if (x.linea.equals(nuevo.linea)
								&& x.distancia > nuevo.distancia) {
							lineasPendientes.remove(x);
							lineasPendientes.add(nuevo);
							break;
						}
					}
				}
			}
		}
		return this.buscarSalidaLLegada(lineasVistas, llegada) ;
	}
	
	
	private String buscarSalidaLLegada(ArrayList<Intersecciones> inter,
			Integer llegada) {
		for (Intersecciones x : inter)
			if (x.linea.equals(llegada))
				return x.pasaPor;
		return "";
	}
}
