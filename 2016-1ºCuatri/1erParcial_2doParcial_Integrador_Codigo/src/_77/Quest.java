package _77;

import java.util.*;
public class Quest {
	public static void main(String[] args) {
		String[] colors = {"blue", "red", "green", "yellow", "orange"};
		Arrays.sort(colors);
		//blue,green,orange,red,yellow
		int s2 = Arrays.binarySearch(colors, "orange");
		int s3 = Arrays.binarySearch(colors, "violet");
		System.out.println(s2 + " " + s3);
	}
}


/*
What is the result?
A. 2 -1
B. 2 -4
C. 2 -5						[X]
D. 3 -1
E. 3 -4
F. 3 -5
G. Compilation fails.
H. An exception is thrown at runtime.
*/