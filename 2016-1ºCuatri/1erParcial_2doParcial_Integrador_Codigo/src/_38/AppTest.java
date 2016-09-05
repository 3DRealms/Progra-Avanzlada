package _38;

public class AppTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		 // some code here for ArrayIndexOutOfBoundsException
			int [] b = new int[2];
			b[3] = 4;
			System.out.println(b[2]);
		} catch (ArrayIndexOutOfBoundsException e1) {
				System.out.print("a");
		} catch (Exception e2) {
			System.out.print("b");
		} finally {
			System.out.print("c");
		}
	}

}

/*
If some sort of exception is thrown at line 34, which output is possible?
A. a
B. b
C. c
D. ac							[X]
E. abc
*/