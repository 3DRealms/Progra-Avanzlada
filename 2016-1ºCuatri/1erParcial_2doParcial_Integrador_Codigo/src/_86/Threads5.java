package _86;

public class Threads5 {
	public static void main (String[] args) {
		new Thread(	new Runnable() {
						public void run() {
							System.out.print("bar");
						}
					}
					).start();
	}
}

/*
What is the result?
A. Compilation fails.
B. An exception is thrown at runtime.
C. The code executes normally and prints "bar".			[X]
D. The code executes normally, but nothing prints.
*/