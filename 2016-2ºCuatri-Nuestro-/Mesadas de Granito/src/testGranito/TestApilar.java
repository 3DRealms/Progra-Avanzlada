package testGranito;

import granito.Apilar;

import java.io.File;
import java.io.FileNotFoundException;

import junit.framework.Assert;

import org.junit.Test;

public class TestApilar {

	@Test
	public void testConstructor() throws FileNotFoundException{
			Apilar p1 = new Apilar( new File("PreparacionDePrueba\\LotePrueba\\Entrada\\01.in"));
	}
	
}
