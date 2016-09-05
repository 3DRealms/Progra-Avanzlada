package _75;

import java.util.*;
public class Mapit {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		Integer i1 = 45;
		Integer i2 = 46;
		set.add(i1);
		set.add(i1);
		set.add(i2);
		System.out.print(set.size() + " ");
		set.remove(i1);
		System.out.print(set.size() + " ");
		i2 = 47;
		set.remove(i2);
		System.out.print(set.size() + " ");
	}
}

/*
What is the result?
A. 2 1 0
B. 2 1 1				[X]
C. 3 2 1
D. 3 2 2
E. Compilation fails.
F. An exception is thrown at runtime.
*/
