package primerParcialRecuperatorio.punto2;


//public class Parent {
//	public Parent(){
//		System.out.print("A");
//	}
//}


class Child extends Parent{
	public Child(int x){
		System.out.print("B");
	}
	public Child (){
		this(123);
		System.out.print("C");
	}
	public static void main(String[] args) {
		new Child();
	}
}


/*
A. ABC						[X]
B. ACB
C. AB
D. AC
E. Error de compilacion
 */