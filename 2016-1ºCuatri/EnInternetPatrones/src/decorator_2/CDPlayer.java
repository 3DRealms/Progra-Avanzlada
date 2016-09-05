package decorator_2;

public class CDPlayer extends AutoDecorador{
	
	public CDPlayer(Vendible vendible){
		super(vendible);
	}
	
	public String getDescripcion(){
		return getVendible().getDescripcion()+" + CDPlayer";
	}
	
	public int getPrecio(){
		return getVendible().getPrecio() + 200;
	}
}