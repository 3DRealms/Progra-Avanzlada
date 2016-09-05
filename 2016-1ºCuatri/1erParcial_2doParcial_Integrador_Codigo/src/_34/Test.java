package _34;

public class Test {
	public static void main(String [] args) {
		int x = 5;
		boolean b1 = true;
		boolean b2 = false;
		if ((x == 4) && !b2 )
			System.out.print("1 ");
		System.out.print("2 ");
		if ((b2 = true) && b1 )
			System.out.print("3 ");
	}
}


/*
What is the result?
A. 2
B. 3
C. 1 2
D. 2 3								[X]
E. 1 2 3
F. Compilation fails.
G. An exception is thrown at runtime.
*/