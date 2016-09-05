package caos_en_la_envazadora;

import org.junit.Assert;
import org.junit.Test;

public class Testing {
	
	@Test
    public void quieroquecaigalasubcadena() {
 
        Envazadora datos = new Envazadora("caso_enunciado.in");
        Assert.assertEquals(46, datos.ResolverCaos() );
        datos.grabar("casos_enunciado.out");
		
	}
}