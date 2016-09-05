package _58;

public class Icelandic extends Horse {
	public void makeNoise() { System.out.println("whinny"); }
	public static void main(String[] args) {
		Icelandic i1 = new Icelandic();
		Icelandic i2 = new Icelandic();
		Icelandic i3 = new Icelandic();
		i3 = i1; i1 = i2; i2 = null; i3 = i1;
	}
}

/*
When line 14 is reached, how many objects are eligible for the garbage collector?
A. 0
B. 1
C. 2
D. 3
E. 4						[X]
F. 6
*/