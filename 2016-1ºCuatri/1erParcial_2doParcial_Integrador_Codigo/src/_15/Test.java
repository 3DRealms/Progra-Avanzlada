package _15;

interface TestA {
	String toString();
}
public class Test {
public static void main(String[] args) {
		System.out.println(
							new TestA() {
								public String toString() {
									return "test";
								}
							}
						   );
	}
}


/*
What is the result?
A. test										[X]
B. null
C. An exception is thrown at runtime.
D. Compilation fails because of an error in line 1.
E. Compilation fails because of an error in line 4.
F. Compilation fails because of an error in line 5.
*/