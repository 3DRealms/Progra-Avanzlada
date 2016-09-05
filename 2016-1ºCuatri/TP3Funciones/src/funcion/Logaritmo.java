package funcion;

public class Logaritmo extends OperacionUnaria {
	public Logaritmo(double num1) {
		setNumero1(num1);

	}

	public double resolver() {
		try {
			if (getNumero1() < 0)
				throw new Exception(
						"No se puede calcular el logaritmo de un numero negativo");
			if (getNumero1() == 0)
				throw new Exception(
						"No se puede calcular el logaritmo de cero");
			return (Math.log(getNumero1()));
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

}
