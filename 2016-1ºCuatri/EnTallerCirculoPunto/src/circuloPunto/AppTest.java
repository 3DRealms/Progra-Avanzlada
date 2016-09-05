package circuloPunto;

public class AppTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Prueba Circulo Punto
		Punto p1 = new Punto (0,0);
		Punto p2 = new Punto (1,1);
		Punto p3 = new Punto (4,4);
		Circulo c1 = new Circulo(2,p1);
		System.out.println("-------CIRCULO - PUNTO -------");
		System.out.println("("+p1.getX()+" , "+p1.getY()+") "+c1.contienePunto(p1));
		System.out.println("("+p1.getX()+" , "+p1.getY()+") "+c1.contienePunto(p2));
		System.out.println("("+p1.getX()+" , "+p1.getY()+") "+c1.contienePunto(p3));
		
		//Prueba Circulo Circulo
		Punto c_circ1 = new Punto (0,0);
		Punto c_circ2 = new Punto (0,2);
		Punto c_circ3 = new Punto (2,0);
		Punto c_circ4 = new Punto (2,2);
		Circulo c_c1 = new Circulo(1,c_circ1);
		Circulo c_c2 = new Circulo(1,c_circ2);
		Circulo c_c3 = new Circulo(1,c_circ3);
		Circulo c_c4 = new Circulo(1,c_circ4);
		System.out.println("-------CIRCULO - CIRCULO -------");
		System.out.println("("+c_c1.getPunto().getX()+" , "+c_c1.getPunto().getY()+") "+c_c1.contieneCirculo(c_c1));
		System.out.println("("+c_c2.getPunto().getX()+" , "+c_c2.getPunto().getY()+") "+c_c1.contieneCirculo(c_c2));
		System.out.println("("+c_c3.getPunto().getX()+" , "+c_c3.getPunto().getY()+") "+c_c1.contieneCirculo(c_c3));
		System.out.println("("+c_c4.getPunto().getX()+" , "+c_c4.getPunto().getY()+") "+c_c1.contieneCirculo(c_c4));
		
		//Prueba Circulo Circulo
		Punto p_rec1 = new Punto (0,0);
		Punto p_rec2 = new Punto (2,3);
		Punto c_rec1 = new Punto (4,0);
		Punto c_rec2 = new Punto (3,0);
		Punto c_rec3 = new Punto (2,-1);
		Punto c_rec4 = new Punto (3,-1);
		Punto c_rec5 = new Punto (2.5,-0.5);
		Punto c_rec6 = new Punto (2.7071,-0.7071);
		Punto c_rec7 = new Punto (2.7072,-0.7072);
		Rectangulo r1 = new Rectangulo (p_rec1,p_rec2);
		Circulo c_r1 = new Circulo (1,c_rec1);
		Circulo c_r2 = new Circulo (1,c_rec2);
		Circulo c_r3 = new Circulo (1,c_rec3);
		Circulo c_r4 = new Circulo (1,c_rec4);
		Circulo c_r5 = new Circulo (1,c_rec5);
		Circulo c_r6 = new Circulo (1,c_rec6);
		Circulo c_r7 = new Circulo (1,c_rec7);
		System.out.println("-------CIRCULO - RECTANGULO -------");
		System.out.println("("+c_rec1.getX()+" , "+c_rec1.getY()+") "+c_r1.contieneRectangulo(r1));
		System.out.println("("+c_rec2.getX()+" , "+c_rec2.getY()+") "+c_r2.contieneRectangulo(r1));
		System.out.println("("+c_rec3.getX()+" , "+c_rec3.getY()+") "+c_r3.contieneRectangulo(r1));
		System.out.println("("+c_rec4.getX()+" , "+c_rec4.getY()+") "+c_r4.contieneRectangulo(r1));
		System.out.println("("+c_rec5.getX()+" , "+c_rec5.getY()+") "+c_r5.contieneRectangulo(r1));
		System.out.println("("+c_rec6.getX()+" , "+c_rec6.getY()+") "+c_r6.contieneRectangulo(r1));
		System.out.println("("+c_rec7.getX()+" , "+c_rec7.getY()+") "+c_r7.contieneRectangulo(r1));


	}

}
