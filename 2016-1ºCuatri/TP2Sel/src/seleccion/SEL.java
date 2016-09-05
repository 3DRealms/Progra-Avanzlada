package seleccion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//import java.text.DecimalFormat;

import seleccion.MatrizMath;


public class SEL {

	private MatrizMath coeficientes;
	private VectorMath independiente;
	private VectorMath resultado;
	private int dimension;

	//CONTRUCTOR
	public SEL(String path) {
		File f = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			f = new File(path);
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String linea;
			String[] datos;

			dimension = Integer.parseInt(br.readLine());
			coeficientes = new MatrizMath(dimension, dimension);

			for (int i = 0; i < dimension * dimension; i++) {
				linea = br.readLine();
				datos = linea.split(" ");
				coeficientes.setDatoMatriz(Integer.parseInt(datos[0]),
						Integer.parseInt(datos[1]),
						Double.parseDouble(datos[2]));
			}
			
			independiente = new VectorMath(dimension);
			for (int i = 0; i < dimension; i++) {
				independiente.setVectorDatos(i,
						Double.parseDouble(br.readLine()));
			}
			//Faltaba esto en el constructor
			resultado = new VectorMath(dimension);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//METODOS
	public VectorMath resolucionXgaussJordan() throws Exception {
		
		return coeficientes.GaussJordan(independiente);
		
	}
	
	
	
	public VectorMath getResultado() {
		return resultado;
	}

	public void setResultado(VectorMath resultado) {
		this.resultado = resultado;
	}

	public void escribirArchivo(String path) {
		FileWriter fw = null;
		PrintWriter pw = null;
		//DecimalFormat df = new DecimalFormat("0.00");
		try {
			fw = new FileWriter(path);
			pw = new PrintWriter(fw);
			resultado.getDimension();
			for (int i = 0; i < resultado.getDimension(); i++){
				pw.println(resultado.getVectorDatos(i));
				}
			pw.println(this.errorSolucion());
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

	public double errorSolucion() {
		double error = 0;
		try {
			error = independiente.restar(resultado).normaDos() / 100;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return error;
	}

	//GETTER AND SETTER
	public VectorMath getIndependientes() {
		return independiente;
	}

	public MatrizMath getCoeficientes() {
		return coeficientes;
	}
}
