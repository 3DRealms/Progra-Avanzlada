package pelicula;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;



public class Pelicula {


	private Integer Matriz [][];
	private boolean Visto[];
	private int nodos;
	private Cinta cinta;
	private Integer Distancias[];
	private final int INF=Integer.MAX_VALUE;
	private int Inicio;
	private int previo[]; 

	
	public Pelicula(String path){
		
		
		File archivo=null;
		FileReader fr=null;
		BufferedReader br=null;
		
	try {
			archivo=new File(path);
			fr= new FileReader(archivo);
			br= new BufferedReader(fr);
			
			String linea=br.readLine();
			String line[]=linea.split(" ");
			
			int cant_nodos=Integer.parseInt(line[0]);
			this.nodos=cant_nodos;
			
			int escena_fin=Integer.parseInt(line[1]);

			Stack <Cinta> peli= new Stack<Cinta>();
			
			for(int i=0;i<nodos;i++){
				linea=br.readLine();
				line=linea.split(" ");
				cinta=new Cinta(Integer.parseInt(line[0]),Integer.parseInt(line[1]),Integer.parseInt(line[2]));
				peli.add(cinta);
			}
	
			Matriz = new Integer[nodos][nodos];
			Distancias = new Integer[nodos];
			Visto = new boolean[nodos];
			previo=new int[nodos];
			
			
			for(int i=0; i< nodos; i++){
				Visto[i] = false;
				previo[ i ] = 0;
				for(int j=0; j < nodos ; j++){
					Matriz[i][j]= 0;
					Matriz[j][i]= 0;
				}					
			}
			

			for(int i = 0; i < nodos; i++){
				 cinta=peli.remove(0);
				 for(int j=0;j<peli.size();j++){
					 if(cinta.getFin()>peli.get(j).getInicio() && cinta.getFin()!=escena_fin &&cinta.getFin()<peli.get(j).getFin()) {
							Matriz[cinta.getNodo()-1][ peli.get(j).getNodo()-1]=cinta.getFin()-peli.get(j).getInicio()+1;
							Matriz[peli.get(j).getNodo()-1][ cinta.getNodo()-1]=cinta.getFin()-peli.get(j).getInicio()+1;
					 }
					
					 if(cinta.getFin()==peli.get(j).getInicio() && cinta.getFin()!=escena_fin){
						 Matriz[cinta.getNodo()-1][ peli.get(j).getNodo()-1]= 1;
						Matriz[ peli.get(j).getNodo()-1][cinta.getNodo()-1]= 1;
						  
					 }
						
				 }
		
			}			 
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Dijkstra(){
		
		
		
		for(int i = 0 ; i < nodos ; i++){
			if(noHayAdyacencia(i))
				Distancias[i] = INF;
			else                                                                 
				Distancias[i] = costo(Inicio,i);                                 
				
			}
		
		Distancias[Inicio] = 0;
		Visto[Inicio] = true;
		
		while(noEstanVistosTodos()){
			//minima arista
			int v = minimo(); 
			Visto[v] = true;
			
			for(int i = 0; i < nodos ; i++){
				if(adyacenciaNoVista(v,i))
					if(Distancias[i] > (Distancias[v] + costo(v,i))){
						Distancias[i] = Distancias[v] + costo(v,i);
						  previo[i] = v;
					}
			}  			
		}
	}
	
	
	public boolean noHayAdyacencia(int i) {
		if (Inicio != i && Matriz[Inicio][i] == 0)
			return true;
		return false;
	}

	public Integer costo(int a, int i) {
		return Matriz[a][i];
	}
	
	
	public boolean noEstanVistosTodos() {
		int cont = 0;
		for (int i = 0; i < nodos; i++)
			if (Visto[i] == true)
				cont++;
		if (cont == nodos)
			return false;
		return true;
	}
	
	
	private int minimo() {
		int s = 0, arista = 0;
		Integer min = 0;
		for (int i = 0; i < nodos; i++) {
			if ((Distancias[i] <= min || s == 0) && Visto[i] == false) {
				s = 1;
				min = Distancias[i];
				arista = i;
			}
		}
		return arista;
	}
	
	
	public boolean adyacenciaNoVista(int v, int i) {
		if (v != i && Matriz[v][i] != 0 && Visto[i] == false)
			return true;
		return false;
	}

	public void mostrarMatriz() {
		for (int i = 0; i < nodos; i++) {
			for (int j = 0; j < nodos; j++) {
				System.out.print(Matriz[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	public void mostrarDistancias() {
		for (int i = 0; i < nodos; i++) {
			{
				System.out.print(Distancias[i] + " ");
			}
			
		}
		System.out.println();
	}
	
	public ArrayList<Integer> obtenerCamino (int nodoDestino){
	      ArrayList<Integer> camino = new ArrayList<Integer>();	      
	      if( nodoDestino == this.previo[nodoDestino]){
	    	  camino.add(nodoDestino);
	    	  return camino;
	      }
	      
	      int nodoDestinoTemp = nodoDestino;
		  while (nodoDestinoTemp != this.Inicio) 		  
		  {		  
			  camino.add(nodoDestinoTemp);		    	
			  nodoDestinoTemp = this.previo[nodoDestinoTemp];		     
		  }		  
		  camino.add(Inicio);		 
		  return camino;	   
	   }


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path="pelicula.in";
		Pelicula p1= new Pelicula(path);
		
	//p1.mostrarMatriz();
	
	//LOS NODOS VAN DE 0 a 8	
	p1.Inicio=0;
	p1.Dijkstra();
	p1.mostrarDistancias();
	ArrayList<Integer>secuencia=new ArrayList<Integer>();
	secuencia=p1.obtenerCamino(8);
	
	
	for(int c=0;c<secuencia.size();c++){
		System.out.print( secuencia.get(c)+1+" ");
	}
	
	

	

		
	}

}
