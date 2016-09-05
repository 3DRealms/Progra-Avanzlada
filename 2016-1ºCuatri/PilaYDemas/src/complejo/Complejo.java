package complejo;
import java.lang.Math.*;
public class Complejo {
	
	//Atributos
	private double real;
	private double ima;
	
	//Constructores
	public Complejo (double r,double i)
	{
		real=r;
		ima=i;
	}
	public Complejo()
	{
		this(0,0);
	}
	private static boolean test()
	{
		Complejo c1= new Complejo(3,1);
		if (c1.real==3&&c1.ima==1)
			return true;
		return false;
	}
	public static Complejo suma(Complejo c1,Complejo c2)
	{
		return new Complejo(c1.real+c2.real,c1.ima+c2.ima);
	}
	public Complejo suma (Complejo c)
	{
		return new Complejo(real+c.real,ima+c.ima);
	}
	public Complejo resta (Complejo c)
	{
		return new Complejo(real-c.real,ima-c.ima);
	}
	public String toString()
	{
		return "Complejo (real= "+real+", ima= "+ima+")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Complejo other = (Complejo) obj;
		if (Double.doubleToLongBits(ima) != Double.doubleToLongBits(other.ima))
			return false;
		if (Double.doubleToLongBits(real) != Double.doubleToLongBits(other.real))
			return false;
		return true;
	}
	
	public Complejo multiplicacion(Complejo c)
	{
		return new Complejo(real*c.real+(-1)*(ima*c.ima),real*c.ima+ima*c.real);
	}
	
	public static void main(String[]args)
	{
		Complejo c1=new Complejo(1,3);
		Complejo c2=new Complejo(2,1);
		Complejo c3=c1.suma(c2);
		System.out.println(c3.toString());
		double modulo=c3.modulo();
		System.out.println("El modulo del complejo es: "+modulo+".");
	}

	public double modulo()
	{
		return Math.sqrt(Math.pow(real, 2)+Math.pow(ima, 2));
	}
}
