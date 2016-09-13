package selMath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class SelMath {

	private MatrizMath matMath;
	private VectorMath indepen;

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

		double pivote; // Pivote para hacer 1s.
		double coeficiente; // Coeficiente para multiplicar la fila y restala para hacer 0s.


		for (int i = 0; i < matMath.getCol(); i++) {

			int contAux = i + 1;
			while (matMath.getPorCoor(i, i) == 0 && contAux < matMath.getCol() - 1) {  // mientras el pivote no sea cero y no me escape de la dimension
				matMath.intercambiarFilas(i, contAux); 
														// es por si hay 0s.
				//if (matMath.getPorCoor(i, i) == 0) // pensaba que era nesesaria, peor la verdad que no
				
				contAux++;
 			}
			if (matMath.getPorCoor(i, i) != 0) { // si el pivote es distinto de cero, puedo operar, sino paso a otra columna
				pivote = matMath.getPorCoor(i, i); // Asigno el pivote para dividir y hacer
										// esa columna los 0s.
				for (int k = 0; k < matMath.getCol(); k++) {
					matMath.setPorCoor(i, k, matMath.getPorCoor(i, k) / pivote);
					
				}
				indepen.setPorCoor(i, indepen.getPorCoor(i) / pivote);
				for (int j = 0; j < matMath.getFil(); j++) { // Recorre las
																// filas.
					coeficiente = matMath.getPorCoor(j, i); // multiplica este nº por la
												// fila que tiene el 1.
					if (j != i) {
						indepen.setPorCoor(j, (indepen.getPorCoor(j) - coeficiente * indepen.getPorCoor(i)));
						for (int k = 0; k < matMath.getCol(); k++) { // Recorre por columnas.
							double tempValue = matMath.getPorCoor(j,k) - coeficiente * matMath.getPorCoor(i,k);
							matMath.setPorCoor(j, k, tempValue);
							
						} // ejemplo en https://es.wikipedia.org/wiki/Eliminaci%C3%B3n_de_Gauss-Jordan
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Locale.setDefault(new Locale("en", "Us"));
		String matrizTXT = "01.txt";
		try {

			SelMath sel = new SelMath(new File(matrizTXT));
			System.out.println(sel);
			System.out.println("\n\n");
			sel.resolver();
			System.out.println(sel);



		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("El archivo esta rancio!");
		} catch (DistDimException e){
			e.printStackTrace();
		}
	}


}
