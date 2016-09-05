package test;

import java.io.File;

import org.junit.Test;

import edu.unlam.subterraneos.Subterraneos;

public class SubterraneosTest {

	@Test
	public void test(){
		Subterraneos subterraneos = new Subterraneos(new File(""), new File(""));
		subterraneos.resolver();
	}
}
