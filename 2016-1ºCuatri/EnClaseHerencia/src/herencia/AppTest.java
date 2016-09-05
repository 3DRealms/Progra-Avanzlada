package herencia;

public class AppTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Punto2D punto1 = new Punto2D ();
		Punto2D punto2 = new Punto2D (0,1);
		Punto2D punto3 = new Punto2D (1,2);
		Punto2D punto4 = new Punto2D (3,4);
		Punto2D punto2Dclonado = new Punto2D ();
		punto2Dclonado = punto4.clone();
		System.out.println("Punto 1: "+ punto1);
		System.out.println("Punto 2: "+ punto2);
		System.out.println("Punto 3: "+ punto3);
		System.out.println("Punto 4: "+ punto4);
		System.out.println("Clonado Punto 4: "+ punto2Dclonado);
		punto3.desplazamiento(punto4);
		System.out.println("Punto 3: "+ punto3);
		Punto3D punto5 = new Punto3D ();
		Punto3D punto6 = new Punto3D (1,2,3);
		Punto3D punto7 = new Punto3D (3,4,5);
		Punto3D punto3Dclonado = new Punto3D ();
		punto3Dclonado = punto7.clone();
		System.out.println("Punto 5: "+ punto5);
		System.out.println("Punto 6: "+ punto6);
		System.out.println("Punto 7: "+ punto7);
		System.out.println("Clonado Punto 7: "+ punto3Dclonado);
		punto6.desplazamiento(punto7);
		System.out.println("Punto 6: "+ punto6);
	}

}
