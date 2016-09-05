package thread;

public class AppTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Con start se ejecuta como un hilo independiente
		
		
		
		/*
		 * (Create) -> start() -> (Execute) ->  sleep()  -> (Espera)
		 * 							 |		<- - - - - - <-
		 * 							\|/
		 * 						   (Muere)
		 */
		new MiThread("julio").start();
		new MiThread("Lucas").start();
		
		MiThread a = new MiThread("Julio");
		MiThread b = new MiThread("Lucas");
		
		MiThread c = new MiThread("German");
		MiThread d = new MiThread("En Verga Dura");
		

		//Espera el prorama principal que termine el Hilo
		try {
			//Comienza el Hilo
			a.start();
			a.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Corre el metodo del Hilo
		b.run();
		
		/*
		 * Sockets
		 * 
		 * 					Server										Clientes
		 * 
		 * Puerto	1. 	Pubicar en la								(C1)		Socket 1
		 * IP			Red Server								- - -			IP	
		 * 														|				Puerto
		 * 														|
		 * 														|	(C2)		Socket 2
		 * 			2.	Escucha de peticiones					|	|			IP
		 * 				de conexion								|	|			Puerto
		 * 														|	| 
		 * Socket 1	<-- - - - - - - - - - - - - - - - - - - - - - 	|
		 * Socket 2 <- - - - - - - - - - - - - - - - - - - - - - - - 
		 * Socket N
		 */
		
	}

}
