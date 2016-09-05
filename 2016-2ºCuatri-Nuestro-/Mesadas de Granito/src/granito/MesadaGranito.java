package granito;

public class MesadaGranito {
	private int a;
	private int b;
	
	
	public MesadaGranito(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public void girar(){
		int aux = a;
		a = b;
		b = aux;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	} 
	public String toString(){
		return a+"x"+b;
	}
}
