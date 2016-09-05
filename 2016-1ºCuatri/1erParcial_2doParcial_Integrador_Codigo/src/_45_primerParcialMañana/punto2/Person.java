package _45_primerParcialMañana.punto2;


public class Person {
	 private String name;
	 public Person(String name) {
		 this.name = name;
	 }
	 public boolean equals(Person p) {
		 return p.name.equals(this.name);
	 }
	 public static void main(String[] args) {
		Person p1 =  new Person("Pedro");
		Person p2 = new Person("Pedro");
		if (p1.equals(p2))
			System.out.println("OK");
		else
			System.out.println("FALSE");
	 }
 }

/*
Which statement is true?
A. The equals method does NOT properly override the Object.equals method.		[X]
B. Compilation fails because the private attribute p.name cannot be accessed in line 5.
C. To work correctly with hash-based data structures, this class must also implement the hashCode method.
D. When adding Person objects to a java.util.Set collection, the equals method in line 4 will prevent duplicates.
*/