package funcion;

public class Potenciacion extends OperacionBinaria{
	
	public Potenciacion(double num1, double num2) {
		setNumero1(num1);
		setNumero2(num2);

	}

	@SuppressWarnings("finally")
	public double resolver() {
		try {
			if (getNumero2() == 0 && getNumero1() == 0)
				throw new Exception("Cero elevado a la cero es una indeterminacion");
			if (getNumero2() < 1 && getNumero1() < 0)
				throw new Exception("No existe la raiz de un numero negativo");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return (Math.pow(getNumero1(), getNumero2()));
		}
	}

}
