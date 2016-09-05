package complejo;

public class AppTest {
	
	public static void main( String args[]){
	
	Complejo c1 = new Complejo( 2, 3 );
	Complejo c2 = new Complejo( 7, 10 );
	Complejo c3 = new Complejo();
	Complejo c4 = new Complejo();
	
	System.out.println(c1);
	c3 = c1.clone();
	System.out.println(c3);
	System.out.println(c1.equals(c3));
	System.out.println(c1.equals(c2));
	c4.producto(c1, c3);
	System.out.println(c4);
	}

}
