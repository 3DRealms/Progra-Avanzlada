package ar.edu.unlam.prograavanzada.grafos.problemas.arbol;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Arbol {

	private Integer cantidadNodos;
	private Integer cantidadArcos;
	
	private NodoArbol[] nodosArbol;
	
	private ArrayList<Integer> raices;
	private ArrayList<Integer> masDeUnPredecesor;
	private ArrayList<Integer> nodosFueraDeArbol;
	private Boolean reglaUno;
	private Boolean reglaDos;
	private Boolean reglaTres;
	
	public Arbol (final String archivoEntrada){
		FileReader fr = null;
		BufferedReader br = null;
		try{
			fr = new FileReader(new File(archivoEntrada));
			br = new BufferedReader(fr);
			
			String[] linea = br.readLine().split(" ");
			
			this.cantidadNodos = Integer.valueOf(linea[0]);
			this.cantidadArcos = Integer.valueOf(linea[1]);
			
			this.nodosArbol = new NodoArbol[this.cantidadNodos];
			
			for(int i=0; i<this.cantidadArcos; i++){
				linea = br.readLine().split(" ");
				Integer nodoOrigen = Integer.valueOf(linea[0])-1;
				Integer nodoDestino = Integer.valueOf(linea[1])-1;
				
				//Agrego los nodos si no pertenecian al arbol
				if(this.nodosArbol[nodoOrigen]==null){
					this.nodosArbol[nodoOrigen]=new NodoArbol(nodoOrigen);
				}
				if(this.nodosArbol[nodoDestino]==null){
					this.nodosArbol[nodoDestino]=new NodoArbol(nodoDestino);
				}
				
				//agrego destino como precedido por origen
				this.nodosArbol[nodoOrigen]
					.getPrecedidos().add(nodoDestino);
				
				//agrego origen como predecesor de destino
				this.nodosArbol[nodoDestino]
						.getPredecesores().add(nodoOrigen);
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
		
		this.raices = new ArrayList<Integer>();
		this.masDeUnPredecesor = new ArrayList<Integer>();
		
		for(Integer nroNodo=0; nroNodo<this.nodosArbol.length; nroNodo++){
			
			List<Integer> predecesores = this.nodosArbol[nroNodo].getPredecesores();
			if(predecesores.isEmpty()){
				this.raices.add(nroNodo);
			} else if(predecesores.size()>1){
				this.masDeUnPredecesor.add(nroNodo);
			}
			
		}
		
		this.reglaUno=raices.size()==1;
		
		this.reglaDos=this.masDeUnPredecesor.isEmpty();
		
		if(this.reglaUno){
			this.reglaTres=this.hayCaminos(raices.get(0));
		} else {
			this.reglaTres=false;
		}
	}
	
	private Boolean hayCaminos(Integer raiz) {
		
		List<Integer> sinVisitar = new ArrayList<Integer>();
		for(Integer nroNodo=0; nroNodo<this.cantidadNodos; nroNodo++){
			sinVisitar.add(nroNodo);
		}
		List<Integer> visitados = new ArrayList<Integer>();
		visitados.add(raiz);
		sinVisitar.remove(raiz);
		
		Boolean todosPertenecen = true;
		while(!sinVisitar.isEmpty() && todosPertenecen){
			
			Set<Integer> pertenecen = new HashSet<Integer>();
			
			for(Integer noVisitado : sinVisitar){
				for(Integer visitado : visitados){
					if(this.nodosArbol[visitado].getPrecedidos().contains(noVisitado)){
						pertenecen.add(noVisitado);
					}
				}
			}
			
			if(pertenecen.isEmpty()){
				todosPertenecen=false;
			} else {
				sinVisitar.removeAll(pertenecen);
				visitados.addAll(pertenecen);
			}
		}
		
		if(todosPertenecen){
			return true;
		} else {
			this.nodosFueraDeArbol=new ArrayList<Integer>();
			this.nodosFueraDeArbol.addAll(sinVisitar);
			return false;
		}
	}

	public void grabarResultado(final String archivoSalida){
		FileWriter fw = null;
		PrintWriter pw = null;
		try{
			fw = new FileWriter(new File(archivoSalida));
			pw = new PrintWriter(fw);
			
			if(this.reglaUno && this.reglaDos && this.reglaTres){
				pw.println("Si "+(this.raices.get(0)+1));
			} else {
				pw.println("No");
				
				if(this.reglaUno){
					pw.println(this.raices.get(0)+1);
				} else if(this.raices.isEmpty()){
					pw.println("0");
				} else {
					String raicesStr = "";
					for(Integer raiz : this.raices){
						raicesStr = String.format("%s%d ", 
								raicesStr, raiz+1);
					}
					pw.println(raicesStr);
				}
				
				if(this.reglaDos){
					pw.println("0");
				} else {
					String masDeUnPredecesorStr = "";
					for(Integer nodoReglaDos : this.masDeUnPredecesor){
						masDeUnPredecesorStr = String.format("%s%d ", 
								masDeUnPredecesorStr, nodoReglaDos+1);
					}
					pw.println(masDeUnPredecesorStr);
				}
				
				if(this.reglaTres || !this.reglaUno){
					pw.println("0");
				} else {
					String fueraDeArbolStr = "";
					for(Integer nodoFueraDeArbol : this.nodosFueraDeArbol){
						fueraDeArbolStr = String.format("%s%d ", 
								fueraDeArbolStr, nodoFueraDeArbol+1);
					}
					pw.println(fueraDeArbolStr);
				}
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
