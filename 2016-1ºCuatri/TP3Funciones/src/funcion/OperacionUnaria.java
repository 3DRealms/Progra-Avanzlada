package funcion;

public abstract class OperacionUnaria implements Expresion {
	
	private double numero1;
	private double resultado;
	public double getNumero1() {
		return numero1;
	}
	public void setNumero1(double numero1) {
		this.numero1 = numero1;
	}
	public double getResultado() {
		return resultado;
	}
	public void setResultado(double resultado) {
		this.resultado = resultado;
	}

}
