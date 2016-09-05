package ar.edu.unlam.prograavanzada.grafos.problemas.conexionesenred;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConexionesEnRed {

	List<SolicitudRedes> solicitudes;
	
	HashMap<Integer, Set<Integer>> adyacencias;
	
	List<Boolean> respuestas;
	
	public ConexionesEnRed(final String pathEntrada){
		FileReader fr = null;
		BufferedReader br = null;
		try{
			
			fr = new FileReader(new File(pathEntrada));
			br = new BufferedReader(fr);
			
			this.solicitudes = new ArrayList<SolicitudRedes>();
			
			String[] linea = br.readLine().split(" ");
			while(!linea[0].equals("F")){
				this.solicitudes.add(
						new SolicitudRedes(
								linea[0],
								Integer.valueOf(linea[1]),
								Integer.valueOf(linea[2])
							)
					);
				linea = br.readLine().split(" ");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(fr!=null)
					fr.close();
				if(br!=null)
					br.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void resolver(){
		this.respuestas = new ArrayList<Boolean>();
		this.adyacencias = new HashMap<Integer, Set<Integer>>();
		
		for(SolicitudRedes solicitud : this.solicitudes){
			
			// Reporte de nueva conexion
			if(solicitud.getTipo().equals("C")){
				
				// Si las PC son nuevas, se agregan al mapa de adyacencia
				if(!this.adyacencias.containsKey(solicitud.getPcDesde())){
					this.adyacencias.put(solicitud.getPcDesde(), new HashSet<Integer>());
				}
				if(!this.adyacencias.containsKey(solicitud.getPcHasta())){
					this.adyacencias.put(solicitud.getPcHasta(), new HashSet<Integer>());
				}
				
				// Se agrega a cualquier pc preexistente que contengan una de las pc conectadas, 
				// la relacion bidireccional con la otra pc conectada
				for(Integer pc : this.adyacencias.keySet()){
					if(this.adyacencias.get(pc).contains(solicitud.getPcDesde())){
						this.adyacencias.get(pc).add(solicitud.getPcHasta());
						this.adyacencias.get(solicitud.getPcHasta()).add(pc);
						
					} else if(this.adyacencias.get(pc).contains(solicitud.getPcHasta())){
						this.adyacencias.get(pc).add(solicitud.getPcDesde());
						this.adyacencias.get(solicitud.getPcDesde()).add(pc);
					}
				}
				
				// Se agrega al mapa la adyacencia entre las pc de la nueva conexion
				this.adyacencias.get(solicitud.getPcDesde()).add(solicitud.getPcHasta());
				this.adyacencias.get(solicitud.getPcHasta()).add(solicitud.getPcDesde());
				
			} else if (solicitud.getTipo().equals("P")){
				
				// Si existe una de las pc en el mapa de adyacencia y contiene a la otra, entonces estan conectdas
				if( this.adyacencias.containsKey(solicitud.getPcDesde()) 
					&& this.adyacencias.get(solicitud.getPcDesde()).contains(solicitud.getPcHasta())){
					this.respuestas.add(true);
				} else {
					this.respuestas.add(false);
				}
			}
		}
		
	}

	public void grabar(final String pathSalida){
		FileWriter fw = null;
		PrintWriter pw = null;
		try{
			fw = new FileWriter(new File(pathSalida));
			pw = new PrintWriter(fw);
			
			for(Boolean respuesta : this.respuestas){
				pw.println(respuesta ? "S" : "N");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(fw!=null)
					fw.close();
				if(pw!=null)
					pw.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
