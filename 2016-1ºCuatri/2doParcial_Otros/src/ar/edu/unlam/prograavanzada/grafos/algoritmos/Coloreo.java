package ar.edu.unlam.prograavanzada.grafos.algoritmos;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ar.edu.unlam.prograavanzada.grafos.entidades.Grafo;
import ar.edu.unlam.prograavanzada.grafos.entidades.Nodo;

/**
 * @author Nicolas
 * O(n^3)
 */
public class Coloreo {

	public static void colorearSecuencialAleatorio(Grafo g){
		Collections.shuffle(g.getNodos());
		Coloreo.colorear(g);
	}
	
	public static void colorearMatula(Grafo g){
		Collections.sort(g.getNodos(), new Comparator<Nodo>() {
			@Override
			public int compare(Nodo nodo1, Nodo nodo2) { //Menor a mayor
				return nodo1.getGrado() - nodo2.getGrado();
			}
		});
		Coloreo.colorear(g);
	}
	
	public static void colorearWelshPowell(Grafo g){
		Collections.sort(g.getNodos(), new Comparator<Nodo>() {
			@Override
			public int compare(Nodo nodo1, Nodo nodo2) { //Mayor a menor
				return nodo2.getGrado() - nodo1.getGrado();
			}
		});
		Coloreo.colorear(g);
	}
	
	private static void colorear(Grafo g){
		
		List<Nodo> nodos = g.getNodos();
		
		int cantidadNodos = nodos.size();
		
		int color=1, nodosColoreados=0, indiceNodo=0;
		
		while (nodosColoreados<cantidadNodos){
			while (nodosColoreados<cantidadNodos && indiceNodo<cantidadNodos){
				
				if (nodos.get(indiceNodo).getColor()==0 && puedoColorear(g.getMatriz(), nodos, indiceNodo, color)){
					nodos.get(indiceNodo).setColor(color);
					nodosColoreados++;
				}
				indiceNodo++;
			}
			color++;
			indiceNodo=0;
		}
		
		g.setCantidadColores(color-1);
	}
	
	private static boolean puedoColorear(int[][] matriz, List<Nodo> nodos, int indiceNodoActual, int color) {
		
		Boolean puedoColorear = true;
		Integer numeroNodoActual = nodos.get(indiceNodoActual).getNumero(); //se obtiene el numero de los nodos por indice debido al desordenamiento
		
        for (int i = 0; i < matriz.length && puedoColorear; i++) {
        	
            if ( matriz[numeroNodoActual][nodos.get(i).getNumero()] > 0 //es adyacente
            	 && nodos.get(i).getColor()==color ) {
            	
				puedoColorear = false;
            }
        }
        return puedoColorear;
    }
	
}
