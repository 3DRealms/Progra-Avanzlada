package estructuras;

public class NodoDinamico {
	private Object datos;
	private NodoDinamico siguiente;
	
	//Getter - Setter
	public Object getDatos() {
		return datos;
	}
	public void setDatos(Object datos) {
		this.datos = datos;
	}
	public NodoDinamico getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(NodoDinamico siguiente) {
		this.siguiente = siguiente;
	}
	
	//Constructor
	public NodoDinamico(Object datos, NodoDinamico siguiente) {
		super();
		this.datos = datos;
		this.siguiente = siguiente;
	}	
}
