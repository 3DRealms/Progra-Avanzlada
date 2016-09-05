package _05;

class PingPong2 {
	synchronized void hit(long n) {
		for(int i = 1; i < 3; i++)
			System.out.print(n + "-" + i + " ");
	}
}
public class Tester implements Runnable {
	static PingPong2 pp2 = new PingPong2();
	public static void main(String[] args) {
		new Thread(new Tester()).start();
		new Thread(new Tester()).start();
	}
	public void run() {
		pp2.hit(Thread.currentThread().getId());
	}
}

/*
 * Which statement is true?
A. The output could be 5-1 6-1 6-2 5-2
B. The output could be 6-1 6-2 5-1 5-2		[X]
C. The output could be 6-1 5-2 6-2 5-1
D. The output could be 6-1 6-2 5-1 7-1
 */

