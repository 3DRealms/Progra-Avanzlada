package SelMath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MatrizMath {

	protected int filas;
	protected int columnas;
	protected double[][] mat;

	public int getFilas() {
		return filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public MatrizMath(int filas, int columnas, double[][] mat) {
		this.filas = filas;
		this.columnas = columnas;
		this.mat = mat;
	}

	public MatrizMath(String ruta) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(ruta));
		this.filas = sc.nextInt();
		this.columnas = sc.nextInt();
		this.mat = new double[this.filas][this.columnas];

		for (int i = 0; i < (this.filas * this.columnas); i++) {
			sc.nextLine();
			int fil = sc.nextInt();
			int col = sc.nextInt();
			this.mat[fil][col] = sc.nextDouble();

		}

		sc.close();

	}

	public void mostrarMatriz() {
		int j;
		for (int i = 0; i < this.filas; i++) {
			// System.out.print("|");
			for (j = 0; j < this.columnas; j++) {
				System.out.print(this.mat[i][j]);
				if (j != this.mat[i].length - 1)
					System.out.print("\t");

			}

			System.out.println();
		}

	}

	public MatrizMath suma(MatrizMath m2) throws DistDimException {

		if ((this.filas != m2.filas) || (this.columnas != m2.columnas)) {
			throw new DistDimException("Distinta dimension");
		}
		MatrizMath aux = new MatrizMath(this.filas, this.columnas,
				new double[this.filas][this.columnas]);

		for (int i = 0; i < this.filas; i++) {
			for (int j = 0; j < this.columnas; j++)
				aux.mat[i][j] = (this.mat[i][j] + m2.mat[i][j]);
		}

		return aux;
	}

	public MatrizMath resta(MatrizMath m2) throws DistDimException {

		if ((this.filas != m2.filas) || (this.columnas != m2.columnas)) {
			throw new DistDimException("Distinta dimension");
		}
		MatrizMath aux = new MatrizMath(this.filas, this.columnas,
				new double[this.filas][this.columnas]);

		for (int i = 0; i < this.filas; i++) {
			for (int j = 0; j < this.columnas; j++)
				aux.mat[i][j] = (this.mat[i][j] - m2.mat[i][j]);
		}

		return aux;
	}

	public MatrizMath producto(MatrizMath m2) throws DistDimException {

		if (this.columnas != m2.filas) {
			throw new DistDimException("No se puede realizar el producto");
		}
		MatrizMath multiplicacion = new MatrizMath(this.filas, m2.columnas,
				new double[this.filas][m2.columnas]);

		for (int x = 0; x < multiplicacion.mat.length; x++) {
			for (int y = 0; y < multiplicacion.mat[x].length; y++) {
				for (int z = 0; z < this.columnas; z++) {
					multiplicacion.mat[x][y] += this.mat[x][z] * m2.mat[z][y];
				}
			}
		}

		return multiplicacion;
	}

	public void productoPorReal(double real) {

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (mat[i][j] != 0)
					mat[i][j] *= real;
			}

		}
	}

	public VectorMath multiplicacionVectorMatriz(VectorMath vectorcito)
			throws DistDimException {
		VectorMath vector = new VectorMath(this.columnas);
		if ((this.columnas != vectorcito.dim)) {
			throw new DistDimException("Distinta dimension");
		}

		for (int x = 0; x < this.mat.length; x++) {
			for (int y = 0; y < vectorcito.dim; y++) {
				vector.vec[x] += (this.mat[x][y] * vectorcito.vec[y]);
			}
		}

		return vector;

	}

	public double getPorCoor(int fil, int col) {
		if (fil > this.filas || col > this.columnas)
			throw new DistDimException("Dimension Erronea");
		return mat[fil][col];
	}

	public void setPorCoor(int fil, int col, double value) {
		if (fil > this.filas || col > this.columnas)
			throw new DistDimException("Dimension Erronea");
		mat[fil][col] = value;
	}

	public MatrizMath subMathExcluyendoFC(int rowException, int columnException) {
		int i, j, i2 = 0, j2 = 0;

		if (this.filas == 1 && this.columnas == 1)
			return this;

		MatrizMath result = new MatrizMath(filas - 1, columnas - 1,
				new double[filas - 1][columnas - 1]);

		for (i = 0; i < this.filas; i++) {
			j2 = 0; // Para reiniciar columnas
			if (i != rowException) { // Pregunta si hay que saltear la fila, en
										// ese caso no recorre nada

				for (j = 0; j < this.columnas; j++) {
					if (j != columnException) { // Si la columna es valida->
						result.mat[i2][j2] = mat[i][j]; // Guarda el dato
						j2++; // Y aumenta la columna, ya que guardo

					} // Salida del if que pregunta por la columna

				} // Salida del segundo for
				i2++; // Cada vez que termina el primer if aumento filas
			} // 1er if

		} // fin del 1erfor
		return result;
	}

	public double determinante() throws DistDimException {
		if (this.columnas != this.filas)
			throw new DistDimException("Distinta dimension");
		double aux = 0;
		if (filas == 1) // Si la matriz es de 1x1, el determinante es el unico
			return mat[0][0];

		if (filas == 2) // Si es de 2x2, uso la regla practica
			return ((mat[0][0] * mat[1][1]) - (mat[0][1] * mat[1][0]));

		if (filas > 2) {
			for (int j = 0; j < columnas; j++) { // Para mayores a 2x2, divido
													// el determinante en
													// distintas submatrices
				MatrizMath subMat = new MatrizMath(filas - 1, columnas - 1,
						new double[filas - 1][columnas - 1]);
				subMat = this.subMathExcluyendoFC(0, j); // Recorre la primer
															// fila solamente
				aux += mat[0][j] * subMat.determinante() * Math.pow(-1, j);
			}
		}

		return aux;

	}

	public MatrizMath copiarMatriz() {
		MatrizMath auxiliar = new MatrizMath(filas, columnas,
				new double[filas][columnas]);

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				auxiliar.mat[i][j] = mat[i][j];

			}
		}

		return auxiliar;
	}

	public MatrizMath matrizCofactores() {
		MatrizMath matAux = new MatrizMath(filas, columnas,
				new double[filas][columnas]);

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				MatrizMath subMat = new MatrizMath(filas - 1, columnas - 1,
						new double[filas - 1][columnas - 1]);
				subMat = this.subMathExcluyendoFC(i, j);
				double detAux = subMat.determinante();
				if (detAux != 0) {
					matAux.mat[i][j] = detAux * Math.pow(-1, j + i);
				}
			}
		}

		return matAux;
	}

	public void transpuesta() {
		double aux;
		for (int i = 0; i < filas; i++) {
			for (int j = i + 1; j < columnas; j++) {

				aux = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = aux;

			}
		}

	}

	public boolean compararMatrices(MatrizMath wacho) { // /PROXIMAMENTE CON
														// ERROR

		if ((filas != wacho.filas) || (columnas != wacho.columnas))
			return false;

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (mat[i][j] != wacho.mat[i][j])
					return false;
			}
		}
		return true;
	}

	public MatrizMath inversaDeUnaMatrizCuadrada() {
		// Aca faltaria la exception no se cuanto para determinantes = 0
		MatrizMath matInversa = this.matrizCofactores();

		matInversa.productoPorReal((1 / determinante()));
		matInversa.transpuesta();

		return matInversa;

	}

}
