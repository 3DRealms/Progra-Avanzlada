package funcion;

public class Constante implements Expresion{
	
	private double numero;
	
	
	public double getNumero() {
		return numero;
	}


	public void setNumero(double numero) {
		this.numero = numero;
	}


	public Constante(double num)
	{
		numero=num;
		
	}
	public double resolver()
	{
		return numero;
		
	}

}
