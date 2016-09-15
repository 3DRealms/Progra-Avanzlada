package polinimio;

public class Polinomio {

	private int grado;
	private double[] coeficiente;

	//La posicion 0 del arreglo de coeficientes con tiene el coeficiente
	//	de grado n y la posicion n con tiene al termino independiente.

	public int getGrado() {
		return grado;
	}
	public void setGrado(int grado) {
		this.grado = grado;
	}

	public double[] getCoeficiente() {
		return coeficiente;
	}

	public double getCoorCoeficiente(int i) {
		return coeficiente[i];
	}

	public void setCoeficiente(double[] coeficiente) {
		this.coeficiente = coeficiente;
	}

	public Polinomio(){ 
		this.setCoeficiente(null);
		this.setGrado(0);
	}

	public Polinomio(double[] coeficiente, int grado){ 
		this.setCoeficiente(coeficiente);
		this.setGrado(grado);
	}

	public double potencia(double x, int grado ){
		if( grado == 1)
		{
			return x;
		}
		return 	x*potencia(x,grado-1);			
	}


	public double evaluarMSucesivas(double x ){
		double resultado = 0;
		double aux;
		for( int i = 0; i < this.getGrado() ; i++ )
		{
			aux = 1;
			for( int j = i; j <this.getGrado() ; j++){
				aux *= x;
			}
			System.out.println("Sucesiva: "+x+"^"+(this.getGrado()-i)+" = "+aux);
			resultado += this.getCoorCoeficiente( i )*aux;
		}
		resultado += this.getCoorCoeficiente( this.getGrado() );
		return resultado;
	}

	//Sin considerar exponente par	
	public double evaluarRecursiva(double x ) { 
		double resultado = 0;
		double aux;

		for( int i = 0; i < this.getGrado() ; i++ )
		{
			aux = potencia( x,this.getGrado()-i);
			//	System.out.println("Recursiva"+x+"^"+(this.getGrado()-i)+" = "+aux);
			resultado += this.getCoorCoeficiente( i )*aux;
		}

		resultado += this.getCoorCoeficiente( this.getGrado() );
		return resultado;
	}

	//Considerando exponente par o inpar
	public double evaluarRecursivaPar(double x ) {
		double resultado = 0;
		double aux;

		for( int i = 0; i < this.getGrado() ; i++ ){
			
			
			
			///NO ESTOY SEGURO A LO QUE SE REFIERE CON LO DE PAR e IMPAR. 
			if( ( this.getGrado() - i % 2 ) == 0 ){
				aux = potencia( x*x , this.getGrado() / 2 );
			}
			else{
				aux = x*potencia( x , this.getGrado()-i) ;
			}

			aux = potencia( x,this.getGrado()-i);
			//	System.out.println("Recursiva PAR"+x+"^"+(this.getGrado()-i)+" = "+aux);
			resultado += this.getCoorCoeficiente( i )*aux;
	
		
		}

		resultado += this.getCoorCoeficiente( this.getGrado() );
		return resultado;
	}

	public double evaluarProgDinamica(double x ) {
		double resultado = 0;
		return resultado;
	}

	public double evaluarMejorada(double x ) {
		double resultado = 0;
		return resultado;
	}

	public double evaluarPow (double x ) {
		double resultado = 0;
		for( int i = 0; i < this.getGrado() ; i++ )
		{
			//	System.out.println("Math.Pow: "+x+"^"+(this.getGrado()-i)+" = " + Math.pow(x,(this.getGrado()-i)) );
			resultado += this.getCoorCoeficiente( i ) * Math.pow(x, (this.getGrado()-i) );
		}
		resultado += this.getCoorCoeficiente( this.getGrado() );
		return resultado;
	}

}
