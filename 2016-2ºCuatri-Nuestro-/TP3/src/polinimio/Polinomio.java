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
		public double potenciaPar(double x, int grado ){
		if( grado == 0)
		{
			return 1;
		}
		if( ( (n) % 2) != 0) 		//si es impar 
			return  potenciaPar( x, n );
							// si es par.
		return  potenciaPar( x*x,( n )/2);
	}


	// style c.
	public double evaluarMSucesivas(double x ){
		double resultado = 0;
		double potencia;
		for( int i = 0; i < this.getGrado() ; i++ )
		{
			potencia = 1;
			for( int j = i; j <this.getGrado() ; j++){
				potencia *= x;
			}
			//	System.out.println("Sucesiva: "+x+"^"+(this.getGrado()-i)+" = "+aux);
			resultado += this.getCoorCoeficiente( i )*potencia;
		}
		resultado += this.getCoorCoeficiente( this.getGrado() );
		return resultado;
	}

	// Potencia recursiva, re poco otimo stack feo :c
	public double evaluarRecursiva(double x ) { 
		double resultado = 0;
		double potencia;

		for( int i = 0; i < this.getGrado() ; i++ )
		{
			potencia = potencia( x,this.getGrado()-i);
			//	System.out.println("Recursiva"+x+"^"+(this.getGrado()-i)+" = "+aux);
			resultado += this.getCoorCoeficiente( i )*potencia;
		}

		resultado += this.getCoorCoeficiente( this.getGrado() );
		return resultado;
	}

	// Considerando exponente par o inpar (caso optimizado del anterior).
	public double evaluarRecursivaPar(double x ) {
		double resultado = 0;
		double potencia;
		int n;
		for( int i = 0; i < this.getGrado() ; i++ )
		{	
			n = this.getGrado() - i ;

			potencia = potenciaPar(x);
			
			//	System.out.println("Recursiva"+x+"^"+(this.getGrado()-i)+" = "+aux);
			resultado += this.getCoorCoeficiente( i )*potencia;
		}

		resultado += this.getCoorCoeficiente( this.getGrado() );
		return resultado;
	}
	
	// La programacion Dinamica consiste en reutilizar lo ya calculado. 
	// al estilo optimo matematico Dani 3.0.
	public double evaluarProgDinamica(double x ) {
		double resultado = 0;
		double potencia = 1; // este es el x elevado a la potencia, en la primera es 1 porque x^0 = 1;
		
		for( int i = this.getGrado(); i >= 0  ; i-- )
		{	
			resultado += this.getCoorCoeficiente( i )*potencia;
			potencia *= x; // Aca incremento el exponente en 1.
		}
		return resultado;
	}

	//Mejorada de la programacion dinamica n-1
	public double evaluarMejorada(double x ) {
		double resultado = this.getCoorCoeficiente(0);
		double potencia = 1; // este es el x elevado a la potencia, en la primera es 1 porque x^0 = 1;
		
		for( int i = this.getGrado(); i >= 1  ; i-- )
		{	
			resultado += this.getCoorCoeficiente( i )*potencia;
			potencia *= x; // Aca incremento el exponente en 1.
		}
		return resultado;
	}
	
	
	
	// Al estilo java, poco optimo orible (sin h).
	public double evaluarPow (double x ) {
		double resultado = 0;
		for( int i = 0; i < this.getGrado() ; i++ )
		{
			//System.out.println("Math.Pow: "+x+"^"+(this.getGrado()-i)+" = " + Math.pow(x,(this.getGrado()-i)) );
			resultado += this.getCoorCoeficiente( i ) * Math.pow(x, (this.getGrado()-i) );
		}
		resultado += this.getCoorCoeficiente( this.getGrado() );
		return resultado;
	}

}
