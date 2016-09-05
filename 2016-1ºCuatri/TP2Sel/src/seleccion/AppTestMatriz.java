package seleccion;

import seleccion.MatrizMath;

public class AppTestMatriz {

		
		public static void main(String[] args) throws Exception {
			/*MatrizMath b = new MatrizMath(2, 2);
			try {
				b.setDatoMatriz(0, 0, 1);
				b.setDatoMatriz(1, 0, 2);
				b.setDatoMatriz(0, 1, 2);
				b.setDatoMatriz(1, 1, 1);
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println(b.inversa());
			b.inversa().guardarEnArchivo("inversaDeV");

			MatrizMath c = new MatrizMath("inversaDeV");
			System.out.println(c);
			System.out.println(b.producto(c));
			System.out.println(c.errorInversa());
		
		*/
			MatrizMath  m = new MatrizMath("matriz.txt");
			double[] resultado = {1,2,3};
			VectorMath  v = new VectorMath(3, resultado );
			System.out.println( m );
			System.out.println( m.GaussJordan( v ));

		}

	}

