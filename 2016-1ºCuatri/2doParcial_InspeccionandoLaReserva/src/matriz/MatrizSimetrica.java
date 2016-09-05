package matriz;

public class MatrizSimetrica {

	
	private double[][] matriz;
	private int dim;
	
	
	public MatrizSimetrica(int dim){
		this.dim = dim;
		matriz= new double[dim][dim];
	}


	public int getDim() {
		return dim;
	}


	public double getValor(int f, int c){
		
		return matriz[f][c];
	}
	
	public void setearAdyacencia(int f, int c,double valor){
		
		matriz[f][c]=valor;
		matriz[c][f]=valor;
		
	}
}
