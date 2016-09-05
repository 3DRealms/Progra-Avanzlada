package _55_primerParcial.punto1;
public class Batman {
		int squares = 81;	
	public static void main(String[] args) {
	new Batman().go();

	}
	void go(){
		incr(++squares);
		System.out.println(squares);
	}
	
	void incr( int squares){
		squares += 10;
	}
}
