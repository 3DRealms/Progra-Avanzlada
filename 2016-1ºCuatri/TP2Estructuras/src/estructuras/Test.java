package estructuras;

public class Test {
public static void main(String[] args) {
	Object obj1 = new Object();
	Object obj2 = new Object();
	Object obj3 = new Object();
	Object obj4 = new Object();
	Object obj5 = new Object();
	
	Lista l1 = new Lista( 30 );
	Pila  p1 = new PilaEstatica();
	Pila  p2 = new PilaContieneLista( 30, l1, 0 );
	Pila  p3 = new PilaHeredaLista();
	
	p2.empty();
	p2.push(obj1);
	p2.push(obj2);
	p2.push(obj3);
	p2.push(obj4);
	p2.push(obj5);
	
	
	}
}