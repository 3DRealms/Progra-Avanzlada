package integrador.punto2.Complejo;

public class AppTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Complejo c1 = new Complejo();
		Complejo c2 = new Complejo(1);
		Complejo c3 = new Complejo(3,4);
		Complejo c4 = new Complejo(2,4);
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c3.toString());
		System.out.println(c4.equals(c3));
		c4.Sumar(c2);
		System.out.println(c4.equals(c3));
		System.out.println(c4.modulo());
		c4.Sumar(5);
		System.out.println(c4);
		c4 = c1.clone();
		System.out.println(c4);
		
		
		
		
	}

}
