package herencia;                                                                                                                         
                                                                                                                                          
public class Punto3D extends Punto2D {                                                                                                    
                                                                                                                                          
	private double z;                                                                                                                     
	                                                                                                                                      
	public Punto3D(double x, double y, double z) {                                                                                        
		super(x,y);                                                                                                                       
		this.z = z;                                                                                                                       
	}                                                                                                                                     
	                                                                                                                                      
	public Punto3D() {                                                                                                                    
		super();                                                                                                                          
		this.z = 0;                                                                                                                       
	}                                                                                                                                     
                                                                                                                                          
	@Override                                                                                                                             
	public String toString() {                                                                                                            
		return "( " + this.getX() +" , "+ this.getY()+ " , "+ this.z + " )";                                                              
	}                                                                                                                                     
                                                                                                                                          
	@Override                                                                                                                             
	public boolean equals(Object obj) {                                                                                                   
		if (this == obj)                                                                                                                  
			return true;                                                                                                                  
		if (!super.equals(obj))                                                                                                           
			return false;                                                                                                                 
		if (getClass() != obj.getClass())                                                                                                 
			return false;                                                                                                                 
		Punto3D other = (Punto3D) obj;                                                                                                    
		if (this.getX() != other.getX() && other.getY() != other.getY() && Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;                                                                                                                 
		return true;                                                                                                                      
	}                                                                                                                                     
	                                                                                                                                      
	public void desplazamiento (Punto3D obj){                                                                                             
		this.setX( (this.getX() + obj.getX() ) );                                                                                         
		this.setY( (this.getX() + obj.getX() ) );                                                                                         
		this.z = (this.z + obj.z);                                                                                                        
	} 
	
	public Punto3D clone (){
		Punto3D clonado = new Punto3D();
		clonado.setX( this.getX() );
		clonado.setY( this.getY() );
		clonado.z = this.z;
		return clonado;
	}
	
	
}                                                                                                                                         
                                                                                                                                          