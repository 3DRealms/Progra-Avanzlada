package ar.edu.unlam.prograavanzada.grafos.algoritmos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ar.edu.unlam.prograavanzada.grafos.entidades.Arista;

public class Prim {

	private Integer[][] matrizAdyacencia;
	
	private List<Arista> arbolMenorCosto;

	public Prim(Integer[][] matrizAdyacencia){
		this.matrizAdyacencia=matrizAdyacencia;
	}
	
	public void resolver(){
		
		this.arbolMenorCosto = new ArrayList<Arista>();

		Integer cantidadVertices = this.matrizAdyacencia.length;
		
		List<Integer> verticesVisitados = new ArrayList<Integer>();
		Integer primerVertice = new Random().nextInt(cantidadVertices);
		verticesVisitados.add(primerVertice);
		
		List<Integer> verticesRestantes = new ArrayList<Integer>();
		for(int i=0; i<cantidadVertices; i++){
			verticesRestantes.add(i);
		}
		verticesRestantes.remove(primerVertice);
		
		
		while(verticesVisitados.size()<cantidadVertices){

			Arista aristaMenorPeso = null;
			
			for(Integer verticeVisitado : verticesVisitados){
				for(Integer verticeRestante : verticesRestantes){
					
					if(this.matrizAdyacencia[verticeVisitado][verticeRestante]!=null 
						&& this.matrizAdyacencia[verticeVisitado][verticeRestante]>0){
						
						Integer pesoArista = this.matrizAdyacencia[verticeVisitado][verticeRestante];
						
						if(aristaMenorPeso==null || pesoArista<aristaMenorPeso.getPeso()){
							aristaMenorPeso = new Arista(verticeVisitado, verticeRestante, pesoArista);
						}
						
					}
				}
			}
			verticesVisitados.add(aristaMenorPeso.getNodoHasta());
			verticesRestantes.remove(aristaMenorPeso.getNodoHasta());
			
			arbolMenorCosto.add(aristaMenorPeso);
		}
		
	}

	public List<Arista> getArbolMenorCosto() {
		return arbolMenorCosto;
	}
	
}
