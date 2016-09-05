package unidad3Ej11;


public class AppTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseA a1 = new BaseA();
		a1. mostrar();
		DerivadaB b1 = new DerivadaB();
		b1. mostrar();
		BaseA a2 = new DerivadaB();
		a2. mostrar();
	}
}
