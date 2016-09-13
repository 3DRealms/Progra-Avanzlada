package selMath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;


public class VectorMath {
	
	private int dim;
	private double [] vec;
	
	public VectorMath(int dim, double[] vec){
		this.dim = dim;
		this.vec = new double[dim];
		for (int i = 0; i < dim ; i++) {
			this.vec[i] = vec[i];
			//System.out.println( vec[i]);
		}
		
	}
	
	public boolean equals(VectorMath vecComp){
		
		if(dim != vecComp.dim){
			return false;
		}
		for (int i = 0; i < dim ; i++) {
			if(this.vec[i] != vecComp.vec[i]){
				return false;
			}
			//System.out.println( vec[i]);
		}
		return true;
		
	}
	
	public VectorMath clone(){
		return new VectorMath(this.dim, this.vec);
		
	}
	
	public VectorMath(int dim){
		this.dim = dim;
		this.vec = new double[dim];
		
	}
	
	public double normaUno(){
		double norma = 0;
		for (int i = 0; i < dim ; i++) {
			norma = vec[i];
			//System.out.println( vec[i]);
		}
		return norma;
	}
	
	public double normaDos(){
		double norma = 0;
		for (int i = 0; i < dim ; i++) {
			norma = Math.pow(vec[i], 2);
			//System.out.println( vec[i]);
		}
		
		return Math.sqrt(norma);
	}
	
	public double normaInfinita(){
		double norma = vec[0];
		for (int i = 0; i < dim ; i++) {
			if(norma <vec[i])
				norma = vec[i];
			//System.out.println( vec[i]);
		}
		return norma;
	}
	
	public VectorMath(File dirFile) throws FileNotFoundException {
		
		Scanner sc = new Scanner(dirFile);
		dim = sc.nextInt();
		vec = new double[dim]; // vector para almacenar la lectura
		
		for (int i = 0; i < vec.length ; i++) {
			vec[i] =sc.nextDouble() ;
			//System.out.println( vec[i]);
		}
		
		sc.close();
		
	}
	
	public VectorMath(Scanner sc, int dim) throws FileNotFoundException {
		

		this.dim = dim;
		vec = new double[dim]; // vector para almacenar la lectura
		
		for (int i = 0; i < vec.length ; i++) {
			vec[i] =sc.nextDouble() ;
			//System.out.println( vec[i]);
		}
		
		
		
	}
	
	public VectorMath(VectorMath obj) {
		this.dim = obj.dim;
		this.vec = new double[dim];
		for (int i = 0; i < this.dim; i++) {
			this.vec[i] = obj.vec[i];
		}
	}

	public VectorMath sumar(VectorMath vec) throws DistDimException{
		if (dim != vec.dim){
			throw new DistDimException(" Distinta Dimension ");
		}
		//System.out.println(vec.dim);
		VectorMath aux = new VectorMath(dim);
		for (int i=0; i<dim; i++){
			aux.vec[i]=this.vec[i]+vec.vec[i];
			//System.out.println(aux.vec[i]);
		}
		return aux;
	}
	
	public VectorMath producto(double num) throws DistDimException{
		
		//System.out.println(vec.dim);
		VectorMath aux = new VectorMath(dim);
		for (int i=0; i<dim; i++){
			aux.vec[i]=this.vec[i]*num;
			//System.out.println(aux.vec[i]);
		}
		return aux;
	}
	public VectorMath producto(MatrizMath matInput) throws DistDimException{

		if (dim != matInput.getFil() ){
			throw new DistDimException(" Distinta Dimension ");
		}		

		VectorMath aux = new VectorMath(matInput.getCol());
		
		for (int i=0; i<matInput.getCol(); i++){
			aux.vec[i]=0;
			for (int j=0; j<dim; j++){
				aux.vec[i] += this.vec[i]*matInput.getPorCoor(j, i);
			}
			//System.out.println(aux.vec[i]);
		}
		return aux;
	}
	
	public double producto(VectorMath vec){
		if (dim != vec.dim){
			throw new DistDimException(" Distinta Dimension ");
		}
		//System.out.println(vec.dim);
		double resultado = 0;
		for (int i=0; i<dim; i++){
			resultado+=this.vec[i]*vec.vec[i];
			//System.out.println(aux.vec[i]);
		}
		return resultado;
		
	}
	
	public VectorMath restar(VectorMath vec) throws DistDimException{
		if (dim != vec.dim)
			throw new DistDimException(" Distinta Dimension ");
		 
		VectorMath aux = new VectorMath(dim);
		for (int i=0; i<dim; i++)
			aux.vec[i]=this.vec[i]-vec.vec[i];
		return aux;
	}	
	
	public String toString(){
		String retorno = "( ";
		for(int i = 0; i < vec.length; i++){
			retorno += vec[i];
			if(i < vec.length-1){
				retorno +=", ";
			}
		}
		retorno += " )";

		return retorno;
	}



	public int getDim() {
		return dim;
	}

	public double getPorCoor(int coor) {
		return vec[coor];
	}
	
	public void setPorCoor(int coor, double value){
		vec[coor] = value;
	}

}
