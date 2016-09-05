package test;

import java.util.Map;

import model.Plaqueta;

import org.junit.Test;

public class MainTest {

	@Test
	public void enunciado(){
		String entrada = "LLLLCCCLC";
	}
	
	@Test
	public void enunciadoInvertido(){
		String entrada = "CCCCLLLCL";
	}
	
	@Test
	public void entradaVacia(){
		String entrada = "";
	}
	
	@Test
	public void soloCotrol(){
		String entrada = "CCCCCCCC";
	}
	
	@Test
	public void soloLeds(){
		String entrada = "LLLLLLLL";
	}
	
	@Test
	public void unicoParCL(){
		String entrada = "CL";
	}
	
	@Test
	public void unicoParLC(){
		String entrada = "LC";
	}
	
	@Test
	public void controles_leds(){
		String entrada = "CCCCCLLLLL";
	}
	
	@Test
	public void leds_controles(){
		String entrada = "LLLLLCCCCC";
	}
	
	@Test
	public void unicoControl(){
		String entrada = "LLLLCLLLL";
	}
	
	@Test
	public void unicoLed(){
		String entrada = "CCCCLCCCC";
		Plaqueta plaqueta = new Plaqueta(Generador.getFileIn(entrada, "unicoLed.in"));
		plaqueta.crearConexiones();
		plaqueta.escribirResultad(Generador.getFileOut("unicoLed.out"));
	}
}
