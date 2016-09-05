package peliculas;

	import java.io.*;
	import java.util.*;


	public class Pelicula {
		private ArrayList<Nodo> lista;
		private Grafo grafo;
        private Dijkstra algoritmo;
		
				
		
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
				
	
				
				grafo = new Grafo(cant_nodos,false);
				
				grafo.crearArco(0 , 1, 20);
				grafo.crearArco(0, 2, 10);
				grafo.crearArco(1, 2, 15);
				grafo.crearArco(1, 3, 15);
				grafo.crearArco(1, 4, 35);
				grafo.crearArco(2, 3, 30);
				grafo.crearArco(3, 4, 20);
				grafo.crearArco(3, 5, 30);
				grafo.crearArco(4, 5, 10);
				grafo.crearArco(4, 6, 20);
				grafo.crearArco(5, 6, 10);
				grafo.crearArco(5, 7, 9);
				grafo.crearArco(5, 8,10);
				grafo.crearArco(7, 8, 1);
				algoritmo = new Dijkstra(grafo,0);
				lista = new ArrayList<Nodo>(cant_nodos);
				
				lista = algoritmo.obtenerCamino(cant_nodos-1);
				
				for(int c=0;c<lista.size();c++){
					System.out.println( lista.get(c));
				}
				
				
			
							 
				 
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
		
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			String path="pelicula.in";
			Pelicula p1= new Pelicula(path);
		
			
		}

	}


