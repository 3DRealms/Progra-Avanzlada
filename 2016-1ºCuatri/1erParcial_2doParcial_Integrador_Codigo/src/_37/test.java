package _37;

static void test() throws RuntimeException {
	try {
		System.out.print("test ");
		throw new RuntimeException();
	}
	catch (Exception ex) {
		System.out.print("exception ");
	}
}
public static void main(String[] args) {
	try {
		test();
	}
	catch (RuntimeException ex) {
		System.out.print("runtime ");
	}
	System.out.print("end ");
}

/*

What is the result?
A. test end
B. Compilation fails.
C. test runtime end
D. test exception end							[X]
E. A Throwable is thrown by main at runtime.
*/