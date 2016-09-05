package caos_en_la_envazadora;

public class AppTest {

	public static void main(String[] args) {
		
        Envazadora latas = new Envazadora("caso_enunciado.in");
        latas.ResolverCaos();
        latas.grabar("caso_enunciado.out");

	}

}