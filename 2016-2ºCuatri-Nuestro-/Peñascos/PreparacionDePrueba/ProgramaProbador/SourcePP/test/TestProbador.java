package test;

import java.io.File;
import java.io.FileNotFoundException;

import junit.framework.Assert;

import org.junit.Test;

import construirCasa.Probador;

public class TestProbador {
	
	
	// probamos casos normales que funcione
	@Test
	public void caso1() throws FileNotFoundException{
		Probador p1 = new Probador(new File("PreparacionDePrueba\\LotePrueba\\Entrada\\01.in"), new File("PreparacionDePrueba\\LotePrueba\\Salida Esperada\\01.out"));
		Assert.assertTrue("Caso de prueba1", p1.probarFalso());
		
	}
	// probamos casos normales que funcione
	@Test
	public void caso2() throws FileNotFoundException{
		Probador p2 = new Probador(new File("PreparacionDePrueba\\LotePrueba\\Entrada\\02.in"), new File("PreparacionDePrueba\\LotePrueba\\Salida Esperada\\02.out"));
		Assert.assertTrue("Caso de prueba2", p2.probarFalso());
		
	}
	// probamos casos normales que funcione
	@Test
	public void caso3() throws FileNotFoundException{
		Probador p3 = new Probador(new File("PreparacionDePrueba\\LotePrueba\\Entrada\\03.in"), new File("PreparacionDePrueba\\LotePrueba\\Salida Esperada\\03.out"));
		Assert.assertTrue("Caso de prueba3", p3.probarFalso());
		
	}
	// probamos si acierta que la casa esta fuera del terreno
	@Test
	public void caso4() throws FileNotFoundException{
		Probador p4 = new Probador(new File("PreparacionDePrueba\\LotePrueba\\Entrada\\04.in"), new File("PreparacionDePrueba\\LotePrueba\\Salida Esperada\\04.out"));
		Assert.assertFalse("Caso de prueba4", p4.probarFalso());
		
	}
	// probamos si acierta que hay un peñasco en el medio de la casa
	@Test
	public void caso5() throws FileNotFoundException{
		Probador p5 = new Probador(new File("PreparacionDePrueba\\LotePrueba\\Entrada\\05.in"), new File("PreparacionDePrueba\\LotePrueba\\Salida Esperada\\05.out"));
		Assert.assertFalse("Caso de prueba5", p5.probarFalso());
		
	}

} 
