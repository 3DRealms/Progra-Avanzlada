package _24;

class Money {
	private String country = "Canada";
	public String getC() {
		return country;
	}
}
class Yen extends Money {
	public String getC() {
		return super.country;				//26
	}
}
public class Euro extends Money {
	public String getC(int x) {
		return super.getC();
	}
	public static void main(String[] args) {
		System.out.print(new Yen().getC() + " " + new Euro().getC());
	}
}

/*
What is the result?
A. Canada
B. null Canada
C. Canada null
D. Canada Canada
E. Compilation fails due to an error on line 26.	[X] osea linea 11
F. Compilation fails due to an error on line 29.
*/