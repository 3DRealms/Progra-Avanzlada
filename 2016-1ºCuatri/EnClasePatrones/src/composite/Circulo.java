package composite;

public class Circulo implements Figura {
	private double radio;
	
	public Circulo(double radio) {
		super();
		this.radio = radio;
	}
	
	public double calcularArea(){
		return Math.PI*Math.pow(this.radio,2);
	}
}