package ar.edu.unlam.prograavanzada.grafos.problemas.acortandoelcamino;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class AcortandoElCamino {

	private Integer[][] matrizAdyacenciaYDistancias;
	
	private Integer cantidadBifurcaciones;
	
	private List<Galeria> galeriasCerradas;
	
	public AcortandoElCamino(final String rutaArchivoEntrada){
		FileReader fr = null;
		BufferedReader br = null;
		try{
			
			fr = new FileReader(new File(rutaArchivoEntrada));
			br = new BufferedReader(fr);
			
			String[] linea = br.readLine().split(" ");
			
			this.cantidadBifurcaciones = Integer.valueOf(linea[0]);
			Integer cantidadGaleriasAbiertas = Integer.valueOf(linea[1]);
			Integer cantidadGaleriasCerradas = Integer.valueOf(linea[2]);
			
			this.matrizAdyacenciaYDistancias= new Integer[cantidadBifurcaciones][cantidadBifurcaciones];
			
			for(int i=0; i<cantidadGaleriasAbiertas; i++){
				linea = br.readLine().split(" ");
				
				Galeria galeria = new Galeria(
						Integer.valueOf(linea[0])-1, 
						Integer.valueOf(linea[1])-1,
						Integer.valueOf(linea[2])
					);
				
				this.matrizAdyacenciaYDistancias[galeria.getBifurcacionDesde()][galeria.getBifurcacionHasta()]=galeria.getDistancia();
				this.matrizAdyacenciaYDistancias[galeria.getBifurcacionHasta()][galeria.getBifurcacionDesde()]=galeria.getDistancia();
			}
			
			this.galeriasCerradas = new ArrayList<Galeria>();
			
			for(int i=0; i<cantidadGaleriasCerradas; i++){
				linea = br.readLine().split(" ");
				
				Galeria galeria = new Galeria(
						Integer.valueOf(linea[0])-1, 
						Integer.valueOf(linea[1])-1,
						Integer.valueOf(linea[2])
					);
				
				this.galeriasCerradas.add(galeria);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(fr!=null){
					fr.close();
				}
				if(br!=null){
					br.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void resolver(){
		
		Integer codigoResultado = 1;
		
//		Dijkstra dijkstra = new Dijkstra(this.matrizAdyacenciaYDistancias);
//		dijkstra.resolver(this.cantidadBifurcaciones-1);
//		Integer[] distanciasMinimas = dijkstra.getDistanciasMinimas();
		Integer[] distanciasMinimas = this.resolverDijkstra(this.matrizAdyacenciaYDistancias, this.cantidadBifurcaciones-1);
		
		Integer menorDistancia = distanciasMinimas[0];
		
		Galeria galeriaCerradaAAbrir = null;
		
		for(Galeria galeriaCerrada : this.galeriasCerradas){
			this.matrizAdyacenciaYDistancias[galeriaCerrada.getBifurcacionDesde()][galeriaCerrada.getBifurcacionHasta()]=galeriaCerrada.getDistancia();
			this.matrizAdyacenciaYDistancias[galeriaCerrada.getBifurcacionHasta()][galeriaCerrada.getBifurcacionDesde()]=galeriaCerrada.getDistancia();
			
//			Dijkstra dijkstra = new Dijkstra(this.matrizAdyacenciaYDistancias);
//			dijkstra.resolver(this.cantidadBifurcaciones-1);
//			distanciasMinimas = dijkstra.getDistanciasMinimas();
			distanciasMinimas = this.resolverDijkstra(this.matrizAdyacenciaYDistancias, this.cantidadBifurcaciones-1);
			
			Integer posibleMenorDistanciaConUnaGaleria = distanciasMinimas[0];
			
			if( posibleMenorDistanciaConUnaGaleria<menorDistancia ){
				codigoResultado = 2;
				menorDistancia = posibleMenorDistanciaConUnaGaleria;
				galeriaCerradaAAbrir = galeriaCerrada;
			}
			
			this.matrizAdyacenciaYDistancias[galeriaCerrada.getBifurcacionDesde()][galeriaCerrada.getBifurcacionHasta()]=null;
			this.matrizAdyacenciaYDistancias[galeriaCerrada.getBifurcacionHasta()][galeriaCerrada.getBifurcacionDesde()]=null;
		}
		
		Galeria segundaGaleriaCerradaAAbrir = null;
		
		for(Galeria galeriaCerrada : this.galeriasCerradas){
			this.matrizAdyacenciaYDistancias[galeriaCerrada.getBifurcacionDesde()][galeriaCerrada.getBifurcacionHasta()]=galeriaCerrada.getDistancia();
			this.matrizAdyacenciaYDistancias[galeriaCerrada.getBifurcacionHasta()][galeriaCerrada.getBifurcacionDesde()]=galeriaCerrada.getDistancia();
			
			for(Galeria segundaGaleriaCerrada : this.galeriasCerradas){
				this.matrizAdyacenciaYDistancias[segundaGaleriaCerrada.getBifurcacionDesde()][segundaGaleriaCerrada.getBifurcacionHasta()]=segundaGaleriaCerrada.getDistancia();
				this.matrizAdyacenciaYDistancias[segundaGaleriaCerrada.getBifurcacionHasta()][segundaGaleriaCerrada.getBifurcacionDesde()]=segundaGaleriaCerrada.getDistancia();
				
//				Dijkstra dijkstra = new Dijkstra(this.matrizAdyacenciaYDistancias);
//				dijkstra.resolver(this.cantidadBifurcaciones-1);
//				distanciasMinimas = dijkstra.getDistanciasMinimas();
				distanciasMinimas = this.resolverDijkstra(this.matrizAdyacenciaYDistancias, this.cantidadBifurcaciones-1);
				
				Integer posibleMenorDistanciaConDosGalerias = distanciasMinimas[0];
				
				if( posibleMenorDistanciaConDosGalerias<menorDistancia ){
					codigoResultado = 3;
					menorDistancia = posibleMenorDistanciaConDosGalerias;
					galeriaCerradaAAbrir = galeriaCerrada;
					segundaGaleriaCerradaAAbrir = segundaGaleriaCerrada;
				}
				
				this.matrizAdyacenciaYDistancias[segundaGaleriaCerrada.getBifurcacionDesde()][segundaGaleriaCerrada.getBifurcacionHasta()]=null;
				this.matrizAdyacenciaYDistancias[segundaGaleriaCerrada.getBifurcacionHasta()][segundaGaleriaCerrada.getBifurcacionDesde()]=null;
			}
			
			this.matrizAdyacenciaYDistancias[galeriaCerrada.getBifurcacionDesde()][galeriaCerrada.getBifurcacionHasta()]=null;
			this.matrizAdyacenciaYDistancias[galeriaCerrada.getBifurcacionHasta()][galeriaCerrada.getBifurcacionDesde()]=null;
		}
		
		String respuesta = codigoResultado.toString();
		switch (codigoResultado) {
		case 3:
			respuesta+=" "+(this.galeriasCerradas.indexOf(segundaGaleriaCerradaAAbrir)+1);
		case 2:
			respuesta+=" "+(this.galeriasCerradas.indexOf(galeriaCerradaAAbrir)+1);
		case 1:
			respuesta+=" "+menorDistancia;
			break;
		}
		System.out.println(respuesta);
	}

	private Integer[] resolverDijkstra(Integer[][] matrizAdyacenciaYDistancias, Integer nodoFinal) {
		
		Integer dimension = matrizAdyacenciaYDistancias.length;
		List<Integer> nodosAEvaluar = new ArrayList<Integer>();
		
		for(int i=0; i<dimension; i++){
			nodosAEvaluar.add(i);
		}
		nodosAEvaluar.remove(nodoFinal);
		
		Integer[] distancias = new Integer[dimension];
		distancias[nodoFinal]=0;
		
		Integer nodoActual=nodoFinal;
		
		while(!nodosAEvaluar.isEmpty() && nodoActual!=null){
			
			for(Integer nodoAdyacente : obtenerAdyacentes(matrizAdyacenciaYDistancias, nodoActual)){
				
				if(nodosAEvaluar.contains(nodoAdyacente)){
					
					Integer posibleMenorDistancia = matrizAdyacenciaYDistancias[nodoAdyacente][nodoActual]+distancias[nodoActual];
					
					if(distancias[nodoAdyacente]==null
						|| posibleMenorDistancia<distancias[nodoAdyacente]){
						distancias[nodoAdyacente]=posibleMenorDistancia;
					}
				}
			}
			nodosAEvaluar.remove(nodoActual);
			
			Integer siguienteNodo = null;
			for(Integer nodoRestante : nodosAEvaluar){
				if( distancias[nodoRestante]!=null &&
					( siguienteNodo==null || distancias[nodoRestante]<distancias[siguienteNodo] )	){
					
					siguienteNodo=nodoRestante;
				}
			}
			nodoActual=siguienteNodo;
		}
		return distancias;
	}

	private List<Integer> obtenerAdyacentes(Integer[][] matrizAdyacenciaYDistancias, Integer nodoActual) {
		List<Integer> adyacentes = new ArrayList<Integer>();
		for(int i=0; i<matrizAdyacenciaYDistancias.length; i++){
			if(matrizAdyacenciaYDistancias[nodoActual][i]!=null)
				adyacentes.add(i);
		}
		return adyacentes;
	}
}
