import java.util.Objects;

public class Complejo {
	
	private float real;
	private float imag;
	public Complejo(float real, float imag)
	{
				this.real = real;
				this.imag = imag;
	}
	
	public Complejo Sumar(Complejo obj){
		
		return new Complejo(this.real + obj.real, this.imag + obj.imag);
	}


	public static void main() {
	Complejo a = new Complejo(2,3);
	StdOut.println("a = "+ a);
	
	}
	
}