package _07primerParcialRecuperatorio.punto1Parecido;

public abstract class Shape {
	 private int x;
	 private int y;
	 public abstract void draw();
	 public void setAnchor(int x, int y) {
		 this.x = x;
		 this.y = y;
	}
}


/*
Which two classes use the Shape class correctly? (Choose two.)
A. public class Circle implements Shape {
private int radius;
}
B. public abstract class Circle extends Shape {
private int radius;											[X]
}
C. public class Circle extends Shape {
private int radius;
public void draw();
}
D. public abstract class Circle implements Shape {
private int radius;
public void draw();
}
E. public class Circle extends Shape {
private int radius;											[X]

public void draw() { /code/ }
F. public abstract class Circle implements Shape {
private int radius;
public void draw() { /code/ }
*/