package thread;

public class MiThread extends Thread {
	MiThread (String nombre){
		//Llamo a los constructores de Thread y le paso el nombre
		super(nombre);
	}
	public void run(){
		for (int i=0 ; i<10 ; i++){
			//Recuoerar el nombre del Thread
			System.out.println(i+") "+getName() );
		}
		System.out.println("Hilo Finalizado");
	}
	
}
