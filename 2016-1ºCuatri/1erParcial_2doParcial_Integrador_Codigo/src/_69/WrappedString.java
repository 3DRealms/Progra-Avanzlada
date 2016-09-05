package _69;

import java.util.*;
public class WrappedString {
	private String s;
	public WrappedString(String s) {
		this.s = s;
	}
	public static void main(String[] args) {
		HashSet<Object> hs = new HashSet<Object>();
		WrappedString ws1 = new WrappedString("aardvark");
		WrappedString ws2 = new WrappedString("aardvark1");
		String s1 = new String("aardvark");
		String s2 = new String("aardvark");
		hs.add(ws1);
		hs.add(ws2);
		hs.add(s1);
		hs.add(s2);
		System.out.println(hs.size());
	}
}

/*
A. 0
B. 1
C. 2
D. 3						[X]
E. 4
F. Compilation fails.
G. An exception is thrown at runtime.
*/