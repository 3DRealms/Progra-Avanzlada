package _14;

class Atom {
	Atom() {
		System.out.print("atom ");
	}
}
class Rock extends Atom {
	Rock(String type) {
		System.out.print(type);
	}
}
public class Mountain extends Rock {
	Mountain() {
		super("granite ");
		new Rock("granite ");
	}
	public static void main(String[] a) {
		new Mountain();
	}
}


/*
 * What is the result?
A. Compilation fails.
B. atom granite
C. granite granite
D. atom granite granite
E. An exception is thrown at runtime.
F. atom granite atom granite			[X]
*/
