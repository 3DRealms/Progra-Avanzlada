package decorator_2;

public abstract class AutoDecorador implements Vendible{
	private Vendible vendible;
	
	public AutoDecorador (Vendible vendible){
		setVendible(vendible);
	}
	
	public Vendible getVendible(){
		return vendible;
	}
	
	public void setVendible (Vendible vendible){
		this.vendible = vendible;
	}

}
