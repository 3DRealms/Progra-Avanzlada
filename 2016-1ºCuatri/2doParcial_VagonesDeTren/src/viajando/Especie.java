package viajando;

public class Especie {
private String nombre;
private int cant;
private int agresividad;

public Especie(String nom, int agre,int animales){
this.nombre=nom;
this.agresividad=agre;
this.cant=animales;
	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public int getAgresividad() {
		return agresividad;
	}

	public void setAgresividad(int agresividad) {
		this.agresividad = agresividad;
	}

}
