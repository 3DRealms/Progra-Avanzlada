package red;

public class AppTest {

	
	public static void main(String[] args) {
		Archivo arch = new Archivo("Subterraneo.in", "Subterraneo.out");
		Subterraneos subte = new Subterraneos();
		subte = arch.leer(subte);
		subte.camino();
		arch.guardar(subte);

	}

}
