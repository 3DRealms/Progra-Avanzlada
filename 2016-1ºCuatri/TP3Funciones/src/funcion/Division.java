package funcion;

public class Division extends OperacionBinaria {

	public Division(double num1, double num2) {
		setNumero1(num1);
		setNumero2(num2);
	}

	public double resolver() {
		try {
			if (getNumero2() == 0)
				throw new Exception("No se puede dividir por cero");
			setResultado(getNumero1() / getNumero2());
			return getResultado();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
