package composite;

import java.util.Vector;

public class Compuesta implements Figura{
	 
	 private Vector<Figura> list = new Vector<Figura>();


	public double calcularArea(){
		double area=0;
		for(Figura f : this.list){
			area+= f.calcularArea();
			
		}
		return area;		
	}
	
	public void agregar(Figura f){
		
		this.list.add(f);	
	}
}
