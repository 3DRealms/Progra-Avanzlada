package composite;

public class Cuadrado implements Figura {

	private double base;
	private double altura;

	public Cuadrado(double lado) {
		super();
		this.base = lado;
		this.altura = lado;
	}
	
	public double calcularArea(){
		return base*altura;
	}
}
