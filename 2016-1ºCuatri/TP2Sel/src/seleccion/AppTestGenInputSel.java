package seleccion;

public class AppTestGenInputSel {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeneradorInputSEL gen = new GeneradorInputSEL();
		gen.GenerarArchivosInput("dimensiones.txt");
		System.out.println("Se han generado los archivos de input correctamente.");
	}

}
