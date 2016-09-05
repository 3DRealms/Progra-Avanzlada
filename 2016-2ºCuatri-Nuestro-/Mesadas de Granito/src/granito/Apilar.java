package granito;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Scanner;

public class Apilar {

	private int cant;
	private MesadaGranito[] mesadas;

	public Apilar(File dir) throws FileNotFoundException {

		Scanner scIn 	 = new Scanner(dir); 

		cant = scIn.nextInt();
		mesadas = new MesadaGranito[cant];

		for(int i = 0; i<cant; i ++){
			mesadas[i] = new MesadaGranito(scIn.nextInt(),scIn.nextInt());
		}		
	}

}
