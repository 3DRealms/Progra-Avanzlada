package decorator_2;

/*
 * 	-----------------	
 *	|   Component	|
 *	-----------------
 *	|				|
 *	| + operacion()	|<---------------------------------------
 *	|				|										|
 *	-----------------										|
 *			/|\												|
 *		 	 |												|
 *		 ---------------------------------					|
 *		 |								 |					|
 *--------------------		-------------------------		|
 *|ComponenteComcreto|		|  ComponenteComcreto	|		|
 *--------------------		------------------------|		|
 *|		   			 |		|	  	   				|<>------	
 *|  + operacion()   |		|    + operacion()		|
 *|		   			 |		|component->operation() |
 *--------------------		|	  	   				|	
 *				-------------------------
 *					/|\
 *					 |
 *	-----------------------------------------
 *	|										|
 *-------------------		-------------------------
 *|   DecoratorA	|		|      DecoratorB		|
 *-------------------		------------------------|
 *| - Add Estados	|		|  -Add Comportamiento	|
 *-----------------	|   	| + operacion() 		|
 *|					|		|	  	   				|
 *| + operacion()	|		-------------------------
 *|					|
 *-------------------	
				

 */
public class AppTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vendible auto1 = new FiatUno();
		auto1 = new CDPlayer(auto1);
		auto1 = new Gasoil(auto1);
		
		System.out.println(auto1.getDescripcion());
		System.out.println("Su precio es: " + auto1.getPrecio());
		
		Vendible auto2 = new FordFiesta();
		auto2 = new MP3Player(auto2);
		auto2 = new Gasoil(auto2);
		auto2 = new AireAcondicionado(auto2);
		
		System.out.println(auto2.getDescripcion());
		System.out.println("Su precio es: " + auto2.getPrecio());
		
	}

}
