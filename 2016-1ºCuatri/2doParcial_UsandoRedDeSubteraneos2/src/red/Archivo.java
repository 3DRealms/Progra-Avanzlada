package red;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;


public class Archivo {
	public String entrada;
	public String salida;

	public Archivo(String entrada, String salida) {
		this.entrada = entrada;
		this.salida = salida;
	}

	public Subterraneos leer(Subterraneos subte) {
		File file;
		FileReader fr = null;
		BufferedReader br = null;
		String[] datos;
		subte = new Subterraneos();
		try {
			file = new File(entrada);
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			
			datos = br.readLine().split(" ");
			//inicializa las lineas y las estaciones
			int lineas = Integer.parseInt(datos[0]);
			int estaciones = Integer.parseInt(datos[1]);
			
			subte.cantLineas = lineas;
			subte.estaciones = estaciones;
			
			subte.subtes = new int[lineas][estaciones];
			
			//inicializo en cero
			for(int i = 0; i < lineas;i++){
				for(int j = 0; j < estaciones;j++){
					subte.subtes[i][j]= Integer.MAX_VALUE;
				}
			}
			for(int i = 0; i < lineas;i++){
				//recorre las lineas
				datos = br.readLine().split(" ");
				for(int j = 1; j <= Integer.parseInt(datos[0]);j++){
					//recorre las estaciones
					subte.subtes[i][Integer.parseInt(datos[j])-1]= 1;
				}
			}
			datos = br.readLine().split(" ");
			subte.salida = Integer.parseInt(datos[0]);
			subte.llegada = Integer.parseInt(datos[1]);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null)
					fr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return subte;
	}
	
	public void guardar(Subterraneos subte){
		FileWriter fw = null;
		PrintWriter pw = null;
		try{
			fw = new FileWriter(this.salida);
			pw = new PrintWriter(fw);
			
			pw.println(subte.cantLineasRecorridas);
			//Dijstra est amal tira uno siempre
			pw.println(subte.lineasRecorridas);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (fw != null)
					fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}