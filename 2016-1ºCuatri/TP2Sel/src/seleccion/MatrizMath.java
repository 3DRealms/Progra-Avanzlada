package seleccion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;

import seleccion.VectorMath;

import static java.lang.Math.*;

public class MatrizMath {

	private double[][] matriz;
	private int fila;
	private int columna;

	//CONSTRUCTORES
	public MatrizMath(String path) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			archivo = new File(path);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea;
			String[] datos;

			linea = br.readLine();

			datos = linea.split(" ");

			fila = Integer.parseInt(datos[0]);
			columna = Integer.parseInt(datos[1]);
			matriz = new double[fila][columna];

			for (int i = 0; i < fila * columna; i++) {

				linea = br.readLine();
				datos = linea.split(" ");
				matriz[Integer.parseInt(datos[0])][Integer.parseInt(datos[1])] = Double.parseDouble(datos[2]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null)
					fr.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public MatrizMath(int fil, int col) {
		matriz = new double[fil][col];
		this.fila = fil;
		this.columna = col;
	}

	//GETTER AND SETTER
	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}

	public String getFila(int i) {
		return Arrays.toString(matriz[i]);
	}

	public double getDatoMatriz(int x, int y) throws Exception {
		if (x < 0 || x >= this.fila || y < 0 || y >= this.columna)
			throw new Exception("No existe dicha posicion en la matriz");
		return this.matriz[x][y];
	}

	public void setDatoMatriz(int x, int y, double val) throws Exception {
		if (x < 0 || x >= this.fila || y < 0 || y >= this.columna)
			throw new Exception("No existe dicha posicion en la matriz");
		this.matriz[x][y] = val;
	}

	//METODOS
	public MatrizMath ObtenerIdentidad() {
		if (fila != columna) {
			System.out.println("La matriz no es cuadrada, no posee identidad");
			return null;
		}

		MatrizMath id = new MatrizMath(this.fila, this.columna);
		for (int i = 0; i < fila; i++)
			id.matriz[i][i] = 1;

		return id;
	}

	public MatrizMath clone() {
		MatrizMath aux = new MatrizMath(this.fila, this.columna);

		for (int i = 0; i < this.fila; i++) { 
			aux.matriz[i] = Arrays.copyOf(this.matriz[i], this.columna);
		}
		return aux;
	}

	public MatrizMath sumar(MatrizMath obj) throws Exception {
		if (this.fila != obj.fila || this.columna != obj.columna)
			throw new Exception("Las matrices son de distintas dimensiones");

		MatrizMath aux = new MatrizMath(this.fila, this.columna);

		for (int i = 0; i < fila; i++)
			for (int j = 0; j < columna; j++)
				aux.matriz[i][j] = this.matriz[i][j] + obj.matriz[i][j];

		return aux;
	}

	public MatrizMath restar(MatrizMath obj) throws Exception {
		if (this.fila != obj.fila || this.columna != obj.columna)
			throw new Exception("Las matrices son de distintas dimensiones");

		MatrizMath aux = new MatrizMath(this.fila, this.columna);

		for (int i = 0; i < fila; i++)
			for (int j = 0; j < columna; j++)
				aux.matriz[i][j] = this.matriz[i][j] - obj.matriz[i][j];

		return aux;
	}

	public MatrizMath producto(double escalar) {
		MatrizMath aux = new MatrizMath(this.fila, this.columna);

		for (int i = 0; i < fila; i++)
			for (int j = 0; j < columna; j++)
				aux.matriz[i][j] = escalar * this.matriz[i][j];

		return aux;
	}

	public MatrizMath producto(MatrizMath obj) throws Exception {
		if (this.columna != obj.fila)
			throw new Exception("Las matrices no pueden multiplicarse");

		MatrizMath aux = new MatrizMath(this.fila, obj.columna);

		for (int i = 0; i < this.fila; i++)
			for (int j = 0; j < obj.columna; j++)
				for (int k = 0; k < this.fila; k++)
					aux.matriz[i][j] += this.matriz[i][k] * obj.matriz[k][j];

		return aux;
	}

	public VectorMath producto(VectorMath obj) throws Exception {
		if (this.columna != obj.getDimension())
			throw new Exception("La Matriz y el Vector no pueden multiplicarse");

		VectorMath aux = new VectorMath(this.fila);

		for (int i = 0; i < this.fila; i++) {
			double suma = 0;
			for (int j = 0; j < obj.getDimension(); j++)
				suma += this.matriz[i][j] * obj.getVectorDatos(j);
			aux.setVectorDatos(i, suma);
		}

		return aux;
	}

	public MatrizMath transpuesta() {
		MatrizMath aux = new MatrizMath(this.columna, this.fila);

		for (int i = 0; i < this.fila; i++)
			for (int j = 0; j < this.columna; j++)
				aux.matriz[j][i] = this.matriz[i][j];
		return aux;
	}

	public double determinante() throws Exception {
		if (this.fila != this.columna)
			throw new Exception("No se puede calcular el determinante");

		if (this.fila == 1)
			return matriz[0][0];

		double result = 0;

		if (this.fila == 2) {
			result = matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
		} else {
			for (int i = 0; i < fila; i++) {
				MatrizMath submatriz = new MatrizMath(this.fila - 1,
						this.columna - 1);
				submatriz = subMatriz(this, i, 0); // Elimino fila i y col 0
				System.out.println(submatriz);
				result += pow(-1, i) * matriz[i][0] * submatriz.determinante();
				System.out.println(result);
			}
		}
		return result;
	}

	/**
	 * params fila y columna ue no se van a considerar
	 */
	private MatrizMath subMatriz(MatrizMath obj, int fila, int columna) {
		MatrizMath matriz = new MatrizMath((obj.fila - 1), (obj.columna - 1));
		int posfil = 0;
		int poscol;

		for (int i = 0; i < obj.fila; i++) {
			poscol = 0;
			if (i != fila) { // Saco la fila x
				for (int j = 0; j < obj.columna; j++) { // Saco la columna 0
					if (j != columna) {
						matriz.matriz[posfil][poscol] = obj.matriz[i][j];
						poscol++;
					}
				}
				posfil++;
			}
		}
		return matriz;
	}

	public MatrizMath inversa() throws Exception {
		if (this.fila != this.columna || this.determinante() == 0)
			throw new Exception("La matriz no tiene inversa");

		MatrizMath aux = new MatrizMath(this.fila, this.columna);

		double det = this.determinante();

		for (int i = 0; i < this.fila; i++) {
			for (int j = 0; j < this.columna; j++) {
				MatrizMath submat = new MatrizMath(this.fila - 1,
						this.columna - 1);
				submat = subMatriz(this, i, j);
				aux.matriz[i][j] = pow(-1, i + j) * submat.determinante();
			}
		}
		return aux.transpuesta().producto(1 / det);
	}

	public double errorInversa() {

		try {
			double a = this.ObtenerIdentidad().restar(this.inversa()).normaDos();
			return a;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public MatrizMath multiplicaFila(int i1, double k) throws Exception {
		try {
			MatrizMath resultado = new MatrizMath(fila, columna);
			for (int i = 0; i < fila; i++) {
				for (int j = 0; j < columna; j++) {
					if (i == i1) {
						resultado.matriz[i1][j] = k * this.matriz[i][j];
					} else {
						resultado.matriz[i][j] = this.matriz[i][j];
					}
				}
			}
			return resultado;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/*
	public double normaUno() throws Exception {
		if (this.fila != this.columna)
			throw new Exception(
					"No se puede calcular la norma uno de la matriz");

		double aux;
		VectorMath vec = new VectorMath(this.columna);

		for (int j = 0; j < this.columna; j++) {
			aux = 0;
			for (int i = 0; i < this.fila; i++)
				aux += abs(this.matriz[i][j]);
			vec.setVectorDatos(j, aux);
		}

		return vec.normaInfinita();
	}
	*/

	public double normaDos() throws Exception {
		if (this.fila != this.columna)
			throw new Exception(
					"No se puede calcular la norma dos de la matriz");

		double aux = 0;

		for (int i = 0; i < this.fila; i++)
			for (int j = 0; j < this.columna; j++)
				aux += pow(abs(matriz[i][j]), 2);

		return sqrt(aux);
	}

	/*	
	 * public double normaInfinito() throws Exception { if (this.fila !=
	 * this.columna) throw new Exception(
	 * "No se puede calcular la norma infinito de la matriz");
	 * 
	 * double aux; VectorMath vec = new VectorMath(this.columna);
	 * 
	 * for (int i = 0; i < fila; i++) { aux = 0; for (int j = 0; j < columna;
	 * j++) aux += abs(this.matriz[i][j]); vec.setVectorDatos(i, aux); } return
	 * vec.normaInfinita(); }
	 */

	public void guardarEnArchivo(String path) {

		FileWriter fr = null;
		PrintWriter pw = null;

		try {
			String linea;
			fr = new FileWriter(path);
			pw = new PrintWriter(fr);

			pw.println(this.fila + " " + this.columna);

			for (int i = 0; i < this.fila; i++) {
				for (int j = 0; j < this.columna; j++) {
					linea = String.valueOf(i) + " " + String.valueOf(j) + " "
							+ String.valueOf(this.matriz[i][j]);
					pw.println(linea);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	private void pivote(double matriz[][], int piv, int var) {
		double temp = 0;
		temp = matriz[piv][piv];
		for (int y = 0; y < (var + 1); y++) {
			matriz[piv][y] = matriz[piv][y] / temp;
		}
	}

	private void hacerceros(double matriz[][], int piv, int var) {
		for (int x = 0; x < var; x++) {
			if (x != piv) {
				double c = matriz[x][piv];
				for (int z = 0; z < (var + 1); z++) {
					matriz[x][z] = ((-1 * c) * matriz[piv][z]) + matriz[x][z];
				}
			}
		}
	}

	public vectorMath GaussJordan(){
		
	}
	
	
	public VectorMath GaussJordan(VectorMath independiente) throws Exception {
		int var = independiente.getDimension(), piv = 0;
		double matriz[][] = new double[var][var + 1];
		
		for (int x = 0; x < var; x++) {
			for (int y = 0; y < (var + 1); y++) {
				if (y == var)
					matriz[x][y] = independiente.getVectorDatos(x);
				else
					matriz[x][y] = this.matriz[x][y];
			}
		}
		for (int a = 0; a < var; a++) {
			pivote(matriz, piv, var);
			hacerceros(matriz, piv, var);
			piv++;
		}

		VectorMath res = new VectorMath(var);
		for (int x = 0; x < var; x++) {
			res.setVectorDatos(x, matriz[x][var]);
		}

		return res;
	}

	@Override
	public String toString() {
		String salida = "Matriz = ";

		for (int i = 0; i < fila; i++)
			salida += System.getProperty("line.separator")
					+ Arrays.toString(matriz[i]);

		return salida;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof MatrizMath))
			return false;
		MatrizMath other = (MatrizMath) obj;
		if (columna != other.columna)
			return false;
		if (fila != other.fila)
			return false;
		for (int i = 0; i < fila; i++) { // Para que compare todas las filas
			if (!Arrays.equals(matriz[i], other.matriz[i]))
				return false;
		}
		return true;
	}

	public void main() {
		MatrizMath m = new MatrizMath("matriz.txt");
		try {
			System.out.println( m.determinante() );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}