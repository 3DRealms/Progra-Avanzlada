package _85;

public class Main {

	public static void main(String[] args) {
		Runnable r = new Runnable() {
			public void run() {
				System.out.print("Cat");
			}
		};
		Thread t = new Thread(r){
			public void run() {
				System.out.print("Dog");
			}
		};
		t.start();
	}
}


/*
What is the result?
A. Cat
B. Dog								[X]
C. Compilation fails.
D. The code runs with no output.
E. An exception is thrown at runtime.
*/
