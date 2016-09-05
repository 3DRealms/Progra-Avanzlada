package circuloPunto;

public class Rectangulo {
	
	private Punto inferior_izq;
	private Punto superior_der;
	private double base;
	private double altura;
	private double area;
	
	
	public Punto getInferior_izq() {
		return inferior_izq;
	}
	public void setInferior_izq(Punto inferior_izq) {
		this.inferior_izq = inferior_izq;
		
		
		//this.base = this.superior_der.getX() - this.inferior_izq.getX();
		//this.altura = this.superior_der.getY() - this.inferior_izq.getY();
	}
	public Punto getSuperior_der() {
		return superior_der;
	}
	public void setSuperior_der(Punto superior_der) {
		this.superior_der = superior_der;
	}
	public double getBase() {
		return base;
	}
	
	public double getAltura() {
		return altura;
	}

	public Rectangulo( Punto inf_izq, Punto sup_der){
		this.inferior_izq = inf_izq;
		this.superior_der = sup_der;
		this.altura = this.superior_der.getY() - this.inferior_izq.getY();	
		this.base = this.superior_der.getX() - this.inferior_izq.getX();
		this.area = this.altura * this.base;
	}

	
	
    /*getEdad o getFecha_Nacimiento
	Son atributos propios necesarios para el modelado
	Para evitar por ejemplo sobrecalculo de datos que se reutilizarian
	constantemente.
	De esta manera tambien cuando cambie el area por ejemplo
	tengo que recalcular la propiedad interna!
	
	
	Easy
	interseccion entre 2 rectangulos
	
	Expert
	
	Interseccion de rectangulo y circulo
	*/
	
	
	
}
