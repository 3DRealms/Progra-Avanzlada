package _16;

public static void parse(String str) {
	try {
		float f = Float.parseFloat(str);
	} catch (NumberFormatException nfe) {
		f = 0;
	} finally {
		System.out.println(f);
	}
}
public static void main(String[] args) {
	parse("invalid");
}

/*
What is the result?
A. 0.0
B. Compilation fails.						[X]
C. A ParseException is thrown by the parse method at runtime.
D. A NumberFormatException is thrown by the parse method at runtime.
*/