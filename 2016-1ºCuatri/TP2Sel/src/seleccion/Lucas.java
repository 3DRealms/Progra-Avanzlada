//Revisada 06/05/2016 Rodri German

package seleccion;

import java.io.File;
import java.util.Arrays;

public class Lucas {
	
	public static String [] listarIn(String extension) {
		File carpeta = new File (".");
		//getCanonicalPath() me dice la ruta actual
	    File[] listaArchivos = carpeta.listFiles();
	    String[] nombres = new String[listaArchivos.length];
	    String[] nombresPosta;
        int k=0;
	    int cuantoson = 0;
        for (int i = 0; i < listaArchivos.length; i++){
        	listaArchivos[i].getName().toLowerCase();
        	if (listaArchivos[i].getName().endsWith(extension)){
        		//http://stackoverflow.com/questions/8393849/how-to-get-name-of-file-object-without-its-extension-in-java
        		int posicionNombre = listaArchivos[i].getName().lastIndexOf(".");
        		if(posicionNombre != -1) {
        			nombres [i] = listaArchivos[i].getName().substring(0, posicionNombre);
        			cuantoson++;
        		}
        	}
        }
        nombresPosta = new String[cuantoson];
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