package juegoconletras;

import java.io.File;
import java.util.Arrays;

public class Lucas {
	
	public static String [] listarIn() {
		File carpeta = new File (".");
		//getCanonicalPath() me dice la ruta actual
	    File[] listaArchivos = carpeta.listFiles();
	    String[] nombres = new String[listaArchivos.length];
	    
	        for (int i = 0; i < listaArchivos.length; i++){
	        	if (listaArchivos[i].getName().endsWith(".in")||listaArchivos[i].getName().endsWith(".IN")){
	        		//http://stackoverflow.com/questions/8393849/how-to-get-name-of-file-object-without-its-extension-in-java
	        		int posicionNombre = listaArchivos[i].getName().lastIndexOf(".");
	        		if(posicionNombre != -1) {
	        			nombres [i] = listaArchivos[i].getName().substring(0, posicionNombre);
	        		}
	        	}
	        }
	        int cuantoson = 0;
	        for (int j = 0; j < listaArchivos.length; j++){
	   	     	if (nombres [j] != null){
	   	     		cuantoson++;
	   	     	}
	        }
	        String[] nombresPosta = new String[cuantoson];
	        int k=0;
	        for (int j = 0; j < listaArchivos.length; j++){
	        	if (nombres [j] != null){
	   	     		nombresPosta[k]= nombres [j];
	   	     		k++;
	   	     		}
	        }
	        //Ordeno los nombres
	        Arrays.sort(nombresPosta);
	        return nombresPosta;
	    }
}