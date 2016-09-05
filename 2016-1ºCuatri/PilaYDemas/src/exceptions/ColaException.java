package exceptions;

public class ColaException extends Exception{


	private static final long serialVersionUID = 1L;



	public ColaException(){
		super("Cola Vacia");
	}
	
	public ColaException(String msj){
		super(msj);
	}
}
