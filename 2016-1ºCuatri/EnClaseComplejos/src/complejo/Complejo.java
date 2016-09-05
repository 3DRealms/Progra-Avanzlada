package complejo;

public class Complejo {
	
	private double real,
				   imaginaria;
	
	public Complejo(){
		this.real = 0;
		this.imaginaria = 0;
	}
	
	public Complejo( double re, double im){
		this.real = re;
		this.imaginaria = im;
	}
	
	public Complejo suma( Complejo a, Complejo b){
		double x = a.imaginaria + b.imaginaria;
		double y = a.real + b.real;
		return new Complejo(x,y);
	}
	
	public Complejo resta( Complejo a, Complejo b){
		double x = a.imaginaria - b.imaginaria;
		double y = a.real - b.real;
		return new Complejo(x,y);
	}
	
	public Complejo producto( Complejo c1, Complejo c2 ){
		double x = c1.real*c2.real - c1.imaginaria*c2.imaginaria;
	    double y = c1.real*c2.imaginaria + c1.imaginaria*c2.real;
	    return new Complejo(x, y);
	}
	
	public Complejo producto( Complejo c1, double c2 ){
		double x = c1.real*c2;
	    double y = c1.imaginaria*c2;
	    return new Complejo(x, y);
	}
	
	public Complejo producto( double c1, Complejo c2 ){
		double x = c1*c2.real;
	    double y = c1*c2.imaginaria;
	    return new Complejo(x, y);
	}
	
	public double modulo(){
	     return Math.sqrt(real*real+imaginaria*imaginaria);
	}
	
	public void mostrar(){
        System.out.println("Real: " + this.real );
        System.out.println("Imaginaria: " + this.imaginaria );
    }
	
	public String toString(){
		
		return "(" + this.real + ";" + this.imaginaria + ")";
	}
	
	public boolean comparar(Complejo c1, Complejo c2){
		return( c1.real == c2.real && c1.imaginaria == c2.imaginaria);
	}
	
	public boolean equals( Object o ){
		if( o == null ) return false;
		if( !(o instanceof Complejo) ) return false;
		Complejo otro = (Complejo)o;
		return this.real == otro.real && this.imaginaria == otro.imaginaria;
	}
	
	
	
	public Complejo clone(){
		Complejo c = new Complejo(this.real,this.imaginaria);
		return c;
	}

}
