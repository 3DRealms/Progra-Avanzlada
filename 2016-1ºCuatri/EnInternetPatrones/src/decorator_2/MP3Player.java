package decorator_2;

public class MP3Player extends AutoDecorador{
		
	public MP3Player(Vendible vendible){
		super(vendible);
	}
	
	public String getDescripcion(){
		return getVendible().getDescripcion()+" + MP3Player";
	}
	
	public int getPrecio(){
		return getVendible().getPrecio() + 500;
	}
}