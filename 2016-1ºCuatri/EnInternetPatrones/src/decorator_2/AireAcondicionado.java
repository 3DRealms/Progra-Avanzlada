package decorator_2;

public class AireAcondicionado extends AutoDecorador{
	
	public AireAcondicionado(Vendible vendible){
		super(vendible);
	}
	
	public String getDescripcion(){
		return getVendible().getDescripcion()+" + Aire Acondicionado";
	}
	
	public int getPrecio(){
		return getVendible().getPrecio() + 1500;
	}
}
