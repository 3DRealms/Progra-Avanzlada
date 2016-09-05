package redEmpresarial;

import grafo.BFS;
import grafo.GrafoNDNP;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import oia.EjercicioOIA;

public class RedEmpresarial extends EjercicioOIA {
	private int cantConexiones;
	private int cantPersonas;
	private Map<String, Integer> nombreIDNodo = new HashMap<String, Integer>();
	private List<String> personas = new ArrayList<String>();
	private GrafoNDNP grafo;
	private Set<String> personasResultado;
	private int distMax;
	
	public RedEmpresarial(File entrada, File salida) {
		super(entrada, salida);
		
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(entrada);
			br = new BufferedReader(fr);
			String linea;
			String[] datos;
			linea = br.readLine();
			cantConexiones = Integer.parseInt(linea);
			int []nodosOrigen = new int[cantConexiones];
			int []nodosDestino = new int[cantConexiones];
			
			for(int i = 0; i < cantConexiones; i++) {
				linea = br.readLine();
				datos = linea.split(" ");
				
				
				if(!personas.contains(datos[0]))
					personas.add(datos[0]);
				nodosOrigen[i] = personas.indexOf(datos[0]);
				nombreIDNodo.put(datos[0], nodosOrigen[i]);
				
				if(!personas.contains(datos[1]))
					personas.add(datos[1]);
				nodosDestino[i] = personas.indexOf(datos[1]);
				nombreIDNodo.put(datos[1], nodosDestino[i]);
				
				
				
			}
			
			cantPersonas = personas.size();
			grafo = new GrafoNDNP(cantPersonas);
			
			for(int i = 0; i < cantConexiones; i++) {
				grafo.setArista(true, nodosOrigen[i], nodosDestino[i]);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
				try {
					if (fr != null)
						fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	@Override
	public void resolver() {
		BFS bfs = new BFS(grafo);
		Set<Integer> nodosDistMax = new TreeSet<Integer>();
		distMax = 0;
		for(int i = 0; i < cantPersonas; i++) {
			int []distancias = bfs.getDistancias(i);
			for(int j = 0; j < cantPersonas; j++) {
				if(distancias[j] > distMax) {
					nodosDistMax.clear();
					distMax = distancias[j];
					nodosDistMax.add(j);
				} else if (distancias[j] == distMax) {
					nodosDistMax.add(j);
				}
			}
		}
		
		
		personasResultado = new TreeSet<String>();
		for (Integer index : nodosDistMax) 
			personasResultado.add(personas.get(index));	
		
		imprimirResultados();
	}

	private void imprimirResultados() {
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter(salida);
			pw = new PrintWriter(fw);
			pw.println(distMax);
			for (String nombre : personasResultado)
				pw.println(nombre);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
				try {
					if(fw != null) 
						fw.close();
				} catch (IOException e) {
					e.printStackTrace();
			}
		}
	}
	
	
	
	
	
}
