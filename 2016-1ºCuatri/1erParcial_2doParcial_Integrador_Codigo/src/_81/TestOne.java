package _81;

 public class TestOne implements Runnable {
	 public static void main (String[] args) throws Exception {
		 Thread t = new Thread(new TestOne());
		 t.start();
		 System.out.print("Started");
		 t.join();
		 System.out.print("Complete");
	 }
	 public void run() {
		 for (int i = 0; i < 4; i++) {
			 System.out.print(i);
		 }
	 }
 }
 
 /*
 What can be a result?
 A. Compilation fails.
 B. An exception is thrown at runtime.
 C. The code executes and prints "StartedComplete".
 D. The code executes and prints "StartedComplete0123".
 E. The code executes and prints "Started0123Complete".		[X]
 */