package _35_primerParcialMañana.punto1;

interface Foo {
	
}
class Alpha implements Foo {
	
}
class Beta extends Alpha {
	
}
class Delta extends Beta {
	public static void main( String[] args ) {
		Beta x = new Beta();
		// insert code here
		//Alpha a = x;
		Foo f = (Delta)x;
		//Foo f = (Alpha)x;
		//Beta b = (Beta)(Alpha)x;
	}
}

/*
Which code, inserted at line 16, will cause a java.lang.ClassCastException?
A. Alpha a = x;
B. Foo f = (Delta)x;					[X]
C. Foo f = (Alpha)x;
D. Beta b = (Beta)(Alpha)x;
*/