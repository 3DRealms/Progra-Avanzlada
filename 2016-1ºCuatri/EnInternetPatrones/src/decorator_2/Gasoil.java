package decorator_2;

public class Gasoil extends AutoDecorador{
	
	public Gasoil(Vendible vendible){
		super(vendible);
	}
	
	public String getDescripcion(){
		return getVendible().getDescripcion()+" + GasOil";
	}
	
	public int getPrecio(){
		return getVendible().getPrecio() + 1200;
	}
}
