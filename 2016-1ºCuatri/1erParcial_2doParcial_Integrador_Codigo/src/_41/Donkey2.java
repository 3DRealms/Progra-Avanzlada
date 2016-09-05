package _41;

public class Donkey2 {
	 public static void main(String[] args) {
		 boolean assertsOn = true;
		 assert (assertsOn) : assertsOn = true;
		 if(assertsOn) {
		 System.out.println("assert is on");
		 }
	 }
 }

/*
 If class Donkey is invoked twice, the first time without assertions enabled, and the second time with assertions enabled, what are the results?
A. no output
B. no output
assert is on
C. assert is on					[X]
D. no output
An AssertionError is thrown.
E. assert is on
An AssertionError is thrown.
*/