package imagenes_espaciales;

public class AppTest {

	public static void main(String[] args) {
		
		Compresion datos = new Compresion("caso_enunciado.in");
		datos.ResolversinComprimir();
		datos.ResolverComprimido();
		//Los hice por separado para que el codigo quedara mas claro
		datos.guardarArchivoDescomprimido("caso_enunciado1.out");
		datos.guardarArchivoComprimido("caso_enunciado2.out");
	}

}
