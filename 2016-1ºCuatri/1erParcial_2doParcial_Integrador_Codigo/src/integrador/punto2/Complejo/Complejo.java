package integrador.punto2.Complejo;

public class Complejo {
	private double real;
	private double imaginaria;
	
	//Constructores
	public Complejo(){
		this.real=0;
		this.imaginaria=0;
	}
	public Complejo( double x){
		this.real = x;
		this.imaginaria=0;
	}
	public Complejo(double x, double y){
		this.real = x;
		this.imaginaria = y;
	}
	//Metodos
	public void Sumar(double x){
		this.real+=x;
	}
	public void Sumar (Complejo x){
		this.real += x.real;
		this.imaginaria += x.imaginaria;
	}
	public Complejo clone (){
		Complejo x = new Complejo( this.real, this.imaginaria);
		return x;
	}
	public double modulo (){
		return Math.sqrt(this.real*this.real+this.imaginaria*this.imaginaria);
	}
	public boolean equals (Object x){
		if (x instanceof Complejo){
			Complejo z = (Complejo) x;
			if (this.real == z.real && this.imaginaria == z.imaginaria)
				return true;
		}
		return false;
	}
	public String toString(){
		return this.real + " + " + this.imaginaria + "i";
	}
}