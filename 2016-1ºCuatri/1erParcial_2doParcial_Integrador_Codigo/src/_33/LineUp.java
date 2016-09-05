package _33;

public class LineUp {
	public static void main(String[] args) {
		double d = 12.345;
		// BAD 			System.out.printf("|%7d| \n", d);
		//|12,345000|	System.out.printf("|%7f| \n", d);
		//ILLEGAL 		System.out.printf("|%3.7d| \n", d);
		//|12,3450000| 	System.out.printf("|%3.7f| \n", d);
		//ILLEGAL		System.out.printf("|%7.3d| \n", d);
		//| 12,345| 	System.out.printf("|%7.3f| \n", d);
	}
}


/*
A. System.out.printf("|%7d| \n", d);
B. System.out.printf("|%7f| \n", d);
C. System.out.printf("|%3.7d| \n", d);
D. System.out.printf("|%3.7f| \n", d);
E. System.out.printf("|%7.3d| \n", d);
F. System.out.printf("|%7.3f| \n", d);		[X]
*/