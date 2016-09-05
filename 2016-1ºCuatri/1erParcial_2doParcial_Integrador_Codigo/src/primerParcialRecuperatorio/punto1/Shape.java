package primerParcialRecuperatorio.punto1;

public class Shape {
	private String color;
	
	public Shape (String color){
		System.out.println("Shape");
		this.color = color;
	}

	public static void main(String[]args){
		new Rectangle();
	}
}

class Rectangle extends Shape{
	public Rectangle(){
		System.out.println("Rectangle");
	}
}

/*
A. ShapeRectangle
B. RectangleShape
C. Rectangle
D.Error de compilacion linea 6
E.Error de compilacion linea 17				[X]
*/