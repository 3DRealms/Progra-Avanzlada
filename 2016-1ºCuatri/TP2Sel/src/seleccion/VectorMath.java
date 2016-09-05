package seleccion;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

import seleccion.MatrizMath;

public class VectorMath {

	private int dimension;
	private double vectorDatos[];

	//CONSTRUCTORES
	public VectorMath(int dim) {
		this.dimension = dim;
		this.vectorDatos = new double[this.dimension];
	}
	public VectorMath(int dim, double[] vector) {
		this.dimension = dim;
		this.vectorDatos = new double[this.dimension];
		for (int i = 0; i < dim; i++) {
			vectorDatos[i] = vector[i];
		}
	}

	public VectorMath(String path) {
		File f = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			f = new File(path);
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			this.dimension = Integer.parseInt(br.readLine());
			this.vectorDatos = new double[dimension];
			for (int i = 0; i < dimension; i++) {
				vectorDatos[i] = Double.parseDouble(br.readLine());
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

	///GETTER & SETTERS
	public int getDimension() {
		return dimension;
	}
	
	

	public double[] getVector() {
		return vectorDatos;
	}

	public void setVectorDatos(double[] vectorDatos) {
		this.vectorDatos = vectorDatos;
	}

	public void setDimension(int dim) {
		this.dimension = dim;
	}

	public double getVectorDatos(int pos) throws Exception {
		if (pos > this.dimension)
			throw new Exception("Fuera de las dimensiones");
		return vectorDatos[pos];
	}

	public void setVectorDatos(int pos, double valor) throws Exception {
		if (pos > this.dimension)
			throw new Exception("Fuera de las dimensiones");
		this.vectorDatos[pos] = valor;
	}

	//METODOS
	//OPERACIONES MATEMATICAS
	public VectorMath sumar(VectorMath vec) throws DistDimException {
		if (this.dimension != vec.dimension)
			throw new DistDimException("Distina Dimension");

		VectorMath aux = new VectorMath(this.dimension);
		for (int i = 0; i < this.dimension; i++) {
			aux.vectorDatos[i] = this.vectorDatos[i] + vec.vectorDatos[i];
		}
		return aux;
	}

	public VectorMath restar(VectorMath vec) throws DistDimException {
		if (this.dimension != vec.dimension)
			throw new DistDimException("Distina Dimension");

		VectorMath aux = new VectorMath(this.dimension);
		for (int i = 0; i < this.dimension; i++) {
			aux.vectorDatos[i] = this.vectorDatos[i] - vec.vectorDatos[i];
		}
		return aux;
	}

	public VectorMath producto(int escalar) {
		VectorMath aux = new VectorMath(this.dimension);
		for (int i = 0; i < this.dimension; i++) {
			aux.vectorDatos[i] = escalar * this.vectorDatos[i];
		}
		return aux;
	}

	public double producto(VectorMath vec) {
		if (this.dimension != vec.dimension)
			throw new DistDimException("Distina Dimension");

		double producto = 0;

		for (int i = 0; i < this.dimension; i++) {
			producto += this.vectorDatos[i] * vec.vectorDatos[i];
		}

		return producto;
	}

	public VectorMath producto(MatrizMath obj) throws Exception {
		if (obj.getFila() != this.dimension)
			throw new Exception("La Matriz y el Vector no pueden multiplicarse");

		VectorMath aux = new VectorMath(obj.getColumna());

		for (int j = 0; j < obj.getColumna(); j++) {
			double suma = 0;
			for (int i = 0; i < this.dimension; i++)
				suma += this.vectorDatos[i] * obj.getDatoMatriz(i, j);
			aux.vectorDatos[j] = suma;
		}

		return aux;
	}

	//NORMAS
	public double normaUno() {

		double norma = 0;

		for (int i = 0; i < this.dimension; i++) {
			norma += abs(this.vectorDatos[i]);
		}
		return norma;
	}

	public double normaDos() {
		float norma = 0;

		for (int i = 0; i < this.dimension; i++) {
			norma += pow(this.vectorDatos[i], 2);
		}
		return sqrt(norma);
	}

	public double normasInfinita() {
		double norma = this.vectorDatos[0] ;

		for (int i = 1; i < this.dimension; i++) {
			if(norma < this.vectorDatos[i])
				norma = abs(this.vectorDatos[i]);
		}
		return norma;
	}


	@Override
	public String toString() {
		return "Vector: " + Arrays.toString(this.vectorDatos);
	}

	public VectorMath clone() {
		VectorMath aux = new VectorMath(this.dimension);
		aux.vectorDatos = Arrays.copyOf(this.vectorDatos, this.dimension);
		return aux;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VectorMath other = (VectorMath) obj;
		if (!Arrays.equals(vectorDatos, other.vectorDatos))
			return false;
		if (dimension != other.dimension)
			return false;
		return true;
	}

}
