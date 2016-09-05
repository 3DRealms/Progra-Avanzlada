package _56;

public class Yippe {
	public static void main(String [] args) {
		for(int x = 1; x < args.length; x++) {
			System.out.print(args[x] +" ");
		}
	}
}

/*
What is the result?
A. No output is produced.
1 2 3
B. No output is produced.				[X]
2 3 4
C. No output is produced.
1 2 3 4
D. An exception is thrown at runtime.
1 2 3
E. An exception is thrown at runtime.
2 3 4
F. An exception is thrown at runtime.
1 2 3 4
*/