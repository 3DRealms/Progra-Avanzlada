package circuloPunto;

public class Circulo {
	private double radio;
	private Punto punto;
	
	public Circulo(double radio, Punto punto) {
		this.radio = radio;
		this.punto = punto;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public Punto getPunto() {
		return punto;
	}

	public void setPunto(Punto punto) {
		this.punto = punto;
	}
	
	public boolean contienePunto(Punto obj ){
		double vec= Math.sqrt(obj.getX() * obj.getX() + obj.getY() * obj.getY());
		return (vec < this.radio);
		
	}
	
	public boolean contieneCirculo( Circulo circ){
		double distanciaCirculoX = Math.abs( this.getPunto().getX() - circ.getPunto().getX() );
		double distanciaCirculoY = Math.abs( this.getPunto().getY() - circ.getPunto().getY() );
		double distanciaCirculo = Math.sqrt( Math.pow(distanciaCirculoX, 2) + Math.pow( distanciaCirculoY , 2) );
		return ( this.getRadio() + circ.getRadio() >= distanciaCirculo);
	}	
		
	public boolean contieneRectangulo( Rectangulo rec){
		double distanciaX = Math.abs( ( this.getPunto().getX() - rec.getInferior_izq().getX() - (rec.getBase()/2) ) );
		double distanciaY = Math.abs( ( this.getPunto().getY() - rec.getInferior_izq().getY() - (rec.getAltura()/2) ) );
		double distanciaAngulo = Math.pow( (distanciaX - (rec.getBase()/2)), 2) + Math.pow( (distanciaY - (rec.getAltura()/2)),2 );
		if ( distanciaX > rec.getBase()/2 + this.radio ){
			return false;
		}
		if ( distanciaY > rec.getAltura()/2 + this.radio ){
			return false;
		}
		if ( distanciaX <= rec.getBase()/2 ){
			return true;
		}
		if ( distanciaY <= rec.getAltura()/2){
			return true;
		}
		return ( distanciaAngulo <= Math.pow( this.radio,2) );
	}
	
}
