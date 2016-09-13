package selMath;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class SelMath {

	private MatrizMath matMath;
	private VectorMath indepen;
	private VectorMath resultado;
	
	public SelMath(File dirFile) throws FileNotFoundException {

		Scanner sc = new Scanner(dirFile);
		int lado = sc.nextInt();

		matMath = new MatrizMath(sc, lado);

		indepen = new VectorMath(sc, lado);

		sc.close();

		
	}
	
	public String toString(){

		return matMath.toString() + indepen.toString();
	}

	public void resolver() {
		Calendar tIni = new GregorianCalendar();
		
		resultado = indepen.clone();
		MatrizMath matAux = matMath.clone();
		double pivote; // Pivote para hacer 1s.
		double coeficiente; // Coeficiente para multiplicar la fila y restala para hacer 0s.

		
		for (int i = 0; i < matAux.getCol(); i++) {

			int contAux = i + 1;
			while (matAux.getPorCoor(i, i) == 0 && contAux < matAux.getCol() - 1) {  // mientras el pivote no sea cero y no me escape de la dimension
				matAux.intercambiarFilas(i, contAux); 
														// es por si hay 0s.
				//if (matAux.getPorCoor(i, i) == 0) // pensaba que era nesesaria, peor la verdad que no
				
				contAux++;
 			}
			if (matAux.getPorCoor(i, i) != 0) { // si el pivote es distinto de cero, puedo operar, sino paso a otra columna
				pivote = matAux.getPorCoor(i, i); // Asigno el pivote para dividir y hacer
										// esa columna los 0s.
				for (int k = 0; k < matAux.getCol(); k++) {
					matAux.setPorCoor(i, k, matAux.getPorCoor(i, k) / pivote);
					
				}
				resultado.setPorCoor(i, resultado.getPorCoor(i) / pivote);
				for (int j = 0; j < matAux.getFil(); j++) { // Recorre las
																// filas.
					coeficiente = matAux.getPorCoor(j, i); // multiplica este nº por la
												// fila que tiene el 1.
					if (j != i) {
						resultado.setPorCoor(j, (resultado.getPorCoor(j) - coeficiente * resultado.getPorCoor(i)));
						for (int k = 0; k < matAux.getCol(); k++) { // Recorre por columnas.
							double tempValue = matAux.getPorCoor(j,k) - coeficiente * matAux.getPorCoor(i,k);
							matAux.setPorCoor(j, k, tempValue);
							
						} // ejemplo en https://es.wikipedia.org/wiki/Eliminaci%C3%B3n_de_Gauss-Jordan
					}
				}
			}
		}
		
		Calendar tFin = new GregorianCalendar();

		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		System.out.println("Rendimiento: " + diff);
		
		
	}
	
	private double calcError(){
		
		VectorMath aux = new VectorMath(resultado.getDim());
		double acumu;
		
		for(int i = 0; i < matMath.getFil(); i++){
			acumu = 0;
			for(int j = 0; j < matMath.getCol(); j++){
				acumu += resultado.getPorCoor(j)*matMath.getPorCoor(i, j);
			}
			aux.setPorCoor(i, Math.abs(acumu));
		}
		//System.out.println(aux);
		
		for(int i = 0; i < resultado.getDim(); i++){
			aux.setPorCoor(i, aux.getPorCoor(i)-Math.abs(indepen.getPorCoor(i)));
		}
		
		//System.out.println(aux);
		
		return aux.normaDos();
		
	}
	
	public void imprimirSalida(String path){
		FileWriter fw = null;
		PrintWriter pw = null;
		//DecimalFormat df = new DecimalFormat("0.00");
		try {
			fw = new FileWriter(path);
			pw = new PrintWriter(fw);
			pw.println(resultado.getDim());
			for (int i = 0; i < resultado.getDim(); i++){
				pw.println(resultado.getPorCoor(i));
				}
			pw.println(this.calcError());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Locale.setDefault(new Locale("en", "Us"));
		String inMat01 = "01.in";
		String outMat01 = "01.out";
		String inMat02 = "02.in";
		String outMat02 = "02.out";
		String inMat03 = "03.in";
		String outMat03 = "03.out";
		String inMat04 = "04.in";
		String outMat04 = "04.out";
		String inMat05 = "05.in";
		String outMat05 = "05.out";
		try {

			SelMath sel1 = new SelMath(new File(inMat01));
			sel1.resolver();				
			sel1.imprimirSalida(outMat01);
			
			SelMath sel2 = new SelMath(new File(inMat02));
			sel2.resolver();				
			sel2.imprimirSalida(outMat02);
			
			SelMath sel3 = new SelMath(new File(inMat03));
			sel3.resolver();				
			sel3.imprimirSalida(outMat03);
			
			SelMath sel4 = new SelMath(new File(inMat04));
			sel4.resolver();				
			sel4.imprimirSalida(outMat04);
			
			SelMath sel5 = new SelMath(new File(inMat05));
			sel5.resolver();				
			sel5.imprimirSalida(outMat05);



		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("El archivo esta rancio!");
		} catch (DistDimException e){
			e.printStackTrace();
		}
	}


}
