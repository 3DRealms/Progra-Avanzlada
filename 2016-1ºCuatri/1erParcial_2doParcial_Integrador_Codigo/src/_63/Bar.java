package _63;

/*
class Foo {
	 public int a = 3;
	 public void addFive() {
		 a += 5; System.out.print("f "); 
	 }
}
 */
class Bar extends Foo {
	 public int a = 8;
	 public void addFive() {
		 this.a += 5;
		 System.out.print("b " );
	}
	public static void main(String[] args) {
		Foo f = new Bar();
		f.addFive();
		System.out.println(f.a);
	}
}


/*
What is the result?
A. b 3							[X]
B. b 8
C. b 13
D. f 3
E. f 8
F. f 13
G. Compilation fails.
H. An exception is thrown at runtime.
*/