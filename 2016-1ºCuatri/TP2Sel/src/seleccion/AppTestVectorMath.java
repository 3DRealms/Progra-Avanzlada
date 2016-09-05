package seleccion;

import seleccion.MatrizMath;

public class AppTestVectorMath {
	
	public static void main(String[] args) throws Exception {

		VectorMath a = new VectorMath(3);
		a.setVectorDatos(0, 1);
		a.setVectorDatos(1, 2);
		a.setVectorDatos(2, 3);

		MatrizMath b = new MatrizMath(3, 2);
		try {
			b.setDatoMatriz(0, 0, 1);
			b.setDatoMatriz(1, 0, 1);
			b.setDatoMatriz(2, 0, 2);
			b.setDatoMatriz(0, 1, 2);
			b.setDatoMatriz(1, 1, 2);
			b.setDatoMatriz(2, 1, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		VectorMath c = null;

		try {
			c = a.producto(b);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(c);

	}


}
