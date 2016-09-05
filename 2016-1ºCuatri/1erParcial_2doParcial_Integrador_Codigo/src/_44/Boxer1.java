package _44;

 public class Boxer1{
	 Integer i;
	 int x;
	 public Boxer1(int y) {
		 x = i+y;
		 System.out.println(x);
	 }
	 public static void main(String[] args) {
		 new Boxer1(new Integer(4));
	 }
 }
 
 /*
 What is the result?
A. The value "4" is printed at the command line.
B. Compilation fails because of an error in line 5.
C. Compilation fails because of an error in line 9.
D. A NullPointerException occurs at runtime.			[X]
E. A NumberFormatException occurs at runtime.
F. An IllegalStateException occurs at runtime.
  */