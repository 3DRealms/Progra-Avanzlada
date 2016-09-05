package decorator_JuegoRPG;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class ItemTests {
	
	 	@Test
	    public void quePuedoAgregarItemDeAtaque() {
	 
	        Personaje link = new Explorador();
	        Assert.assertEquals(1, link.obtenerPuntosDeAtaque() );
	        // agrego item de ataque
	          link = new ConEspadaAtacosa(link);
	          System.out.println(link.obtenerPuntosDeAtaque());
	          Assert.assertEquals( 5 + 1, link.obtenerPuntosDeAtaque() );
	    }
	 
	    /*@Test
	    @Ignore
	    public void quePuedoAgregarAmbosItems() {
	 
	        Personaje link = new Explorador();
	        Assert.assertEquals(1, link.obtenerPuntosDeAtaque());
	 
	        // agrego item de ataque
	        link = new ConEspadaAtacosa(link);
	        Assert.assertEquals(5 + 1, link.obtenerPuntosDeAtaque());
	 
	        Assert.assertEquals(0, link.obtenerPuntosDeDefensa());
	        link = new ConEscudoDeFelpudo(link);
	        // agrego defensa
	        Assert.assertEquals(10 + 0, link.obtenerPuntosDeDefensa());
	        // y no pierdo ataque
	        Assert.assertEquals(5 + 1, link.obtenerPuntosDeAtaque());
	    }
	 */
	   /* @Test
	   @Ignore
	    public void quePuedoAgregarDosTiposDeItem() {
	        Personaje link = new Explorador();
	        Assert.assertEquals(1, link.obtenerPuntosDeAtaque());
	 
	        // agrego item de ataque
	        link = new ConEspadaAtacosa(link);
	        Assert.assertEquals(5 + 1, link.obtenerPuntosDeAtaque());
	 
	        // agrego gema multiplicadora (x2)
	        link = new ConGemaGemosa(link);
	        Assert.assertEquals((5 + 1) * 2, link.obtenerPuntosDeAtaque());
	    }
*/
}