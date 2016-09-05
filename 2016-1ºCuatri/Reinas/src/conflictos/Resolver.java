package conflictos;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Resolver {
	
	public static void GrabarArchivoGenerado(int dato) {
		FileWriter fw = null;
		PrintWriter pw = null;
		try{
			
			fw = new FileWriter("conflictos.in");
			pw = new PrintWriter(fw);
			int dimension = dato ;
			int reinas = dato;
			pw.println(dimension+" "+reinas);
			for (int fila = 1 ; fila<=dato ; fila++){
				
				for(int columna=1 ; columna<=dato ; columna++){
				
					pw.println(fila+" "+columna);
				}
			}					
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				if( null != fw ){
					fw.close();
				}
			}	
			catch (Exception e2){
				e2.printStackTrace();
			}
		}
	}
	
	public static void metodoResolver(){
		
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		String linea;
		String[] datos;
		
		int dimension = 0;
		int i = 1;
		Reina reinaActual;
		int [][] tablero = null;
		ArrayList<Reina> reinas = new ArrayList<Reina>();
		
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try{
			
			archivo = new File("conflictos.in");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			linea = br.readLine();
			datos = linea.split(" ");
			dimension = Integer.parseInt( datos[0] );
			tablero = new int[dimension][dimension];
			
			
			while( ( linea = br.readLine() ) != null ){
				
				datos = linea.split(" ");
				reinaActual = new Reina( i, Integer.parseInt(datos[0]), Integer.parseInt(datos[1]) );
				tablero[Integer.parseInt(datos[0])-1][Integer.parseInt(datos[1])-1] = reinaActual.getId();
				reinas.add(reinaActual);
				i++;
				
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		long start_time = System.currentTimeMillis();
		for(int j=0; j<dimension; j++ ){
			
			for( int k=0; k<dimension; k++ ){
				
				if( tablero[j][k] != 0  ){
					/*las reinas estan identificadas en la matriz por su id,
					 * el cual es uno mas que el indice en el que estan en
					 * el array reinas
					 * */
					reinaActual = reinas.get(tablero[j][k]-1); 
					
					int f = reinaActual.getFila()-1;
					int c = reinaActual.getColumna()-1;
				
					//recorrido hacia la izquierda
					do{
						if( c > 0){
							c--;
							if( tablero[f][c] != 0 ){
								reinaActual.getConflictosCon().add( tablero[f][c] );
							}
						}					
					}while( c>0 && tablero[f][c] == 0 );
					
					f = reinaActual.getFila()-1;
					c = reinaActual.getColumna()-1;
					
					//recorrido hacia arriba
					do{
						if(f > 0){
							f--;
							if( tablero[f][c] != 0 ){
								reinaActual.getConflictosCon().add( tablero[f][c] );
							}
						}
					}while( f > 0 && tablero[f][c] == 0);
					
					f = reinaActual.getFila()-1;
					c = reinaActual.getColumna()-1;
					
					//recorrido hacia la derecha
					do{
						if( c < dimension-1 ){
							c++;
							if( tablero[f][c] != 0 ){
								reinaActual.getConflictosCon().add( tablero[f][c] );
							}
						}
					}while( c < dimension-1 && tablero[f][c] == 0);
					
					f = reinaActual.getFila()-1;
					c = reinaActual.getColumna()-1;
					
					//recorrido hacia abajo
					do{
						if(f < dimension-1){
							f++;
							if( tablero[f][c] != 0 ){
								reinaActual.getConflictosCon().add( tablero[f][c] );
							}
						}
					}while( f < dimension-1 && tablero[f][c] == 0);
					
					f = reinaActual.getFila()-1;
					c = reinaActual.getColumna()-1;
					//recorrido diagonal superior izquierda
					do{
						if( f>0 && c>0 ){
							f--;
							c--;
							if( tablero[f][c] != 0 ){
								reinaActual.getConflictosCon().add( tablero[f][c] );
							}
						}
					}while( f>0 && c>0 && tablero[f][c] == 0);
					
					f = reinaActual.getFila()-1;
					c = reinaActual.getColumna()-1;
					//recorrido diagonal superior derecha
					do{
						if( f>0 && c<dimension-1 ){
							f--;
							c++;
							if( tablero[f][c] != 0 ){
								reinaActual.getConflictosCon().add( tablero[f][c] );
							}
						}
					}while( f>0 && c<dimension-1 && tablero[f][c] == 0);
					
					f = reinaActual.getFila()-1;
					c = reinaActual.getColumna()-1;
					//recorrido diagonal inferior izquierda
					do{
						if( f<dimension-1 && c>0 ){
							f++;
							c--;
							if( tablero[f][c] != 0 ){
								reinaActual.getConflictosCon().add( tablero[f][c] );
							}
						}
					}while( f<dimension-1 && c>0 && tablero[f][c] == 0);
					
					f = reinaActual.getFila()-1;
					c = reinaActual.getColumna()-1;
					//recorrido diagonal inferior derecha
					do{
						if( f<dimension-1 && c<dimension-1 ){
							f++;
							c++;
							if( tablero[f][c] != 0 ){
								reinaActual.getConflictosCon().add( tablero[f][c] );
							}
						}
					}while( f<dimension-1 && c<dimension-1 && tablero[f][c] == 0);
					
				}
				
			}
		}
		long end_time = System.currentTimeMillis();
		System.out.println("Tiempo en ejecutarse: "+(end_time-start_time));
		
		try{
			fw = new FileWriter("conflictos.out");
			pw = new PrintWriter(fw);
			
			for(int v=0; v<reinas.size(); v++){
				String raw = "";
				Collections.sort(reinas.get(v).getConflictosCon());
				for(int w=0; w<reinas.get(v).getConflictosCon().size(); w++ ){
					raw+=reinas.get(v).getConflictosCon().get(w)+" " ;
				}
				pw.println(reinas.get(v).getConflictosCon().size()+" "+raw);
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if( null != fw ){
					fw.close();
				}
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
	}
}
