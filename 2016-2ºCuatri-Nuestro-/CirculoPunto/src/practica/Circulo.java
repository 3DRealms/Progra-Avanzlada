package practica;

public class Circulo {
	
	private Punto centro;
	private double radio;
	
	public boolean estaDentro(Punto p){
		
		if ( ( p.distanciaAOtroPunto(centro) - this.radio  ) >  0)
			return false;
		
		return true;
	}
	
	public Circulo(Punto centro, double radio){
		
		this.centro = centro.clone();
		
		this.radio = radio;
		//System.out.println("OYTI ASDUIAH CONSRUIDO SUDIA ");
		
	}
	public boolean intersepcion(Circulo c){
		
		double dist = this.centro.distanciaAOtroPunto(c.centro);
		if( dist <= (this.radio + c.radio) ) // el igual es porque se tocan las curvas.
			return true;
	
		return false;
		
	 // return this.centro.distanciaAOtroPunto(c.centro) <= (this.radio + c.radio);
	}
	public boolean sobrePerimetro(Punto p){
		
		if ( ( p.distanciaAOtroPunto(centro) - this.radio  ) != 0)
			return false;
		
		return true;
	}
	
	public double perimetro(){
		return 2*this.radio*Math.PI;
	}
	
	public double area(){
		return Math.PI*Math.pow(radio, 2);
	}
	
	public String toString(){
		return "R: "+ radio + " - Centro: " + centro;
	}
	
	public static void main(String[] args) {
		
		Punto p1 = new Punto(2,2);
		Circulo c1 = new Circulo(p1,22);
		
		}
}
