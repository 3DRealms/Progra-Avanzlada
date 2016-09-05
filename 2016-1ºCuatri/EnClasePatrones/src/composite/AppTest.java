package composite;

public class AppTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Figura c = new Circulo(2);
		Figura t = new Triangulo(2, 1);
		Figura cua = new Cuadrado(5);
	
		Compuesta vagon = new Compuesta();
		vagon.agregar(c);
		vagon.agregar(t);
		vagon.agregar(cua);
		
		Compuesta vagon2 = new Compuesta();
		vagon2.agregar(c);
		vagon2.agregar(t);
		vagon2.agregar(cua);
		
		Compuesta tren = new Compuesta();
		tren.agregar(vagon);
		tren.agregar(vagon2);
		
		
		System.out.println(tren.calcularArea());
	}

}
