package tests;
import java.io.FileNotFoundException;
import java.util.Locale;

import SelMath.MatrizMath;
import SelMath.VectorMath;

import org.junit.Assert;
import org.junit.Test;

public class TestMatrizMath {
	
	
		@Test
		public void determinante1x1(){
			try {
				MatrizMath m1 = new MatrizMath("C:\\Datos\\matriz2.txt");

				Assert.assertEquals(0, m1.determinante(),0);
				
			} catch (FileNotFoundException e) {
				 
				e.printStackTrace();
			}
			
			
		}
		
		@Test
		public void determinante2x2(){
			try {
				MatrizMath m2 = new MatrizMath("C:\\Datos\\matriz3.txt");

				Assert.assertEquals(-2.0, m2.determinante(),0);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		@Test
		public void determinante2x2Caso2(){
			try {
				MatrizMath m3 = new MatrizMath("C:\\Datos\\matriz32.txt");

				Assert.assertEquals(-873.0, m3.determinante(),0);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		@Test
		public void determinante3x3(){
			try {
				MatrizMath m4 = new MatrizMath("C:\\Datos\\matriz5.txt");

				Assert.assertEquals(27.00, m4.determinante(),0);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		@Test
		public void determinante4x4(){
			try {
				MatrizMath m5 = new MatrizMath("C:\\Datos\\matriz6.txt");

				Assert.assertEquals(0.0, m5.determinante(),0);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		@Test
		public void determinante4x4Caso2(){
			try {
				MatrizMath m6 = new MatrizMath("C:\\Datos\\matriz61.txt");

				Assert.assertEquals(-360.0, m6.determinante(),0);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		@Test
		public void determinante7x7(){
			try {
				MatrizMath m7 = new MatrizMath("C:\\Datos\\7x7.txt");

				Assert.assertEquals(0, m7.determinante(),0);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		@Test
		public void matrizCofactores(){
			try {
				MatrizMath m8 = new MatrizMath("C:\\Datos\\matrizCofactor.txt");
				MatrizMath m9 = new MatrizMath("C:\\Datos\\matrizCofactorResultado.txt");
				MatrizMath m10 = m8.matrizCofactores();
				
				Assert.assertTrue(m10.compararMatrices(m9));
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		@Test
		public void matrizinversa(){
			try {
				MatrizMath m8 = new MatrizMath("C:\\Datos\\matrizCofactor.txt");
				MatrizMath m9 = new MatrizMath("C:\\Datos\\matrizInversa.txt");
				MatrizMath m10 = m8.inversaDeUnaMatrizCuadrada();

				Assert.assertTrue(m10.compararMatrices(m9));
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		@Test
		public void matrizinversa4x4(){
			Locale.setDefault(new Locale("en", "Us"));
			try {
				MatrizMath m8 = new MatrizMath("C:\\Datos\\matInver2.txt");
				MatrizMath m9 = new MatrizMath("C:\\Datos\\matInver2Resultado.txt");
				MatrizMath m10 = m8.inversaDeUnaMatrizCuadrada();
				//m10.mostrarMatriz();
				VectorMath n1 = new VectorMath(4);
				n1.setPorCoor(0, -8);
				n1.setPorCoor(1, -20);
				n1.setPorCoor(2, -2);
				n1.setPorCoor(3, 4);
				
				VectorMath n2= m10.multiplicacionVectorMatriz(n1);
				//System.out.println(n2);

				Assert.assertTrue(m10.compararMatrices(m9));
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
}
