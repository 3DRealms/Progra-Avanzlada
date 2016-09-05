package practica;


public class Punto {
	private double x;
	private double y; 
	
	
	public Punto(){
		x = 0;
		y = 0;
	}
	
	public Punto(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public Punto clone(){
		return new Punto(this);
	}
	
	public Punto(Punto p){
		this.x = p.x;
		this.y = p.y;
	}
	
	public void desplazar(double x,double y){
		this.x += x;
		this.y += y;
	}
	
	public double distanciaAOtroPunto(Punto p){
		double a;
		double b;
		a = this.getX() - p.getX(); //no hace falta el get 
		b = this.y - p.y; // Mismo ambito, ( Clase Punto ) 
		
		return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2) );
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public String toString(){
		return "("+x+","+y+")";
	}
	
	

	public static void main(String[] args) {
		
		Punto p1 = new Punto(4,2);
		Punto p2 = new Punto(6,2);
		
		
		p1.desplazar(4, 1);
		System.out.println("p1"+p1);
		
		System.out.printf("Distancia p1"+p1+" a p2"+p2+":  %.2f ",p1.distanciaAOtroPunto(p2));

	}

}
