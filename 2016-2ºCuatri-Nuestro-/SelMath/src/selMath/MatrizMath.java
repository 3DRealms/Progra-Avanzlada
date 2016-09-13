package selMath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class MatrizMath {

	private int col;   			// Cantidad de columnas
	private int fil;   			// Cantidad de filas
	private double [][] mat;		// Matriz de double

	public MatrizMath(File dirFile) throws FileNotFoundException {

		Scanner sc = new Scanner(dirFile);
		fil = sc.nextInt();
		col = sc.nextInt();

		mat = new double[fil][col]; // vector para almacenar la lectura

		for (int i = 0; i < fil*col ; i++) {
			int tempFil = sc.nextInt();
			int tempCol = sc.nextInt();

			mat[tempFil][tempCol] =sc.nextDouble() ;
			//System.out.println( mat[tempFil][tempCol]);
		}

		sc.close();

	}
	
	public MatrizMath(Scanner sc, int dim) throws FileNotFoundException {


		fil = dim;
		col = dim;

		mat = new double[fil][col]; // vector para almacenar la lectura

		for (int i = 0; i < fil*col ; i++) {
			int tempFil = sc.nextInt();
			int tempCol = sc.nextInt();

			mat[tempFil][tempCol] =sc.nextDouble() ;
			//System.out.println( mat[tempFil][tempCol]);
		}


	}

	public MatrizMath(int fil,int col){
		this.fil = fil;
		this.col = col;
		this.mat = new double[fil][col];

	}

	public String toString(){
		String aux="";

		for(int i = 0; i<fil;i++){
			for(int j = 0; j<col;j++){
				aux += mat[i][j];
				aux += " ";
			}
			aux += '\n';
		}
		return aux;
	}

	public MatrizMath sumar(MatrizMath matInput) throws DistDimException{
		if (fil != matInput.fil && col != matInput.col )
			throw new DistDimException(" Distinta Dimension ");

		MatrizMath aux = new MatrizMath(fil,col);
		for(int i = 0; i<fil;i++){
			for(int j = 0; j<col;j++){
				aux.mat[i][j] = matInput.mat[i][j] + this.mat[i][j];
			}
		}
		return aux;
	}	
	public MatrizMath resta(MatrizMath matInput) throws DistDimException{
		if (fil != matInput.fil && col != matInput.col )
			throw new DistDimException(" Distinta Dimension ");

		MatrizMath aux = new MatrizMath(fil,col);
		for(int i = 0; i<fil;i++){
			for(int j = 0; j<col;j++){
				aux.mat[i][j] = matInput.mat[i][j] - this.mat[i][j];
			}
		}
		return aux;
	}	

	public  void intercambiarFilas(int esta, int porEsta){ //intercamiar filas ( ejemplo: f1 por f2)
		VectorMath aux = new VectorMath(this.fil);
		//El cambio Clasico
		for( int i = 0; i< this.fil ; i++ ){ 
			aux.setPorCoor(i, this.getPorCoor(esta, i));
			this.mat[esta][i] = this.mat[porEsta][i];
			this.mat[porEsta][i] = aux.getPorCoor(i);
		}
	}
	
	public  void intercambiarColumna(int esta, int porEsta){
		VectorMath aux = new VectorMath(this.fil);
		for( int i = 0; i< this.fil ; i++ ){
			aux.setPorCoor(i, this.getPorCoor( i, esta));
			this.mat[i][esta] = this.mat[i][porEsta];
			this.mat[i][porEsta] = aux.getPorCoor(i);
		}
	}
/*
	public VectorMath gaussJordan(VectorMath independiente){
		VectorMath resultado = new VectorMath( independiente );         	// Vector de resultados :) 
		double pivote;     													// Pivote para hacer 1s.
		double coeficiente;  				// Coeficiente para multiplicar la fila y restala para hacer 0s.
		//	double [][] matriz = (double[][]) mat.clone();			// Esto copia el puntero ¬¬
		double [][] matriz  = new double[this.getFil()][this.getCol()];	
		for(int i = 0; i< this.getCol(); i++ ){
			for(int j = 0; j < this.getFil() ; j++ ){
				matriz[i][j] = this.mat[i][j];
			}
		}
		for(int i = 0; i< this.getCol(); i++ ){			
			if ( matriz[i][i] == 0  ){ 				// Esta rancio todavia, osea se puede ir de rango.
				this.intercambiarFilas( i , i+1 );      // pero intercabia piola es por si hay 0s.
			}
			pivote = matriz[i][i];					// Asigno el pivote para dividir y hacer esa columna los 0s.
			for(int k = 0; k<this.getCol();k++){ 		
				matriz[i][k] /= pivote;  //  Pero si hago gauss joran ya me queda el 1 :) 
			}
			resultado.setPorCoor(i, resultado.getPorCoor(i) / pivote ) ;
			for(int j = 0; j<this.getFil();j++){	//Recorre las filas.
				coeficiente = matriz[j][i];  //multiplica este nº por la fila que tiene el 1.
				if( j != i ){
					resultado.setPorCoor(j,( resultado.getPorCoor(j) - coeficiente*resultado.getPorCoor(i) ) );
					for ( int k = 0; k < this.getCol(); k++){ 			// Recorre por columnas. 
						matriz[j][k] = matriz[j][k] - coeficiente* matriz[i][k]; // cosa loca :)
					}					// ejemplo en https://es.wikipedia.org/wiki/Eliminaci%C3%B3n_de_Gauss-Jordan					
				}
			}
		}
		System.out.println(this);
		System.out.println("Vector de resultados = " + resultado);
		return resultado;
	}


*/

	public MatrizMath producto(MatrizMath matInput) throws DistDimException{

		if ( col != matInput.fil  ) {
			throw new DistDimException(" Distinta Dimension ");
		}		

		MatrizMath aux = new MatrizMath(fil,matInput.col);

		for (int i=0; i<fil; i++){
			for (int j=0; j<matInput.col; j++){
				aux.mat[i][j] = 0;
				for (int k=0; k<col; k++){
					aux.mat[i][j] += mat[i][k]*matInput.mat[k][j];
				}

			}
		}
		return aux;
	}
	
	
	public VectorMath producto(VectorMath vecInput) throws DistDimException{

		if (vecInput.getDim() != col ) {
			throw new DistDimException(" Distinta Dimension ");
		}		

		VectorMath aux = new VectorMath(fil);

		for (int i=0; i<col; i++){
			aux.setPorCoor(i,0);
			for (int j=0; j<vecInput.getDim(); j++){
				aux.setPorCoor(i,vecInput.getPorCoor(i)*mat[i][j] + aux.getPorCoor(i));
				//aux.vec[i] += this.vec[i]*matInput.getPorCoor(j, i);
			}
			//System.out.println(aux.vec[i]);
		}
		return aux;
	}

	// Super Rancio, revisar!
	
	public double determinate() throws DistDimException{

		if (fil != col ) {
			throw new DistDimException("Matriz no Cuadrada");
		}		
		//	double resultado; 
		int k = 0;

		// dividir la primera fila por el numero de la pos 0 0. asi obtengo el 1.
		// Luego: hacemos 0 en la columna que emos echo el 1, osea 1*f[c] - f[i][j]
		for(k = 0; k < col-2; k++)
		{
			double pivote = mat[k][k];
			for( int i = k; i < col ; i ++){
				mat[k][i] /= pivote;
			}
			for( int i = 1; i < fil; i ++){
				pivote = mat[i][k];
				for( int j = k; j < col ; j++){
					mat[i][j] -= pivote*mat[k][j];
				}
			}
			System.out.println(this);
		}

		if( fil == 1)
			return mat[k][k];

		return mat[k][k]*mat[k+1][k+1]-mat[k][k+1]*mat[k+1][k];
	}
/*
	public static void main(String[] args) {
		Locale.setDefault(new Locale("en", "Us"));
		VectorMath vec1;
		String vectorTXT = "3.txt";
		MatrizMath mat1;
		String matrizTXT = "03.txt";/*
		try {

			vec1 = new VectorMath(new File(vectorTXT));
			mat1 = new MatrizMath(new File(matrizTXT));			
			//System.out.println("matriz 1:\n"+mat1+"\n");
			//	System.out.println("-1-: \n"+mat1.resta(mat1));
			//System.out.println( mat1.producto(vec1) );
			//System.out.println(mat1.producto(mat1));
			System.out.println( vec1 );

			mat1.gaussJordan(vec1);


		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("El archivo esta rancio!");
		} catch (DistDimException e){
			e.printStackTrace();
		}
	}*/

	public int getCol() {
		return col;
	}

	public int getFil() {
		return fil;
	}

	public double[][] getMat() {
		return mat;
	}

	public double getPorCoor(int fil, int col) {
		if (fil > this.fil || col > this.col )
			throw new DistDimException("Dimension Erronea");
		return mat [fil][col];
	}
	
	public void setPorCoor(int fil, int col, double value) {
		if (fil > this.fil || col > this.col )
			throw new DistDimException("Dimension Erronea");
		mat [fil][col] = value;
	}

}
