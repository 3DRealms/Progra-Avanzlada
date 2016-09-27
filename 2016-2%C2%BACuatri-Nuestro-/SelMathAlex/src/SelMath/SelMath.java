package SelMath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class SelMath {
	protected MatrizMath matriz;
	protected VectorMath independiente;
	public VectorMath resultado;
	
	public SelMath(String ruta) throws FileNotFoundException{

		Scanner sc = new Scanner(new File(ruta));
		
		int orden = sc.nextInt();
		MatrizMath m1 = new MatrizMath(orden,orden, new double[orden][orden]);
		VectorMath v1 = new VectorMath(orden, new double[orden]);
		
		resultado = new VectorMath(orden);
		independiente = v1;
		matriz = m1;
		
		int fil,col;

		for(int i=0; i < (matriz.filas*matriz.columnas); i++)
		{
			fil = sc.nextInt();
			col = sc.nextInt();
			matriz.mat[fil][col] = sc.nextDouble();
			
		}
		
		for(int i=0; i< independiente.dim; i++)
			independiente.vec[i] = sc.nextInt();	
				
		sc.close();
		
	}
	
	public boolean resolverSistemaEcuacionesLineales(){
		Calendar tIni = new GregorianCalendar();
		
		if(matriz.determinante() == 0)
			return false;
		
		MatrizMath inversa = matriz.inversaDeUnaMatrizCuadrada();
		resultado = inversa.multiplicacionVectorMatriz(independiente);
		
		
		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		System.out.println("Rendimiento: " + diff);
		
		return true;
	}
	
	public double calcError(){
		
		VectorMath bPrima = matriz.multiplicacionVectorMatriz(resultado);
		return independiente.restar(bPrima).normaDos();
		
	}
	

}
