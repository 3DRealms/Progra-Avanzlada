package exceptions;

public class PilaException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PilaException(){
		super("Pila Vacia");
	}
	
	public PilaException(String msj){
		super(msj);
	}
}
