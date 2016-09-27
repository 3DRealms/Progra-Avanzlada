package tests;

import java.io.FileNotFoundException;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

import SelMath.MatrizMath;
import SelMath.SelMath;
import SelMath.VectorMath;


@SuppressWarnings("unused")
public class TestSelMath {
	@Test
	public void caso1SEL4x4() {
		Locale.setDefault(new Locale("en", "Us"));
		try {
			String miPath = "C:\\Datos2\\04.in";
			SelMath prueba = new SelMath(miPath);

			prueba.resolverSistemaEcuacionesLineales();
//			System.out.println(prueba.resultado);
//			System.out.println(prueba.calcError());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void caso2SEL2x2(){
		Locale.setDefault(new Locale("en", "Us"));
		try {
			String miPath = "C:\\Datos2\\01.in";
			SelMath prueba = new SelMath(miPath);
			prueba.resolverSistemaEcuacionesLineales();
//			System.out.println(prueba.resultado);
//			System.out.println(prueba.calcError());
			
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void fatiga(){
		Locale.setDefault(new Locale("en", "Us"));
		try {
			String miPath = "C:\\Datos2\\200.in";
			SelMath prueba = new SelMath(miPath);
			prueba.resolverSistemaEcuacionesLineales();
			//System.out.println(prueba.resultado);
			System.out.println(prueba.calcError());
			
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
