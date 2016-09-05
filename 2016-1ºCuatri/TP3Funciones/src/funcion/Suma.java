package funcion;

public class Suma extends OperacionBinaria {
	
	public Suma(double num1, double num2) {
		setNumero1(num1);
		setNumero2(num2);
	}

	public double resolver() {
		return (getNumero1() + getNumero2());
	}

}
