package herencia;

public class Punto2D {
	
	private double x;
	private double y;
	
	public Punto2D (){
		this.x = 0;
		this.y = 0;
	}
	
	public Punto2D (double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	public double distancia (Punto2D obj){
		double distanciaX = Math.abs((this.x - obj.x));
		double distanciaY = Math.abs((this.y - obj.y));
		double distanciaReal = Math.sqrt(Math.pow(distanciaX,2) + Math.pow(distanciaY,2));
		return distanciaReal;
	}
	
	public double modulo (Punto2D obj){
		double distanciaReal = Math.sqrt(Math.pow(obj.x,2) +Math.pow(obj.y,2));
		return distanciaReal;
	}

	@Override
	public String toString() {
		return "( " + this.x +" , "+ this.y + " )";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto2D other = (Punto2D) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}
	
	public Punto2D clone (){
		Punto2D clonado = new Punto2D();
		clonado.x = this.x;
		clonado.y = this.y;
		return clonado;
	}
	
	public void desplazamiento (Punto2D obj){
		this.x= (this.x + obj.x);
		this.y = (this.y + obj.y);
	}	
}
	
	
	
//	distancia		x	3D	x
//	modulo			x	3D	x
//	toString		x	3D	X
//	equals			x	3D	X
//	clone			x	3D	X
//	desplazamiento	x	3D	x
//	test			x	3D	X
	
